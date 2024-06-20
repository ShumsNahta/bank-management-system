package bank.management.system;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
	
	long random;
	JTextField nameField, fnameField, emailField, addressField, cityField, stateField, pinField;
	JButton next;
	JRadioButton maleButton, femaleButton, other, married, unmarried;
	JDateChooser dateChooser;
	
	public SignUpOne() {
		Random ran = new Random();
		random= Math.abs(ran.nextLong() % 9000L + 1000L);
		setLayout(null);
		
		JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
		formNo.setFont(new Font("Raleway", Font.BOLD, 35));
		formNo.setBounds(80,20,600,40);
		add(formNo);
		
		JLabel personalDetails = new JLabel("Page 1: Personal Details");
		personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personalDetails.setBounds(200,80,400,30);
		add(personalDetails);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD, 18));
		name.setBounds(100,140,100,30);
		add(name);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameField.setBounds(300,140,300,30);
		add(nameField);
		
		nameField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isWhitespace(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Name can only contain alphabets");
                }
            }
        });
		
		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway", Font.BOLD, 18));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnameField = new JTextField();
		fnameField.setFont(new Font("Raleway", Font.BOLD, 14));
		fnameField.setBounds(300,190,300,30);
		add(fnameField);
		
		fnameField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isWhitespace(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Father's name can only contain alphabets");
                }
            }
        });
		
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD, 18));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,  240, 300, 30);
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD, 18));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		maleButton = new JRadioButton("Male");
		maleButton.setBounds(300, 290, 60, 30);
		maleButton.setBackground(Color.WHITE);
		add(maleButton);
		
		femaleButton = new JRadioButton("Female");
		femaleButton.setBounds(450, 290, 100, 30);
		femaleButton.setBackground(Color.WHITE);
		add(femaleButton);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(maleButton);
		genderGroup.add(femaleButton);
		
		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Raleway", Font.BOLD, 18));
		email.setBounds(100,340,200,30);
		add(email);
		
	    emailField = new JTextField();
		emailField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailField.setBounds(300,340,300,30);
		add(emailField);
		
		emailField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Email cannot contain digits");
                }
            }
        });
		
		JLabel maritalStatus = new JLabel("Marital Status:");
		maritalStatus.setFont(new Font("Raleway", Font.BOLD, 18));
		maritalStatus.setBounds(100,390,200,30);
		add(maritalStatus);
		
		married = new JRadioButton("Married");
		married.setBounds(300, 390, 80, 30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(412, 390, 120, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(545, 390, 120, 30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		maritalGroup.add(other);
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway", Font.BOLD, 18));
		address.setBounds(100,440,200,30);
		add(address);
		
		addressField = new JTextField();
		addressField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressField.setBounds(300,440,300,30);
		add(addressField);
		
		JLabel city = new JLabel("City");
		city.setFont(new Font("Raleway", Font.BOLD, 18));
		city.setBounds(100,490,200,30);
		add(city);
		
		cityField = new JTextField();
		cityField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityField.setBounds(300,490,300,30);
		add(cityField);
		
		JLabel state = new JLabel("State");
		state.setFont(new Font("Raleway", Font.BOLD, 18));
		state.setBounds(100,540,200,30);
		add(state);
		
		stateField = new JTextField();
		stateField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateField.setBounds(300,540,300,30);
		add(stateField);
		
		JLabel pincode = new JLabel("Pincode:");
		pincode.setFont(new Font("Raleway", Font.BOLD, 18));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		pinField = new JTextField();
		pinField.setFont(new Font("Raleway", Font.BOLD, 14));
		pinField.setBounds(300,590,300,30);
		add(pinField);
		
		pinField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
					e.consume();
					JOptionPane.showMessageDialog(null,"PIN code can only contain digits");
				}
			}
		});
		
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
		String formno = " " + random;
		String name = nameField.getText();
		String fname = fnameField.getText();
		String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(maleButton.isSelected()) {	
			gender = "Male";
		}else if(femaleButton.isSelected()) {
			gender = "Female";
		}
		
		String email = emailField.getText();
		String marital = null;
		if(married.isSelected()) {
			marital = "Married";
		}else if(unmarried.isSelected()) {
			marital = "Unmarried";
		}else if(other.isSelected()){
			marital = "Other";
		}
		
		String address = addressField.getText();
		String city = cityField.getText();
		String state = stateField.getText();
		String pin = pinField.getText();
		
		try {
			if(name.equals("") || fname.equals("") || dob.equals("") || gender.equals("") || email.equals("") || address.equals("") || city.equals("") || state.equals("") || pin.equals("")) {
				JOptionPane.showMessageDialog(null, "All fields are required");
			} else {
				Conn c = new Conn();
				String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignUpTwo(formno).setVisible(true);
			}
		}catch(Exception ae) {
			System.out.println(ae);
		}
	}	
	public static void main(String args[]) {
		new SignUpOne();
	}
}
