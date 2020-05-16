import java.util.ArrayList;
import java.util.Date;

public class Sale {

	public int id;
	public Date saleDate;
	public double totalAmount;
	public ArrayList<String> items;

	public Sale(int id, Date saleDate, double totalAmount) {
		this.id = id;
		this.saleDate = saleDate;
		this.totalAmount = totalAmount;
		items = new ArrayList<String>();
	}

	public void addItem(String item) {
		items.add(item);
	}

	public String toString() {
		return "Sale ID: " + id + " Sale Date: " + saleDate + " Total Amount: " + totalAmount;
	}

}
