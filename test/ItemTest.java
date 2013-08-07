
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.containsString;

public class ItemTest {
    Item item;

    @Test
    public void shouldContainItemQuantityAndNamed(){
            item = new Item(1,"book",10.00,false);
            assertThat(item.toString(), containsString("book"));
            assertThat(item.toString(), containsString("1"));
            assertThat(item.toString(), containsString("10.00"));
    }


    @Test
    public void shouldCalculateTaxForItem() {
        item = new Item(1,"perfume",10.00,true);
        Item item1 = new Item(1, "book", 10.00, false);
        assertThat(item.getTax(), is(1.50));
        assertThat(item1.getTax(), is(0.));

    public void shouldHaveTenPercentTaxForItem(){
        Item item = new Item(1, "Some Item", 1.00, false);
        assertThat(item.getTax(), is(0.10));
    }

    @Test
    public void shouldHaveTenPercentTaxForItemWithDifferentPrice(){
        Item item = new Item(1, "Some Item", 1.10, false);
        double tax = item.getTax();
        assertTrue(0.1099999 < tax && tax < .11000001);
    }

    @Test
    public void shouldHaveAdditionalFivePercentImportTaxWhenItemIsImported(){

    }

    @Test
    public void shouldRoundTax() {
        item = new Item(1,"perfume",10.00,true);
        assertThat(item.roundNumber(1.495, .05), is(1.50));
        assertThat(item.roundNumber(1.495,.05), is(1.50));
    }

}
