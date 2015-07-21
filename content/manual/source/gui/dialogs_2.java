showOptionDialog(
      getMessage("confirmCopy.title"),
      getMessage("confirmCopy.msg"),
      MessageType.CONFIRMATION,
      new Action[] {
              new DialogAction(DialogAction.Type.YES) {
                  public void actionPerform(Component component) {
                      copySettings();
                  }
              },
              new DialogAction(DialogAction.Type.NO)
      }
);