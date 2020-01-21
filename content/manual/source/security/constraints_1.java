@AccessGroup(name = "Sales", parent = RootGroup.class)
public class SalesGroup extends AnnotatedAccessGroupDefinition {

    @JpqlConstraint(target = Customer.class, where = "{E}.grade = 'B'") // <1>
    @JpqlConstraint(target = Order.class, where = "{E}.customer.grade = 'B'") // <2>
    @Override
    public ConstraintsContainer accessConstraints() {
        return super.accessConstraints();
    }

    @Constraint(operations = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE}) // <3>
    public boolean customerConstraints(Customer customer) {
        return Grade.BRONZE.equals(customer.getGrade());
    }

    @Constraint(operations = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE}) // <4>
    public boolean orderConstraints(Order order) {
        return order.getCustomer() != null && Grade.BRONZE.equals(order.getCustomer().getGrade());
    }

    @Constraint(operations = {EntityOp.UPDATE, EntityOp.DELETE}) // <5>
    public boolean orderUpdateConstraints(Order order) {
        return order.getAmount().compareTo(new BigDecimal(100)) < 1;
    }
}