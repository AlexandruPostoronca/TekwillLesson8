import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        // write your code here

        switch (ch) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    /* Do not change the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter));
    }
}