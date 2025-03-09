import java.util.stream.Stream;

public class FindArmstrongNumber {

    //Armstrong number is the number in any given number base, which forms the total of the same number,
    //when each of its digits is raised to the power of the number of digits in the number.
    // 153 => 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
    // 371 es un número de Armstrong porque 3^3 + 7^3 + 1^3 = 37

    public static void main(String[] args) {
        System.out.println("Is Armstrong Number : " + isArmstrongNumber(371));
    }

    public static boolean isArmstrongNumber(int num) {
        if (num < 0) {
            return false;
        }

        int numDigits = String.valueOf(num).length();

        int sum = String.valueOf(num)
            .chars()
            .map(Character::getNumericValue)
            .map(n -> (int) Math.pow(n, numDigits))
            .sum();

        return sum == num;
    }
}
