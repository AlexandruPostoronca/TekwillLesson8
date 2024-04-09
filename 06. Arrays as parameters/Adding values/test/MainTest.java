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
    public void testAddValueToElement_basicCase() {
        simpleTest("1 1 101 1 1", "1 1 1 1 1\n2 100");
    }

    @Test
    public void testAddValueToElement_addZero() {
        simpleTest("1 1 1 1 1", "1 1 1 1 1\n3 0");
    }

    @Test
    public void testAddValueToElement_addNegativeValue() {
        simpleTest("1 1 -1 1 1", "1 1 0 1 1\n2 -1");
    }

    @Test
    public void testAddValueToElement_addMaxLongValue() {
        simpleTest("9223372036854775807 1 9223372036854775806 1 1", "9223372036854775807 1 0 1 1\n2 9223372036854775806");
    }

    @Test
    public void testAddValueToElement_addValueToLastElement() {
        simpleTest("1 1 1 1 101", "1 1 1 1 100\n4 1");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}