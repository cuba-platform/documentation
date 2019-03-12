procActionsFragment.initializer()
        .setBeforeStartProcessPredicate(() -> {
            getScreenData().getDataContext().commit();
            return true;
        })
        .setAfterStartProcessListener(() -> {
            notifications.create()
                    .withCaption(messageBundle.getMessage("processStarted"))
                    .withType(Notifications.NotificationType.HUMANIZED)
                    .show();
        })
        .init(PROCESS_CODE, getEditedEntity());