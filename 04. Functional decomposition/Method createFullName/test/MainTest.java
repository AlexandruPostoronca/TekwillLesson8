import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
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
    public void createFullNameTest1() {
        simpleTest("John Lennon", "John", "Lennon");
    }

    @Test
    public void createFullNameTest2() {
        simpleTest(" ", "", "");
    }

    @Test
    public void createFullNameTest3() {
        simpleTest("Robert Downey", "Robert", "Downey");
    }

    @Test
    public void createFullNameTest4() {
        simpleTest("John ", "John", "");
    }

    @Test
    public void createFullNameTest5() {
        simpleTest(" Lennon", "", "Lennon");
    }

    @Test
    public void createFullNameTest6() {
        simpleTest(" ", "", "");
    }

    @Test
    public void createFullNameTest7() {
        simpleTest("JohnLennon ", "JohnLennon", "");
    }

    @Test
    public void createFullNameTest8() {
        simpleTest("John Lennon", "John", "Lennon");
    }

    @Test
    public void createFullNameTest9() {
        simpleTest("JohnLennon  ", "JohnLennon", " ");
    }

    private void simpleTest(String expectedOutput, String firstName, String lastName) {
        String fullName = Main.createFullName(firstName, lastName);
        assertEquals(expectedOutput, fullName);
    }
}