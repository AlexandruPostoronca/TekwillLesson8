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
    public void testInvertArraySingleElementTrue() {
        simpleTest("false", "true");
    }

    @Test
    public void testInvertArraySingleElementFalse() {
        simpleTest("true", "false");
    }

    @Test
    public void testInvertArrayAllTrue() {
        simpleTest("false false false false", "true true true true");
    }

    @Test
    public void testInvertArrayAllFalse() {
        simpleTest("true true true true", "false false false false");
    }

    @Test
    public void testInvertArrayMixed() {
        simpleTest("false true false true", "true false true false");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}