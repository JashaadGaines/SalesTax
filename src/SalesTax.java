import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
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
        //System.out.println("grandtotal= " + salesTax.grandTotal);

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
        addToTotals(price, 0);
        String[] newWords = new String[words.length - 2];
        System.arraycopy(words, 0, newWords, 0, newWords.length);
        String goodItems = concatenateArray(Arrays.copyOfRange(newWords, 1, newWords.length));
        return new Item(Integer.parseInt(newWords[0]), goodItems, price, checkForWord(lineItem, "imported"));
    }

    public double calculateSalesTax(double price, String lineItem) {
        double amount;
        if (checkForWord(lineItem, "pills") || checkForWord(lineItem, "book") || checkForWord(lineItem, "chocolates")) {
            amount = 0;
        } else {
            amount = price * .1;
        }
        return amount;
    }

    public boolean checkForWord(String sentence, String keyWord) {
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (word.equals(keyWord)) {
                return true;
            }
        }
        return false;
    }

    public double calculateImportTax(double price, String lineItem) {
        double amount;
        if (checkForWord(lineItem, "imported")) {
            amount = price * .05;
        } else {
            amount = 0;
        }
        return amount;
    }


    public double totalItemTax(double price, String lineItem) {
        return roundTax(calculateSalesTax(price, lineItem) + calculateImportTax(price, lineItem));
    }

    public Double roundTax(double totalTax) {
        DecimalFormat number = new DecimalFormat("0.00");
        return Double.parseDouble(number.format(totalTax));
    }


    public void addToTotals(double price, double totalTax) {
        this.totalTax += totalTax;
        grandTotal += totalTax + price;
        totalTax = roundTax(totalTax);
        grandTotal = roundTax(grandTotal);
    }

    public String concatenateArray(String[] array) {
        String concat = "";
        for (String item : array) {
            concat += item + " ";
        }
        return concat;
    }

    public BigDecimal doubleToBigDecimal(Double number) {
        BigDecimal decimalNumber = new BigDecimal(number);
        decimalNumber.setScale(3);
        return decimalNumber;
    }

    public String printTotals() {
        System.out.println("Sales Taxes: " + doubleToBigDecimal(totalTax) + "\nTotal: " + doubleToBigDecimal(grandTotal));
        return "Sales Taxes: " + doubleToBigDecimal(totalTax) + "\nTotal: " + doubleToBigDecimal(grandTotal);
    }
}
