package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Registrationform extends JFrame implements ActionListener {
    private JTextField firstNameField, lastNameField, addressField, emailField, phoneField, usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> genderComboBox;
    private JButton submitButton, clearButton;
    private JLabel imageLabel;

    public Registrationform() {
        setTitle("Registration Form");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel l10 = new JLabel("Register Here");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        constraints.gridx = 1;
        constraints.gridy = 0;
	    formPanel.add(l10,constraints);

        JLabel firstNameLabel = new JLabel("First Name: ");
        firstNameLabel.setForeground(new Color(25, 25, 112));
        firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        // firstNameLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        constraints.gridx = 0;
        constraints.gridy = 1;
        formPanel.add(firstNameLabel, constraints);

        firstNameField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        formPanel.add(firstNameField, constraints);

        JLabel lastNameLabel = new JLabel("Last Name: ");
        lastNameLabel.setForeground(new Color(150, 3, 72));
        lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        // lastNameLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        constraints.gridx = 0;
        constraints.gridy = 2;
        formPanel.add(lastNameLabel, constraints);

        lastNameField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        formPanel.add(lastNameField, constraints);

        JLabel addressLabel = new JLabel("Address: ");
        addressLabel.setForeground(new Color(25, 25, 112));
        addressLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        // addressLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        constraints.gridx = 0;
        constraints.gridy = 3;
        formPanel.add(addressLabel, constraints);

        addressField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        formPanel.add(addressField, constraints);

        JLabel genderLabel = new JLabel("Gender: ");
        genderLabel.setForeground(new Color(150, 3, 72));
        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        // genderLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        constraints.gridx = 0;
        constraints.gridy = 4;
        formPanel.add(genderLabel, constraints);

        genderComboBox = new JComboBox<>(new String[] { "Male", "Female", "Other" });
        constraints.gridx = 1;
        constraints.gridy = 4;
        formPanel.add(genderComboBox, constraints);

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setForeground(new Color(25, 25, 112));
        emailLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        // emailLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        constraints.gridx = 0;
        constraints.gridy = 5;
        formPanel.add(emailLabel, constraints);

        emailField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        formPanel.add(emailField, constraints);

        JLabel phoneLabel = new JLabel("Phone: ");
        phoneLabel.setForeground(new Color(150, 3, 72));
        phoneLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        // phoneLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        constraints.gridx = 0;
        constraints.gridy = 6;
        formPanel.add(phoneLabel, constraints);

        phoneField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 6;
        formPanel.add(phoneField, constraints);

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setForeground(new Color(25, 25, 112));
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        // usernameLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        constraints.gridx = 0;
        constraints.gridy = 7;
        formPanel.add(usernameLabel, constraints);

        usernameField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 7;
        formPanel.add(usernameField, constraints);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(new Color(150, 3, 72));
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        // passwordLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        constraints.gridx = 0;
        constraints.gridy = 8;
        formPanel.add(passwordLabel, constraints);

        passwordField = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 8;
        formPanel.add(passwordField, constraints);
       
        JPanel imagePanel = new JPanel(new BorderLayout());
        ImageIcon image = new ImageIcon("src/hotel/management/system/icons/oop img 2.jpg");
        Image i2 = image.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,1,450,350);
        add(l3);
    

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
    submitButton = new JButton("Submit");
    submitButton.addActionListener(this);
    buttonPanel.add(submitButton);
    submitButton.setBackground(new Color(150, 3, 72));
    submitButton.setForeground(Color.WHITE);

    clearButton = new JButton("Clear");
    clearButton.addActionListener(this);
    buttonPanel.add(clearButton);

    mainPanel.add(formPanel, BorderLayout.WEST);
    mainPanel.add(imagePanel, BorderLayout.EAST);
    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

    add(mainPanel);

    setVisible(true);
}

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submitButton) {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String address = addressField.getText();
        String gender = (String) genderComboBox.getSelectedItem();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp", "root", "Sahil@15");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO user (first_name, last_name, address, gender, email, phone, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, address);
            stmt.setString(4, gender);
            stmt.setString(5, email);
            stmt.setString(6, phone);
            stmt.setString(7, username);
            stmt.setString(8, password);
            
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "User registered successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Error registering user.");
            }

            con.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "MySQL JDBC driver not found.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error connecting to MySQL database.");
        }
    }
}

        // Validate input fields
    //     if (firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || email.isEmpty() || phone.isEmpty()
    //             || username.isEmpty() || password.isEmpty()) {
    //         JOptionPane.showMessageDialog(this, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
    //     } else {
    //         JOptionPane.showMessageDialog(this, "Registration successful", "Success",
    //                 JOptionPane.INFORMATION_MESSAGE);
    //         clearForm();
    //     }
    // } else if (e.getSource() == clearButton) {
    //     // Handle clear button action
    //     clearForm();
    // }



    
private void clearForm() {
    firstNameField.setText("");
    lastNameField.setText("");
    addressField.setText("");
    emailField.setText("");
    phoneField.setText("");
    usernameField.setText("");
    passwordField.setText("");
    genderComboBox.setSelectedIndex(0);
}

public static void main(String[] args) {
    new Registrationform();
}
}