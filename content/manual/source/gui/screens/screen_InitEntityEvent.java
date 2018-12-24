@Subscribe
protected void onInitEntity(InitEntityEvent<Foo> event) {
    event.getEntity().setStatus(Status.ACTIVE);
}