
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;

public class lab07 extends Thread implements ActionListener {
	JFrame myFrame;
	JTextArea myTextArea;
	JMenu fileMenu, helpMenu;
	JMenuItem newMenuI, saveMenuI, openMenuI, exitMenuI, contactMenuI;
	JMenuBar myMenuBar;
	private JFrame frame;
	private JTextField textField;
	JButton btnSubmit;

	public static JFileChooser fc = null;

	public lab07() {
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

		myFrame.pack();
		myFrame.setLocation(400, 400);
		myFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New")) {
			// enter code for New Menu here
			myTextArea.setText("");
		}
		if (e.getActionCommand().equals("Open")) {
			// enter code for Open Menu here
			Openthreed Openthreed = new Openthreed();

			Openthreed.start();

			// create a thread and put (open code) in the run()

		}
		if (e.getActionCommand().equals("Save")) {
			// enter code for Open Menu here
			// create a thread and put (open code) in the run()

			savethreed savethreed = new savethreed();

			savethreed.start();
		}
		if (e.getActionCommand().equals("Exit")) {
			// enter code for Exit Menu here

			System.exit(0);
		}
		if (e.getActionCommand().equals("Contact")) {
			// enter code for Contact Menu here
			// create a thread and put code to create specified frame in run()
			// myTextArea.setText("ABDULAZIZ ALMOGREN 435103275");
			contentthreed  Contact =new contentthreed();
			Contact.start();
			
			
			// frame.pack();

		}
	}// end of actionPerformed()

	public class Openthreed extends Thread {

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

	public class savethreed extends Thread {

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

			}
		}

	}
	public class contentthreed extends Thread {

		public void run() {
			frame = new JFrame();
			//frame.setSize(600,400 );
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			JPanel panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.NORTH);

			JLabel lblLabel = new JLabel("Name");
			panel.add(lblLabel);

			textField = new JTextField();
			panel.add(textField);
			textField.setColumns(10);

			JTextArea textArea = new JTextArea();
			frame.getContentPane().add(textArea, BorderLayout.CENTER);

			 btnSubmit = new JButton("Submit");
			frame.getContentPane().add(btnSubmit, BorderLayout.SOUTH);
			btnSubmit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
			});

			 frame.pack();

		}


	}

	public static void main(String[] args) {
		new lab07();
	}
}// end of class
