package jdbcproj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String query = "insert into staff_master (staff_name,hire_date,dept_code) values('Ramakant Pandit','17/10/2016',5);";
		String query2 = "select * from staff_master";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dphtschema1","root","admin1903");
			Statement s = conn.createStatement();
			int rowsAffected = s.executeUpdate(query);
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
