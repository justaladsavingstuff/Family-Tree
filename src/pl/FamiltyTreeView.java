package pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bll.PersonBO;

public class FamiltyTreeView implements ActionListener {
	
	private JFrame frame;
	private JTextField cnic1;
	private JTextField cnic2;
	private JButton button;
	private JTextArea result;
	// frame
    private JFrame f;
 
    // label to display text
    private JLabel l;
	
	private PersonBO bo;
	private JTextField name;
	private JButton button2;
	private JTextArea result2;  
	
	
	public FamiltyTreeView() throws SQLException {
		bo = new PersonBO();
		frame = new JFrame("Check if two citizens are half siblings or not");
		cnic1 = new JTextField("");
		cnic2 = new JTextField("");
		button = new JButton("Check");
		result = new JTextArea();
		
		//for "find citizen by name and display" frame
		name = new JTextField("");
		// create a new frame to store text field and button
        f = new JFrame("Task 2");
 
        // create a label to display text
        l = new JLabel();
 
        // add text to label
        l.setText("Search citizen by name");
 
        // create a panel
        JPanel p = new JPanel();
 
        // add label to panel
        p.add(l);
 
        // add panel to frame
        f.add(p);
 
        // set the size of frame
        f.setSize(300, 300);
 
        f.show();
        name = new JTextField("");
        button2 = new JButton("Find");
        result2 = new JTextArea();
        
		
	}
	public void viewSibling() {

		//for the firm form
		cnic1.setBounds(50, 50, 200, 50);
		cnic2.setBounds(50, 100, 200, 50);
		button.setBounds(50, 150, 100, 50);
		button.addActionListener(this);
		result.setBounds(50, 200, 200, 200);
		frame.add(cnic1);
		frame.add(cnic2);
		frame.add(result);
		frame.add(button);
		frame.setSize(400,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	public void viewCitizen() {

		//for the second form 
		name.setBounds(50, 50, 200, 50); //this is the text field
		button2.setBounds(50, 150, 100, 50);
		result2.setBounds(50, 200, 200, 200);
		
		button2.addActionListener(this);
		
		f.add(name);
		f.add(button2);
		f.add(result2);
		
		
		
		f.setSize(400,500);
		f.setLayout(null);
		f.setVisible(true);
	}

	@Override
//	public void actionPerformed(ActionEvent e) {
//		int nic1 = Integer.parseInt(cnic1.getText()); //getting the user input and converting it to integer 
//		int nic2 = Integer.parseInt(cnic2.getText());
//		if (bo.isHalfSibling(nic1, nic2)) { //calling the method we made in the business layer 
//			result.setText("Yes, the two citizens are half siblings");
//		} else {
//			result.setText("No, the two citizens are not half siblings");
//	}
//}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button2)
		{
		String name1 = name.getText();
		//result2.setText("hey");
		result2.setText("Name: " + (bo.findCitizenByName(name1).getName()) + "\n" +"Own CNIC: " + Integer.toString((bo.findCitizenByName(name1).getCnic())) + "\n" + "Father CNIC: " + Integer.toString((bo.findCitizenByName(name1).getFather())) + "\n" + "Mother's CNIC: "+ Integer.toString((bo.findCitizenByName(name1).getMother())));
		}
		else if(e.getSource()==button)
		{
			int nic1 = Integer.parseInt(cnic1.getText()); //getting the user input and converting it to integer 
			int nic2 = Integer.parseInt(cnic2.getText());
			if (bo.isHalfSibling(nic1, nic2)) { //calling the method we made in the business layer 
				result.setText("Yes, the two citizens are half siblings");
			} else {
				result.setText("No, the two citizens are not half siblings");
		}
		}
		
	}
	
	
	public static void main(String[] args) {
		FamiltyTreeView app;
		try {
			app = new FamiltyTreeView();
			app.viewSibling();
			app.viewCitizen();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
