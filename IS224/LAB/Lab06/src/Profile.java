import java.io.Serializable;


public class Profile implements Serializable {
	public String name;
	public String bio;

	public Profile() {
		name = "";
		bio = "";
	}

	public Profile(String name, String bio) {
		this.name = name;
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Profile [name=" + name + ", bio=" + bio + "]";
	}

}
