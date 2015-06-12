@Inject
protected Table customersTable;

@Override
public void init(Map<String, Object> params) {
  customersTable.setStyleProvider(new Table.StyleProvider() {
      @Nullable
      @Override
      public String getStyleName(Entity entity, @Nullable String property) {
          Customer customer = (Customer) entity;
          if (property == null) {
              // style for row
              if (hasComplaints(customer))
                  return "unsatisfied-customer";
          } else if (property.equals("grade")) {
              // style for column "grade"
              switch (customer.getGrade()) {
                  case PREMIUM: return "premium-grade";
                  case HIGH: return "high-grade";
                  case MEDIUM: return "medium-grade";
                  default: return null;
              }
          }
          return null;
      }
  });
}