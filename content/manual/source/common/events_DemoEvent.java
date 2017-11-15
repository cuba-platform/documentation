public class DemoEvent extends ApplicationEvent {
    public DemoEvent(User source) {
        super(source);
    }

    @Override
    public User getSource() {
        return (User) super.getSource();
    }
}