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
    public void simpleSort() {
        simpleTest("1 2 3", "3 1 2");
    }

    @Test
    public void testNegativeNumbers() {
        simpleTest("-3 -2 -1", "-3 -1 -2");
    }

    @Test
    public void testRepeatedNumbers() {
        simpleTest("1 2 2 3", "2 1 3 2");
    }

    @Test
    public void testAlreadySorted() {
        simpleTest("1 2 3", "1 2 3");
    }

    @Test
    public void testLargeNumbers() {
        simpleTest("100000 200000 300000", "200000 100000 300000");
    }

    @Test
    public void testSingleNumber() {
        simpleTest("1", "1");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}