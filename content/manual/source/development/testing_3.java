package com.company.sales;

import com.haulmont.cuba.testsupport.TestContainer;

import java.util.ArrayList;
import java.util.Arrays;

public class SalesTestContainer extends TestContainer {

    public SalesTestContainer() {
        super();
        appComponents = new ArrayList<>(Arrays.asList(
                "com.haulmont.cuba"
                // add CUBA premium add-ons here
                // "com.haulmont.bpm",
                // "com.haulmont.charts",
                // "com.haulmont.fts",
                // "com.haulmont.reports",
                // and custom app components if any
        ));
        appPropertiesFiles = Arrays.asList(
                // List the files defined in your web.xml
                // in appPropertiesConfig context parameter of the core module
                "com/company/sales/app.properties",
                // Add this file which is located in CUBA and defines some properties
                // specifically for test environment. You can replace it with your own
                // or add another one in the end.
                "com/haulmont/cuba/testsupport/test-app.properties");
        initDbProperties();
    }

    private void initDbProperties() {
        dbDriver = "org.postgresql.Driver";
        dbUrl = "jdbc:postgresql://localhost/sales_test";
        dbUser = "cuba";
        dbPassword = "cuba";
    }

    public static class Common extends SalesTestContainer {

        // A common singleton instance of the test container which is initialized once for all tests
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