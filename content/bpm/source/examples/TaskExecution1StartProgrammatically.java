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