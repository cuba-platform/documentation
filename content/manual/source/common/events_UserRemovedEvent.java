public class UserRemovedEvent extends ApplicationEvent implements UiEvent {
    public UserRemovedEvent(User source) {
        super(source);
    }

    @Override
    public User getSource() {
        return (User) super.getSource();
    }
}