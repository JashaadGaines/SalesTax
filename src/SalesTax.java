import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SalesTax {
    static ArrayList<Item> itemList = new ArrayList<Item>();
    static double totalTax = 0.00, grandTotal = 0.00;

    public static void main(String[] args) throws IOException {
        SalesTax salesTax = new SalesTax();
        salesTax.readInput("/Users/Thoughtworker/Documents/SalesTax.txt");
        for (int i=0; i < itemList.size(); i++) {
             addToTotals(itemList.get(i).getPrice(), itemList.get(i).getTax());
//            System.out.println(item);
        }
        System.out.println(salesTax);
    }

    public void readInput(String filename) throws IOException {
        Scanner reader = new Scanner(new FileReader(filename));
        while (reader.hasNext()) {
            itemList.add(new ItemParser().parseItem(reader.nextLine()));
        }
    }

    public static void addToTotals(double price, double tax) {
        totalTax += tax;
        grandTotal += price;
    }

    public String toString() {
        return "Sales Taxes: " + String.format("%.2f", totalTax) + "\nTotal: " + String.format("%.2f", grandTotal);
    }
}
