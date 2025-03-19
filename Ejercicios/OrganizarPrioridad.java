import java.util.Set;
import java.util.TreeSet;

class OrganizarPrioridad {

    //Organizar = ['1001:1','1002:1','1002:2','1003:3','1004:4']
    // Se debe organizar por el primer valor, en caso de haber dos con el mismo valor,se
    // da prioridad con el segundo valor

    public static void main(String[] args) {
        // Código para organizar prioridades

        String[] valores = { "1002:1", "1001:1", "1003:3", "1004:4", "1002:2" };

        Set<String> lhs = new TreeSet<>();

        for (String val : valores) {
            lhs.add(val);
        }
        lhs.forEach(System.out::println);
    }
}
