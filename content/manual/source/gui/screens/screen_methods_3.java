@Override
protected void commit(Action.ActionPerformedEvent event) {
    commitChanges().then(() -> {
        // this flag is used for returning correct outcome on subsequent screen closing
        commitActionPerformed = true;
        // perform actions after the data has been saved
    });
}
