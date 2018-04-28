BpmEntitiesService.ProcInstanceDetails procInstanceDetails = new BpmEntitiesService.ProcInstanceDetails("orderProcessing")
        .addProcActor("manager", userSession.getCurrentOrSubstitutedUser())
        .addProcActor("storekeeper", someOtherUser)
        .setEntity(getItem());
ProcInstance procInstance = bpmEntitiesService.createProcInstance(procInstanceDetails);
processRuntimeService.startProcess(procInstance, "Started", new HashMap<>());