public class UnderlinedButtonDecorator implements ComponentDecorator {
    @Override
    @SuppressWarnings("unchecked")
    public void decorate(Object component, Set<String> state) {
        DesktopButton item = (DesktopButton) component;
        JButton jButton = (JButton) item.getComponent();
        Font originalFont = jButton.getFont();
        Map attributes = originalFont.getAttributes();

        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jButton.setFont(originalFont.deriveFont(attributes));
    }
}