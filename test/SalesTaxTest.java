import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

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
    public void setUp() {
        salesTax = new SalesTax();
    }

    @Test
    public void shouldReadFromTextFile() throws IOException {
        String filename = "/Users/Thoughtworker/Documents/SalesTax.txt";
        salesTax.readInput(filename);
        assertThat(salesTax.itemList.get(0).getName(),is("book "));
    }

    @Test
    public void shouldFindExceptionGoods() {

        assertTrue(salesTax.checkForWord("2 pills", "pills"));
        assertTrue(salesTax.checkForWord("2 book", "book"));
        assertTrue(salesTax.checkForWord("2 chocolates", "chocolates"));
    }

    @Test
    public void shouldCalculateTaxForItem() {

        assertThat(salesTax.calculateSalesTax(5, "CD"), is(.50));
        assertThat(salesTax.calculateSalesTax(5, "book"), is(0.));
        assertThat(salesTax.calculateSalesTax(5, "pills"), is(0.));
        assertThat(salesTax.calculateSalesTax(5, "chocolates"), is(0.));
    }

    @Test
    public void shouldAddImportTaxToImports() {
        assertThat(salesTax.calculateImportTax(5, "1 imported box of chocolate fairies"), is(.25));
        assertThat(salesTax.calculateImportTax(5, "1 normal box of chocolate fairies"), is(0.0));

    }

    @Test
    public void shouldRoundTax() {
        assertThat(salesTax.roundTax(1.495), is(1.50));
    }

    @Test
    public void shouldGetTotalItemTaxRounded() {
        assertThat(salesTax.totalItemTax(12.49, "book"), is(0.));
        assertThat(salesTax.totalItemTax(14.99, "CD"), is(1.50));
        assertThat(salesTax.totalItemTax(10.00, "imported chocolates"), is(.50));
        assertThat(salesTax.totalItemTax(27.99, "imported perfume"), is(4.20));
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
    public void shouldPrintTotals() {
        double price = 9.00, totalTax = 1.50;
        salesTax.addToTotals(price, totalTax);
        assertThat(salesTax.printTotals(), is("Sales Taxes: 1.5\nTotal: 10.5"));
    }

    @Test
    public void shouldParseItem() {
        salesTax.itemParser("1 music cd at 14.99");
        Item newGood = salesTax.itemParser("1 book at 12.49");
        assertThat(newGood.getName(), is("book "));
        assertTrue(newGood.getQuantity() == 1 ) ;
        assertTrue(newGood.getPrice() == 12.49);
        assertTrue(newGood.isImported() == false);
    }

    @Test
    public void shouldPrintGrandTotal(){

    }

}
