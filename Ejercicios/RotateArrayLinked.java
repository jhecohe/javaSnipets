import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

class RotateArray {

    // https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
        rotate(arr, 3);

        for (Integer n : arr) {
            System.out.print(n);
        }
    }

    public static void rotate(Integer[] nums, int k) {
        LinkedHashSet<Integer> list = new LinkedHashSet<>(Arrays.asList(nums));

        int index = 0;
        while (index <= k) {
            Integer num = list.removeFirst();
            list.add(num);
            index++;
        }

        // list.toArray(nums);
        Iterator<Integer> num = list.iterator();

        int i = 0;
        while (num.hasNext()) {
            nums[i] = num.next();
            i++;
        }
    }
}
