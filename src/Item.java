import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworker
 * Date: 8/1/13
 * Time: 11:33 AM
 * To change this template use File | Settings | File Templates.
 */
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

    public double calculateSalesTax() {
        if (!name.contains("pills") && !name.contains("book") && !name.contains("chocolate")) {
            tax += roundNumber(price * .1);
        }
        if(imported) {
            tax += roundNumber(price * .05);
        }
        price += tax;
        return tax;
    }

    public Double roundNumber(double totalTax) {
        DecimalFormat number = new DecimalFormat("0.00");
        Double tax = Double.parseDouble(number.format(totalTax));
        return tax;
    }

    public String toString(){
    return quantity + " " + name + String.format("%.2f",price);
    }


}
