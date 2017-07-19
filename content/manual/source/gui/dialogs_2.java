showOptionDialog(
    getMessage("confirmCopy.title"),
    getMessage("confirmCopy.msg"),
    MessageType.CONFIRMATION,
    new Action[] {
        new DialogAction(DialogAction.Type.YES, Status.PRIMARY).withHandler(e -> copySettings()),
        new DialogAction(DialogAction.Type.NO, Status.NORMAL)
    }
);