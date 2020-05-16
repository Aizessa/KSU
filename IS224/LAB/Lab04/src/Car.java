import java.io.Serializable;

public class Car implements Serializable {
	String model;
	String year;

	public Car(String model, String year) {
		this.model = model;
		this.year = year;
	}

	public String toString() {
		return "Model: " + model + " Year: " + year;
	}

}
