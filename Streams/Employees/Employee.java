import java.util.List;

record Employee(
    int id,
    String name,
    String dept,
    List<Project> projects,
    double salary,
    String gender
) {}
