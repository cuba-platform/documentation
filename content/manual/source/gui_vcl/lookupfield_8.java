lookupField.setOptionIconProvider(new LookupField.OptionIconProvider<Customer>(){
    @Override
    public String getItemIcon(Customer c){
        if(c.getType()== LegalStatus.LEGAL)
            return"icons/icon-office.png";
        return"icons/icon-user.png";
    }
});