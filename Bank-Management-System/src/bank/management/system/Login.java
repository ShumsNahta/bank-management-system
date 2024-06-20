package bank.management.system;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JButton login, signUp, clear;
	JTextField cardfield;
	JPasswordField pinfield;
	
	Login(){
		setTitle("Automated Teller Machine");
		setLayout(null);
		
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.jpg"));
		Image image = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); 
		ImageIcon icon2 = new ImageIcon(image);
		JLabel label = new JLabel(icon2);
		label.setBounds(130, 50, 100, 100);
		getContentPane().setBackground(Color.WHITE);
		JLabel text  = new JLabel("Welcome to ATM");
		text.setBounds(300, 50, 400, 100);
		text.setFont(new Font("Osward", Font.BOLD, 35));
		
		JLabel cardno = new JLabel("Card No:");
		cardno.setBounds(160, 200, 150, 30);
		cardno.setFont(new Font("Osward", Font.BOLD, 30));
		
		cardfield = new JTextField();
		cardfield.setBounds(350, 200, 250, 30);
		cardfield.setFont(new Font("Arial", Font.BOLD,14));
		add(cardfield);
		
		JLabel pin = new JLabel("PIN:");
		pin.setBounds(160, 260, 150, 30);
		pin.setFont(new Font("Osward", Font.BOLD, 30));
		
		pinfield = new JPasswordField();
		pinfield.setBounds(350, 260, 250, 30);
		pinfield.setFont(new Font("Arial", Font.BOLD,14));
		add(pinfield);
		
		login = new JButton("SIGN IN");
		login.setBounds(350, 320, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(500, 320, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signUp = new JButton("SIGN UP");
		signUp.setBounds(425, 375, 100, 30);
		signUp.setBackground(Color.BLACK);
		signUp.setForeground(Color.WHITE);
		signUp.addActionListener(this);
		add(signUp);
		
		add(label);
		add(text);
		add(cardno);
		add(pin);
	
		cardfield.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
					e.consume();
					JOptionPane.showMessageDialog(null,"Card number can only contain digits");
				}
			}
		});
		
		pinfield.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
					e.consume();
					JOptionPane.showMessageDialog(null,"PIN can only contain digits");
				}
			}
		});
		
		setSize(900,480);
		setVisible(true);
		setLocation(300,150);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			Conn conn = new Conn();
			String cardNumber = cardfield.getText();
			String pinNumber = pinfield.getText();
			String query = "select * from login where cardNumber = '" + cardNumber +"' and pinNumber = '"+pinNumber+"'";
			try {
				ResultSet rs = conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
				}
			}catch(Exception excep) {
				System.out.println(excep);
			}
		
		}else if (e.getSource() == clear) {
			cardfield.setText("");
			pinfield.setText("");
		}else if(e.getSource() == signUp) {
			setVisible(false);
			new SignUpOne().setVisible(true);
		}
	}
	
	public static void main(String args[]) {
		new Login();
	}

}
