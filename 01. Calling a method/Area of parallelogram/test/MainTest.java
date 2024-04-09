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
    public void test1() {
        simpleTest("6", "2 3");
    }

    @Test
    public void test2() {
        simpleTest("100", "2 50");
    }

    @Test
    public void test3() {
        simpleTest("80", "4 20");
    }

    @Test
    public void test4() {
        simpleTest("0", "0 0");
    }

    @Test
    public void test5() {
        simpleTest("-100", "-2 50");
    }

    @Test
    public void test6() {
        simpleTest("100", "-2 -50");
    }

    @Test
    public void testCountAreaOfParallelogramWithIntegerInputs() {
        simpleTest("80", "8 10");
    }

    @Test
    public void testCountAreaOfParallelogramWithZeroInputs() {
        simpleTest("0", "0 0");
    }

    @Test
    public void testCountAreaOfParallelogramWithNegativeInputs() {
        simpleTest("-12", "-4 3");
    }

    public void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}