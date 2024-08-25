import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JavaClass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name: ");
		String name=sc.nextLine();
		System.out.println("Enter Price: ");
		int price=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/11thmarchj2ee","root","root");
			PreparedStatement pst=con.prepareStatement("Insert into product(name,price) values(?,?)");
			pst.setString(1, name);
			pst.setInt(2, price);
			int count=pst.executeUpdate();
			if (count>0) {
				System.out.println("Data insert");
			}else {
				System.out.println("Data doesn't insert");
			}
		} catch (SQLException|ClassNotFoundException e) {
		e.printStackTrace();
		
		}
	}

}
