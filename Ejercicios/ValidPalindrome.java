class ValidPalindrome {

    public static void main(String[] args) {
        // String cadena = "A man, a plan, a canal: Panama"; //Explanation: "amanaplanacanalpanama" is a palindrome.
        // String cadena = "race a car"; //Explanation: "raceacar" is not a palindrome.
        String cadena = " "; //Explanation: s is an empty string "" after removing non-alphanumeric characters.
        // Since an empty string reads the same forward and backward, it is a palindrome.

        boolean res = validarCadena(cadena);
        System.out.println(res);
    }

    private static boolean validarCadena(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        System.out.println(s);
        int indexBack = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(indexBack)) return false;
            indexBack--;
        }
        return true;
    }
}
/*
   https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
*/
