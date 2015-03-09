package ro.stefan.appConfig;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.net.UnknownHostException;

@Configuration
public class AppConfig {

    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    MongoClient mongoClient(){
        MongoClient client = null;
        try {
            client = new MongoClient();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
}
