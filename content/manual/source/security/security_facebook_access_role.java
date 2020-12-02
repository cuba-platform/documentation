@Role(name = "facebook-access")
public class FacebookAccessRole extends AnnotatedRoleDefinition {
    @ScreenAccess(screenIds = {
            "help",
            "aboutWindow",
            "settings",
    })
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }
}