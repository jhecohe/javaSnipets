package utils.Comparator;


import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortMatriz {
    
    private static void sortArrayByFirstValue(int[][] array) {
        
        // Arrays.sort(array, Comparator.comparingInt(a -> a[0])); 
        Arrays.sort(array, Comparator.comparingInt(a -> a[1])); // Sor the matrix by the second element
    }

    private static void sortArrayBySecondValue(int[][] array) {
        
        // Comparator<int[]> com = (a, b) ->  a[0] - b[0];
        // Arrays.sort(array, com);

        // Arrays.sort(array, (a, b) -> Integer.compare(a[1], b[1])); // Sort the matrix by the first element
        Arrays.sort(array, (a, b) -> Integer.compare(a[1], b[1])); // Sort the matrix by the second element
    }

    public static void main(String[] args) {
        int[][] nums = {{9,6},{1,34},{2,4},{7,95}};
        int[][] nums2 = {{9,6},{1,34},{2,4},{7,95}};
        
        sortArrayByFirstValue(nums);
        sortArrayBySecondValue(nums2);

        for(int[] row : nums){
            for(int col : row){
                System.out.print(col + " ");
            }
        }

        System.out.println(" ________________________ ");

        for(int[] row : nums2){
            for(int col : row){
                System.out.print(col + " ");
            }
        }
    }
}
