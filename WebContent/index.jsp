package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.GetDB;
import model.User;

public class ConnDbDao {
	private final String JDBC_URL =
			"jdbc:sqlserver://MGT2019\\SQLEXPRESS;databaseName=TeamA";
	private final String DB_USER = "TeamA";
	private final String DB_PASS = "teama";

	//データベースを取得
	public List<User> ConDbLogin(User user){
		String pass = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			//SELECT文を準備
			String sql = "select Pass "
					+ "from PersonalList "
					+ "where PersonalID =" +  user.getId();
			Statement pStmt = conn.createStatement();

			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery(sql);
			if(rs.next()) {
				pass = rs.getString("Pass");
				System.out.println("接続されたお");
				List <User> list = ConnDbUser(pass);
				return list;
			}
			return null;

		}catch(SQLException e ) {
			e.printStackTrace();
			System.out.println("接続できませんわ");
			return null;
		}
	}

	public List<User>  ConnDbUser(String str) {
		List<User> empList = new ArrayList<>();
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select * from PersonalList "
					+ "WHERE Pass = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, str);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				int id= rs.getInt("PersonalID");
				String name = rs.getString("PersonalName");
				String pass = rs.getString("Pass");
				byte loginFlag = (byte)rs.getInt("LoginFlag");
				User employee = new User(id, name, pass, loginFlag);
				empList.add(employee);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
			System.out.println("Userリストむ～りぃぃぃぃ");
		}
		return empList;
	}


	public List<GetDB>  ConnDbUserInfo(int i) {
		List<GetDB> empList = new ArrayList<>();
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select * from ReadingDate "
					+ "WHERE 社員ID = "+ i;
			Statement pStmt = conn.createStatement();
			ResultSet rs = pStmt.executeQuery(sql);

			if(rs.next()) {
				String name = rs.getString("社員名");
				String belongs = rs.getString("所属地");
				String status = rs.getString("在席状況");
				String comment = rs.getString("ヒトコト");
				GetDB employee = new GetDB(name, belongs, status, comment);
				empList.add(employee);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
			System.out.println("UserInfoリストむ～りぃぃぃぃ");
		}
		return empList;
	}

	public List<GetDB>  findAll() {
		List<GetDB> empList = new ArrayList<>();
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select * from ReadingDate";
			Statement pStmt = conn.createStatement();
			ResultSet rs = pStmt.executeQuery(sql);

			while(rs.next()) {
				String name = rs.getString("社員名");
				String belongs = rs.getString("所属地");
				String status = rs.getString("在席状況");
				String comment = rs.getString("ヒトコト");
				GetDB employee = new GetDB(name, belongs, status, comment);
				empList.add(employee);
			}

		}catch(SQLException e ) {
			e.printStackTrace();
			System.out.println("findリストむ～りぃぃぃぃ");
		}
		return empList;
	}

	public List<GetDB> WhereView (String str) {
		if( str.equals("すべて") ) {
			return null;
		}
		List<GetDB> empList = new ArrayList<>();
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			String sql = "select * from ReadingDate "
					+ "WHERE 所属地 = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, str);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				String name = rs.getString("社員名");
				String belongs = rs.getString("所属地");
				String status = rs.getString("在席状況");
				String comment = rs.getString("ヒトコト");
				GetDB employee = new GetDB(name, belongs, status, comment);
				empList.add(employee);
			}

		}catch(SQLException e ) {
			e.printStackTrace();
			System.out.println("whereできないぞおおお");
		}

		return empList;
	}

	//在席
	public List<GetDB> ConnDbStatus(String presence, String leaveseat, int i) {
		int log =0;
		if( presence != null ) {
			log = 1;
		}else if(leaveseat != null) {
			log = 0;
		}
		return StatusView(log, i);
	}

	public  List<GetDB> StatusView( int log, int i ){
		List<GetDB> empList = new ArrayList<>();
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "UPDATE EmployeeList "
					+"SET StatusNo = "+ log
					+" WHERE PersonalNo = "+i;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("社員名");
				String belongs = rs.getString("所属地");
				String status = rs.getString("在席状況");
				String comment = rs.getString("ヒトコト");
				GetDB employee = new GetDB(name, belongs, status, comment);
				empList.add(employee);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
			System.out.println("Statusリストできないっぺよ");
		}
		return empList;
	}

	//ログインアウト
	public List<User>  ConnDbLoginLogout(int i , String str) {
		List<User> empList = new ArrayList<>();
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "UPDATE PersonalList "
					+"SET LoginFlag = "+ i
					+" WHERE Pass ="+str;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.executeUpdate();
		}catch(SQLException e ) {
			e.printStackTrace();
			System.out.println("LoginLogoutリストできないぺよ");
		}
			return empList;
	}

	//削除
	public void  ConnDbDelete(User user) {
//		List<User> empList = new ArrayList<>();
		try{
			//初期接続時のサーバー宣言
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch(Exception e ){
			e.printStackTrace();
			System.out.println("Delete時の接続むぅぅぅりぃぃぃぃｘ・・・・");
		}
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String pass = null;
			//SELECT文を準備
			String sql = "select Pass "
					+ "from PersonalList "
					+ "where PersonalID =" +  user.getId();
			Statement pStmt = conn.createStatement();

			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery(sql);
			if(rs.next()) {
				pass = rs.getString("Pass");
			}
			if(pass.equals(user.getPass()))
			{
				//SQL文（DELETE）の作成
				sql = "delete from PersonalList "
							+ "WHERE PersonalID = ? ";
				//SQL文の実行処理
				CallableStatement cStmt = conn.prepareCall(sql);
				cStmt.setInt(1, user.getId());
				//DB更新
				cStmt.executeUpdate();

				//SQL文（Insert）の作成
				sql = "set identity_insert PersonalList ON "
						+ "insert into PersonalList(PersonalID,PersonalName) "
						+ "values ( ? ,(N'None')) "
						+ "set identity_insert PersonalList OFF";
				//SQL文の実行処理
				cStmt = conn.prepareCall(sql);
				cStmt.setInt(1, user.getId());
				//DB更新
				cStmt.executeUpdate();
			}
			else
			{
				System.out.println("あの・・・でりぃと・・したいんですけど・・・むぅぅりぃぃぃ・・・・");
			}
		}catch(SQLException e ) {
				e.printStackTrace();
				System.out.println("Deleteできませぇぇぇぇぇん！！");
		}
	}

	public void RegisterDB(User user) {
		try{
			//初期接続時のサーバー宣言
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch(Exception e ){
			e.printStackTrace();
			System.out.println("新規登録接続むぅぅぅりぃぃぃぃｘ・・・・");
		}
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//SQL文（INSERT）の作成
			String sql = "INSERT INTO PersonalList(PersonalName, Pass)"
					+ "Values(?, ?)";
			//SQL文の実行処理
			CallableStatement cStmt = conn.prepareCall(sql);
			cStmt.setString(1, user.getName());
			cStmt.setString(2, user.getPass());
			//DB更新
			cStmt.executeUpdate();

		}catch(SQLException e ) {
				e.printStackTrace();
				System.out.println("登録できませぇぇぇぇぇん！！");
		}
	}

	//部署変更
	public List<User>  ConnDbChangeBelong(int BelongsNo , int PersonalId) {
		List<User> empList = new ArrayList<>();
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "UPDATE EmployeeList "
					+"SET BelongsNo = "+ BelongsNo
					+" WHERE PersonalNo ="+ PersonalId;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.executeUpdate();
		}catch(SQLException e ) {
			e.printStackTrace();
			System.out.println("ChangeBelongリストできないぺよ");
			return null;
		}
		System.out.println("変更できたっぺよ");
		return empList;
	}

	//ユーザーIDとパス照合
	public boolean ConnDbCollation(User user)
	{
		String rePass = null;
		try{
			//初期接続時のサーバー宣言
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch(Exception e ){
			e.printStackTrace();
			System.out.println("新規登録接続むぅぅぅりぃぃぃぃｘ・・・・");
		}
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS))
		{
			//SQL文（INSERT）の作成
			String sql = "SELECT Pass "
					+ "FROM PersonalList "
					+ "WHERE PersonalID = ?";
			//SQL文の実行処理
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user.getId());
			ResultSet rs = pStmt.executeQuery();
			if(rs.next())
			{
				rePass=rs.getString("Pass");
			}
			if(rePass.equals(user.getPass()))
			{
				return true;
			}
		}
		catch(Exception e )
		{
				e.printStackTrace();
				System.out.println("IDないしはパスが合ってないぉ");
		}
		return false;
	}

	//コメント入力
	public List<User>  ConnDbCommentInput(String Comment , int PersonalId)
	{
		List<User> empList = new ArrayList<>();
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS))
		{
			String sql = "UPDATE EmployeeList "
					+"SET Comment = "+ Comment
					+"WHERE PersonalNo ="+ PersonalId;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.executeUpdate();
		}
		catch(SQLException e )
		{
			e.printStackTrace();
			System.out.println("コメントの入力に失敗！");
			return null;
		}
		System.out.println("コメントの入力に成功！");
		return empList;
	}

	public int ConnDbRegisterId(User user)
	{
//		try{
//			//初期接続時のサーバー宣言
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		}
//		catch(Exception e ){
//			e.printStackTrace();
//			System.out.println("新規登録接続むぅぅぅりぃぃぃぃｘ・・・・");
//		}
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS))
		{
			//SELECT文を準備
			String sql = "SELECT PersonalID "
					+"FROM PersonalList "
					+"WHERE PersonalName = ? AND Pass = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getPass());
			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			if(rs.next())
			{
				int id = rs.getInt("PersonalID");
				return id;
			}
		}
		catch(SQLException e )
		{
			e.printStackTrace();
			System.out.println("接続できませんわ");
		}
		return 0;
	}
}


