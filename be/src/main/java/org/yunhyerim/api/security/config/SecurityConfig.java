package org.yunhyerim.api.security.config;
import org.yunhyerim.api.security.aop.SecurityFilter;
import org.yunhyerim.api.security.domain.SecurityProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{
    private SecurityProvider provider;

    public SecurityConfig(SecurityProvider provider) {
        this.provider = provider;
    }

    @Override
    public void configure(HttpSecurity http) {
        SecurityFilter filter = new SecurityFilter(provider);
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}