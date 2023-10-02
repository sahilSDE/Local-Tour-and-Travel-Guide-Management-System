package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

        public static void main(String[] args) {
                new Dashboard().setVisible(true);
        }

        public Dashboard() {
                super("Tour And Travel Management Sytem");

                setForeground(Color.CYAN);
                setLayout(null);

                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/oop img 1.jpg"));
                

                Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel NewLabel = new JLabel(i3);
                NewLabel.setBounds(0, 0, 1750, 1000);
                add(NewLabel);

                JLabel AirlineManagementSystem = new JLabel("Welcome to VIT tours and travel");
                AirlineManagementSystem.setForeground((new Color(199, 171, 179)));
                AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 44));
                AirlineManagementSystem.setBounds(860, 40, 1000, 85);
                NewLabel.add(AirlineManagementSystem);

                JMenuBar menuBar = new JMenuBar();
                setJMenuBar(menuBar);

                JMenu AirlineSystem = new JMenu( "TRAVELLER");
                AirlineSystem.setForeground(new Color(150, 3, 72));
                menuBar.add(AirlineSystem);

                JMenuItem FlightDetailshello1 = new JMenuItem("LOGIN");
                AirlineSystem.add(FlightDetailshello1);

                FlightDetailshello1.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                                try {
                                        new Login().setVisible(true);
                                } catch (Exception e) {
                                }
                        }
                });

                JMenuItem FlightDetailshello2 = new JMenuItem("REGISTERATION");
                AirlineSystem.add(FlightDetailshello2);

                FlightDetailshello2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                                try {
                                        new Registrationform().setVisible(true);
                                } catch (Exception e) {
                                }
                        }
                });

                JMenuItem FlightDetailshello3 = new JMenuItem("ADD ROOM");
                AirlineSystem.add(FlightDetailshello3);

                FlightDetailshello3.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                                try {
                                        new AddRoom().setVisible(true);
                                } catch (Exception e) {
                                }
                        }
                });

                JMenuItem FlightDetailshello4 = new JMenuItem("SEARCH ROOM");
                AirlineSystem.add(FlightDetailshello4);

                FlightDetailshello4.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                                try {
                                        new HotelFilterGUI().setVisible(true);
                                } catch (Exception e) {
                                }
                        }
                });    

                JMenuItem FlightDetails = new JMenuItem("");
                AirlineSystem.add(FlightDetails);

                JMenu AirlineSystemHello = new JMenu("ADMIN");
                AirlineSystemHello.setForeground(new Color(5, 96, 176));
                menuBar.add(AirlineSystemHello);

                
                JMenuItem flightDetailshello3 = new JMenuItem("NEW CUSTOMER");
                AirlineSystemHello.add(flightDetailshello3);

                flightDetailshello3.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                                try {
                                        new NewCustomer().setVisible(true);
                                } catch (Exception e) {
                                }
                        }
                });

                setSize(1950, 1090);
                setVisible(true);
                getContentPane().setBackground(Color.WHITE);
        }
}

