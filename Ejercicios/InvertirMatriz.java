public class InvertirMatriz {
    

    private static void invertir(int[][] matriz) {
        
        int rows = matriz.length;
        int columns = matriz[0].length;

        for (int i = 0; i < rows/2; i++) {
            for (int j = 0; j < columns; j++) {
                int temp = matriz[i][j];
                 matriz[i][j] = matriz[rows-1 - i][columns-1 -j];
                 matriz[rows-1 - i][columns-1 -j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        
        int[][] matriz = {{1,2,3},{4,5,6},{7,8,9}};

        // invertir(matriz);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
}
