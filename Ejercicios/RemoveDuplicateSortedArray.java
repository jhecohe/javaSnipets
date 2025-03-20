import java.util.Arrays;

class RemoveDuplicateSortedJava{
    public static int removeDuplicates(int[] nums) {
        int l = 0, r = nums.length-1, count = 1;
        for(int i=0; i<r; i++){
            if(nums[i] == nums[i+1]){
                l = i+1;
                while(l < r){
                    nums[l] = nums[l+1];
                    ++l;
                }
                
                r--;
                --i;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // int[] nums = {1,1,2}; // 2
        int[] nums = {0,0,1,1,1,2,2,3,3,4}; // 5 -> 0,1,2,3,4
        int res = removeDuplicates(nums);
        System.out.println(res);
        System.out.println(res == 5);

        int[] expected = {0,1,2,3,4};

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
