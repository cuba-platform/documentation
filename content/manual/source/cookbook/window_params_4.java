openLookup("sample$Customer.browse",
        items -> {
            if (!items.isEmpty()) {
                getItem().setCustomer((Customer) items.iterator().next());
            }
        },
        WindowManager.OpenType.DIALOG.setWidth("600px").setHeight("400px"));