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
    public void testPrintWithOneStringArgument() {
        simpleTest("test\n4", "print(\"test\")", "print(\"test\", 4)");
    }

    @Test
    public void testPrintWithOneStringArgument2() {
        simpleTest("My name is Bond\n4", "print(\"My name is Bond\")", "print(\"My name is Bond\", 4)");
    }

    @Test
    public void testPrintWithTwoArguments() {
        simpleTest("Hello, world\n42", "print(\"Hello, world\")", "print(\"Hello, world\", 42)");
    }

    @Test
    public void testPrintWithTwoArguments2() {
        simpleTest("Hello there!\n100", "print(\"Hello there!\")", "print(\"Hello there!\", 100)");
    }

    private void simpleTest(String input, String... expectedOutputLines) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Main.main(new String[0]);

        String expectedOutput = String.join(System.lineSeparator(), expectedOutputLines);
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}