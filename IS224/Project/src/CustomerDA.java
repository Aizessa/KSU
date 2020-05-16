import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.*;

public class CustomerDA {
	public static boolean insertCustomer(Customer C) {
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/is224?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			Statement statment = connect.createStatement();
			int result = statment.executeUpdate(
					"insert into customer values("+ C.id+","+"'" +C.name+"'" + ","+"'" +C.city+"'"  + ","+"'" +C.country+"'"  + ","+C.phone+ ");");
			
			if(result>=1) {
				JOptionPane.showMessageDialog(new JFrame(), "Has Been Added", "Operation",JOptionPane.OK_OPTION);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"wrong", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}

	public static boolean deleteCustomer(Customer c) {
		
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/is224?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			Statement statment = connect.createStatement();
			int result = statment.executeUpdate(
					"delete from Customer where idCustomer="+c.id+");");
			
			if(result>=1) {
				JOptionPane.showMessageDialog(new JFrame(), "Has Been deleted", "Operation",JOptionPane.OK_OPTION);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"wrong", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}

	public static Customer retrieveCustomer(int id) {
		
		Customer customer = null;
		try {
		Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/is224?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from customer where idCustomer=" + id + ";");
			int idretrive;
			String name;
			String city;
			String country;
			String phone;
			while (result.next()) {
				idretrive = result.getInt(1);
				name = result.getString(2);
				city = result.getString(3);
				country = result.getString(4);
				phone = result.getString(5);

				 customer = new Customer(idretrive, name, city, country, phone);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return customer;

	}

	public static ArrayList<Customer> retrieveAllCustomers() {
		ArrayList<Customer> array = new ArrayList<>();

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/is224?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from customer;");
			int id;
			String name;
			String city;
			String country;
			String phone;
			while (result.next()) {
				id = result.getInt(1);
				name = result.getString(2);
				city = result.getString(3);
				country = result.getString(4);
				phone = result.getString(5);

				array.add(new Customer(id, name, city, country, phone));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return array;

	}
}
