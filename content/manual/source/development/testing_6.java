public class SalesTestContainer extends TestContainer {

    public SalesTestContainer() {
        ...
    }

    public static class Common extends SalesTestContainer {

        public static final SalesTestContainer.Common INSTANCE = new SalesTestContainer.Common();

        private static volatile boolean initialized;

        private Common() {
        }

        @Override
        public void before() throws Throwable {
            if (!initialized) {
                super.before();
                initialized = true;
            }
            setupContext();
        }

        @Override
        public void after() {
            cleanupContext();
            // never stops - do not call super
        }
    }
}
