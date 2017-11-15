public interface Events {
    String NAME = "cuba_Events";

    void publish(ApplicationEvent event);
}