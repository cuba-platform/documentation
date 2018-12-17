customersTable.addSelectionListener(customerSelectionEvent ->
        notifications.create()
                .withCaption("You selected " + customerSelectionEvent.getSelected().size() + " customers")
                .show());
