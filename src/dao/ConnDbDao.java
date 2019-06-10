package dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
	public List<GetDB> findAll(){
		List<GetDB>empList = new ArrayList<>();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			//SELECT文を準備
			String sql = "SELECT * FROM SampleBaseDate";
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

	//ユーザを取得
	public List<User> findUserAll(){
		List<User> empUser = new ArrayList<>();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			////SELECT文を準備
			String sql = "SELECT * FROM 社員個人データ表";
			Statement pStmt = conn.createStatement();

			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery(sql);

			//結果表に格納されたレコードの内容を
			//Employeeインスタンスに設定し、ArrayListインスタンスに追懐
			while(rs.next()) {
				int id = rs.getInt("社員ID");
				String name = rs.getString("社員名");
				String department = rs.getString("パスワード");
				Byte nowLogin =  rs.getByte("ログイン判定");
				User employee = new User(id, name, department, nowLogin);
				empUser.add(employee);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
			System.out.println("接続できませんわ");
			return null;
		}
		System.out.println("接続されたお");
		return empUser;
	}
}
