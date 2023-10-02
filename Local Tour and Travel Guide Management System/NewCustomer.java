package hotel.management.system;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCustomer extends JFrame {
	private Connection conn = null;
    private PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1, t2, t3, t4, t5, t6;
	JComboBox comboBox;
	JRadioButton r1, r2;
	Choice c1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustomer frame = new NewCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NewCustomer() throws SQLException {

		setBounds(530, 200, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
		Image i3 = i1.getImage().getScaledInstance(450, 400, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(480, 10, 300, 500);
		add(l1);

		JLabel lblName = new JLabel("NEW CUSTOMER FORM");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);

		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 76, 200, 14);
		contentPane.add(lblId);

		comboBox = new JComboBox(new String[] { "Passport", "Aadhar Card", "Voter Id", "Driving license" });
		comboBox.setBounds(271, 73, 150, 20);
		contentPane.add(comboBox);

		JLabel l2 = new JLabel("Mobile Number :");
		l2.setBounds(35, 111, 200, 14);
		contentPane.add(l2);

		t1 = new JTextField();
		t1.setBounds(271, 111, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 151, 200, 14);
		contentPane.add(lblName_1);

		t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 191, 200, 14);
		contentPane.add(lblGender);

		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Raleway", Font.BOLD, 14));
		r1.setBackground(Color.WHITE);
		r1.setBounds(271, 191, 80, 12);
		add(r1);

		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Raleway", Font.BOLD, 14));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350, 191, 100, 12);
		add(r2);

		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 231, 200, 14);
		contentPane.add(lblCountry);

		JLabel lblCheckInStatus = new JLabel("Checked-In :");
		lblCheckInStatus.setBounds(35, 274, 200, 14);
		contentPane.add(lblCheckInStatus);

		JLabel lblDeposite = new JLabel("Deposit :");
		lblDeposite.setBounds(45, 320, 200, 14);
		contentPane.add(lblDeposite);

		t3 = new JTextField();
		t3.setBounds(271, 231, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);

		t5 = new JTextField();
		t5.setBounds(271, 316, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);

		t6 = new JTextField();
		t6.setBounds(271, 274, 150, 20);
		contentPane.add(t6);
		t6.setColumns(10);
		try {
            // Initialize the database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp", "root", "Sahil@15");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query = "INSERT INTO addnewcustomers (id, mobile_number, name, gender, country, checked_in, deposit) VALUES (?, ?, ?, ?, ?, ?, ?)";
					pst = conn.prepareStatement(query);
					pst.setString(1, comboBox.getSelectedItem().toString());
					pst.setString(2, t1.getText());
					pst.setString(3, t2.getText());
					pst.setString(4, (r1.isSelected() ? "Male" : "Female"));
					pst.setString(5, t3.getText());
					pst.setString(6, t6.getText());
					pst.setString(7, t5.getText()); 
					
					
					int rowsInserted = pst.executeUpdate();
					if (rowsInserted > 0) {
						JOptionPane.showMessageDialog(null, "New customer added successfully!");
					}
					
				} catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				} finally {
					try {
						if (pst != null) {
							pst.close();
						}
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}

			
			}
		}

		);
		btnNewButton.setBounds(100, 430, 120, 30);
		btnNewButton.setBackground(new Color(150, 3, 72));
		btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);

		JButton btnExit = new JButton("Back");
		// btnExit.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		new Reception().setVisible(true);
		// 		setVisible(false);
		// 	}
		// });
		btnExit.setBounds(260, 430, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		getContentPane().setBackground(Color.WHITE);
	}
}