// Java program to find equilibrium index of an array
// using nested loop
class FindEquilibrium {
    static int findEquilibrium(int[] arr) {

        // Check for indexes one by one until
        // an equilibrium index is found
        for (int i = 0; i < arr.length; ++i) {
            // Get left sum
            int leftSum = 0;
            for (int j = 0; j < i; j++)
                leftSum += arr[j];

            // Get right sum
            int rightSum = 0;
            for (int j = i + 1; j < arr.length; j++)
                rightSum += arr[j];

            // If leftsum and rightsum are same, then
            // index i is an equilibrium index
            if (leftSum == rightSum)
                return i;
        }

        // If equilibrium index doesn't exist
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(findEquilibrium(arr));
    }
}
