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
    public void testFromProblem1() {
        simpleTest("64", "4 3");
    }

    @Test
    public void testFromProblem2() {
        simpleTest("1", "5 0");
    }

    @Test
    public void testFromProblem3() {
        simpleTest("10000000000", "10 10");
    }

    @Test
    public void testPowerWithZeroExponent() {
        simpleTest("1", "2 0");
    }

    @Test
    public void testPowerWithZeroExponentAndZeroBase() {
        simpleTest("1", "0 0");
    }

    @Test
    public void testPowerWithZeroBaseAndNonZeroExponent() {
        simpleTest("0", "0 10");
    }

    @Test
    public void testPowerWithNegativeBaseAndOddExponent() {
        simpleTest("-125", "-5 3");
    }

    @Test
    public void testPowerWithNegativeBaseAndEvenExponent() {
        simpleTest("25", "-5 2");
    }

    @Test
    public void testPowerWithPositiveExponent() {
        simpleTest("1024", "2 10");
    }

    @Test
    public void testPowerWithBaseEqualToOne() {
        simpleTest("1", "1 100");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}