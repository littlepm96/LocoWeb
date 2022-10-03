package com.example.locoweb.configuration;

import com.example.locoweb.utils.AppConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeRequests()
                .antMatchers("/admin/**")
                .access("hasRole('ROLE_ADMIN')")
            .and()
            .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginProcessing")
                .permitAll()
                .defaultSuccessUrl("/admin/list")
            .and()
            .logout()
                .logoutUrl("/login?logout=")
            .and()
            .build();
	}

    @Bean
	public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
            .withUsername(AppConstants.ADMIN_USER)
            .password(encoder().encode(AppConstants.ADMIN_PW))
            .roles("USER", "ADMIN")
            .build());

        return manager;
	}

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
