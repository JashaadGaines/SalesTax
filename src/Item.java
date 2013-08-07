
public class Item {
    private double price;
    private String name;
    private int quantity;
    private boolean imported;
    private double tax;

    public Item(int quantity,String name, double price, boolean imported) {

        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.imported = imported;
        calculateSalesTax();
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
        return tax;
    }

    public void calculateSalesTax() {
//        if (!name.contains("pills") && !name.contains("book") && !name.contains("chocolate")) {
//            tax += roundNumber(price * .1, .05);
//        }
//        if(imported) {
//            tax += roundNumber(price * .05, .05);
//        }
//        price += tax;

    }

    public Double roundNumber(double totalTax, double v){
        return Math.ceil(totalTax/v)*v;
    }

    public String toString(){
        return quantity + " " + name + String.format("%.2f",price);
    }
}
