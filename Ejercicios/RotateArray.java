import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

class RotateArray {

    // https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150

    public static void main(String[] args) {
        rotate(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
    }

    public static void rotate(Integer[] nums, int k) {
        List<Integer> l = Arrays.asList(nums);
        LinkedHashSet<Integer> list = new LinkedHashSet<>(l);

        int index = 0;
        while (index < k) {
            Integer num = list.removeFirst();
            list.add(num);
            index++;
        }

        list.stream().forEach(System.out::print);
    }
}
