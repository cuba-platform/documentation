import com.company.sales.entity.Order;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.relatedentities.RelatedEntitiesAPI;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("sales_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {

    @Inject
    private RelatedEntitiesAPI relatedEntitiesAPI;
    @Inject
    private GroupTable<Order> ordersTable;

    @Subscribe("related")
    protected void onRelatedClick(Button.ClickEvent event) {
        relatedEntitiesAPI.openRelatedScreen(ordersTable.getSelected(), Order.class, "customer");
    }

}