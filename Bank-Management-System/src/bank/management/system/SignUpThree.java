package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class SignUpThree extends JFrame implements ActionListener{
	
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit, cancel;
	String formno;
	
	public SignUpThree(String formno) {
		this.formno = formno;
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
		setLayout(null);
		
		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		l1.setBounds(200,40,400,40);
		add(l1);
		
		JLabel type = new JLabel("Account Type");
		type.setFont(new Font("Raleway", Font.BOLD, 22));
		type.setBounds(100,130,400,40);
		add(type);
		
		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway",Font.BOLD,16));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100,180,200,20);
		add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway",Font.BOLD,16));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350,180,200,20);
		add(r2);
		
		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway",Font.BOLD,16));
		r3.setBackground(Color.WHITE);
		r3.setBounds(100,220,200,20);
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Raleway",Font.BOLD,16));
		r4.setBackground(Color.WHITE);
		r4.setBounds(350,220,250,20);
		add(r4);
		
		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Raleway", Font.BOLD, 22));
		card.setBounds(100,300,200,40);
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
		number.setFont(new Font("Raleway", Font.BOLD, 22));
		number.setBounds(330,300,300,40);
		add(number);
		
		JLabel cardDetail = new JLabel("Your 16-digit Card Number");
		cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
		cardDetail.setBounds(100,330,300,20);
		add(cardDetail);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(100,370,200,40);
		add(pin);
		
		JLabel pNumber = new JLabel("XXXX");
		pNumber.setFont(new Font("Raleway", Font.BOLD, 22));
		pNumber.setBounds(330,370,300,40);
		add(pNumber);

		JLabel pinDetail = new JLabel("Your 4-digit Password");
		pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
		pinDetail.setBounds(100,400,300,20);
		add(pinDetail);
		
		JLabel services = new JLabel("Services Required:");
		services.setFont(new Font("Raleway", Font.BOLD, 22));
		services.setBounds(100,450,250,40);
		add(services);
		
		c1 = new JCheckBox("ATM Card");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway", Font.BOLD, 16));
		c1.setBounds(100,500,200,30);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway", Font.BOLD, 16));
		c2.setBounds(350,500,200,30);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway", Font.BOLD, 16));
		c3.setBounds(100,550,200,30);
		add(c3);
		
		c4 = new JCheckBox("Email & SMS Alerts");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway", Font.BOLD, 16));
		c4.setBounds(350,550,200,30);
		add(c4);
		
		c5 = new JCheckBox("Checkbook");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway", Font.BOLD, 16));
		c5.setBounds(100,600,200,30);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway", Font.BOLD, 16));
		c6.setBounds(350,600,200,30);
		add(c6);
		
		c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway", Font.BOLD, 12));
		c7.setBounds(100,680,600,30);
		add(c7);
		
		ButtonGroup groupAccount = new ButtonGroup();
		groupAccount.add(r1);
		groupAccount.add(r2);
		groupAccount.add(r3);
		groupAccount.add(r4);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.setBounds(250,720,100,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.setBounds(420,720,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
		setSize(800,850);
		setLocation(380,50);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
	}		
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() ==  submit) {
			String accountType = "";
			if(r1.isSelected()) {
				accountType = "Saving Account";
			}else if(r2.isSelected()) {
				accountType = "Fixed Deposit Account";
			}else if(r3.isSelected()) {
				accountType = "Current Account";
			}else if(r4.isSelected()) {
				accountType = "Recurring Deposit Account";
			}
			
			Random random = new Random();
			String cardNumber = "" + Math.abs((random.nextLong() % 90000000l + 5040936000000000l));
			String pinNumber = "" + Math.abs((random.nextLong() % 9000l) + 1000l);
			
			String facility = "";
			if(c1.isSelected()) {
				facility += " ATM Card";
			}else if(c2.isSelected()) {
				facility += " Internet Banking";
			}else if(c3.isSelected()) {
				facility += " Mobile Banking";
			}else if(c4.isSelected()) {
				facility += " EMAIL & SMS Alerts";
			}else if(c5.isSelected()) {
				facility += " Checkbook";
			}else if(c6.isSelected()) {
				facility += " E-Statement";
			}
			
			try {
				if(accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is required");
				}else if(facility.equals("")) {
					JOptionPane.showMessageDialog(null, "Atleast one service is required");
				}else if(!c7.isSelected()) {
					JOptionPane.showMessageDialog(null, "Please confirm if the details your entered are correct");
				}
				else {					
					Conn conn = new Conn();
					String query1 = "insert into signUpThree values('"+formno+"','"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
					String query2 = "insert into login values('"+formno+"','"+cardNumber+"', '"+pinNumber+"')";
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Card Number: "+ cardNumber + "\n Pin: "+ pinNumber);
					setVisible(false);
					new Deposit(pinNumber).setVisible(false);
					
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}else if(ae.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}
	
	public static void main(String args[]) {
		new SignUpThree("");
	}
}
