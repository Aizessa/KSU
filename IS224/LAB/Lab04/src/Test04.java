
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.*;

public class Test04 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			method1();// save file
			method2();// read file

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void method1() throws IOException {
		FileDialog fc = new FileDialog(new Frame(), "Save", FileDialog.SAVE);

		fc.setDirectory("C:\\Users\\Abdullah\\Desktop\\");
		fc.setVisible(true);
		if (fc.getName() != null) {
			String x = fc.getDirectory() + fc.getFile();

			File f = new File(x);
			FileOutputStream fout = new FileOutputStream(f);
			ObjectOutputStream out = new ObjectOutputStream(fout);

			Car car1 = new Car("Honda Accord", "2007");
			Car car2 = new Car("BMW 650", "2017");
			Car car3 = new Car("Mercedes s", "2007");

			out.writeObject(car1);
			out.writeObject(car2);
			out.writeObject(car3);

			out.flush();
			out.close();

			System.out.println("Done Writing");

		} else {
			System.out.println("You have to select file to save");
		}

	}

	public static void method2() throws Exception {
		FileDialog fc = new FileDialog(new Frame(), "Load", FileDialog.LOAD);
		fc.setDirectory("C:\\Users\\Abdullah\\Desktop\\");
		fc.setVisible(true);

		String y = fc.getDirectory() + fc.getFile();
		System.out.println(y);

		File f = new File(y);
		if (f.exists() & f.getName() != null) {
			// read the objects saved in the file f here.
			FileInputStream fout = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(fout);

			Car car1, car2, car3;

//			car1 = (Car) in.readObject();
//			car2 = (Car) in.readObject();
//			car3 = (Car) in.readObject();
			
			while((car1 = (Car)in.readObject())!=null) {
				System.out.println(car1);
			}
			in.close();

//			System.out.println("============Read===============");
//			System.out.println(car1);
//			System.out.println(car2);
//			System.out.println(car3);

		} else {
			System.out.println("You have to select  file");
		}
	}

}
