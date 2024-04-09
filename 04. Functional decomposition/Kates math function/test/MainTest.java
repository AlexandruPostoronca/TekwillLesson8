import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

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
    public void testNegativeInput() {
        simpleTest("17.0", "-4");
    }

    @Test
    public void testZeroInput() {
        simpleTest("1.0", "0");
    }

    @Test
    public void testPositiveFractionalInput() {
        simpleTest("24.999999999999996", "0.2");
    }

    @Test
    public void testPositiveIntegerInput() {
        simpleTest("3.0", "2");
    }

    @Test
    public void testLargePositiveInput() {
        simpleTest("9.99999999999E11", "1000000");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testF1() {
        double expectedOutput = 26.0;
        double input = 5.0;
        double delta = 0.0001;

        assertEquals(expectedOutput, Main.f1(input), delta);
    }

    @Test
    public void testF2() {
        double expectedOutput = 4.0;
        double input = 0.5;
        double delta = 0.0001;

        assertEquals(expectedOutput, Main.f2(input), delta);
    }

    @Test
    public void testF3() {
        double expectedOutput = 1.25;
        double input = 1.5;
        double delta = 0.0001;

        assertEquals(expectedOutput, Main.f3(input), delta);
    }

    @Test
    public void testFWithNegativeInput() {
        double expectedOutput = 2.0;
        double input = -1.0;
        double delta = 0.0001;

        assertEquals(expectedOutput, Main.f(input), delta);
    }

    @Test
    public void testFWithInputBetweenZeroAndOne() {
        double expectedOutput = 4.0;
        double input = 0.5;
        double delta = 0.0001;

        assertEquals(expectedOutput, Main.f(input), delta);
    }

    @Test
    public void testFWithInputGreaterThanOne() {
        double expectedOutput = 3.0;
        double input = 2.0;
        double delta = 0.0001;

        assertEquals(expectedOutput, Main.f(input), delta);
    }

    @Test
    public void testMainMethod() {
        double expectedOutput = 24.0;
        String input = "5.0";
        double delta = 0.0001;

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[] {});
        assertEquals(expectedOutput, Double.parseDouble(systemOut().trim()), delta);
    }

    // Helper method to capture System.out output
    private String systemOut() {
        return outputStreamCaptor.toString().replace("\r\n", "\n").replace("\r", "\n").trim();
    }
}