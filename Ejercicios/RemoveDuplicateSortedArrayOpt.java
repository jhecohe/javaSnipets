import java.util.Arrays;

class RemoveDuplicateSortedJavaOpt{
    public static int removeDuplicates(int[] nums) {
        int i = 0; 

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return ++i;
    }

    public static void main(String[] args) {
        // int[] nums = {1,1,2}; // 2
        int[] nums = {0,0,1,1,1,2,2,3,3,4}; // 5 -> 0,1,2,3,4
        int res = removeDuplicates(nums);
        System.out.println(res);
        System.out.println(res == 5);

        int[] expected = {0,1,2,3,4};
        // int[] expected = {1,2};

        Arrays.stream(nums).forEach(System.out::print);
        System.out.println("");

        for (int i = 0; i < res; i++) {
            if(expected[i] != nums[i]){
                System.out.println("Wrong value esperado "+expected[i] + " retornado "+ nums[i]);
                break;
            }
        }

    }
}
