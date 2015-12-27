package ee.erp.central.user;

import com.vaadin.annotations.Theme;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.vaadin.spring.annotation.VaadinUI;

/**
 * Created by Artyom on 12/23/2015.
 */

@VaadinUI(path = "/user")
@Theme("valo")
public class UserPage extends UI {

    @Autowired
    ReloadableResourceBundleMessageSource messageSource;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout();

        layout.addComponent(new Label(messageSource.getMessage("user.welcome", null, VaadinSession.getCurrent().getLocale())));
        layout.addComponent(new Link("Login zone",new ExternalResource("http://localhost:8080/log1n/")));
        layout.addComponent(new Link("User zone",new ExternalResource("http://localhost:8080/user/")));
        layout.addComponent(new Link("Admin zone",new ExternalResource("http://localhost:8080/admin/")));
        setContent(layout);
    }
}
