package uni.aed.model;

public class Software {

    String name;
    String version;
    int quantity;
    int price;

    public Software(String name, String version, int quantity, int price) {
        this.name = name;
        this.version = version;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + version + " " + quantity + " " + price;
    }
}
