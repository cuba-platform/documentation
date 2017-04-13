import com.company.sales.entity.Order;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.relatedentities.RelatedEntitiesAPI;

import javax.inject.Inject;


public class OrderBrowse extends AbstractLookup {

    @Inject
    private RelatedEntitiesAPI relatedEntitiesAPI;

    @Inject
    private Table<Order> ordersTable;


    public void onRelatedClick() {
        relatedEntitiesAPI.openRelatedScreen(ordersTable.getSelected(),
                Order.class, "customer");
    }
}