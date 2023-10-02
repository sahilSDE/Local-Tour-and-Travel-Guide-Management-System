package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRoom extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }


    public AddRoom() {
        setBounds(450, 200, 1000, 450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/oop img 3.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,20,500,370);
                add(l15);
        
        JLabel l10 = new JLabel("Add Rooms");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(194, 10, 120, 22);
	contentPane.add(l10);
        
	
        
	JLabel l1 = new JLabel("Room Number");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(64, 70, 102, 22);
	contentPane.add(l1);
        
        
        t4 = new JTextField();
	t4.setBounds(194, 70, 156, 20);
	contentPane.add(t4);
        

	JLabel l2 = new JLabel("Food Availability");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 110, 102, 22);
	contentPane.add(l2);
        
        comboBox = new JComboBox(new String[] { "Available", "Not available" });
	comboBox.setBounds(196, 110, 154, 20);
	contentPane.add(comboBox);


	JLabel l3 = new JLabel("Marriage status");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 150, 132, 22);
	contentPane.add(l3);
        
        comboBox_2 = new JComboBox(new String[] { "Bachelor", "Married" });
	comboBox_2.setBounds(196, 150, 154, 20);
	contentPane.add(comboBox_2);

	JLabel l4 = new JLabel("Price");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 190, 102, 22);
	contentPane.add(l4);
        
        t2 = new JTextField();
	t2.setBounds(194, 190, 156, 20);
	contentPane.add(t2);

        JLabel l5 = new JLabel("Bed Type");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 230, 102, 22);
	contentPane.add(l5);


        comboBox_3 = new JComboBox(new String[] { "Single Bed", "Double Bed"});
	comboBox_3.setBounds(196, 230, 154, 20);
	contentPane.add(comboBox_3);

	

	

	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(64, 321, 111, 33);
        b1.setBackground(new Color(150, 3, 72));
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	
        contentPane.setBackground(Color.WHITE);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == b1) {
                String room = t4.getText();
                String available = (String) comboBox.getSelectedItem();
                String status = (String) comboBox_2.getSelectedItem();
                String price = t2.getText();
                String type = (String) comboBox_3.getSelectedItem();
                
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp", "root", "Sahil@15");
                
                String query = "INSERT INTO AddRoom (room_number, food_available, marriage_status, price, bed_type) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, room);
                stmt.setString(2, available);
                stmt.setString(3, status);
                stmt.setString(4, price);
                stmt.setString(5, type);
                
                int rowsInserted = stmt.executeUpdate();
                
                stmt.close();
                con.close();
                
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Room Successfully Added");
                    this.setVisible(false);
                }
            } else if (ae.getSource() == b2) {
                this.setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
