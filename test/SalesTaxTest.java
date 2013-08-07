import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertTrue;
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

        assertThat(salesTax.itemList.get(0).getName(),is("book "));
        assertThat(salesTax.itemList.get(1).getName(),is("music CD "));
        assertThat(salesTax.itemList.get(2).getPrice(),is(0.85));
    }

    @Test
    public void shouldAddToOverallTotal() {
        double price = 10.00, totalTax = .5;
        salesTax.addToTotals(price, totalTax);
        assertThat(salesTax.totalTax, is(.50));
        assertThat(salesTax.grandTotal, is(10.50));
    }

    @Test
    public void shouldCalculateGrandTotals(){
        assertThat(salesTax.grandTotal, is(28.33));
    }



}
