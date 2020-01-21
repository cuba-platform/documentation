@Role(name = "Customers Full Access")
public class CustomersFullAccessRole extends AnnotatedRoleDefinition {

    @EntityAccess(target = Customer.class,
            allow = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE})
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(target = Customer.class, modify = {"name", "email"})
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }

    @ScreenAccess(allow = {"application-demo", "demo_Customer.browse", "demo_Customer.edit"})
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }
}