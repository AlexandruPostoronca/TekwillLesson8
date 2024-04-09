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
    public void testCallMeAwesomeWithValidInput() {
        simpleTest("Alice, you're awesome!", "Alice");
    }

    @Test
    public void testCallMeAwesomeWithLongInput() {
        simpleTest("Pseudopseudohypoparathyroidism, you're awesome!", "Pseudopseudohypoparathyroidism");
    }

    @Test
    public void testCallMeAwesomeWithNumericInput() {
        simpleTest("404, you're awesome!", "404");
    }

    @Test
    public void testCallMeAwesomeWithSpecialCharacterInput() {
        simpleTest("Hello!@#%$, you're awesome!", "Hello!@#%$");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}