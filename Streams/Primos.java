import java.util.stream.IntStream;

public class Primos {

    // Numeros primos -> Son divisibles por 1 y el mismo numero
    public static void main(String[] args) {
        isPrime(9);
        isPrime(17);
        isPrime(1);
        isPrime(0);
        isPrime(-5);
    }

    private static void isPrime(int num) {
        if (num <= 1) {
            System.out.println("Numero no es primo");
            return;
        }

        boolean isPrimo = IntStream.range(2, num - 1).noneMatch(x ->
            (num % x == 0)
        );

        if (isPrimo) {
            System.out.println("Numero es primo");
        } else {
            System.out.println("Numero no es primo");
        }
    }
}
