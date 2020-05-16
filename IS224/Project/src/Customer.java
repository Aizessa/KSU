
public class Customer {

	public int id;
	public String name, city, country, phone;
	
	public Customer(int id,String name, String city, String country, String phone){
		this.id = id;
		this.name = name;
		this.city = city;
		this.country = country;
		this.phone = phone;
	}
	public String toString(){
		return "Customer ID: " + id + " Customer Name: " + name
				+ "Customer City: " + city + "Customer Country: " + country 
				+ "Customer Phone number: " + phone;
	}
}
