public class Main {

    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        long num1 = scanner.nextLong();
        String operator = scanner.next();
        long num2 = scanner.nextLong();

        switch (operator) {
            case "^" -> SimpleCalculator.power(num1, num2);
            case "+" -> SimpleCalculator.sumTwoNumbers(num1, num2);
            case "-" -> SimpleCalculator.subtractTwoNumbers(num1, num2);
            case "/" -> SimpleCalculator.divideTwoNumbers(num1, num2);
            case "*" -> SimpleCalculator.multiplyTwoNumbers(num1, num2);
            default -> {
            }
        }
    }
}