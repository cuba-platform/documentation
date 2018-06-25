CustomerList window = (CustomerList) openWindow("customer-list", WindowManager.OpenType.DIALOG);
window.addCloseWithCommitListener(() -> {
    getItem().setCustomer(window.getSelectedCustomer());
});