package com.goal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;


@EnableWebSecurity
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true, jsr250Enabled=true)
public class SecurityConfig {

	 @Autowired UserDetailsService userDetailsService;

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
	            throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.authorizeRequests().antMatchers("/goal/**").authenticated()
	        .antMatchers("/user/**").authenticated()
	                .and()
	                    .csrf().ignoringAntMatchers("/res/**")
	                .and()
	                    .headers()
	                    .addHeaderWriter(new XFrameOptionsHeaderWriter(
	                            XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
	                .and()
	                    .formLogin()
	                    .loginPage("/login")
	                    .loginProcessingUrl("/login_processing")
	                    .failureUrl("/login?error")
	                    .defaultSuccessUrl("/", true)
	                    .usernameParameter("userId")
	                    .passwordParameter("password")
	                .and()
	                    .logout()
	                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout_processing"))
	                    .logoutSuccessUrl("/")
	                    .invalidateHttpSession(true)
	        ;
	        return http.build();
	    }

}
