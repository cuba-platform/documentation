package com.company.sales.web.order;

import com.company.sales.entity.Customer;
import com.company.sales.entity.Order;
import com.company.sales.entity.OrderLine;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.options.ContainerOptions;
import com.haulmont.cuba.gui.components.data.table.ContainerTableItems;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.model.*;
import com.haulmont.cuba.gui.screen.PrimaryEditorScreen;
import com.haulmont.cuba.gui.screen.StandardEditor;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;

import javax.inject.Inject;
import java.sql.Date;

@UiController("sales_Order.edit")
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    private DataComponents dataComponents; // <1>
    @Inject
    private UiComponents uiComponents;

    private InstanceContainer<Order> orderDc;
    private CollectionPropertyContainer<OrderLine> linesDc;
    private CollectionContainer<Customer> customersDc;
    private InstanceLoader<Order> orderDl;
    private CollectionLoader<Customer> customersDl;

    @Subscribe
    protected void onInit(InitEvent event) {
        createDataComponents();
        createUiComponents();
    }

    private void createDataComponents() {
        DataContext dataContext = dataComponents.createDataContext();
        getScreenData().setDataContext(dataContext); // <2>

        orderDc = dataComponents.createInstanceContainer(Order.class);

        orderDl = dataComponents.createInstanceLoader();
        orderDl.setContainer(orderDc); // <3>
        orderDl.setDataContext(dataContext); // <4>
        orderDl.setView("order-edit");

        linesDc = dataComponents.createCollectionContainer(
                OrderLine.class, orderDc, "lines"); // <5>

        customersDc = dataComponents.createCollectionContainer(Customer.class);

        customersDl = dataComponents.createCollectionLoader();
        customersDl.setContainer(customersDc);
        customersDl.setDataContext(dataContext);
        customersDl.setQuery("select e from sales_Customer e"); // <6>
        customersDl.setView(View.MINIMAL);
    }

    private void createUiComponents() {
        DateField<Date> dateField = uiComponents.create(DateField.TYPE_DATE);
        getWindow().add(dateField);
        dateField.setValueSource(new ContainerValueSource<>(orderDc, "date")); // <7>

        Form form = uiComponents.create(Form.class);
        getWindow().add(form);

        LookupPickerField<Customer> customerField = uiComponents.create(LookupField.of(Customer.class));
        form.add(customerField);
        customerField.setValueSource(new ContainerValueSource<>(orderDc, "customer"));
        customerField.setOptions(new ContainerOptions<>(customersDc)); // <8>

        TextField<Integer> amountField = uiComponents.create(TextField.TYPE_INTEGER);
        amountField.setValueSource(new ContainerValueSource<>(orderDc, "amount"));

        Table<OrderLine> table = uiComponents.create(Table.of(OrderLine.class));
        getWindow().add(table);
        getWindow().expand(table);
        table.setItems(new ContainerTableItems<>(linesDc)); // <9>

        Button okButton = uiComponents.create(Button.class);
        okButton.setAction(getWindow().getActionNN(WINDOW_COMMIT_AND_CLOSE));
        getWindow().add(okButton);

        Button cancelButton = uiComponents.create(Button.class);
        cancelButton.setAction(getWindow().getActionNN(WINDOW_CLOSE));
        getWindow().add(cancelButton);
    }

    @Override
    protected InstanceContainer<Order> getEditedEntityContainer() { // <10>
        return orderDc;
    }

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) { // <11>
        orderDl.load();
        customersDl.load();
    }
}