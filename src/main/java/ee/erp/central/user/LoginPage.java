package ee.erp.central.user;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.vaadin.spring.annotation.VaadinUI;

@VaadinUI(path = "/log1n")
public class LoginPage extends UI {

    @Autowired
    AuthenticationManager manager;

    @Override
    protected void init(VaadinRequest request) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken("user", "password");

        SecurityContextHolder.getContext()
                .setAuthentication(manager.authenticate(authenticationToken));

        VerticalLayout mainLayout = new VerticalLayout();
        setContent(mainLayout);

        mainLayout.addComponent(new Label("Welcome to Login Page"));
        mainLayout.addComponent(new Link("Login zone", new ExternalResource("http://localhost:8080/log1n/")));
        mainLayout.addComponent(new Link("Admin zone", new ExternalResource("http://localhost:8080/admin/")));

        VerticalLayout loginLayout = new VerticalLayout();

        TextField userName = new TextField("Username");
        PasswordField password = new PasswordField("Password");
        Button signIn = new Button("Log in");

        loginLayout.addComponent(userName);
        loginLayout.addComponent(password);
        loginLayout.addComponent(signIn);

        mainLayout.addComponent(loginLayout);

//        Button button = new Button("Button");
//        verticalLayout.addComponent(button);
//
//        button.addClickListener(new Button.ClickListener() {
//            @Override
//            public void buttonClick(Button.ClickEvent clickEvent) {
//
//                Label label = new Label("Label");
//
//                verticalLayout.addComponent(label);
//            }
//        });

        signIn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                System.out.println(userName.getValue());
            }
        });


    }
}