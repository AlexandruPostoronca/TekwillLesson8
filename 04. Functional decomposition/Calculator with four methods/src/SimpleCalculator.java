public class SimpleCalculator {


    // Implement your methods here
    public static void subtractTwoNumbers(long a, long b) {
        long resultSubtract = 0;
        resultSubtract = a - b;
        System.out.println(resultSubtract);
    }

    public static void sumTwoNumbers(long a, long b) {
        long resultSubtract = 0;
        resultSubtract = a + b;
        System.out.println(resultSubtract);
    }

    public static void divideTwoNumbers(long a, long b) {
        long resultSubtract = 0;
        if ((b > 0) || (b <= -1)) {
            resultSubtract = a / b;
            System.out.println(resultSubtract);
        } else {
            System.out.println("Division by 0!");
        }
    }

    public static void multiplyTwoNumbers(long a, long b) {
        long resultSubtract = 0;
        resultSubtract = a * b;
        System.out.println(resultSubtract);
    }

    // Implemented method
    public static void power(long n, long p) {
        long number = n;
        long power = p;
        long result = 1;
        while (power > 0) {
            if (power % 2 != 0) {
                result *= number;
            }
            power /= 2;
            number *= number;
        }
        System.out.println(result);
    }
}