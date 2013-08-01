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
        setPrice(price); setName(name); setImported(imported); setQuantity(quantity);
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

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }
}
