import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.HtmlAttributes;

import javax.inject.Inject;
import java.util.Map;

public class DemoScreen extends AbstractWindow {
    @Inject
    protected Button demoBtn;
    @Inject
    protected HtmlAttributes html;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        html.setDomAttribute(demoBtn, HtmlAttributes.DOM.TITLE, "Hello !");

        html.setCssProperty(demoBtn, HtmlAttributes.CSS.BACKGROUND_COLOR, "red");
        html.setCssProperty(demoBtn, HtmlAttributes.CSS.BACKGROUND_IMAGE, "none");
        html.setCssProperty(demoBtn, HtmlAttributes.CSS.BOX_SHADOW, "none");
        html.setCssProperty(demoBtn, HtmlAttributes.CSS.BORDER_COLOR, "red");
        html.setCssProperty(demoBtn, "color", "white");

        html.setCssProperty(demoBtn, HtmlAttributes.CSS.MAX_WIDTH, "400px");
    }
}