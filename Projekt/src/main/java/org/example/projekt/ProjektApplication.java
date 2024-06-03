package org.example.projekt;

import com.vaadin.flow.spring.security.VaadinAwareSecurityContextHolderStrategyConfiguration;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.example.projekt.ui.LoginView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class ProjektApplication extends VaadinWebSecurity {

    public static void main(String[] args) {
        SpringApplication.run(ProjektApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity web) throws Exception {
        super.configure(web);
        setLoginView(web, LoginView.class);
    }

    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new InMemoryUserDetailsManager(
                User.withUsername("Radek")
                        .password("{noop}pass")
                        .roles("ADMIN")
                        .build(),
                User.withUsername("Aleksandra")
                        .password("{noop}pass")
                        .roles("ADMIN")
                        .build()
        );
    }


}
