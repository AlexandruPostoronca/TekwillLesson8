import java.util.*;

public class Main {

    // write a method here

    /* Do not change the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] result = getFirstAndLast(array);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }

    private static int[] getFirstAndLast(int[] array) {
        int[] newArray=new int[2];
       newArray[0]=array[0];
       newArray[1]=array[array.length-1];
       return newArray;
    }
}