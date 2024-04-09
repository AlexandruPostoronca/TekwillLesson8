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
    public void testDivideFromProblem() {
        simpleTest("2.5", "500000000000 200000000000");
    }

    @Test
    public void testDivideWithValidInput1() {
        simpleTest("2.5", "5 2");
    }

    @Test
    public void testDivideWithValidInput2() {
        simpleTest("-2.5", "-5 2");
    }

    @Test
    public void testDivideWithValidInput3() {
        simpleTest("-2.5", "5 -2");
    }

    @Test
    public void testDivideWithValidInput4() {
        simpleTest("0.25", "1 4");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}