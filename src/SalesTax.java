import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworker
 * Date: 7/31/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class SalesTax {
    double totalTax , grandTotal;

    public String readInput(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String input = reader.readLine();
        return input;
    }

    public boolean checkGood(String goods) {
        if (goods.equals("pills") || goods.equals("book") || goods.equals("chocolates"))
            return true;
        else
            return false;
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
        DecimalFormat number = new DecimalFormat("0.##");
        return Double.parseDouble(number.format(totalTax));
    }


    public void addToTotals(double price, double totalTax) {
        this.totalTax += totalTax;
        grandTotal += totalTax + price;
    }

    public String printItem(String lineItem, Double price) {
        String[] words = lineItem.split(" ");
        words[words.length-1] = price.toString();
        words[words.length-2] = ":";

        return concatenateArray(words);

    }



    public  String concatenateArray(String[] array){
         String concat = "";
        for(String item: array){
             concat += item + " ";
         }
        return concat;
    }
}
