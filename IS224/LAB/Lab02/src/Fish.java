
public class Fish extends Animal implements Pet {
	public String name;

	public Fish(String name) {
		super(0);
		this.name = name;
	}

	public Fish() {
		this("");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Fish don't play!");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Fish eat plants");
	}

	public void walk() {
		System.out.println("Fish has no legs");
	}

}
