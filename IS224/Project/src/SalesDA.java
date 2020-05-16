import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SalesDA {
	
	public static boolean insertSale(Sale s) {
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/is224?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			Statement statment = connect.createStatement();
			Date d = new Date(s.saleDate.getTime());
			int result = statment.executeUpdate(
					"insert into Sale values("+s.id+","+"'"+d.toString()+"'"+","+s.totalAmount+");");
			
			if(result>=1) {
				JOptionPane.showMessageDialog(new JFrame(), "Has Been Added", "Operation",JOptionPane.OK_OPTION);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"wrong", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}

	public static boolean deleteSale(Sale s) {

		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/is224?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			Statement statment = connect.createStatement();
			int result = statment.executeUpdate(
					"delete from Sale where idSale="+s.id+";");
			
			if(result>=1) {
				JOptionPane.showMessageDialog(new JFrame(), "Has Been deleted", "Operation",JOptionPane.NO_OPTION);
			}
			else
				JOptionPane.showMessageDialog(new JFrame(), "Hasn't deleted", "Operation",JOptionPane.ERROR_MESSAGE);
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"wrong", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}

	public static Sale retrieveSale(int id) {
		Sale sale = null;
		try {
		Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/is224?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from Sale where idSale=" + id + ";");
			int idretrive;
			Date date;
			double amount;
			while (result.next()) {
				idretrive = result.getInt(1);
				date = result.getDate(2);
				amount = result.getDouble(3);

				 sale = new Sale(idretrive,date,amount);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sale;
	}

	public static ArrayList<Sale> retrieveAllSale() {
		ArrayList<Sale> array = new ArrayList<>();

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/is224?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from Sale;");
			int id;
			Date d;
			double amount;
			while (result.next()) {
				id = result.getInt(1);
				d = result.getDate(2);
				amount = result.getDouble(3);

				array.add(new Sale(id,d,amount));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return array;
	}

}
