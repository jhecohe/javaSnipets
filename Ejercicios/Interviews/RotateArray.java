package Interviews;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
* RotateArray
*/
public class RotateArray {

    /*
        You may have been using Java for a while. Do you think a simple Java array question
        can be a challenge? Let’s use the following problem to test.
        Problem: Rotate an array of n elements to the right by k steps. For example, with n
        = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. How many different
        ways do you know to solve this problem?
         */

        public static int[] rotate(int n, int k) {
            int[] a = createArray(n);
            rot(a, 0, a.length-1);
            rot(a, 0, k-1);
            rot(a, k, a.length-1);
            return a;
        }

        public static void rot(int[] a, int start, int end) {

            while( start < end ){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++;
                end--;
            }
        }

        public static Integer[] rotateWithCollection(int n, int k) {
            Integer[] a = createArrayObj(n);

            LinkedHashSet<Integer> list = new LinkedHashSet<>(Arrays.asList(a));

            int i=0;
            while(i<=k){
                Integer temp = list.removeFirst();
                list.add(temp);
                i++;
            }

            return list.toArray(new Integer[list.size()]);
        }

        static int[] createArray(int n){
            int[] a = new int[n];
            for(int i=0; i<n; i++){
                a[i] = i+1;
            }
            return a;
        }

        static Integer[] createArrayObj(int n){
            Integer[] a = new Integer[n];
            for(int i=0; i<n; i++){
                a[i] = i+1;
            }
            return a;
        }

        public static void main(String[] args) {
            int[] array = rotate(7, 3);
            Integer[] ar = rotateWithCollection(7, 3);
            System.out.println(Arrays.toString(array));
            System.out.println(Arrays.toString(ar));
        }
}
