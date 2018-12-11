@Inject
private Table<Customer> table;

@Subscribe
protected void onInit(InitEvent event) {
    table.setIconProvider(new ListComponent.IconProvider<Customer>() {
        @Nullable
        @Override
        public String getItemIcon(Customer entity) {
            CustomerGrade grade = entity.getGrade();
            switch (grade) {
                case PREMIUM: return "icons/premium_grade.png";
                case HIGH: return "icons/high_grade.png";
                case MEDIUM: return "icons/medium_grade.png";
                default: return null;
            }
        }
    });
}