void methodA() {
    Transaction tx = persistence.createTransaction();
    try {
        methodB(); <1>
        tx.commit(); <4>
    } finally {
        tx.end();
    }
}

void methodB() {
    Transaction tx = persistence.getTransaction();
    try {
        tx.commit(); <2>
    } catch (Exception e) {
        return; <3>
    } finally {
        tx.end();
    }
}