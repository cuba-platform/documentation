@Inject
private UserSession userSession;

@Override
protected void initNewItem(Complaint item) {
    item.setOpenedBy(userSession.getUser());
    item.setStatus(ComplaintStatus.OPENED);
}