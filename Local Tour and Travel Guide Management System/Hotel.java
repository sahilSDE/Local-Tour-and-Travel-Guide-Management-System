package hotel.management.system;

public class Hotel {
    private String name;
    private int price;

    public Hotel(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

