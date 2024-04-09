import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static boolean[] inverseFlags(boolean[] flags) {
        boolean[] newFlags = new boolean[flags.length];
        for (int i = 0; i < flags.length; i++) {
            newFlags[i] =!flags[i] ? true : false;
        }
        return newFlags;
    }

    /* Do not change the code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final List<Boolean> booleans = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Boolean::parseBoolean)
                .collect(Collectors.toList());
        final boolean[] flags = new boolean[booleans.size()];
        for (int i = 0; i < flags.length; i++) {
            flags[i] = booleans.get(i);
        }
        final String representation = Arrays.toString(inverseFlags(flags))
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        System.out.println(representation);
    }
}