import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworker
 * Date: 8/1/13
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
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
        assertThat(item.calculateSalesTax(), is(1.50));

    }

    @Test
    public void shouldRoundTax() {
        assertThat(item.roundNumber(1.495), is(1.50));
    }

}
