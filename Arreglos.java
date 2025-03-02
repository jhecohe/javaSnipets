import java.util.ArrayList;
import java.util.List;

public class Arreglos {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>(List.of("casa", "otro"));
        l.add("otro added");
        System.out.println(l);
    }
}
