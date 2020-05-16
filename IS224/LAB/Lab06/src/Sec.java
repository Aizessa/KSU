import java.awt.event.*;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Sec implements ActionListener {
	Frame myFrame;
	Button save, load, exit;
	Label myLabel1, myLabel2;
	TextField name;
	TextArea bio;
	Panel northPanel, southPanel, centerPanel;

	public Sec() {
		myFrame = new Frame("Submit Profile");
		myFrame.setSize(900, 600);
		myFrame.setLayout(new BorderLayout());

		northPanel = new Panel();
		centerPanel = new Panel();
		southPanel = new Panel();

		myLabel1 = new Label("Name: ");
		name = new TextField("Enter Name Here", 90);
		northPanel.add(myLabel1);
		northPanel.add(name);

		myLabel2 = new Label("Biography: ");
		bio = new TextArea(9, 60);
		centerPanel.add(myLabel2);
		centerPanel.add(bio);

		save = new Button("Save");
		save.addActionListener(this);
		
		load = new Button("Load");
		load.addActionListener(this);
		exit = new Button("Exit");
		exit.addActionListener(this);

		southPanel.add(save);
		southPanel.add(load);
		southPanel.add(exit);
		myFrame.add("North", northPanel);
		myFrame.add("South", southPanel);
		myFrame.add("Center", centerPanel);
		myFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == exit) {
			System.exit(0);
		} else if (e.getSource() == save) {

			try {
				Profile p = new Profile(name.getText(), bio.getText());
				String fileName = JOptionPane.showInputDialog("Enter name to save: ");
				FileOutputStream fout = new FileOutputStream(fileName);
				ObjectOutputStream out = new ObjectOutputStream(fout);
				out.writeObject(p);
				out.close();

			} catch (Exception e1) {
				System.out.println(e1.getMessage());

			}
		} else if (e.getSource() == load) {
			try {
				String fileName = JOptionPane.showInputDialog("Enter name to load: ");
				FileInputStream fin = new FileInputStream(fileName);
				ObjectInputStream oin = new ObjectInputStream(fin);
				Profile p = (Profile) oin.readObject();
				oin.close();
				name.setText(p.name);
				bio.setText(p.bio);
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
		}

	}

	public static void main(String[] args) {
		new Sec();
	}

}
