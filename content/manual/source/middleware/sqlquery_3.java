Query query = persistence.getEntityManager().createNativeQuery(
        "select count(*) from SEC_USER where login = #login");
query.setParameter("login", "admin");
long count = (long) query.getSingleResult();