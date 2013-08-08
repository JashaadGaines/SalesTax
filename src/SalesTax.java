import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesTax {
    private static ArrayList<Item> itemList = new ArrayList<Item>();
    static double totalTax = 0.00, grandTotal = 0.00;
    private ItemParser translator = new ItemParser();
    static SalesTax salesTax = new SalesTax();

    public static void main(String[] args) throws IOException {
        salesTax.readInput("/Users/Thoughtworker/Documents/SalesTax.txt");
        printReceipt();
    }

    public void readInput(String filename) throws IOException {
        Scanner reader = new Scanner(new FileReader(filename));
        while (reader.hasNext()) {
            itemList.add(translator.parseItem(reader.nextLine()));
        }
    }

    public static void addToTotals(double price, double tax) {
        totalTax += tax;
        grandTotal += price + tax;
    }

    public static void printReceipt(){
        for (int i=0; i < itemList.size(); i++) {
            addToTotals(itemList.get(i).getPrice(), itemList.get(i).getTax());
            System.out.println(itemList.get(i));
        }
        System.out.println(salesTax);
    }

    public static ArrayList<Item> getItemList() {
        return itemList;
    }

    public String toString() {
        return "Sales Taxes: " + String.format("%.2f", totalTax) + "\nTotal: " + String.format("%.2f", grandTotal);
    }
}
