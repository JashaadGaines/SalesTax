import org.junit.Test;

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
    @Test
    public void shouldContainItemQuantityAndNamed(){
           Item item = new Item(1,"book",10.00,false);
            assertThat(item.toString(), containsString("book"));
            assertThat(item.toString(), containsString("1"));
            assertThat(item.toString(), containsString("10.00"));
    }


}
