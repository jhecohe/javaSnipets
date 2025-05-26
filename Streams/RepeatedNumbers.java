import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatedNumbers {

    private static void solution(List<Integer> nums) {
        Map<Integer, Long> group = nums
            .stream()
            .collect(
                Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                )
            );
        group.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v)
        );
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 3, 4, 2, 1, 2, 3, 43, 2);
        solution(nums);
    }
}
