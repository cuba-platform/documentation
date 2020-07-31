@StudioFacet
public interface ClipboardTrigger extends Facet {

    // ...
    
    Subscription addCopyListener(Consumer<CopyEvent> listener);

    class CopyEvent extends EventObject {
        public CopyEvent(ClipboardTrigger source, boolean success) {
            super(source);
            this.success = success;
        }

        public boolean isSuccess() {
            return success;
        }
    }
}
