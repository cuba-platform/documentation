/**
 * The listener updates the "processState" field of the {@link HasProcessState} with the name of current BPM process
 * node. This listener is used in the "taskExecution-1" BPM process
 */
public class UpdateProcessStateListener implements ActivitiEventListener {

    private static final Logger log = LoggerFactory.getLogger(UpdateProcessStateListener.class);

    private Metadata metadata;

    public UpdateProcessStateListener() {
        metadata = AppBeans.get(Metadata.class);
    }

    @Override
    public void onEvent(ActivitiEvent event) {
        RuntimeService runtimeService = event.getEngineServices().getRuntimeService();
        String executionId = event.getExecutionId();
        UUID entityId = (UUID) runtimeService.getVariable(executionId, "entityId");
        String entityName = (String) runtimeService.getVariable(executionId, "entityName");
        if (entityId == null) {
            log.error("Cannot update process state. entityId variable is null");
            return;
        }
        if (Strings.isNullOrEmpty(entityName)) {
            log.error("Cannot update process state. entityName variable is null");
            return;
        }
        MetaClass metaClass = metadata.getClass(entityName);
        if (metaClass == null) {
            log.error("Cannot update process state. MetaClass {} not found", entityName);
            return;
        }

        if (!HasProcessState.class.isAssignableFrom(metaClass.getJavaClass())) {
            log.error("{} doesn't implement the HasProcessState");
            return;
        }

        switch (event.getType()) {
            case ACTIVITY_STARTED:
                //activityName is the name of the current element taken from the process model
                String activityName = ((ActivitiActivityEvent) event).getActivityName();
                if (!Strings.isNullOrEmpty(activityName)) {
                    updateProcessState(metaClass, entityId, activityName);
                }
                break;
        }
    }

    /**
     * Method updates the process state of the entity linked with the process instance
     */
    private void updateProcessState(MetaClass metaClass, UUID entityId, String processState) {
        Persistence persistence = AppBeans.get(Persistence.class);
        try (Transaction tx = persistence.getTransaction()) {
            EntityManager em = persistence.getEntityManager();
            Entity entity = em.find(metaClass.getJavaClass(), entityId);
            if (entity != null) {
                ((HasProcessState) entity).setProcessState(processState);
            } else {
                log.error("Entity {} with id {} not found", metaClass.getName(), entityId);
            }
            tx.commit();
        }
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }
}