@Role(name = "Order Management")
public class OrderManagementRole extends AnnotatedRoleDefinition {

    @EntityAccess(entityName = "*", operations = {EntityOp.READ})
    @EntityAccess(entityClass = Order.class, operations = {EntityOp.CREATE, EntityOp.UPDATE})
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityName = "*", view = "*")
    @EntityAttributeAccess(entityClass = Customer.class, modify = {"grade", "comments"})
    @EntityAttributeAccess(entityClass = Order.class, modify = "*")
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }
}