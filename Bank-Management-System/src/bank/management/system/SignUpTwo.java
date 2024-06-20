package bank.management.system;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
	
	JTextField aadharField, panField;
	JButton next;
	JRadioButton sno, syes, eyes, eno;
	JComboBox relign,incomeCategory,educationCategory,occupationCategory,categoryField; 
	String formno;
	
	public SignUpTwo(String formno) {
		this.formno = formno;
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(200,80,400,30);
		add(additionalDetails);
		
		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway", Font.BOLD, 18));
		religion.setBounds(100,140,100,30);
		add(religion);
		
		String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
		relign = new JComboBox(valReligion);
		relign.setBounds(300,140,300,30);
		add(relign);
		relign.setBackground(Color.WHITE);
		
		JLabel category = new JLabel("Category:");
		category.setFont(new Font("Raleway", Font.BOLD, 18));
		category.setBounds(100,190,200,30);
		add(category);
		
		String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
		categoryField = new JComboBox(valCategory);
		categoryField.setBounds(300,190,300,30);
		add(categoryField);
		categoryField.setBackground(Color.WHITE);
		
		JLabel income = new JLabel("Income");
		income.setFont(new Font("Raleway", Font.BOLD, 18));
		income.setBounds(100,240,200,30);
		add(income);
		
		String incomeVal[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
		incomeCategory = new JComboBox(incomeVal);
		incomeCategory.setBounds(300,240,300,30);
		add(incomeCategory);
		incomeCategory.setBackground(Color.WHITE);
		
		JLabel educational = new JLabel("Educational:");
		educational.setFont(new Font("Raleway", Font.BOLD, 18));
		educational.setBounds(100,290,200,30);
		add(educational);
		
		JLabel qualification = new JLabel("Qualification");
		qualification.setFont(new Font("Raleway", Font.BOLD, 18));
		qualification.setBounds(100,315,200,30);
		add(qualification);
		
		String educationVal[] = {"Non-Graduate", "Graduate", "Post-Graduation", "Doctorate", "Other"};
		educationCategory = new JComboBox(educationVal);
		educationCategory.setBounds(300,300,300,30);
		add(educationCategory);
		educationCategory.setBackground(Color.WHITE);
		
		JLabel occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD, 18));
		occupation.setBounds(100,390,200,30);
		add(occupation);
	
		String occupationVal[] = {"Salaried", "Self-Employeed", "Bussiness", "Retired", "Other"};
		occupationCategory = new JComboBox(occupationVal);
		occupationCategory.setBounds(300,390,300,30);
		add(occupationCategory);
		occupationCategory.setBackground(Color.WHITE);
		
		JLabel aadharno = new JLabel("Aadhar Number:");
		aadharno.setFont(new Font("Raleway", Font.BOLD, 18));
		aadharno.setBounds(100,440,200,30);
		add(aadharno);
		
		aadharField = new JTextField();
		aadharField.setFont(new Font("Raleway", Font.BOLD, 14));
		aadharField.setBounds(300,440,300,30);
		add(aadharField);
		
		aadharField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
					e.consume();
					JOptionPane.showMessageDialog(null,"Aadhar number can only contain digits");
				}
			}
		});
		
		JLabel panNo = new JLabel("PAN Number");
		panNo.setFont(new Font("Raleway", Font.BOLD, 18));
		panNo.setBounds(100,490,200,30);
		add(panNo);
		
		panField = new JTextField();
		panField.setFont(new Font("Raleway", Font.BOLD, 14));
		panField.setBounds(300,490,300,30);
		add(panField);
		
		JLabel senior = new JLabel("Senior Citizen");
		senior.setFont(new Font("Raleway", Font.BOLD, 18));
		senior.setBounds(100,540,200,30);
		add(senior);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 80, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(412, 540, 120, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup seniorGroup = new ButtonGroup();
		seniorGroup.add(syes);
		seniorGroup.add(sno);
		
		JLabel exisAcc = new JLabel("Existing Account:");
		exisAcc.setFont(new Font("Raleway", Font.BOLD, 18));
		exisAcc.setBounds(100,590,200,30);
		add(exisAcc);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 80, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(412, 590, 120, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup ExistingGroup = new ButtonGroup();
		ExistingGroup.add(eyes);
		ExistingGroup.add(eno);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(519,660,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(700,750);
		setLocation(380,50);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String religion = (String) relign.getSelectedItem();
		String category = (String) categoryField.getSelectedItem();
		String income = (String) incomeCategory.getSelectedItem();
		String education = (String) educationCategory.getSelectedItem();
		String occupation = (String) occupationCategory.getSelectedItem();
		String seniorCitizen = null;
		if(syes.isSelected()) {	
			seniorCitizen = "Yes";
		}else if(sno.isSelected()) {
			seniorCitizen = "No";
		}
		
		String existingAccount = null;
		if(eyes.isSelected()) {
			existingAccount = "Yes";
		}else if(eyes.isSelected()) {
			existingAccount = "No";
		}
		
		String pan = panField.getText();
		String aadhar = aadharField.getText();
		
		try {
			if(religion.equals("") || category.equals("") || income.equals("") || education.equals("") || occupation.equals("") || pan.equals("") || aadhar.equals("")) {
				JOptionPane.showMessageDialog(null, "All fields are required");
			} else {
				Conn c = new Conn();
				String query = "insert into signuptwo values('" + formno + "', '" + religion + "', '" + category + "', '" + income + "', '" + education + "', '" + occupation + "', '" + aadhar + "', '" + pan + "', '" + seniorCitizen + "', '" + existingAccount + "')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignUpThree(formno).setVisible(true);;
			}
		}catch(Exception ae) {
			System.out.println(ae);
		}
	}	
	public static void main(String args[]) {
		new SignUpTwo("");
	}
}
