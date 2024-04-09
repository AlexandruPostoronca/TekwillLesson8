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
    public void testGetFirstAndLast_basic() {
        simpleTest("1 5", "1 2 3 4 5");
    }

    @Test
    public void testGetFirstAndLast_oneElement() {
        simpleTest("1 1", "1");
    }

    @Test
    public void testGetFirstAndLast_negativeElements() {
        simpleTest("-3 5", "-3 -2 -1 0 5");
    }

    @Test
    public void testGetFirstAndLast_duplicateElements() {
        simpleTest("1 1", "1 2 3 4 1");
    }

    @Test
    public void testGetFirstAndLast_oddLength() {
        simpleTest("1 7", "1 2 3 4 5 6 7");
    }

    @Test
    public void testGetFirstAndLast_evenLength() {
        simpleTest("1 8", "1 2 3 4 5 6 7 8");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}