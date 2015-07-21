TypedQuery<User> query;
List<User> list;

query = em.createQuery("select u from sec$User u where u.name = ?1", User.class);
query.setParameter(1, "testUser");
list = query.getResultList();
assertEquals(1, list.size());
User user = list.get(0);

user.setName("newName");

query = em.createQuery("select u from sec$User u where u.name = ?1", User.class);
query.setParameter(1, "testUser");
list = query.getResultList();
assertEquals(1, list.size());
User user1 = list.get(0);

assertTrue(user1 == user);