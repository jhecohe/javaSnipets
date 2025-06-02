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
public class MainTwo {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeDataBase.getAllEmployees();
        // employees.forEach(e -> System.out.println(e.name() + " : " + e.salary()));

        // Use Collector library and filter bring Development and salary over 80000
       

        // Collectors to Map, Bring Id and Name and a Map

        // Map stream with distinct, bring deparments without duplicates
        

        // flatMap, Bring the name of all the projects

        // Sorted Sort emplyees by salary

        // Min and Max, Search the the employee with tha max and min salary

        // GroupingBy employees by gender 
    }
}
