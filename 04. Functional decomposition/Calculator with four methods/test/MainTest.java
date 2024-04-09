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
    public void testPowerPositiveBasePositiveExponent() {
        simpleTest("16", "2 ^ 4");
    }

    @Test
    public void testPowerNegativeBasePositiveExponent() {
        simpleTest("81", "-3 ^ 4");
    }

    @Test
    public void testPowerPositiveBaseZeroExponent() {
        simpleTest("1", "3 ^ 0");
    }

    @Test
    public void testPowerNegativeBaseZeroExponent() {
        simpleTest("1", "-3 ^ 0");
    }

    @Test
    public void testPowerLargeBase() {
        simpleTest("10000000000", "10 ^ 10");
    }

    @Test
    public void testSumPositiveNumbers() {
        simpleTest("8", "5 + 3");
    }

    @Test
    public void testSumNegativeNumbers() {
        simpleTest("-8", "-5 + -3");
    }

    @Test
    public void testSumZeroAndPositiveNumber() {
        simpleTest("5", "5 + 0");
    }

    @Test
    public void testSumZeroAndNegativeNumber() {
        simpleTest("-5", "-5 + 0");
    }

    @Test
    public void testSubtractPositiveNumbers() {
        simpleTest("2", "5 - 3");
    }

    @Test
    public void testSubtractNegativeNumbers() {
        simpleTest("-2", "-5 - -3");
    }

    @Test
    public void testSubtractZeroAndPositiveNumber() {
        simpleTest("5", "5 - 0");
    }

    @Test
    public void testSubtractZeroAndNegativeNumber() {
        simpleTest("-5", "-5 - 0");
    }

    @Test
    public void testMultiplyPositiveNumbers() {
        simpleTest("15", "5 * 3");
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        simpleTest("15", "-5 * -3");
    }

    @Test
    public void testMultiplyZeroAndNumber() {
        simpleTest("0", "5 * 0");
    }

    @Test
    public void testMultiplyTwoZeros() {
        simpleTest("0", "0 * 0");
    }

    @Test
    public void testDividePositiveNumbers() {
        simpleTest("5", "15 / 3");
    }

    @Test
    public void testDivideNegativeNumbers() {
        simpleTest("5", "-15 / -3");
    }

    @Test
    public void testDivideZeroByNumber() {
        simpleTest("0", "0 / 5");
    }

    @Test
    public void testDivideNumberByZero() {
        simpleTest("Division by 0!", "5 / 0");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}