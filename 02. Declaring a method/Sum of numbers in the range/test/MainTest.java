import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testSumInRangeWithValidInput() {
        simpleTest("1", "1 2");
    }

    @Test
    public void testSumInRangeWithEmptyRange() {
        simpleTest("0", "5 5");
    }

    @Test
    public void testSumInRangeWithNegativeRange() {
        simpleTest("-40", "-10 -5");
    }

    @Test
    public void testSumInRangeWithLargeNumbers() {
        simpleTest("499949999505000000", "10000000 1000000000");
    }

    @Test
    public void testSumInRangeWithSwappedInput() {
        simpleTest("35", "5 10");
    }

    @Test
    public void testSumInRangeWithSameNegativeValues() {
        simpleTest("0", "-3 -3");
    }

    @Test
    public void testSumInRangeWithSamePositiveValues() {
        simpleTest("0", "10 10");
    }

    @Test
    public void testSumInRangeWithNegativeToPositiveRange() {
        simpleTest("-5", "-5 5");
    }

    @Test
    public void testSumInRangeWithMaxIntValues() {
        simpleTest("576460751766552576", "0 1073741824");
    }

    @Test
    public void testSumInRangeWithMinIntValues() {
        simpleTest("-576460752840294400", "-1073741824 0");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}