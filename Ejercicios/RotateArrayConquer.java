class RotateArrayConquer {

    // https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
    // Respuesta -> 5671234
    // 1234567
    // 0123456
    // 012
    // 3456

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        rotate(arr, 3);

        for (Integer n : arr) {
            System.out.print(n);
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k / nums.length;
        invertArray(nums, 0, nums.length-1);
        invertArray(nums, 0, k-1);
        invertArray(nums, k, nums.length -1);
    }

    static void invertArray(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
