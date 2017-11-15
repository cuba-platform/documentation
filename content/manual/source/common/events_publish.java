@Inject
Events events;
// ...
UserRemovedEvent event = new UserRemovedEvent(removedUser);
events.publish(event);