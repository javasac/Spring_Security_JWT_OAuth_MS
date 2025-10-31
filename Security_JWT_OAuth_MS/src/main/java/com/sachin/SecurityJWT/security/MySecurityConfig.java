package com.sachin.SecurityJWT.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class MySecurityConfig
{
    @Bean
    UserDetailsService userDetailsService()
    {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        UserDetails user = User.withUsername("tom").password(passwordEncoder().
                encode("cruise")).authorities("read").build();
        userDetailsService.createUser(user);
        return userDetailsService;
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/name").permitAll()
                        .anyRequest().authenticated()).formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);

        return http.build();
    }
}
