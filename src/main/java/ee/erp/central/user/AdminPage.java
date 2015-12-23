package ee.erp.central.user;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.spring.annotation.VaadinUI;

/**
 * Created by Artyom on 12/23/2015.
 */

@VaadinUI(path = "/admin")
public class AdminPage extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout();

        layout.addComponent(new Label("Welcome to Admin Page"));
        layout.addComponent(new Link("Login zone",new ExternalResource("http://localhost:8080/log1n/")));
        layout.addComponent(new Link("User zone",new ExternalResource("http://localhost:8080/user/")));
        layout.addComponent(new Link("Admin zone",new ExternalResource("http://localhost:8080/admin/")));
        setContent(layout);
    }
}
