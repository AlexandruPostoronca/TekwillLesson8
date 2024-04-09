import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Write your solution here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        System.out.println(gcd(n, l));
    }

    public static int gcd(int a, int b) {
        while (b > 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}