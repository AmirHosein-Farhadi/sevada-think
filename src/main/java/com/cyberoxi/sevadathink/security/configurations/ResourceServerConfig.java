//package com.cyberoxi.sevadathink.security.configurations;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .headers().frameOptions().disable()
//                .and()
//                .authorizeRequests().anyRequest().permitAll();  //added this test the application easier
//        /*        http
//                .headers()
//                .frameOptions()
//                .disable()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/","/home","/register","/login","/blog").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/order/**", "/customer/**").authenticated();*/
//    }
//}