@Inject
private ProcessRuntimeService processRuntimeService;

private static String PROCESS_CODE = "orderProcessing";

public class OrderEdit extends AbstractEditor<Order> {

    public void startProcess() {
        commit();

        ProcDefinition procDefinition = dataManager.load(
                LoadContext.create(ProcDefinition.class)
                .setQuery(new LoadContext.Query("select pd from bpm$ProcDefinition pd where pd.code = :code")
                        .setParameter("code", PROCESS_CODE))
                .setView("procDefinition-procInstanceEdit")
        );

        ProcInstance procInstance = metadata.create(ProcInstance.class);
        procInstance.setProcDefinition(procDefinition);
        procInstance.setEntityId(getItem().getUuid());
        procInstance.setEntityName(getItem().getMetaClass().getName());

        Set<ProcActor> procActors = new HashSet<>();

        ProcActor manager = metadata.create(ProcActor.class);
        manager.setUser(userSession.getUser());
        manager.setOrder(0);
        manager.setProcInstance(procInstance);
        manager.setProcRole(procDefinition.getProcRoles().get(0));

        ProcActor mechanic = metadata.create(ProcActor.class);
        mechanic.setUser(getItem().getMechanic().getUser());
        mechanic.setOrder(1);
        mechanic.setProcInstance(procInstance);
        mechanic.setProcRole(procDefinition.getProcRoles().get(1));

        procActors.add(manager);
        procActors.add(mechanic);

        procInstance.setProcActors(procActors);

        Set<Entity> committed = dataManager.commit(new CommitContext()
                .addInstanceToCommit(manager)
                .addInstanceToCommit(mechanic)
                .addInstanceToCommit(procInstance));

        ProcInstance committedProcInstance = (ProcInstance) committed.stream()
                .filter(p -> p.equals(procInstance))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error"));

        processRuntimeService.startProcess(committedProcInstance, "Started!", new HashMap<>());

        close(COMMIT_ACTION_ID);
    }
}