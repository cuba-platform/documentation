@Override
public void actionPerform(Component component) {
    openWindow("sec$User.browse", WindowManager.OpenType.DIALOG.width(800).height(300).closeable(true).resizable(true).modal(false));
}