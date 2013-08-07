import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemParserTest {
    private ItemParser itemParser;


    @Test
    public void shouldParseItem() {
        Item item = itemParser.parseItem("1 music cd at 14.99");
        assertThat(item.getName(), is("book "));
        assertTrue(item.getQuantity() == 1 ) ;
        assertTrue(item.getPrice() == 12.49);
    }

    @Test
    public void shouldConcatenateArrayToString() {
        String[] newline = {"The", "Big", "dog", "ate", "little", "animals"};
        assertThat(itemParser.concatenateArray(newline), is("The Big dog ate little animals "));
    }

}
