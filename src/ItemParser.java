import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Double.parseDouble;

public class ItemParser {

    public Item parseItem(String lineItem) {

        List<String> words = new ArrayList<String>(Arrays.asList(lineItem.split(" ")));
        double price = extractPrice(words);
        return new Item(Integer.parseInt(words.get(0)), extractGoodItem(words), price, lineItem.contains("imported"));
    }

    private double extractPrice(List<String> line){
        return parseDouble(getLastElement(line));
    }

    private String getLastElement(List<String> line) {
        return line.get(line.size()-1);
    }

    private String extractGoodItem(List<String> line){
        line = line.subList(1, line.size()-2);
        return concatenateArray(line);
    }

    public String concatenateArray(List<String> list) {
        String concat = "";
        for (String item : list) {
            concat += item + " ";
        }
        return concat;
    }
}
