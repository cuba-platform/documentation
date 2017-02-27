@Component("sample_UserEntityListener")
public class UserEntityListener implements BeforeUpdateEntityListener<User> {

    @Inject
    private Persistence persistence;

    @Override
    public void onBeforeUpdate(User user, EntityManager entityManager) {
        if (persistence.getTools().getDirtyFields(user).contains("name")) {
            TypedQuery<Employee> query = entityManager.createQuery(
                    "select e from sample$Employee e where e.user.id = ?1", Employee.class);
            query.setParameter(1, user.getId());
            Employee employee = query.getFirstResult();
            if (employee != null) {
                employee.setName(user.getName());
            }
        }
    }
}