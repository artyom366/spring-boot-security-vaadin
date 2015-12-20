package ee.erp.central;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by Artyom on 12/20/2015.
 */

@SpringBootApplication
public class Application {

    @Value("${spring.datasource.driverClassName}")
    private String databaseDriverClassName;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String databaseUsername;

    @Value("${spring.datasource.password}")
    private String databasePassword;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(databaseDriverClassName);
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(databaseUsername);
        dataSource.setPassword(databasePassword);
        return dataSource;
    }

    @Service
    public static class MyService {
        public String sayHi() {
            return "Hello Spring!";
        }
    }

    @Theme("valo")
    @SpringUI(path = "/app")
    public static class VaadinUI extends UI {

        @Autowired
        MyService myService;

        @Override
        protected void init(VaadinRequest request) {
            Button button = new Button("Greet service");
            button.addClickListener(e -> Notification.show(myService.sayHi()));
            setContent(button);
        }
    }
}
