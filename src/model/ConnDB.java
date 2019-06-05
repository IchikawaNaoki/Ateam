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

			//データベースへ接続
			try(Connection conn = DriverManager.getConnection(
					JDBC_URL, DB_USER, DB_PASS)){

				//SELECT文を準備
				String sql = "SELECT * FROM 社員個人データ表";
				Statement pStmt = conn.createStatement();

				//SELECTを実行し、結果表を取得
				ResultSet rs = pStmt.executeQuery(sql);

				//結果表に格納されたレコードの内容を
				//Employeeインスタンスに設定し、ArrayListインスタンスに追懐
				while(rs.next()) {
					int id = rs.getInt("社員ID");
					String name = rs.getString("社員名");
					String department = rs.getString("所属");
					GetDB employee = new GetDB(id, name, department);
					empList.add(employee);
				}
			}catch(SQLException e ) {
				e.printStackTrace();
				return null;
			}
			return empList;

		}


}