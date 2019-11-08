@UiController("bpmsamples$Task.edit")
@UiDescriptor("task-edit.xml")
@EditedEntityContainer("taskDc")
@LoadDataBeforeShow
public class TaskEdit extends StandardEditor<Task> {

    public static final String PROCESS_CODE = "taskExecution-1";

    @Inject
    protected ProcActionsFragment procActionsFragment;

    @Inject
    protected BpmEntitiesService bpmEntitiesService;

    @Inject
    protected ProcessRuntimeService processRuntimeService;

    @Inject
    private MessageBundle messageBundle;

    @Inject
    private Notifications notifications;

    @Inject
    private Metadata metadata;    

    @Inject
    private Messages messages;

    @Inject
    private InstanceLoader<Task> taskDl;

	...
	
    /**
     * Method starts the process without {@link ProcActionsFragment}
     */
    @Subscribe("startProcessProgrammaticallyBtn")
    private void onStartProcessProgrammaticallyBtnClick(Button.ClickEvent event) {

        commitChanges()
                .then(() -> {
            /*The ProcInstanceDetails object is used for describing a ProcInstance to be created with its proc actors*/
            BpmEntitiesService.ProcInstanceDetails procInstanceDetails = new BpmEntitiesService.ProcInstanceDetails(PROCESS_CODE)
                    .addProcActor("initiator", getEditedEntity().getInitiator())
                    .addProcActor("executor", getEditedEntity().getExecutor())
                    .setEntity(getEditedEntity());

            /*The created ProcInstance will have two proc actors. None of the entities is persisted yet.*/
            ProcInstance procInstance = bpmEntitiesService.createProcInstance(procInstanceDetails);

            /*A map with process variables that must be passed to the Activiti process instance when it is started.
            This variable is used in the model to make a decision for one of gateways.*/
            HashMap<String, Object> processVariables = new HashMap<>();
            processVariables.put("acceptanceRequired", getEditedEntity().getAcceptanceRequired());

            /*Starts the process. The "startProcess" method automatically persists the passed procInstance with its actors*/
            processRuntimeService.startProcess(procInstance, "Process started programmatically", processVariables);
            notifications.create()
                    .withCaption(messageBundle.getMessage("processStarted"))
                    .withType(Notifications.NotificationType.HUMANIZED)
                    .show();

            /*refresh the procActionsFragment to display complete tasks buttons
            (if a process task appears for the current user after the process is started)*/
            initProcActionsFragment();
        });
    }

    private void initProcActionsFragment() {
        procActionsFragment.initializer()
                .standard()
                .setBeforeStartProcessPredicate(() -> {
                    /*the predicate creates process actors and sets them to the process instance
                    created by the ProcActionsFragment*/
                    if (commitChanges().getStatus() == OperationResult.Status.SUCCESS) {
                        ProcInstance procInstance = procActionsFragment.getProcInstance();
                        ProcActor initiatorProcActor = createProcActor("initiator", procInstance, getEditedEntity().getInitiator());
                        ProcActor executorProcActor = createProcActor("executor", procInstance, getEditedEntity().getExecutor());
                        Set<ProcActor> procActors = new HashSet<>();
                        procActors.add(initiatorProcActor);
                        procActors.add(executorProcActor);
                        procInstance.setProcActors(procActors);
                        return true;
                    }
                    return false;
                })
                .setStartProcessActionProcessVariablesSupplier(() -> {
                    /*the supplier returns a map with process variables that will be used by the Activiti process*/
                    Map<String, Object> processVariables = new HashMap<>();
                    processVariables.put("acceptanceRequired", getEditedEntity().getAcceptanceRequired());
                    return processVariables;
                })
                .setAfterStartProcessListener(() -> {
                    /*custom listener in addition to the standard behavior refreshes the "taskDs", because the process
                    automatically updates the "processState" field of the "Task" entity.*/
                    notifications.create()
                            .withCaption(messages.getMessage(ProcActionsFragment.class,"processStarted"))
                            .withType(Notifications.NotificationType.HUMANIZED)
                            .show();
                    initProcActionsFragment();
                    taskDl.setEntityId(getEditedEntity().getId());
                    taskDl.load();
                })
                .setAfterCompleteTaskListener(() -> {
                    notifications.create()
                            .withCaption(messages.getMessage(ProcActionsFragment.class,"taskCompleted"))
                            .withType(Notifications.NotificationType.HUMANIZED)
                            .show();
                    initProcActionsFragment();
                    taskDl.setEntityId(getEditedEntity().getId());
                    taskDl.load();
                })
                .init(PROCESS_CODE, getEditedEntity());
    }

    private ProcActor createProcActor(String procRoleCode, ProcInstance procInstance, User user) {
        ProcActor initiatorProcActor = metadata.create(ProcActor.class);
        initiatorProcActor.setUser(user);
        ProcRole initiatorProcRole = bpmEntitiesService.findProcRole(PROCESS_CODE, procRoleCode, View.MINIMAL);
        initiatorProcActor.setProcRole(initiatorProcRole);
        initiatorProcActor.setProcInstance(procInstance);
        return initiatorProcActor;
    }

    /**
     * Method demonstrates how to get and modify process actions automatically created by the ProcActionsFragment
     */
    private void changeStartProcessBtnCaption() {
        StartProcessAction startProcessAction = procActionsFragment.getStartProcessAction();
        if (startProcessAction != null) {
            startProcessAction.setCaption("Start process using ProcActionsFragment");
        }
    }
}