import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

public class frames implements ActionListener {

	JFrame mainFrame, saleFrame, customerFrame, createNewCustomerframe, retriveCustmerframe, createNewSaleframe,
			RetrieveSaleFrame;
	JButton Customer, Sale;
	JLabel id = new JLabel("ID:    "), name = new JLabel("Name:"), city = new JLabel("City:"),
			country = new JLabel("Country:"), phone = new JLabel("Phone:");

	JPanel mainFramePanela, mainFramePanelb;
	
	JList<Object> SaleItemsList;
	JList<Object> RetrivevCustomerlist;
	ArrayList<String> SaleItemArray;
	JList<Object> RetrieveSaleList;

	public frames() {
		// Main Frame
		// *************************************************************************************
		mainFrame = new JFrame("Course Project");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Preparing and defining the main frame called Course Project

		mainFramePanela = new JPanel();
		mainFramePanelb = new JPanel();

		Customer = new JButton(" Customer ");
		Customer.addActionListener(this);

		Sale = new JButton(" Sale ");
		Sale.addActionListener(this);

		mainFramePanela.add(Customer);
		mainFramePanelb.add(Sale);
		mainFrame.getContentPane().add(mainFramePanela, BorderLayout.NORTH);
		mainFrame.getContentPane().add(mainFramePanelb, BorderLayout.CENTER);

		mainFrame.setLocation(600, 300);
		mainFrame.pack();
		mainFrame.setVisible(true);

		// End OF Main Frame
		// *************************************************************************************

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(" Customer ")) {
			mainFrame.setVisible(false);
			// ** New Frame ** Customers Frame
			// *************************************************************************************
			customerFrame = new JFrame(" Customers ");
			
			customerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel customerFramePanela = new JPanel();
			JPanel customerFramePanelb = new JPanel();
			JButton newCustomer = new JButton(" New Customer ");
			newCustomer.addActionListener(this);
			JButton retCusInfo = new JButton(" Retrieve Customer info");
			retCusInfo.addActionListener(this);
			customerFramePanela.add(newCustomer);
			customerFramePanelb.add(retCusInfo);
			customerFrame.getContentPane().add(customerFramePanela, BorderLayout.NORTH);
			customerFrame.getContentPane().add(customerFramePanelb, BorderLayout.CENTER);
			customerFrame.setLocation(600, 300);
			customerFrame.pack();
			customerFrame.setVisible(true);
			// End OF Customers Frame
			// *************************************************************************************

		} else if (e.getActionCommand().equals(" Sale ")) {
			mainFrame.setVisible(false);
			// ** New Frame ** Sales Frame
			// *************************************************************************************
			saleFrame = new JFrame("Sales");
			saleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel saleFramePanela = new JPanel();
			JPanel saleFramePanelb = new JPanel();
			JButton newSale = new JButton(" New Sale ");
			newSale.addActionListener(this);
			JButton retSaleInfo = new JButton(" Retrieve Sale info ");
			retSaleInfo.addActionListener(this);
			saleFramePanela.add(newSale);
			saleFramePanelb.add(retSaleInfo);
			saleFrame.getContentPane().add(saleFramePanela, BorderLayout.NORTH);
			saleFrame.getContentPane().add(saleFramePanelb, BorderLayout.CENTER);
			saleFrame.pack();
			saleFrame.setVisible(true);
			// End OF Sales Frame
			// *************************************************************************************

		} else if (e.getActionCommand().equals(" New Customer ")) {
			customerFrame.setVisible(false);
			// ** New Frame ** Create New Customer Frame
			// *************************************************************************************

			createNewCustomerframe = new JFrame("create new customer");
			createNewCustomerframe.setSize(320, 300);
			createNewCustomerframe.setLayout(new BorderLayout());
			createNewCustomerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel createNewCustomerframePanel1 = new JPanel();

			// JLabel id = new JLabel("ID: ");
			JTextField NewCustomerIdField = new JTextField(15);
			createNewCustomerframePanel1.add(id);
			createNewCustomerframePanel1.add(NewCustomerIdField);
			createNewCustomerframe.getContentPane().add(createNewCustomerframePanel1, BorderLayout.CENTER);

			JPanel createNewCustomerframePanel2 = new JPanel();
			// JLabel name= new JLabel("Name:");
			JTextField NewCustomerNameField = new JTextField(15);
			createNewCustomerframePanel2.add(name);
			createNewCustomerframePanel2.add(NewCustomerNameField);
			createNewCustomerframe.getContentPane().add(createNewCustomerframePanel2, BorderLayout.CENTER);

			JPanel createNewCustomerframePanel3 = new JPanel();
			// JLabel city = new JLabel("City:");
			JTextField NewCustomerCityField = new JTextField(15);
			createNewCustomerframePanel3.add(city);
			createNewCustomerframePanel3.add(NewCustomerCityField);
			createNewCustomerframe.getContentPane().add(createNewCustomerframePanel3, BorderLayout.CENTER);

			JPanel createNewCustomerframePanel4 = new JPanel();
			// JLabel country = new JLabel("Country:");
			JTextField NewCustomerCountryField = new JTextField(15);
			createNewCustomerframePanel4.add(country);
			createNewCustomerframePanel4.add(NewCustomerCountryField);
			createNewCustomerframe.getContentPane().add(createNewCustomerframePanel4, BorderLayout.CENTER);

			JPanel createNewCustomerframePanel5 = new JPanel();
			// JLabel phone = new JLabel("Phone:");
			JTextField NewCustomerPhoneField = new JTextField(15);
			createNewCustomerframePanel5.add(phone);
			createNewCustomerframePanel5.add(NewCustomerPhoneField);
			createNewCustomerframe.getContentPane().add(createNewCustomerframePanel5, BorderLayout.CENTER);

			JPanel createNewCustomerframePanel6 = new JPanel();
			JButton saveCutomer = new JButton("Save customer");
			saveCutomer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Customer c = new Customer(Integer.parseInt(NewCustomerIdField.getText()),
							NewCustomerNameField.getText(), NewCustomerCityField.getText(),
							NewCustomerCountryField.getText(), Integer.parseInt(NewCustomerPhoneField.getText()));

					if (CustomerDA.insertCustomer(c)) {
						NewCustomerIdField.setText("");
						NewCustomerNameField.setText("");
						NewCustomerCityField.setText("");
						NewCustomerCountryField.setText("");
						NewCustomerPhoneField.setText("");
					}
				}
			});
			createNewCustomerframePanel6.add(saveCutomer);
			createNewCustomerframe.getContentPane().add(createNewCustomerframePanel6, BorderLayout.SOUTH);

			JPanel newCustomerPanel = new JPanel();
			newCustomerPanel.add(createNewCustomerframePanel1);
			newCustomerPanel.add(createNewCustomerframePanel2);
			newCustomerPanel.add(createNewCustomerframePanel3);
			newCustomerPanel.add(createNewCustomerframePanel4);
			newCustomerPanel.add(createNewCustomerframePanel5);
			newCustomerPanel.add(createNewCustomerframePanel6);

			createNewCustomerframe.add(newCustomerPanel);
			createNewCustomerframe.setLocation(550, 300);
			createNewCustomerframe.setVisible(true);

			// End OF Create New Customer Frame
			// *************************************************************************************

		} else if (e.getActionCommand().equals(" Retrieve Customer info")) {
			customerFrame.setVisible(false);
			// ** New Frame ** Retrieve Customers Frame
			// *************************************************************************************

			retriveCustmerframe = new JFrame("Retrieve Customers");

			retriveCustmerframe.setSize(400, 400);
			// JLabel id = new JLabel("ID");
			JTextField idField = new JTextField(20);
			idField.setEnabled(false);

			JRadioButton SpecificCustomer = new JRadioButton("Specific Customer");
			SpecificCustomer.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (SpecificCustomer.isSelected()) {
						idField.setEnabled(true);

					} else {
						idField.setEnabled(false);
						idField.setText("");
					}

				}
			});
			JRadioButton allCustomers = new JRadioButton("All Customers");
			
			allCustomers.setSelected(true);

			ButtonGroup group = new ButtonGroup();
			group.add(SpecificCustomer);
			group.add(allCustomers);

			JButton retriveCustomer = new JButton("  Retrieve");
			retriveCustomer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(allCustomers.isSelected())
						frames.updateList(RetrivevCustomerlist, CustomerDA.retrieveAllCustomers());
					else {
						ArrayList<Customer> arr =new ArrayList<>();
						if(CustomerDA.retrieveCustomer(Integer.parseInt(idField.getText()))!=null) {
						arr.add(CustomerDA.retrieveCustomer(Integer.parseInt(idField.getText())));
						if(!arr.isEmpty())
						frames.updateList(RetrivevCustomerlist,arr );
						}
						else
							JOptionPane.showMessageDialog(new JFrame(), "There is no one with this id", "failed", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			JPanel retriveCustmerframePanel1 = new JPanel();

			retriveCustmerframePanel1.add(SpecificCustomer);
			retriveCustmerframePanel1.add(allCustomers);
			retriveCustmerframePanel1.add(retriveCustomer);

			JPanel retriveCustmerframePanel2 = new JPanel();
			retriveCustmerframePanel2.add(id);
			retriveCustmerframePanel2.add(idField);

			JPanel retriveCustmerframePanel3 = new JPanel(new GridLayout(2, 1));

			retriveCustmerframePanel3.add(retriveCustmerframePanel1);
			retriveCustmerframePanel3.add(retriveCustmerframePanel2);

			retriveCustmerframe.add(retriveCustmerframePanel3, BorderLayout.NORTH);
			// rett.add(p2,BorderLayout.CENTER);

			ArrayList<String> Customerlist = new ArrayList<>();

			RetrivevCustomerlist = new JList<Object>(Customerlist.toArray());
			RetrivevCustomerlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			JScrollPane RetrivevCustomerlistscrollPane = new JScrollPane();
			RetrivevCustomerlistscrollPane.setViewportView(RetrivevCustomerlist);

			retriveCustmerframe.add(RetrivevCustomerlist, BorderLayout.CENTER);

			// retriveCustmerframe.getContentPane().add(new
			// JScrollPane(RetrivevCustomerlist));

			/*
			 * JPanel pp = new JPanel(); pp.add(rb1); pp.add(rb2); pp.add(riev);
			 * pp.add(riev2); pp.add(myList); pp.add(ff);
			 */

			// retriveCustmerframe.add(pp);
			retriveCustmerframe.setLocation(340, 300);
			retriveCustmerframe.setVisible(true);

			// End OF Retrieve Customers Frame
			// *************************************************************************************

		} else if (e.getActionCommand().equals(" New Sale ")) {
			saleFrame.setVisible(false);
			// ** New Frame ** Create New Sale Frame
			// *************************************************************************************

			JPanel createNewSaleframePanel1 = new JPanel();
			JPanel createNewSaleframePanel2 = new JPanel();
			JPanel createNewSaleframePanel3 = new JPanel();
			JPanel createNewSaleframePanel4 = new JPanel();
			JPanel createNewSaleframePanel5 = new JPanel();
			JPanel createNewSaleframePanel6 = new JPanel();

			createNewSaleframe = new JFrame("Create New Sale");
			createNewSaleframe.setLayout(new BorderLayout());
			createNewSaleframe.setSize(400, 400);

			// JLabel l1 = new JLabel("ID:");
			JTextField NewSaleIdField = new JTextField(15);

			createNewSaleframePanel1.add(id);
			createNewSaleframePanel1.add(NewSaleIdField);

			JLabel SaleDate = new JLabel("Sale Date:");
			JTextField SaleDateField = new JTextField(15);

			createNewSaleframePanel2.add(SaleDate);
			createNewSaleframePanel2.add(SaleDateField);

			JLabel totalamount = new JLabel("Total Amount:");
			JTextField totalamountField = new JTextField(15);

			createNewSaleframePanel3.add(totalamount);
			createNewSaleframePanel3.add(totalamountField);

			JLabel AddItemToList = new JLabel("Add Item to List:");
			JTextField AddItemToListField = new JTextField(15);
			JButton Addtolist = new JButton("Add to List:");
			SaleItemArray = new ArrayList<>();
			Addtolist.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					SaleItemArray.add(AddItemToListField.getText());
					SaleItemsList.setListData(SaleItemArray.toArray());
					AddItemToListField.setText("");
				}
			});

			createNewSaleframePanel4.add(AddItemToList);
			createNewSaleframePanel4.add(AddItemToListField);
			createNewSaleframePanel4.add(Addtolist);

			JLabel itemslist = new JLabel("Item List:");
			
			 SaleItemsList = new JList<Object>(SaleItemArray.toArray());
			SaleItemsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			JScrollPane SaleItemsListscrollPane = new JScrollPane();
			SaleItemsListscrollPane.setViewportView(SaleItemsList);
			
			createNewSaleframePanel5.add(itemslist);
			createNewSaleframePanel5.add(SaleItemsListscrollPane);
			
			JButton saveSale = new JButton("Save Sale");
			saveSale.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(SaleDateField.getText());
					Sale s = new Sale(Integer.parseInt(NewSaleIdField.getText()), dt, Double.parseDouble(totalamountField.getText()));
					
					for(String item: SaleItemArray) {
						s.addItem(item);
					}
					
					if(!SalesDA.insertSale(s)) {
						JOptionPane.showMessageDialog(new JFrame(), "Hasn't Added", "failed", JOptionPane.ERROR_MESSAGE);
					}
					NewSaleIdField.setText("");
					SaleDateField.setText("");
					totalamountField.setText("");
					SaleItemsList.setListData(new ArrayList<>().toArray());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			createNewSaleframePanel6.add(saveSale);
			
			JPanel center = new JPanel();
			
			center.add(createNewSaleframePanel1);
			center.add(createNewSaleframePanel2);
			center.add(createNewSaleframePanel3);
			center.add(createNewSaleframePanel4);
			center.add(createNewSaleframePanel5);
			center.add(createNewSaleframePanel6);
		
			createNewSaleframe.getContentPane().add("Center",center);
			createNewSaleframe.setVisible(true);
		
			// End OF Create New Sale Frame
			// *************************************************************************************

		} else if (e.getActionCommand().equals(" Retrieve Sale info ")) {
			saleFrame.setVisible(false);
			// ** New Frame ** Retrieve Sale Frame
			// *************************************************************************************

			RetrieveSaleFrame = new JFrame("Retrieve Sale");

			RetrieveSaleFrame.setSize(400, 400);

			JPanel RetrieveSaleFramePanel1 = new JPanel();
			JPanel RetrieveSaleFramePanel2 = new JPanel();
			JPanel RetrieveSaleFramePanel3 = new JPanel(new GridLayout(2, 1));

			// JLabel idLabel = new JLabel("ID:");
			JTextField RetrieveSaleIdField = new JTextField(20);
			RetrieveSaleIdField.setEnabled(false);

			JRadioButton specificSale = new JRadioButton("Specific Sale");
			specificSale.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (specificSale.isSelected()) {
						RetrieveSaleIdField.setEnabled(true);
					} else {
						RetrieveSaleIdField.setEnabled(false);
						RetrieveSaleIdField.setText("");
					}
				}
			});

			JRadioButton allSales = new JRadioButton("All Sales");
			allSales.setSelected(true);

			ButtonGroup RetrieveSaleGroup = new ButtonGroup();
			RetrieveSaleGroup.add(specificSale);
			RetrieveSaleGroup.add(allSales);

			JButton RetrieveSale = new JButton("Retrieve");
			RetrieveSale.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(allSales.isSelected()) {
					ArrayList<Sale> sales= SalesDA.retrieveAllSale();
					RetrieveSaleList.setListData(sales.toArray());
					}
					else {
						ArrayList<Sale> sales= new ArrayList<>();
						if(SalesDA.retrieveSale(Integer.parseInt(RetrieveSaleIdField.getText()))!=null) {
						sales.add(SalesDA.retrieveSale(Integer.parseInt(RetrieveSaleIdField.getText())));
						RetrieveSaleList.setListData(sales.toArray());
						}else
							JOptionPane.showMessageDialog(new JFrame(), "There is nothing with this id", "failed", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});

			RetrieveSaleFramePanel1.add(specificSale);
			RetrieveSaleFramePanel1.add(allSales);
			RetrieveSaleFramePanel1.add(RetrieveSale);

			RetrieveSaleFramePanel2.add(id);
			RetrieveSaleFramePanel2.add(RetrieveSaleIdField);

			RetrieveSaleFramePanel3.add(RetrieveSaleFramePanel1);
			RetrieveSaleFramePanel3.add(RetrieveSaleFramePanel2);

			ArrayList<String> RetrieveSaleArray = new ArrayList<>();

			RetrieveSaleList = new JList<Object>(RetrieveSaleArray.toArray());
			RetrieveSaleList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			JScrollPane RetrieveSaleListscrollPane = new JScrollPane();
			RetrieveSaleListscrollPane.setViewportView(RetrieveSaleList);

			RetrieveSaleFrame.add(RetrieveSaleFramePanel3, BorderLayout.NORTH);
			RetrieveSaleFrame.add(RetrieveSaleList, BorderLayout.CENTER);

			RetrieveSaleFrame.setVisible(true);

			// End OF Retrieve Sale Frame
			// *************************************************************************************

		}

	}
	
	public static void updateList(JList<Object> list , ArrayList<Customer> arr) {
		ArrayList<String> stringList = new ArrayList<>();
		for(Customer c: arr) {
			stringList.add(c.toString());
		}
		
		list.setListData(stringList.toArray());
	}

	public static void main(String args[]) {
		new frames();
	}

}
