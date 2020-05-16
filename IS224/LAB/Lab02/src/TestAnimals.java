import java.util.*;

public class TestAnimals {
	public static void main(String[] args) {
		Fish f = new Fish();
		Cat c = new Cat("Fiuffy");
		Animal a = new Fish();
		Animal e = new Spider();
		Pet p = new Cat();

		ArrayList<Animal> x = new ArrayList<Animal>();
		x.add(f);
		x.add(c);
		x.add(a);
		x.add(e);
		x.add((Cat) p);

		for (int i = 0; i < x.size(); i++) {
			x.get(i).eat();
			x.get(i).walk();
		}

	}
}
