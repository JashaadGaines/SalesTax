import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemParserTest {
    private ItemParser itemParser;
    Item item;

    @Before
    public void setUp(){
        itemParser = new ItemParser();
        item = itemParser.parseItem("1 music cd at 14.99");
    }

    @Test
    public void shouldGetQuantityFromParsedString() {
        assertThat(item.getQuantity(), is(1));
    }

    @Test
    public void shouldGetItemNameFromParsedString(){
        assertThat(item.getName(), is("music cd "));
    }

    @Test
    public void shouldGetPriceFromParsedString(){
        assertThat(item.getPrice(), is(14.99));
    }


}
