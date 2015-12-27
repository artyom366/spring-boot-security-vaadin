package ee.erp.central.user;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.vaadin.spring.annotation.VaadinUI;

import java.util.ArrayList;
import java.util.Locale;

@VaadinUI(path = "/log1n")
@Theme("valo")
public class LoginPage extends UI {

    @Autowired
    AuthenticationManager manager;

    @Autowired
    ReloadableResourceBundleMessageSource messageSource;


    @Override
    protected void init(VaadinRequest request) {

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);
        setContent(mainLayout);

        Button eng = new Button("Eng");
        Button lv = new Button("Lv");
        Button ru = new Button("Ru");

        mainLayout.addComponent(eng);
        mainLayout.addComponent(lv);
        mainLayout.addComponent(ru);

        eng.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
//                LocaleContextHolder.setLocale(new Locale("en"));
//                getPage().reload();

                VaadinSession.getCurrent().setLocale(new Locale("en"));
                System.out.println(VaadinSession.getCurrent().getLocale());
                getPage().reload();
            }
        });

        lv.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
//                LocaleContextHolder.setLocale(new Locale("lv"));
//                getPage().reload();

                VaadinSession.getCurrent().setLocale(new Locale("lv"));
                System.out.println(VaadinSession.getCurrent().getLocale());
                getPage().reload();
            }
        });

        ru.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
//                LocaleContextHolder.setLocale(new Locale("ru"));
//                getPage().reload();

                VaadinSession.getCurrent().setLocale(new Locale("ru"));
                System.out.println(VaadinSession.getCurrent().getLocale());
                getPage().reload();
            }
        });

        mainLayout.addComponent(new Label("Welcome to Login Page"));
        mainLayout.addComponent(new Link("Login zone", new ExternalResource("http://localhost:8080/log1n/")));
        mainLayout.addComponent(new Link("Admin zone", new ExternalResource("http://localhost:8080/admin/")));

        VerticalLayout loginLayout = new VerticalLayout();
        loginLayout.setMargin(true);
        loginLayout.setSpacing(true);
        mainLayout.addComponent(loginLayout);

        TextField userName = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        Button signIn = new Button(messageSource.getMessage("login.btn", null, VaadinSession.getCurrent().getLocale()));
        signIn.setDescription("this is a login button");

        loginLayout.addComponent(userName);
        loginLayout.addComponent(password);
        loginLayout.addComponent(signIn);

        signIn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken("user", "pass");

                SecurityContextHolder.getContext()
                        .setAuthentication(manager.authenticate(authenticationToken));

                Notification.show("Button Pressed: " + request.getLocale());
            }
        });

        ComboBox comboBox = new ComboBox("Select an option");
        mainLayout.addComponent(comboBox);

        ArrayList<String> options = new ArrayList<>(3);
        options.add("Opt 1");
        options.add("Opt 2");
        options.add("Opt 3");
        comboBox.select(options.get(0));
        comboBox.addItems(options);
        comboBox.setNullSelectionAllowed(false);

        comboBox.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Notification.show("Value selected: " + comboBox.getValue());
            }
        });

        TextField input = new TextField("Input here");
        Label output = new Label();
        mainLayout.addComponent(input);
        mainLayout.addComponent(output);

        ObjectProperty<String> objectProperty = new ObjectProperty<String>("the value");
        input.setPropertyDataSource(objectProperty);
        output.setPropertyDataSource(objectProperty);

    }
}