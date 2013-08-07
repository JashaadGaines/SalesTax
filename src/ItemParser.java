import java.util.Arrays;

public class ItemParser {

    public Item parseItem(String lineItem) {

        String[] words = lineItem.split(" ");
        Item item = new Item(Integer.parseInt(words[0]), extractGoodItem(words), extractPrice(words), lineItem.contains("imported"));
//        addToTotals(item.getPrice(), item.getTax());
        System.out.println(item);
        return item;
    }

    private double extractPrice(String[] line){
        double price = Double.parseDouble(line[line.length - 1]);
        return price;
    }

    private String extractGoodItem(String[] line){
        String[] newWords = new String[line.length - 2];
        System.arraycopy(line, 0, newWords, 0, newWords.length);
        String goodItems = concatenateArray(Arrays.copyOfRange(newWords, 1, newWords.length));
        return goodItems;
    }

    public String concatenateArray(String[] array) {
        String concat = "";
        for (String item : array) {
            concat += item + " ";
        }
        return concat;
    }
}
