import java.util.Arrays;

class TrappingRainWatter {

    public static int trap(int[] height) {
        int count = 0;
        int left = 0, maxLeft = 0;
        int right = height.length-1, maxRight = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > maxLeft){
                    maxLeft = height[left];
                } else {
                    count += maxLeft - height[left];
                }
                left++;
            } else {
                if(height[right] > maxRight){
                    maxRight = height[right];
                } else {
                    count += maxRight - height[right];
                }
                right--;
            }
        }
        Arrays.stream(height).forEach(System.out::print);
        return count;
    }

    public static void main(String[] args) {
        int[] rainValues = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(rainValues);
        System.out.println("\n " + res);
        System.out.println(res == 6);
    }
}
