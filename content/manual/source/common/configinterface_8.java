@Property("myapp.defaultCustomerGrade")
@DefaultInteger(10)
@EnumStore(EnumStoreMode.ID)
CustomerGrade getDefaultCustomerGrade();

@EnumStore(EnumStoreMode.ID)
void setDefaultCustomerGrade(CustomerGrade grade);
