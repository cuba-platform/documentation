procActionsFrame.initializer()
        .setBeforeStartProcessPredicate(this::commit)
        .setAfterStartProcessListener(showNotification(getMessage("processStarted"), NotificationType.HUMANIZED))
        .init(PROCESS_CODE, entity);
