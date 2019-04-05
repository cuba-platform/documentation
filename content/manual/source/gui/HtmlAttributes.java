import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.HtmlAttributes;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("demo_DemoScreen")
@UiDescriptor("demo-screen.xml")
public class DemoScreen extends Screen {

    @Inject
    private Button demoButton;

    @Inject
    protected HtmlAttributes html;

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) {
        html.setDomAttribute(demoButton, HtmlAttributes.DOM.TITLE, "Hello!");

        html.setCssProperty(demoButton, HtmlAttributes.CSS.BACKGROUND_COLOR, "red");
        html.setCssProperty(demoButton, HtmlAttributes.CSS.BACKGROUND_IMAGE, "none");
        html.setCssProperty(demoButton, HtmlAttributes.CSS.BOX_SHADOW, "none");
        html.setCssProperty(demoButton, HtmlAttributes.CSS.BORDER_COLOR, "red");
        html.setCssProperty(demoButton, "color", "white");

        html.setCssProperty(demoButton, HtmlAttributes.CSS.MAX_WIDTH, "400px");
    }
}