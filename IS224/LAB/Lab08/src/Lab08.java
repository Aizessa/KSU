import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;

import javax.swing.*;
import java.io.File;
import java.util.*;

public class Lab08 implements ActionListener {
	JFrame myframe;
	JButton mybutton;
	JTextField myText;
	JPanel Panel;
	JLabel one, two;
	ArrayList<Object> myArrayList;
	JRadioButton fst, sec;
	JFileChooser fc;
	File fileName;
	JList<Object> list;
	int x, y;

	public Lab08() {
		myframe = new JFrame("Lab08");
		Container c = myframe.getContentPane();
		c.setLayout(new BorderLayout());

		fst = new JRadioButton("Display");
		fst.addActionListener(this);
		sec = new JRadioButton("Add");
		sec.addActionListener(this);

		ButtonGroup g1 = new ButtonGroup();
		g1.add(fst);
		g1.add(sec);

		myText = new JTextField("Enter City to list");

		mybutton = new JButton("Press After Selecting Action");
		mybutton.addActionListener(this);

		Panel = new JPanel();
		Panel.add(fst);
		Panel.add(sec);
		Panel.add(myText);
		Panel.add(mybutton);
		myframe.getContentPane().add("North", Panel);

		myArrayList = new ArrayList<Object>();
		myArrayList.add("Riyadh");
		list = new JList<Object>(myArrayList.toArray());

		myframe.getContentPane().add("Center", list);

		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.isMetaDown() || e.isPopupTrigger()) {
					myArrayList.add("X = " + e.getX() + "  Y = " + e.getY());

					list.setListData(myArrayList.toArray());
				}

			}
		});

		myframe.setSize(500, 500);
		myframe.pack();
		myframe.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("Press After Selecting Action")) {
			if (fst.isSelected()) {
				JOptionPane.showMessageDialog(null, list.getSelectedValue());
			} else if (sec.isSelected()) {
				myArrayList.add(myText.getText());

				list.setListData(myArrayList.toArray());
			}
		}

	}

	public static void main(String[] args) {
		new Lab08();

	}
}
