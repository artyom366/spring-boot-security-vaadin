package ee.erp.central.user;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.vaadin.spring.annotation.VaadinUI;


/**
 * Created by Artyom on 12/23/2015.
 */

@VaadinUI(path = "/4030")
public class AccessDeniedPage extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Label("access denied"));
    }
}
