import com.haulmont.cuba.core.*
import com.haulmont.cuba.core.global.*
import com.haulmont.cuba.security.entity.*

PasswordEncryption passwordEncryption = AppBeans.get(PasswordEncryption.class)

Transaction tx = persistence.createTransaction()
try {
    EntityManager em = persistence.getEntityManager()
    Group group = em.getReference(Group.class, UUID.fromString('0fa2b1a5-1d68-4d69-9fbd-dff348347f93'))
    for (i in (1..250)) {
        User user = new User()
        user.setGroup(group)
        user.setLogin("user_${i.toString().padLeft(3, '0')}")
        user.setName(user.login)
        user.setPassword(passwordEncryption.getPasswordHash(user.id, '1'));
        em.persist(user)
    }
    tx.commit()
} finally {
    tx.end()
}