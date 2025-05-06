import java.util.HashMap;

public class ZigzagConversion {

    private static String zigzag(String s, int numRows) {
        HashMap<Integer, String> order = new HashMap<>();
        int p = 0;
        boolean increase = true;

        for (int i = 0; i < s.length(); i++) {
            if (increase) {
                if (null != order.putIfAbsent(p, s.charAt(i) + "")) {
                    order.put(p, order.get(p) + s.charAt(i));
                }
                p++;
            } else {
                if (null != order.putIfAbsent(p, s.charAt(i) + "")) {
                    order.put(p, order.get(p) + s.charAt(i));
                }
                p--;
            }
            if (p == numRows - 1 || p == 0) increase = !increase;
        }
        StringBuilder res = new StringBuilder();

        order.values().forEach(w -> res.append(w));
        return res.toString();
        // Collection<String> words = order.values();
        // return words.stream().collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String word = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println("PAHNAPLSIIGYIR".equals(zigzag(word, numRows)));
    }
}
/*
https://leetcode.com/problems/zigzag-conversion/description/

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
*/
