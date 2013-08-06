import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Thoughtworker
 * Date: 7/31/13
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class SalesTaxTest {
    private SalesTax salesTax;

    @Before
    public void setUp() throws IOException {
        salesTax = new SalesTax();
        String filename = "/Users/Thoughtworker/Documents/SalesTax.txt";
        salesTax.readInput(filename);
    }

    @Test
    public void shouldReadFromTextFile() throws IOException {

        assertThat(salesTax.itemList.get(0).getName(),is("book "));
        assertThat(salesTax.itemList.get(1).getName(),is("music CD "));
        assertThat(salesTax.itemList.get(2).getPrice(),is(0.85));
    }

    @Test
    public void shouldFindExceptionGoods() {

        assertTrue(salesTax.checkForWord("2 pills", "pills"));
        assertTrue(salesTax.checkForWord("2 book", "book"));
        assertTrue(salesTax.checkForWord("2 chocolates", "chocolates"));
    }

    @Test
    public void shouldAddToOverallTotal() {
        double price = 10.00, totalTax = .5;
        salesTax.addToTotals(price, totalTax);
        assertThat(salesTax.totalTax, is(.50));
        assertThat(salesTax.grandTotal, is(10.50));
    }

    @Test
    public void shouldConcatenateArrayToString() {
        String[] newline = {"The", "Big", "dog", "ate", "little", "animals"};
        assertThat(salesTax.concatenateArray(newline), is("The Big dog ate little animals "));
    }

    @Test
    public void shouldParseItem() {
        salesTax.itemParser("1 music cd at 14.99");
        Item newGood = salesTax.itemParser("1 book at 12.49");
        assertThat(newGood.getName(), is("book "));
        assertTrue(newGood.getQuantity() == 1 ) ;
        assertTrue(newGood.getPrice() == 12.49);
    }

    @Test
    public void shouldCalculateGrandTotals(){
        assertThat(salesTax.grandTotal, is(28.33));
    }



}
