import java.util.Scanner;

public class Main {

    public static long power(int n, int m) {
        // write your code here
        long value = 1;
        for (int i = 0; i < m; i++) {
            value *= n;
        }
        return value;
    }

    /* Do not change the code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        System.out.println(power(n, m));
    }
}