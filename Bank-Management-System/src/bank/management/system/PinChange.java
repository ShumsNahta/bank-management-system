package bank.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
	
	JPasswordField pin,rePin;
	JButton change,back;
	String pinNumber;
	
	
	PinChange (String pinNumber){
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setBounds(280,280,500,40);
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN:");
		pintext.setForeground(Color.WHITE);
		pintext.setBounds(165,320,180,25);
		image.add(pintext);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,25));
		pin.setBounds(330,320,180,25);
		image.add(pin);
		
		pin.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "PIN can only contain digits");
                }
            }
        });
		
		JLabel rePinText = new JLabel("Re-Enter New PIN:");
		rePinText.setForeground(Color.WHITE);
		rePinText.setBounds(165,360,180,25);
		image.add(rePinText);
		
		rePin = new JPasswordField();
		rePin.setFont(new Font("Raleway",Font.BOLD,25));
		rePin.setBounds(330,360,180,25);
		image.add(rePin);
		
		rePin.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Re-PIN can only contain digits");
                }
            }
        });
		
		change = new JButton("CHANGE");
		change.setBounds(355,450,150,30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("BACK");
		back.setBounds(355,485,150,30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new PinChange("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == change) {
			try {
				String npin = pin.getText();
				String rpin = rePin.getText();
				
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null,"Entered PIN does not match");
					return;
				}
				if(npin.equals("")) {
					JOptionPane.showMessageDialog(null,"Please enter new PIN");
					return;
				}
				if(rpin.equals("")) {
					JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
					return;
				}
				
				Conn conn = new Conn();
				String query1 = "update bank set pinNumber = '"+rpin+"'where pinNumber = '"+pinNumber+"'";
				String query2 = "update login set pinNumber = '"+rpin+"'where pinNumber = '"+pinNumber+"'";
				String query3 = "update signupthree set pinNumber = '"+rpin+"'where pinNumber = '"+pinNumber+"'";
				
				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				conn.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "PIN changed successfully");
				
				setVisible(false);
				new Transactions(rpin).setVisible(true);

			}catch(Exception e) {
				System.out.println(e);
			}	
		}else {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true); 
		}
	}
}
