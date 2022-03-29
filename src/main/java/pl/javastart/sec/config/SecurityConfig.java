package pl.javastart.sec.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/register", "/confirmation").permitAll()
                .mvcMatchers("/secured").hasRole("USER")
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        );
        http.csrf().disable();
        http.formLogin(login -> login.loginPage("/login").permitAll());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().mvcMatchers("/img/**", "/styles/**");
    }
}