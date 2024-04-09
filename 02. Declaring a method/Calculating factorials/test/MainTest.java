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
    public void testFactorialWithZero() {
        simpleTest("1", "0");
    }

    @Test
    public void testFactorialWithOne() {
        simpleTest("1", "1");
    }

    @Test
    public void testFactorialWithSmallPositiveNumber() {
        simpleTest("6", "3");
    }

    @Test
    public void testFactorialWithLargePositiveNumber() {
        simpleTest("2432902008176640000", "20");
    }

    @Test
    public void testFactorialWithNegativeNumber() {
        simpleTest("1", "-5");
    }

    @Test
    public void test() {
        simpleTest("120", "5");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}