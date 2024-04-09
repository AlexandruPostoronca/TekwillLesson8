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
    public void testFromProblem() {
        simpleTest("arg1 arg2 arg3", new String[]{"arg1", "arg2", "arg3"});
    }

    @Test
    public void testRunWithNoArgs() {
        simpleTest("", new String[]{});
    }

    @Test
    public void testRunWithOneArg() {
        simpleTest("hello", new String[]{"hello"});
    }

    @Test
    public void testRunWithMultipleArgs() {
        simpleTest("hello world 123 true", new String[]{"hello", "world", "123", "true"});
    }

    @Test
    public void testRunWithSpecialCharacters() {
        simpleTest("!@#$%^&*()_+{}|:\"<>?,./;'[]\\=-`~", new String[]{"!@#$%^&*()_+{}|:\"<>?,./;'[]\\=-`~"});
    }

    @Test
    public void testRunWithEmptyStringArg() {
        simpleTest("", new String[]{""});
    }

    private void simpleTest(String expectedOutput, String[] input) {
        String expected = expectedOutput.replace(" ", System.lineSeparator());

        Application application = new Application();
        application.run(input);

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }
}