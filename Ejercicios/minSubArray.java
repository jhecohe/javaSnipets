public class minSubArray {
    
    private static int solution(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) return 0;

        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            while(currentSum >= target){
                currentSum -= nums[left];
                minLength = Math.min(minLength, i - left + 1);
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;

        System.out.println(solution(nums, target) == 2);
    }
}


/*
 https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150

Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray whose(cuyo) sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */