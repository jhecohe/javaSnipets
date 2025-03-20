import java.util.Arrays;

class RemoveDuplicateSortedJava2{
    public static int removeDuplicates(int[] nums) {

                // 012345
        // 111223
        // 1 == 1 -> dup=1 i=0 j=0(1)
        // 1 == 1 -> dup=2 i=0 j=1(1)
        // 1 == 1 -> dup=3 i=0 j=2(1) <-
        // 1 == 2 -> dup=3 i=0 j=3(2) 112223
        // 1 == 2 -> dup=0 i=0 j=4(2) 112223

        int counter = 0;
        int dup = 0;
        for(int i=0; i<nums.length; ++i){
            if(dup>2){
                nums[i] = nums[i+1];
                dup--;
            }
            for(int j=i; j<nums.length; ++j){
                if(nums[i] != nums[j]){
                    counter++;
                    dup=0;
                    break;
                }
                dup++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {

        // int[] nums = {1,1,1,2,2,3}; // 5 -> 1,1,2,2,3,_
        int[] nums = {0,0,1,1,1,1,2,3,3}; // 7 -> 0,0,1,1,2,3,3,_,_
        int res = removeDuplicates(nums);
        System.out.println(res);
        System.out.println(res == 7);

        int[] expected = {0,0,1,1,2,3,3,0,0};

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
