@Inject
Events events;
// ...
UserRemovedEvent event = new UserRemovedEvent(this, removedUser);
events.publish(event);