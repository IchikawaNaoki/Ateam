package model ;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


	public class ConnDB {
		private final String JDBC_URL =
				"jdbc:sqlserver://MGT2019\\SQLEXPRESS;databaseName=TeamA";
		private final String DB_USER = "TeamA";
		private final String DB_PASS = "teama";

		public List<GetDB>findAll(){
			List<GetDB>empList = new ArrayList<>();

			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}

			//データベースへ接続
			try(Connection conn = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS)){

				//SELECT文を準備
				String sql = "SELECT * FROM BaseDate";
				Statement pStmt = conn.createStatement();

				//SELECTを実行し、結果表を取得
				ResultSet rs = pStmt.executeQuery(sql);

				//結果表に格納されたレコードの内容を
				//Employeeインスタンスに設定し、ArrayListインスタンスに追懐
				while(rs.next()) {
					int id = rs.getInt("社員");
					String name = rs.getString("社員名");
					String department = rs.getString("所属名");
					GetDB employee = new GetDB(id, name, department);

					System.out.println(name);
					empList.add(employee);
				}
			}catch(SQLException e ) {
				e.printStackTrace();
				System.out.println("接続できませんわ");
				return null;
			}
			System.out.println("接続されたお");
			return empList;
		}
/*
		//　新規追加
		public boolean create(GetDB ｇetDb) {
	    	//　データベース接続
	    	try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

	    		// insert文の準備
	    		String sql = "INSERT INTO 社員個人データ表(Name_,Text_) VALUES(?,?)";
	    		PreparedStatement pStmt = conn.prepareStatement(sql);

	    		// insert文中の「？」に使用する値を設定しSQLを完成

	    		pStmt.setString(1, mutter.getUserName());
	    		pStmt.setString(2, mutter.getText());

	    		// insert文を実行
	    		 pStmt.executeUpdate();

	    	}
	   	catch( SQLException e) {
	    		e.printStackTrace();
	    		System.out.println("create sql errorだよ");
	    		return false;
	    	}

	    	System.out.println("create true");
	    	return true;
	    }

		//　更新のアップデート
	    public boolean Update(GetDB ｇetDb) {
	    	try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
	    		// update文の準備
	    		String sql = "UPDATE MUTTER SET Text_='aaaaa' WHERE ID=1";
	    		PreparedStatement pStmt = conn.prepareStatement(sql);

	    //		pStmt.setString(1, mutter.getText());
	    //		pStmt.setInt(2, mutter.getId());

	    		pStmt.executeUpdate();

	    	}catch(SQLException e){
	    		e.printStackTrace();
	    		System.out.println("update sql errorだよ");
	    		return false;
	    	}
	    	System.out.println("update true");
	    	return true;
	    }

	    //　削除のdelete
	    public boolean Delete(GetDB ｇetDb) {
	    	try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
	    		// update文の準備

	    		String sql = "DELETE FROM MUTTER WHERE ID=5";
	    		PreparedStatement pStmt = conn.prepareStatement(sql);

	    //		pStmt.setString(1, mutter.getText());
	    //		pStmt.setInt(2, mutter.getId());

	    		pStmt.executeUpdate();

	    		 sql = "SET IDENTITY_INSERT MUTTER ON;"
	    				+ "INSERT INTO MUTTER(ID) VALUES(5);"
	    				+ "SET IDENTITY_INSERT MUTTER OFF;";
	    		 pStmt = conn.prepareStatement(sql);
	    		//pStmt.setInt(1, mutter.getId());

	    		pStmt.executeUpdate();

	    	}catch(SQLException e){
	    		e.printStackTrace();
	    		System.out.println("delete sql errorだよ");
	    		return false;
	    	}
	    	System.out.println("delete true");
	    	return true;
	    }
*/
}