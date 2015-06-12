@Inject
protected Table customersTable;
...
    customersTable.setIconProvider(new Table.IconProvider() {
        @Nullable
        @Override
        public String getItemIcon(Entity entity) {
            CustomerGrade grade = ((Customer) entity).getGrade();
            switch (grade) {
                case PREMIUM: return "icons/premium_grade.png";
                case HIGH: return "icons/high_grade.png";
                case MEDIUM: return "icons/medium_grade.png";
                default: return null;
            }
        }
    });