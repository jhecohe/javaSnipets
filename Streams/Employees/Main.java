import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeDataBase.getAllEmployees();
        // employees.forEach(e -> System.out.println(e.name() + " : " + e.salary()));

        // Use Collector library and filter
        // List<Employee> list = employees
        //     .stream()
        //     .filter(e -> e.dept().equals("Development") && e.salary() > 87000)
        //     .collect(Collectors.toList());
        // list.forEach(System.out::println);

        // Collectors to Map
        // Map<Integer, String> map = employees
        //     .stream()
        //     .filter(e -> e.dept().equals("Development") && e.salary() > 80000)
        //     .collect(Collectors.toMap(Employee::id, Employee::name));
        // System.out.println(map);

        // Map stream with distinct
        // List<String> list = employees
        //     .stream()
        //     .map(Employee::dept)
        //     .distinct()
        //     .collect(Collectors.toList());
        // System.out.println(list);

        // flatMap
        // List<String> list = employees
        //     .stream()
        //     .flatMap(e -> e.projects().stream())
        //     .map(e -> e.name())
        //     .collect(Collectors.toList());

        // Sorted
        // List<Employee> list = employees
        //     .stream()
        //     // .sorted(Comparator.comparing(Employee::salary)) // ascending order
        //     .sorted(
        //         Collections.reverseOrder(Comparator.comparing(Employee::salary))
        //     ) // descending order
        //     .collect(Collectors.toList());
        // System.out.println(list);

        // Min and Max
        // Optional<Employee> list = employees
        //     .stream()
        //     .max(Comparator.comparingDouble(Employee::salary));

        // Optional<Employee> emp = employees
        //     .stream()
        //     .min(Comparator.comparingDouble(Employee::salary));
        // System.out.println(emp.get());

        // Compare Strings by the length
        // Optional<Employee> emp = employees.stream()
        //     .min(Comparator.comparingInt(e -> e.name().length()));

        // System.out.println(emp.get());

        // GroupingBy
        // Map<String, List<Employee>> map = employees.stream()
        // .collect(Collectors.groupingBy(Employee::gender));

        // System.out.println(map);

        // Map<String, List<String>> groupByGendarListName = employees.stream()
        // .collect(Collectors.groupingBy(Employee::gender, Collectors.mapping(Employee::name, Collectors.toList())));

        Map<String, Long> genCount = employees.stream()
        .collect(Collectors.groupingBy(Employee::gender, Collectors.counting()));

        System.out.println(genCount);


    }
}
