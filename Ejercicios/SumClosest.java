class SumClosest {

    // Input: nums = [-1,2,1,-4], target = 1
    // Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
    // Output: 2
    // Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

    public static int threeSumClosest(int[] nums, int target) {

        int len = nums.length;

        int windowSum = 2;
        int maxSum = windowSum;

        for(int i=0; i<len-target;i++){
            windowSum = windowSum - nums[1] + nums[i+target];
            if(windowSum > maxSum){
                maxSum = windowSum;     }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int res = threeSumClosest(nums, 1);
        // int[] nums = { -651,443,-113,70,-305,-139,-982,906,-296,-816,-213,-486,584,173,862,522,-654,-257,-762,-868,428,
        //     -342,-720,298,-323,678,951,-850,541,-135,841,-517,763,488,544,-452,34,703,-898,-603,736,783,-767,123,-90,
        //     -533,197,999,343,285,349,-124,-561,187,-941,-828,-408,546,-69,922,-483,-491,-500,850,301,-597,-643,-823,
        //     75,812,-418,766,772,880,-159,796,-709,-478,919,-171,575,-299,718,-336,-650,172,658,-200,267,297,-550,315,
        //     -976,331,-669,-13,935,904,-367,161,83,-448,101,-400,-430,-506,138,-340,934,680,918,605,-834,-559,65,68,-677,
        //     402,580,43,705,-237,-45,-810,-311,978,230,-87,-758,-872,-642,646,866,707,611,-117,795,673,556,141,-666,839,
        //     -49,698,-60,-298,-129,781,147,-393,876,908,-17,-747,-477,527,-325,-467,979,380,-48,657,-843,-672,-978,296,
        //     405,607,-378,58,470,272,289,-247,322,-700,471,476,-58,-330,192,-103,860,-287,-294,513,-244,-595,-288,-913,
        //     536,-952,-818,-249,-975,364,-338,198,-241,-523,180,-725,388,-246,-638,640,-167,-102,-313,861,-156,-239,-889,
        //     606,-699,-924,-781,320,189,-555,-352,-608,523,649,-180 };
        // int res = threeSumClosest(nums, 1);

        System.out.println(res);
        System.out.println(res == 2);
    }
}
