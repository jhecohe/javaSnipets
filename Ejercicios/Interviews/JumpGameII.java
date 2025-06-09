public class JumpGameII {
    
    private static int jump(int[] nums) {
        
        int size = nums.length;
        int currentJump = 0;
        int maxJump = 0;
        int jumps = 0;

        if(nums.length == 1) return 0;

        for(int i=0; i<size; i++){
            maxJump = Math.max(maxJump, i+nums[i]);

            if(currentJump == i){
                currentJump = maxJump;
                jumps++;

                if(currentJump == size-1){
                    return jumps;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        
        // int[] nums = {2,3,0,1,4}; // 2
        int[] nums = {2,1,1,1,1}; // 3
        int res = jump(nums);
        System.out.println(res);
        System.out.println(res == 3);
    }
}

/*
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

    0 <= j <= nums[i] and
    i + j < n

Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [2,3,0,1,4]
Output: 2

 

Constraints:

    1 <= nums.length <= 104
    0 <= nums[i] <= 1000
    It's guaranteed that you can reach nums[n - 1].


 */