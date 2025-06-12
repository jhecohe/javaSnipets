import java.util.Arrays;

public class LargestNumber {
    

    private static String largestNumber(int[] nums) {
        String[] numsS = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            numsS[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(numsS, (a, b) -> (b+a).compareTo(a+b));

        for (String string : numsS) {
            System.out.println(string);
        }

        return null;
    }
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        String largest = largestNumber(nums);
        System.out.println(largest);
    }
}

/**
 Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"

Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"

 */