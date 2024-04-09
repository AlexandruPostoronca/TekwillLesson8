public class Main {
    public static void main(String[] args) {
        // Write your solution here
        //method();

        method(new int[] { 1, 2, 3 });

        method(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 });

        method(new int[] { 1, 2, 3 }, 4, 5);

        //method(1, 2, 3);
    }
    public static int method(int[] array, int... vararg) { return 1; }
}