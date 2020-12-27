package com.ibcs.rm.Configuration;

import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("project").permitAll();
        http.authorizeRequests().antMatchers("business.requirement").permitAll();
        http.authorizeRequests().antMatchers("functional.requirement").permitAll();
        http.authorizeRequests().antMatchers("Nonfunctional.requirement").permitAll();
        http.csrf().disable();
    }


}
