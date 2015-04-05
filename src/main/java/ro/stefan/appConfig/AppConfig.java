package ro.stefan.appConfig;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ro.stefan.DAO.GenericCollectionDAO;
import ro.stefan.DAO.UsersAdminDAO;
import ro.stefan.appConfig.security.MongoUserDetailsService;


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
    public DB mongoClient() throws Exception{
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

    @Bean
    public GenericCollectionDAO genericCollectionDAO(){
        return new GenericCollectionDAO();
    }
}