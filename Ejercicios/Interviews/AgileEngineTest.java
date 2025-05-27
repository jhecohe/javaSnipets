import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AgileEngineTest {

    /*
    The system you work with on a daily basis runs multiple microservices.
    You have been asked to prepare an aggregation that represents the number
    of user visits to all microservices, for use by data analysts.

    The architect you're working with has already designed the API, which
    consists of a single class: VisitCounter. VisitCounter has a single
    method, count().
    It returns Map<Long , Long> - this map should contain the number of visits
    by the user with a given ID.
    This method accepts an array of may string, UserStats>.
    Every map represents the total number of visits per user to a given microservice.
    There are some problems, however:
    • The map key, which is a String, should be parseable to Long - but it may not be.
    You must skip any such faulty entries.
    • For some keys, UserStats may be null. You must skip any such faulty entries.
    • UserStats l0 has a single field, visitCount, of type Optional<Long>. A getter for
    this field is also implemented. This field will never be null ; however, it might be empty.
    You must skip any such faulty entries.

    Remember that you may receive some invalid input: null, empty maps, and so on.
    Handle it all appropriately and return an empty map.

     */

    public static Map<Long, Long> count(Map<String, UserStats>... visits) {
        if (visits == null || Arrays.stream(visits).findAny().isEmpty()) {
            return null;
        }

        return Stream.of(visits)
            .filter(Objects::nonNull)
            .map(Map::entrySet)
            .flatMap(Collection::stream)
            .filter(
                stringUsersStatsEntry ->
                    stringUsersStatsEntry != null &&
                    stringUsersStatsEntry.getKey() != null &&
                    !stringUsersStatsEntry.getKey().isEmpty()
            )
            .filter(stringUsersStatsEntry ->
                stringIsParseableToLong(stringUsersStatsEntry.getKey())
            )
            .filter(stringUsersStatsEntry ->
                stringUsersStatsEntry.getValue().getVisitCount().isPresent()
            )
            .collect(
                Collectors.toMap(
                    key -> Long.parseLong(key.getKey()),
                    value -> value.getValue().getVisitCount().get()
                )
            );
    }

    public static boolean stringIsParseableToLong(String key) {
        if (key == null) {
            return false;
        }

        try {
            Long.parseLong(key);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static class UserStats {

        private Optional<Long> visitCount;

        public UserStats() {}

        public UserStats(Optional<Long> visitCount) {
            this.visitCount = visitCount;
        }

        public Optional<Long> getVisitCount() {
            return visitCount;
        }

        public void setVisitCount(Optional<Long> visitCount) {
            this.visitCount = visitCount;
        }
    }

    public static Map<String, UserStats> generateData() {
        return Map.ofEntries(
            new AbstractMap.SimpleEntry<>(
                "10001",
                new UserStats(Optional.of(350L))
            ),
            new AbstractMap.SimpleEntry<>(
                "10002",
                new UserStats(Optional.of(324L))
            ),
            new AbstractMap.SimpleEntry<>(
                "10003",
                new UserStats(Optional.of(1030L))
            ),
            new AbstractMap.SimpleEntry<>(
                "10004",
                new UserStats(Optional.of(4010L))
            ),
            new AbstractMap.SimpleEntry<>(
                "",
                new UserStats(Optional.of(4010L))
            ),
            new AbstractMap.SimpleEntry<>(
                "10005",
                new UserStats(Optional.ofNullable(null))
            ),
            new AbstractMap.SimpleEntry<>(
                "1000S",
                new UserStats(Optional.of(800L))
            ),
            new AbstractMap.SimpleEntry<>(
                "10006",
                new UserStats(Optional.of(750L))
            )
        );
    }

    public static void main(String[] args) {
        System.out.println(count(generateData()));
    }
}
