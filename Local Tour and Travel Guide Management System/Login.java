package hotel.management.system;
import java.awt.*;//abstract window toolkit
import javax.swing.*;//create modern gui
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    Connection con;


    Login(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp", "root", "Sahil@15");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,10,150,150);
        add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.BLACK);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b2.addActionListener(this);
        
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,300);
        setLocation(600,350);

    }

    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String uname = t1.getText();
            String pass = new String(t2.getPassword());

            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE username='" + uname + "' AND password='" + pass + "'");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Login Successful!");
                    PreparedStatement stmt1 = con.prepareStatement("INSERT INTO login (username, password) VALUES (?,?)");
                    stmt1.setString(1, uname);
                    stmt1.setString(2, pass);
                    stmt1.executeUpdate();

                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password!");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (e.getSource() == b2) {
            t1.setText("");
            t2.setText("");
        }
    }
    
    public static void main(String[] arg){
        new Login();
    }
}
