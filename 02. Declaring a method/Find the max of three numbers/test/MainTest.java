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
    public void testMaxAtFirstPosition() {
        simpleTest("1", "100 50 -10");
    }

    @Test
    public void testMaxAtSecondPosition() {
        simpleTest("2", "5 50 0");
    }

    @Test
    public void testMaxAtThirdPosition() {
        simpleTest("3", "0 -100 1000");
    }

    @Test
    public void testAllParamsEqual() {
        simpleTest("1", "100 100 100");
    }

    @Test
    public void testAllParamsNegative() {
        simpleTest("3", "-10 -20 -5");
    }

    @Test
    public void testTwoParamsEqualAndGreater() {
        simpleTest("2", "10 20 10");
    }

    @Test
    public void testMaxAtFirstParam() {
        simpleTest("1", "10 3 2");
    }

    @Test
    public void testMaxAtSecondParam() {
        simpleTest("2", "3 10 2");
    }

    @Test
    public void testMaxAtThirdParam() {
        simpleTest("3", "1 2 3");
    }

    @Test
    public void testEqualParams() {
        simpleTest("1", "1 1 1");
    }

    @Test
    public void testMaxAtFirstAndSecondParam() {
        simpleTest("2", "5 8 5");
    }

    @Test
    public void testMaxAtSecondAndThirdParam() {
        simpleTest("3", "5 8 15");
    }

    @Test
    public void testMaxAtFirstAndThirdParam() {
        simpleTest("3", "100 5 200");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}