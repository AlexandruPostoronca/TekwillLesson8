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
    public void testSignWithPositiveInput() {
        simpleTest("1", "11");
    }

    @Test
    public void testSignWithZeroInput() {
        simpleTest("0", "0");
    }

    @Test
    public void testSignWithNegativeInput() {
        simpleTest("-1", "-3");
    }

    @Test
    public void testSignWithMaxIntInput() {
        simpleTest("1", Integer.toString(Integer.MAX_VALUE));
    }

    @Test
    public void testSignWithMinIntInput() {
        simpleTest("-1", Integer.toString(Integer.MIN_VALUE));
    }

    @Test
    public void testSignWithLargePositiveInput() {
        simpleTest("1", "1234567890");
    }

    @Test
    public void testSignWithLargeNegativeInput() {
        simpleTest("-1", "-1876543210");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}