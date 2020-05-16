import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;

public class Lab09 implements ActionListener {
	JFrame myFrame;
	JTextArea myTextArea;
	JMenu fileMenu, helpMenu;
	JMenuItem newMenuI, saveMenuI, openMenuI, exitMenuI, contactMenuI;
	JMenuBar myMenuBar;

	public static JFileChooser fc = null;

	public Lab09() {
		myFrame = new JFrame("My Frame");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = myFrame.getContentPane();
		c.setLayout(new BorderLayout());

		myTextArea = new JTextArea(5, 20);

		fileMenu = new JMenu("File");
		newMenuI = new JMenuItem("New");
		openMenuI = new JMenuItem("Open");
		saveMenuI = new JMenuItem("Save");
		exitMenuI = new JMenuItem("Exit");

		fileMenu.add(newMenuI);
		fileMenu.add(openMenuI);
		fileMenu.add(saveMenuI);
		fileMenu.add(exitMenuI);

		helpMenu = new JMenu("Help");
		contactMenuI = new JMenuItem("Contact");
		helpMenu.add(contactMenuI);

		myMenuBar = new JMenuBar();

		newMenuI.addActionListener(this);
		openMenuI.addActionListener(this);
		saveMenuI.addActionListener(this);
		exitMenuI.addActionListener(this);

		contactMenuI.addActionListener(this);

		myMenuBar.add(fileMenu);
		myMenuBar.add(helpMenu);

		myFrame.setJMenuBar(myMenuBar);
		c.add(new JScrollPane(myTextArea), BorderLayout.CENTER);
                fc = new JFileChooser("Choose File");
		myFrame.pack();
		myFrame.setLocation(400, 400);
		myFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New")) {
			// enter code for New Menu here
			myTextArea.setText(" ");
		}
		if (e.getActionCommand().equals("Open")) {
			// enter code for Open Menu here
                        //create a thread and put (open code) in the run()
			OpenThread open = new OpenThread();
			open.start();
		}
		if (e.getActionCommand().equals("Save")) {
			// enter code for Open Menu here
                        //create a thread and put (open code) in the run()
			SaveThread save = new SaveThread();
			save.start();
		}
		if (e.getActionCommand().equals("Exit")) {
			// enter code for Exit Menu here
			System.exit(0);
		}
		if (e.getActionCommand().equals("Contact")) {
			// enter code for Contact Menu here
                       //create a thread and put code to create specified frame in run()
			ContactThread contact = new ContactThread();
			contact.start();
		}
	}//end of actionPerformed()

	public class OpenThread extends Thread{
	public void run() {
		 if (fc == null) {
				fc = new JFileChooser("Choose File");
		    }
			int result = fc.showOpenDialog(myFrame);
			File fileName;
			if (result == JFileChooser.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, "You have to choose a file");
				return;
			}
			fileName = fc.getSelectedFile();
			try {
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
				String temp;
				myTextArea.setText("");
				while ((temp = br.readLine()) != null) {
					myTextArea.append(temp);
					myTextArea.append("\n");
				} // end of while
				br.close();
			} catch (Exception e3) {
				String message = "Error loading " + e3.getMessage();
				JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
			} // end of catch
	}
		
	}
	public class SaveThread extends Thread{
		public void run() {
			if (fc == null) {
				fc = new JFileChooser("Choose File");
			}
			int result = fc.showSaveDialog(myFrame);

			File fileName;
			if (result == JFileChooser.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, "You have to choose a file");
				return;
			}

			fileName = fc.getSelectedFile();
			try {
				FileWriter fw = new FileWriter(fileName);
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(myTextArea.getText());
				bw.close();

			} catch (Exception e3) {
				String message = "Error loading " + e3.getMessage();
				JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				e3.printStackTrace();

			} // end of catch

		}
	}
	public class ContactThread extends Thread{
		public void run() {
			JFrame contact = new JFrame("ContactThread");
			Container c = contact.getContentPane();
			c.setLayout(new BorderLayout());
			
			
			JPanel panel = new JPanel();
			
			JLabel name = new JLabel("Name: ");
			panel.add(name);
			TextField field = new TextField(10);
			panel.add(field);
			TextArea area = new TextArea();
			contact.add(area , "Center");
			JButton submit = new JButton("Submit");
			contact.add(submit , "South");
			
			
			contact.add(panel , "North");
		
			contact.pack();
			contact.setVisible(true);
			
		}
	}
	
	
	public static void main(String[] args) {
		new Lab09();
	}
}