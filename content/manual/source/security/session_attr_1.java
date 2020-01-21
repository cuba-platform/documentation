@AccessGroup(name = "Level 1", parent = RootGroup.class)
public class FirstLevelGroup extends AnnotatedAccessGroupDefinition {

    @SessionAttribute(name = "accessLevel", value = "1", javaClass = Integer.class)
    @Override
    public Map<String, Serializable> sessionAttributes() {
        return super.sessionAttributes();
    }
}
