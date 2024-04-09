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
    public void testGetMaxMinusCurrent_long() {
        simpleTest("9223372036854775797", "long", "10");
    }

    @Test
    public void testGetMaxMinusCurrent_int() {
        simpleTest("2147483639", "int", "8");
    }

    @Test
    public void testGetMaxMinusCurrent_long_zero() {
        simpleTest("9223372036854775807", "long", "0");
    }

    @Test
    public void testGetMaxMinusCurrent_int_zero() {
        simpleTest("2147483647", "int", "0");
    }

    @Test
    public void testGetMaxMinusCurrent_long_maxValue() {
        simpleTest("0", "long", "9223372036854775807");
    }

    @Test
    public void testGetMaxMinusCurrent_int_maxValue() {
        simpleTest("0", "int", "2147483647");
    }

    private void simpleTest(String expectedOutput, String... inputLines) {
        String input = String.join(System.lineSeparator(), inputLines);
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}