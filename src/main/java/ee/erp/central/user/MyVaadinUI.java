//package ee.erp.central.user;
//
//import com.vaadin.annotations.Theme;
//import com.vaadin.server.VaadinRequest;
//import com.vaadin.spring.annotation.EnableVaadin;
//import com.vaadin.spring.annotation.SpringUI;
//import com.vaadin.spring.server.SpringVaadinServlet;
//import com.vaadin.ui.Button;
//import com.vaadin.ui.Label;
//import com.vaadin.ui.UI;
//import com.vaadin.ui.VerticalLayout;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.context.ContextLoaderListener;
//
//import javax.servlet.annotation.WebListener;
//import javax.servlet.annotation.WebServlet;
//
///**
// * Created by Artyom on 12/20/2015.
// */
//
//@Theme("valo")
//@SpringUI
//public class MyVaadinUI extends UI {
//
//    @WebServlet(value = "/*", asyncSupported = true)
//    public static class Servlet extends SpringVaadinServlet {
//    }
//
//    @WebListener
//    public static class MyContextLoaderListener extends ContextLoaderListener {
//    }
//
//    @Configuration
//    @EnableVaadin
//    public static class MyConfiguration {
//    }
//
//    @Override
//    protected void init(VaadinRequest request) {
//        final VerticalLayout layout = new VerticalLayout();
//        layout.setMargin(true);
//        setContent(layout);
//
//        Button button = new Button("Click Me");
//        button.addClickListener(new Button.ClickListener() {
//            public void buttonClick(Button.ClickEvent event) {
//                layout.addComponent(new Label("Thank you for clicking"));
//            }
//        });
//        layout.addComponent(button);
//    }
//
//}
