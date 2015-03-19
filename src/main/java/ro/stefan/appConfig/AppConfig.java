package ro.stefan.appConfig;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ro.stefan.DAO.UsersAdminDAO;


@Configuration
public class AppConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public DB mongoClient() throws Exception{ //TODO scote de aici nebunia asta pentru ca face cate o instanta pentru fiecare apelare
        DB db = new MongoClient(new ServerAddress("localhost",27017)).getDB("magazin");
        return db;
    }

    @Bean
    public UsersAdminDAO usersAdmin(){
        return new UsersAdminDAO();
    }

    @Bean
    public MongoUserDetailsService mongoUserDetailsService(){
        return new MongoUserDetailsService();
    }
}
