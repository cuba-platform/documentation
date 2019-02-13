@Inject
private TransactionalDataManager txDataManager;

@Transactional
public void transfer(Id<Account, UUID> acc1Id, Id<Account, UUID> acc2Id, Long amount) {
    Account acc1 = txDataManager.load(acc1Id).one();
    Account acc2 = txDataManager.load(acc2Id).one();
    acc1.setBalance(acc1.getBalance() - amount);
    acc2.setBalance(acc2.getBalance() + amount);
    txDataManager.save(acc1);
    txDataManager.save(acc2);
}