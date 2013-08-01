/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworker
 * Date: 8/1/13
 * Time: 11:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class Item {
    double price;
    String name;
    int quantity;
    boolean imported;

    public Item(int quantity,String name, double price, boolean imported) {

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

    public boolean isImported() {
        return imported;
    }

    public String toString(){
    return quantity + " " + name + String.format("%.2f",price);
    }


}
