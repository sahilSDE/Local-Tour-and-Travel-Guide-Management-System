package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class new1 extends JFrame implements ActionListener {
    private JTextField nameField, idField, majorField;
    private JButton addButton, deleteButton, updateButton, clearButton;

    public new1() {
        super("Student Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create labels and text fields for student info
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(20);
        JLabel majorLabel = new JLabel("Major:");
        majorField = new JTextField(20);

        // create buttons for adding, deleting, updating, and clearing info
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        // create panel for student info
        JPanel infoPanel = new JPanel(new GridLayout(3, 2));
        infoPanel.add(nameLabel);
        infoPanel.add(nameField);
        infoPanel.add(idLabel);
        infoPanel.add(idField);
        infoPanel.add(majorLabel);
        infoPanel.add(majorField);

        // create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(clearButton);

        // add panels to main frame
        setLayout(new BorderLayout());
        add(infoPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // add student info to database
            String name = nameField.getText();
            String id = idField.getText();
            String major = majorField.getText();
            // TODO: add code to add student info to database
        } else if (e.getSource() == deleteButton) {
            // delete student info from database
            String id = idField.getText();
            // TODO: add code to delete student info from database
        } else if (e.getSource() == updateButton) {
            // update student info in database
            String name = nameField.getText();
            String id = idField.getText();
            String major = majorField.getText();
            // TODO: add code to update student info in database
        } else if (e.getSource() == clearButton) {
            // clear all fields
            nameField.setText("");
            idField.setText("");
            majorField.setText("");
        }
    }

    public static void main(String[] args) {
        new new1();
    }
}

