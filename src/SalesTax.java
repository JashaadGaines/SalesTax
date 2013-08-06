import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworker
 * Date: 7/31/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class SalesTax {
    static ArrayList<Item> itemList = new ArrayList<Item>();
    double totalTax = 0.00, grandTotal = 0.00;

    public static void main(String[] args) throws IOException {
        SalesTax salesTax = new SalesTax();
        salesTax.readInput("/Users/Thoughtworker/Documents/SalesTax.txt");
        for (Item item : itemList) {
            System.out.println(item);
        }
        System.out.println(salesTax);
    }

    public void readInput(String filename) throws IOException {
        Scanner reader = new Scanner(new FileReader(filename));
        while (reader.hasNext()) {
            itemList.add(itemParser(reader.nextLine()));
        }
    }

    public Item itemParser(String lineItem) {
        String[] words = lineItem.split(" ");
        double price = Double.parseDouble(words[words.length - 1]);
        String[] newWords = new String[words.length - 2];
        System.arraycopy(words, 0, newWords, 0, newWords.length);
        String goodItems = concatenateArray(Arrays.copyOfRange(newWords, 1, newWords.length));
        Item item = new Item(Integer.parseInt(newWords[0]), goodItems, price, checkForWord(lineItem, "imported"));

        addToTotals(item.getPrice(), item.getTax());
        return item;
    }


    public boolean checkForWord(String sentence, String keyWord) {
            if (sentence.contains(keyWord)) {
                return true;
            }
        return false;
    }




    public void addToTotals(double price, double totalTax) {
        this.totalTax += totalTax;
        grandTotal += price;
    }

    public String concatenateArray(String[] array) {
        String concat = "";
        for (String item : array) {
            concat += item + " ";
        }
        return concat;
    }

    public String toString() {
        return "Sales Taxes: " + String.format("%.2f", totalTax) + "\nTotal: " + String.format("%.2f", grandTotal);
    }
}
