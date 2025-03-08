import java.util.Arrays;
import java.util.List;

public class Ejemplo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
            "Ana",
            "Luis",
            "Maria",
            "Pedro",
            "Juan",
            "Carla"
        );

        names
            .stream()
            .filter(name -> {
                return name.length() > 4;
            })
            .forEach(name -> System.out.println(name));

        System.out.println("-------------------------------------------------");

        names
            .stream()
            .map(name -> name.toUpperCase())
            .sorted()
            .forEach(name -> System.out.println(name));

        System.out.println("-------------------------------------------------");

        String result = names
            .stream()
            .reduce("Este String es un tag ", (a, b) -> {
                return a + " - " + b + " / ";
            });
        System.out.println(result);
    }
}
