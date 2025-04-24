import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    private static int solution(String s) {
        if(s == null || s.length() == 0) return 0;

        int right=0;
        int left=0;
        int longest=0;
        Set<Character> chars = new HashSet<>();
            
        while(right<s.length()){
            if (!chars.contains(s.charAt(right))) {
                chars.add(s.charAt(right++));
                longest = Math.max(longest, chars.size());
            } else {
                chars.remove(s.charAt(left++));
            }
        }

        return longest; 
    }

    public static void main(String[] args) {
        String s = "bbabbaa";
        System.out.println(solution(s) ==2);
    }
}

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150

Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 3:
Input: s = "dvdf"
Output: 3

Example 3:
Input: s = "anviaj"
Output: 5
 */