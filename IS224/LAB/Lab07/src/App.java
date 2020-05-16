import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;

public class App implements ActionListener {

	JFrame myframe;
	JMenu Filemenu, Helpmenu;
	JMenuBar mymenubar;
	JPanel centerPanel;
	JLabel label;
	JMenuItem fileOpenitem, fileExititem, helpAboutitem;
	JFileChooser fc;
	File fileName;

	public App() {

		myframe = new JFrame("Lab6");
		Container c =  myframe.getContentPane();
		c.setLayout(new BorderLayout());
		
		mymenubar = new JMenuBar();
		
		Filemenu = new JMenu("File");
		fileOpenitem = new JMenuItem("Open");
		fileExititem = new JMenuItem("Exit");
		Filemenu.add(fileOpenitem);
		Filemenu.add(fileExititem);
		
		Helpmenu = new JMenu("Help");
		helpAboutitem = new JMenuItem("About");
		Helpmenu.add(helpAboutitem);
		
		mymenubar.add(Filemenu);
		mymenubar.add(Helpmenu);
		
		label = new JLabel("User File Choice");
		
		centerPanel = new JPanel();
		centerPanel.add(label);
		//myframe.add("Center" , centerPanel);
		c.add("Center" , centerPanel);
		
		fileOpenitem.addActionListener(this);
		fileExititem.addActionListener(this);
		helpAboutitem.addActionListener(this);

		myframe.setJMenuBar(mymenubar);
		myframe.pack();
		myframe.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Open")) {

			fc = new JFileChooser("Choose File");
			fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			fc.setVisible(true);
			int result = fc.showOpenDialog(myframe);
			if (result == JFileChooser.APPROVE_OPTION) {
				 fileName = fc.getSelectedFile();
				label.setText("File Path: " + fileName.getPath());
			}
		} else if (e.getActionCommand().equals("About")) {
			label.setText("Abdullah Ibrahim ALessa , 435105313");
		} else if(e.getActionCommand().equals("Exit"))
			System.exit(0);

	}

	public static void main(String[] args) {
		new App();
	}
}
