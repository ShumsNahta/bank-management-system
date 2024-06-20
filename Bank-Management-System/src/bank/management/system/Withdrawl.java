package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{
	
	JTextField amount;
	JButton withdraw, back;
	String pinNumber;
	
	public Withdrawl(String pinNumber){
		
		setLayout(null);
		this.pinNumber = pinNumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Enter the amount you want to withdraw");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD,16));
		text.setBounds(190,300,400,20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(190,350,287,25);
		image.add(amount);
		
		amount.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Alphabets not allowed");
                }
            }
        });
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355,485,150,30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back = new JButton("Back");
		back.addActionListener(this);
		back.setBounds(355,520,150,30);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new Withdrawl("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == withdraw) {
			String number = amount.getText();
			Date date = new Date();
			if(number.equals("")) {
				JOptionPane.showInternalMessageDialog(null,"Please enter the amount you want to withdraw");	
			}else {
				try {					
					Conn conn = new Conn();
					String query = "insert into bank values('"+ pinNumber +"','"+ date +"', 'Withdrawl', '"+number+"')";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+" Withdraw Successfully");
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}else if(ae.getSource() == back) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
	}
}
