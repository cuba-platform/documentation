persistence.createTransaction().execute(new Transaction.Runnable() {
    public void run(EntityManager em) {
        // transactional code here
    }
});