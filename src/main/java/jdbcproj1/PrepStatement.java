package jdbcproj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrepStatement p1 = new PrepStatement();
		p1.InsertData("Madhuri Yadav", "19/03/2002", 2);
		

	}
	
	public static void InsertData(String name,String dob, int deptCode) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dphtschema1","root","admin1903");
			String sql = "insert into staff_master (staff_name,hire_date,dept_code) values(?,?,?);";
			PreparedStatement ps1 = conn.prepareStatement(sql);
			
			ps1.setString(1, name);
			ps1.setString(2, dob);
			ps1.setInt(3, deptCode);
			int rowsAffected = ps1.executeUpdate();
			if(rowsAffected == 1) {
				System.out.println("Recored inserted");
			}else {
				System.out.println("Problem while inserting");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
