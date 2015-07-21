void methodA() {
    Transaction tx = persistence.createTransaction();
    try {
        // (1) calling a method creating a nested transaction
        methodB();

        // (4) at this point an exception will be thrown, because transaction
        //     is marked as rollback only
        tx.commit();
    } finally {
        tx.end();
    }
}

void methodB() {
    Transaction tx = persistence.getTransaction();
    try {
        // (2) let us assume  the exception occurs here
        tx.commit();
    } catch (Exception e) {
        // (3) handle it and exit
        return;
    } finally {
        tx.end();
    }
}