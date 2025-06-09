class BestTimeBuyAndSell {

    public static int maxProfit(int[] prices) {
        // Encontrar el minimo y elmaximo
        // Pero tiene que ser en orden
        // El mayor valor de la resta de estos dos valores es lo que se retorna
        // Si la resta da un numero negativo, se retorna 0

        int min = prices[0], max = prices[1], profit = max - min;

        for (int i = 2; i < prices.length; i++) {
            if (min > prices[i - 1]) {
                min = prices[i - 1];
                max = prices[i];
            } else if (max < prices[i]) {
                max = prices[i];
            }

            int p = max - min;
            if (profit < p) profit = p;
        }
        return profit < 0 ? 0 : profit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
