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
    public void testIsVowelWithLowerCaseVowel() {
        simpleTest("true", "a");
    }

    @Test
    public void testIsVowelWithUpperCaseVowel() {
        simpleTest("true", "E");
    }

    @Test
    public void testIsVowelWithLowerCaseNonVowel() {
        simpleTest("false", "z");
    }

    @Test
    public void testIsVowelWithUpperCaseNonVowel() {
        simpleTest("false", "Q");
    }

    @Test
    public void testIsVowelWithLowerCaseY() {
        simpleTest("false", "y");
    }

    @Test
    public void testIsVowelWithUpperCaseY() {
        simpleTest("false", "Y");
    }

    private void simpleTest(String expectedOutput, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}