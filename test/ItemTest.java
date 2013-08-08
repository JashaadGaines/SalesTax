
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class ItemTest {
    Item item;

    @Test
    public void shouldConvertItemToString(){
        item = new Item(1,"book",10.00,false);
        assertThat(item.toString(), containsString("book"));
        assertThat(item.toString(), containsString("1"));
        assertThat(item.toString(), containsString("10.00"));
    }

    @Test
    public void shouldHaveTenPercentTaxForItem(){
        Item item = new Item(1, "Some Item", 1.00, false);
        assertThat(item.getTax(), is(0.10));
    }

    @Test
    public void shouldHaveTenPercentTaxForItemWithDifferentPrice(){
        Item item = new Item(1, "Some Item", 1.10, false);
        assertThat(item.getTax(), is(.15 + Math.ulp(.15)));
    }

    @Test
    public void shouldHaveAdditionalFivePercentImportTaxWhenItemIsImported(){
         Item item = new Item(1, "Some Item", 1.00, true);
        assertThat(item.getTax(), is(.15+Math.ulp(.15)));
    }

    @Test
    public void shouldNotTaxBooksPillsOrChocolates(){
        Item item = new Item(1, "book", 1.00, false);
        assertThat(item.getTax(), is(0.));
    }

    @Test
    public void shouldNotTaxPills(){
        Item item = new Item(1, "pill", 1.00, false);
        assertThat(item.getTax(), is(0.));
    }

    @Test
    public void shouldNotTaxChocolates(){
        Item item = new Item(1, "chocolate", 1.00, false);
        assertThat(item.getTax(), is(0.));
    }

    @Test
    public void shouldRoundTax() {
        item = new Item(1,"perfume",10.00,true);
        assertThat(item.roundNumber(1.495, .05), is(1.50));
        assertThat(item.roundNumber(1.495,.05), is(1.50));
    }

}
