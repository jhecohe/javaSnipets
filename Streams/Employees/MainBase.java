import java.util.Collection;
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
public class MainBase {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeDataBase.getAllEmployees();
        // employees.forEach(e -> System.out.println(e.name() + " : " + e.salary()));

        // Use Collector library and filter bring Development and salary over 80000
        List<Employee> list = employees.stream()
        .filter(e -> e.salary() > 80000)
        .collect(Collectors.toList());

        // Collectors to Map, Bring Id and Name in a Map

        Map<Integer, String> map = employees.stream()
        .collect(Collectors.toMap(Employee::id, Employee::name));

        Collection.stream(map).

        // map.entrySet()
        // .stream()
        // .forEach(m -> System.out.println(m.getKey() + " - " + m.getValue()));

        // Map stream with distinct, bring deparments without duplicates
        
        // var dept = employees.stream()
        // .map(e -> e.dept())
        // .distinct()
        // .collect(Collectors.toList());

        // dept.forEach(System.out::println);

        // flatMap, Bring the name of all the projects

        // var projects = employees.stream()
        // .flatMap(e -> e.projects().stream())
        // .map(p -> p.name())
        // .collect(Collectors.toList());

        // projects.forEach(System.out::println);
        

        // Sorted Sort emplyees by salary

        // var emp = employees.stream()
        // .sorted(Comparator.comparing(e -> e.salary()))
        // .collect(Collectors.toList());

        // emp.forEach(System.out::println);

        // Min and Max, Search the the employee with tha max and min salary

        // Optional<Employee> em = employees.stream()
        // .max(Comparator.comparing(Employee::salary));

        // var e = employees.stream()
        // .min(Comparator.comparingDouble(Employee::salary));

        // System.out.println(e.get());

        // GroupingBy employees by gender 

        // var group = employees.stream()
        // .collect(Collectors.groupingBy(Employee::gender));

        // System.out.println(group);
    }
}
