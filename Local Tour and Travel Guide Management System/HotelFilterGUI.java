package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HotelFilterGUI extends JFrame {
    private final JLabel minPriceLabel;
    private final JLabel maxPriceLabel;
    private final JTextField minPriceField;
    private final JTextField maxPriceField;
    private final JButton filterButton;
    private final JPanel hotelListPanel;
    private final ArrayList<Hotel> hotels;

    public HotelFilterGUI() {
        super("Hotel Filter");

        // Create example hotels
        hotels = new ArrayList<>();
        hotels.add(new Hotel("Hotel Abhi Park,Balajinagar, Satara Rd, Dhanakvadi, Pune City", 1926));
        hotels.add(new Hotel("Prashik Lodge Near Laxminarayan Theatre, Satara Rd, Panchod, Katraj, Pune City", 314));
        hotels.add(new Hotel("Hotel Sagar Executive, Near Pune-Bengaluru Highway",1800 ));
        hotels.add(new Hotel("Pranav Home Yana Heights, Near vitthal Mandir, Kondhwa, Pune City", 743));
        hotels.add(new Hotel("OYO Flagship 81055 Relaxe Lodge, Behind PICT College Wall Compound, Dhanakwadi, Pune City", 1226));
        hotels.add(new Hotel("Sayba Inn Lodging, Triputi Nagar, Pune Satara Road", 1349));
        hotels.add(new Hotel("Nachiket Vardhan Executive,15, Katraj, Pune City", 2267));
        hotels.add(new Hotel("HMR Hotels-Hotels HMR Royal Inn, Pune Satara Road Near Maruti Chowgule Workshop, Katraj, Pune City", 2037));
        hotels.add(new Hotel("Hotel Rajdeep, Dadawadi, Shukravar Peth Swargate, Pune", 2448));
        hotels.add(new Hotel("TownHouse OAK Hotel Golden Emerald Near Shreemanth Dagdusheth Halwai Ganpati Mandir, Pune", 2979));
        hotels.add(new Hotel("Serene Living, Sahyardi Park, Kondhwa, Pune", 2549));
        hotels.add(new Hotel("Hotel Pranav Executive, Kondhwa, Pune", 2749));
        hotels.add(new Hotel("Royal Residency, Elina Living Road, Pune", 3250));
        hotels.add(new Hotel("FabHotel Nandanvan, Market Yard Road, 6/690, Pune", 3503));
        hotels.add(new Hotel("Hotel Utsav Delux, 692/693, Chapahalkar Centre, Market Yard Road, Pune", 3500));
        hotels.add(new Hotel("The Grand Tulip, 1010, Shukravar Peth, Swargate Square, Pune", 3657));
        hotels.add(new Hotel("Royal Humming Bird, Marvel Isola, Pune", 3713));
        hotels.add(new Hotel("Treebo Trend Classic grande, MG road, New Modikhana, Pune", 3972));
        hotels.add(new Hotel("Hotel Utsav Delux, Market Yard Road, Pune", 4350));
        hotels.add(new Hotel("Collection O Hotel Pearl, J M Road, Shivaji Nagar, Pune", 4673));
        hotels.add(new Hotel("Ramee Grand Hotel and Spa, Apte Road, Shivaji Nagar, Pune", 4950));
        hotels.add(new Hotel("Deccan Pavilion, Near Sinhagad College, Narhe Ambegaon, Pune", 5399));
        hotels.add(new Hotel("Hotel Ketan, 917/19A Shivajinagar, Fergusson College Road, Pune", 5890));
        hotels.add(new Hotel("Hotel Aurora Towers, 9 Moledina Road, Pune", 6299));
        hotels.add(new Hotel("Bougainvillea Resort, Mulshi khurd, Pune", 6600));

        // Create filter panel
        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new GridLayout(3, 2));
        minPriceLabel = new JLabel("Minimum Price:");
        filterPanel.add(minPriceLabel);
        minPriceField = new JTextField(10);
        filterPanel.add(minPriceField);
        maxPriceLabel = new JLabel("Maximum Price:");
        filterPanel.add(maxPriceLabel);
        maxPriceField = new JTextField(10);
        filterPanel.add(maxPriceField);
        filterButton = new JButton("Filter");
        filterButton.addActionListener(new FilterButtonListener());
        filterButton.setBackground(new Color(150, 3, 72));
        filterButton.setForeground(Color.WHITE);
        filterPanel.add(filterButton);

        // Create hotel list panel
        hotelListPanel = new JPanel();
        hotelListPanel.setLayout(new BoxLayout(hotelListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(hotelListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add filter panel and hotel list panel to frame
        Container contentPane = getContentPane();
        contentPane.add(filterPanel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Set frame properties
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void displayHotels(ArrayList<Hotel> hotels) {
        hotelListPanel.removeAll();
        hotelListPanel.add(new JLabel("Hotel List Of One Day For One Customer"));
        hotelListPanel.add(Box.createVerticalStrut(10));
        for (Hotel hotel : hotels) {
            JLabel hotelLabel = new JLabel(hotel.getName() + " - " + hotel.getPrice());
            hotelListPanel.add(hotelLabel);
        }
        hotelListPanel.revalidate(); 
        hotelListPanel.repaint();
    }

    private class FilterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int minPrice = Integer.parseInt(minPriceField.getText());
            int maxPrice = Integer.parseInt(maxPriceField.getText());
            ArrayList<Hotel> filteredHotels = new ArrayList<>();
            for (Hotel hotel : hotels) {
                if (hotel.getPrice() >= minPrice && hotel.getPrice() <= maxPrice) {
                    filteredHotels.add(hotel);
                }
            }
            displayHotels(filteredHotels);
        }
    }

    public static void main(String[] args) {
        new HotelFilterGUI();
    }
}

