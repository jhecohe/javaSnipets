class RotateArrayConquer {

    // https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
        rotate(arr, 3);

        for (Integer n : arr) {
            System.out.print(n);
        }
    }

    public static void rotate(Integer[] nums, int k) {
        invertArray(nums);
        for (Integer n : nums) {
            System.out.print(n);
        }
        System.out.println();
        invertRight(nums, k);
        for (Integer n : nums) {
            System.out.print(n);
        }
        System.out.println();
        invertLeft(nums, k * 1);
        for (Integer n : nums) {
            System.out.print(n);
        }
        System.out.println();
    }

    static void invertArray(Integer[] nums) {
        // Primer paso invertir el arreglo
        int pStart = 0;
        int pEnd = nums.length - 1;

        while (pStart < pEnd / 2) {
            int temp = nums[pStart];
            nums[pStart] = nums[pEnd];
            nums[pEnd] = temp;
            pStart++;
            pEnd--;
        }
    }

    static void invertRight(Integer[] nums, int k) {
        int pStart = 0;
        int pEnd = k;

        while (pStart < pEnd / 2) {
            int temp = nums[pStart];
            nums[pStart] = nums[pEnd];
            nums[pEnd] = temp;
            pStart++;
            pEnd--;
        }
    }

    static void invertLeft(Integer[] nums, int k) {
        int pStart = k;
        int pEnd = nums.length - 1;

        while (pStart < pEnd / 2) {
            int temp = nums[pStart];
            nums[pStart] = nums[pEnd];
            nums[pEnd] = temp;
            pStart++;
            pEnd--;
        }
    }
}
