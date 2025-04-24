public class DataVilleOptimal {

    private static int getOptimalStorage(int[] ds) {
        
        if(ds == null || ds.length == 0 || ds.length == 1) return 0;

        int ones=0;
        for (int i = 0; i < ds.length; i++) {
            if(ds[i]==1) ones++;
        }

        if(ones == 0 || ones == ds.length) return 0;

        int minSwaps = Integer.MAX_VALUE;
        int cZeros = 0;

        for (int i = 0; i < ones; i++) {
            if(ds[i] == 0) cZeros++;
        }

        // la primera cantidad de intercambios
        minSwaps = cZeros;

        for (int i = ones; i < ds.length; i++) {
            if (ds[i-ones] == 0) cZeros--;
            if (ds[i] == 0) cZeros++;
        }

        minSwaps = Math.min(minSwaps, cZeros);
        return minSwaps;
    }

    public static void main(String[] args) {
        int[] databaseStorage = { 1, 0, 1, 0, 1 };
        System.out.println( getOptimalStorage(databaseStorage) == 1);
    }
}
