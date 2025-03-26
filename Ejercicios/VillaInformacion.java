class VillaInformacion {

    public static int getOptimalStorage(int[] databaseStorage) {
        int n = databaseStorage.length;
        // Step 1: Count total number of 1s
        int totalOnes = 0;
        for (int num : databaseStorage) {
            if (num == 1) {
                totalOnes++;
            }
        }
        // If there are no 1s or all are 1s, no swaps are needed
        if (totalOnes == 0 || totalOnes == n) {
            return 0;
        }
        // Step 2: Find the minimum number of 0s in a window of size totalOnes
        int minSwaps = Integer.MAX_VALUE;
        int currentZeros = 0;
        // Initial window
        for (int i = 0; i < totalOnes; i++) {
            if (databaseStorage[i] == 0) {
                currentZeros++;
            }
        }
        minSwaps = currentZeros;
        // Slide the window
        for (int i = totalOnes; i < n; i++) {
            // Remove the effect of the outgoing element
            if (databaseStorage[i - totalOnes] == 0) {
                currentZeros--;
            }
            // Add the effect of the incoming element
            if (databaseStorage[i] == 0) {
                currentZeros++;
            }
            // Update minimum swaps
            minSwaps = Math.min(minSwaps, currentZeros);
        }
        return minSwaps;
    }

    public static void main(String[] args) {
        int[] databaseStorage = { 1, 0, 1, 0, 1 };
        System.out.println(
            "Minimum swaps needed: " + getOptimalStorage(databaseStorage)
        );
    }
}
