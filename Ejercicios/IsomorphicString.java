import java.util.LinkedHashMap;

/**
 * IsomorphicString
 */
public class IsomorphicString {

    private static boolean isIsomorphic(String s, String t) {
        if (s.equals(t) && s.length() == 1) return true;

        LinkedHashMap<Character, Integer> sLet = new LinkedHashMap<>();
        LinkedHashMap<Character, Integer> tLet = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            if (null != sLet.putIfAbsent(sChar, 1)) {
                sLet.put(sChar, sLet.get(sChar) + 1);
            }

            if (null != tLet.putIfAbsent(tChar, 1)) {
                tLet.put(tChar, tLet.get(tChar) + 1);
            }

            if (
                !sLet.values().toString().equals(tLet.values().toString())
            ) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // String s = "egg", t = "add"; // true
        // String s = "paper", t = "title"; // true
        // String s = "bbbaaaba", t = "aaabbbba"; //fasle
        String s = "aba", t = "baa"; //fasle

        System.out.println(false == isIsomorphic(s, t) ? "Exitoso" : "Fallo");
    }
}
/**
https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true
Explanation:
The strings s and t can be made identical by:

    Mapping 'e' to 'a'.
    Mapping 'g' to 'd'.
*/
