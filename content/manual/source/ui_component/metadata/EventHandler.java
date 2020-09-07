@StudioComponent(category = "Samples")
public interface LazyTreeTable extends Component {

    // ...

    Subscription addNodeExpandListener(Consumer<NodeExpandEvent> listener);

    class NodeExpandEvent extends EventObject {
        private final Object nodeId;

        public NodeExpandEvent(LazyTreeTable source, Object nodeId) {
            super(source);
            this.nodeId = nodeId;
        }

        public Object getNodeId() {
            return nodeId;
        }
    }
}
