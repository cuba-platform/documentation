public interface TaskService {
    String NAME = "demo_TaskService";

    @Validated // indicates that the method should be validated
    @NotNull
    String completeTask(@Size(min = 5) String comment, @NotNull Task task);
}