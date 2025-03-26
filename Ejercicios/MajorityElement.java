import java.util.HashMap;
import java.util.Map.Entry;

class MajorityElement {

    // https://leetcode.com/problems/majority-element/submissions/1585777497/?envType=study-plan-v2&envId=top-interview-150

    public static void main(String[] args) {
        int res = majorityElement(new int[] { 6, 5, 5 });
        System.out.println(res);
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> majority = new HashMap<>();

        for (Integer num : nums) {
            if (majority.containsKey(num)) {
                majority.put(num, majority.get(num) + 1);
            } else {
                majority.put(num, 1);
            }
        }

        int larger = -1, count = 0;
        for (Entry<Integer, Integer> value : majority.entrySet()) {
            System.out.println(value.getKey() + " - " + value.getValue());
            if (value.getValue() > count) {
                count = value.getValue();
                larger = value.getKey();
            }
        }

        return larger;
    }
}
