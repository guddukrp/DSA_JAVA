package demo;

//import java.sql.Connection;
//import java.sql.DriverManager;

public class Demo {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //load Driver
			
			String user = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/student_manage";
//			con= DriverManager.getConnection(url, user, password);
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}

	}

}
