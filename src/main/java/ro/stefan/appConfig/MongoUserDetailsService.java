package ro.stefan.appConfig;

import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ro.stefan.DAO.UsersAdminDAO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class MongoUserDetailsService implements UserDetailsService{

    @Resource
    private UsersAdminDAO usersAdminDAO;

    private User userDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cursor cursor = usersAdminDAO.UserCursor(username);
        try {
            if (cursor.hasNext()) {

                DBObject mongoUser = cursor.next();
                List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

                String usernameM = (String) mongoUser.get("_id");
                String passwordM = (String) mongoUser.get("password");
                boolean enabledM = (Boolean) mongoUser.get("enabled");
                boolean accountNonExpiredM = (Boolean) mongoUser.get("accountNonExpired");
                boolean credentialsNonExpiredM = (Boolean) mongoUser.get("credentialsNonExpired");
                boolean accountNonLockedM = (Boolean) mongoUser.get("accountNonLocked");
                String roleM = (String) mongoUser.get("role");
                authList.add(new SimpleGrantedAuthority("ROLE_" + roleM.toUpperCase()));

                userDetails = new User(usernameM, passwordM, enabledM, accountNonExpiredM, credentialsNonExpiredM, accountNonLockedM, authList);

            } else {
                throw new UsernameNotFoundException("Userul nu a fost gasit");
            }
        }finally {
            cursor.close();
        }
        return userDetails;
    }
}
