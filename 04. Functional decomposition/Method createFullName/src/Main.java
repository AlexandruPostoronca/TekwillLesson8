// Don't delete scanner import

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // use this program as a source of inspiration for your method

        String firstName1 = scanner.next();
        String lastName1 = scanner.next();
        System.out.println(createFullName(firstName1, lastName1));
    }

    //implement your method here
    public static String createFullName(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        return fullName;
    }
}