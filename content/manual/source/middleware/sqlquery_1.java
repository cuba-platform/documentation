Query query = persistence.getEntityManager().createNativeQuery(
        "select ID, NAME from SALES_CUSTOMER where NAME like ?1");
query.setParameter(1, "%Company%");
List list = query.getResultList();
for (Iterator it = list.iterator(); it.hasNext(); ) {
    Object[] row = (Object[]) it.next();
    UUID id = (UUID) row[0];
    String name = (String) row[1];
}