package pl.javastart.sec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests.anyRequest().authenticated());
        http.csrf().disable();
        http.formLogin(login -> login.loginPage("/login").permitAll());
    }

    @Bean
    public UserDetailsService customUserDetailsService() {
        User.UserBuilder userBuilder = User.builder();
        UserDetails admin = userBuilder.username("admin").password("{noop}admin").roles("ADMIN").build();
        UserDetails user1 = userBuilder.username("user").password("{noop}user").roles("USER").build();
        return new InMemoryUserDetailsManager(admin, user1);
    }
}