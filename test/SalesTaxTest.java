import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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

        assertThat(salesTax.getItemList().get(0).getName(),is("book "));
        assertThat(salesTax.getItemList().get(1).getName(),is("music CD "));
        assertThat(salesTax.getItemList().get(2).getPrice(),is(0.85));
    }

    @Test
    public void shouldAddPriceToGrandTotal() {
        salesTax.addToTotals(salesTax.getItemList().get(1).getPrice(), 0);
        assertThat(salesTax.grandTotal, is(14.99));
    }

    @Test
    public void shouldCalculateGrandTotal(){
        salesTax.addToTotals(0, salesTax.getItemList().get(1).getTax());
        assertThat(salesTax.totalTax, is(1.5));
    }
}
