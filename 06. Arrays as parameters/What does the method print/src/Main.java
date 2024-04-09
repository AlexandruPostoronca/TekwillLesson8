import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Write your solution here

        int[] numbers = { 4, 5, 6 };
        method(numbers);
        System.out.println(Arrays.toString(numbers));
    }
    public static void method(int[] array) {
        array = new int[] { 1, 2, 3 };
    }
}