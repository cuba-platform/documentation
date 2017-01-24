public interface TaskService {
    String NAME = "demo_TaskService";

    @Validated
    @NotNull
    String completeTask(@Size(min = 5) String comment, @NotNull Task task);
}