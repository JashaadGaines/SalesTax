
public class Item {
    private int quantity;
    private String name;
    private double price;
    private boolean imported;
    private double tax;

    public Item(int quantity, String name, double price, boolean imported) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.imported = imported;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTax() {
        if (!name.contains("pill") && !name.contains("book") && !name.contains("chocolate")) {
            tax += roundNumber(price * .1, .05);
        }
        if(imported) {
            tax += roundNumber(price * .05, .05);
        }
        return tax;
    }

    public  Double roundNumber(double i, double v){
        return Math.ceil(i/v) * v;
    }

    public String toString(){
        return quantity + " " + name + String.format("%.2f",price+tax);
    }
}
