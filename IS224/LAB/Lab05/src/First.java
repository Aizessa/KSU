import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class First implements Serializable , ActionListener{
	Frame myFrame;
	Button save, load, exit;
	Label myLabel1, myLabel2;
	TextField name, email;
	Panel namePanel, emailPanel, buttonPanel;

	public First() {
		myFrame = new Frame("Sign up Form");
		myFrame.setSize(300, 200);
		myFrame.setLayout(new FlowLayout());
		namePanel = new Panel();
		emailPanel = new Panel();
		buttonPanel = new Panel();
		myLabel1 = new Label("Name: ");
		name = new TextField("Enter Name Here", 15);
		myLabel2 = new Label("email: ");
		email = new TextField("Enter email Here", 15);
		namePanel.add(myLabel1);
		namePanel.add(name);
		emailPanel.add(myLabel2);
		emailPanel.add(email);
		save = new Button("Save");
		save.addActionListener(this);
		load = new Button("Load");
		exit = new Button("Exit");
		buttonPanel.add(save);
		buttonPanel.add(load);
		buttonPanel.add(exit);
		myFrame.add(namePanel);
		myFrame.add(emailPanel);
		myFrame.add(buttonPanel);
		myFrame.setVisible(true);
		myFrame.pack();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new First();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

}
