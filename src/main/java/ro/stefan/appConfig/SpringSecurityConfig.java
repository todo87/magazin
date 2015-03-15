package ro.stefan.appConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("stefan").password("1234").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/res/**");
    }

    //.csrf() is optional, enabled by default, if using WebSecurityConfigurerAdapter constructor
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/main/**").access("hasRole('ROLE_USER')")
                .and()
                .formLogin().loginPage("/admin").failureUrl("/admin?error")
                .usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/main")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/admin?logout")
                .and()
                .csrf();
      //  http.formLogin().loginPage("/admin/login").failureUrl("/admin/login?error").defaultSuccessUrl("/main",true).usernameParameter("username").passwordParameter("password");

    }
}
