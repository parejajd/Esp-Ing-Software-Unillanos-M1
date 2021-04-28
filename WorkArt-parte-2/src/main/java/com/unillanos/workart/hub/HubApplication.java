package com.unillanos.workart.hub;

import com.unillanos.workart.hub.security.JWTAuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
@ComponentScan(basePackages = "com.unillanos.workart.hub.controllers")
@EntityScan("com.unillanos.workart.hub.entities")
@EnableJpaRepositories("com.unillanos.workart.hub.repositories")
public class HubApplication {
    public static void main(String[] args) {
        SpringApplication.run(HubApplication.class, args);
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception
        {
            http.csrf().disable()
                    .addFilterAfter(new JWTAuthFilter(), UsernamePasswordAuthenticationFilter.class )
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST,"/login").permitAll()
                    .antMatchers(HttpMethod.GET,"/").permitAll()
                    .antMatchers("/v3/api-docs",
                            "/v3/api-docs/**",
                            "/configuration/ui",
                            "/swagger-resources/**",
                            "/configuration/security",
                            "/swagger-ui.html",
                            "/swagger-ui/**",
                            "/webjars/**").permitAll()
                    .anyRequest().authenticated();

        }
    }
}
