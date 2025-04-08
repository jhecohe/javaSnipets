import java.util.Arrays;

class SublistasNumeros {

    public static void main(String[] args) {
        // int[] nums = { 3, 5, 4, 7, 9, 10 };
        // int[] nums = { 1, 2, 8, 3, 4, 5, 9 };
        int[] nums = { 10, 20, 30, 40 };
        int res = numerosConsecutivos(nums);
        // System.out.println(res == 3);
        // System.out.println(res == 5);
        System.out.println(res == 1);
    }

    //012345
    //3547910
    //3457910
    //
    private static int numerosConsecutivos(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int total = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i] - 1) {
                count++;
            } else {
                if (total < count) total = count;
                count = 1;
            }
        }
        return total;
    }
}
/*
Escribí una función que reciba un array de números enteros positivos y devuelva la longitud de la mayor
sublista de números consecutivos ordenados de menor a mayor. Los números no tienen que estar consecutivos
en el array original.
Ejemplo 1:
Entrada: [3, 5, 4, 7, 9, 10]
Sublistas: [3, 4, 5] y [9, 10]
Salida: 3
Ejemplo 2:
Entrada: [1, 2, 8, 3, 4, 5, 9]
Sublistas: [1, 2, 3, 4, 5]
Salida: 5
Ejemplo 3:
Entrada: [10, 20, 30, 40]
Salida: 1
Restricciones:
    • Intentá resolverlo en tiempo lineal O(n)O(n)O(n) o en tiempo O(nlog⁡n)O(n \log n)O(nlogn).
    • No uses estructuras de datos adicionales de gran tamaño.
*/
