import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Write your solution here
        int[] numbers = { 1, 2, 3, 4, 5 };
        //swapFirstAndLastElements(numbers);
        System.out.println(Arrays.toString(numbers)); // before swapping
        swapFirstAndLastElements(numbers);
        System.out.println(Arrays.toString(numbers)); // after swapping
    }

    public static void swapFirstAndLastElements(int[] nums) { // nums is an array
        if (nums.length < 1) {
            return; // it returns nothing, i.e. just exits the method
        }

        int temp = nums[nums.length - 1]; // save the last element in a temporary local variable
        nums[nums.length - 1] = nums[0];  // now, the last element becomes the first
        nums[0] = temp;                   // now, the first element becomes the former last
    }
}