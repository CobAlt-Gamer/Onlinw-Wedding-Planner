package com.wedding.planner.config.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.cors.CorsConfiguration;

import com.wedding.planner.config.auth.jwt.JwtAuthenticationEntryPoint;
import com.wedding.planner.config.auth.jwt.JwtAuthenticationFilter;
import com.wedding.planner.service.impl.UserDetailsServiceImpl;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	@Autowired
	private JwtAuthenticationEntryPoint point;
	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	AuthenticationFailureHandler authenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}

	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).build();
	}

	 @Bean
	SessionRegistry sessionRegistry() {
		 return new SessionRegistryImpl();
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Order(1)
	SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/api/**")
			.csrf(csrf -> csrf.disable())
			.cors(cors -> cors
				    .configurationSource(request -> {
				        CorsConfiguration config = new CorsConfiguration();
				        config.setAllowedOrigins(Arrays.asList("*"));
				        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
				        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
				        return config;
			}))
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/v1/auth/**").permitAll()
				.requestMatchers("/api/v1/manage").hasAnyRole("ADMIN")
				.anyRequest().authenticated())
			.exceptionHandling(ex -> ex
				.authenticationEntryPoint(point))
			.sessionManagement(session -> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	@Order(2)
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
				.requestMatchers("/api/**").denyAll()
				.requestMatchers("/resources/api/**").authenticated()
				.requestMatchers("/resources/**", "/static/**","/cities","/assets/**","/index.jsp","/","/offline.html",
						"/sign-in.jsp","/sign-up/**","/sign-up.jsp","/forgetPassword/**","/forgot-password.jsp","/service-worker.js","webmanifest.json","/terms-of-service","/terms-of-service.jsp","favicon.ico")
				.permitAll()
				.anyRequest()
				.authenticated())
			.sessionManagement((session) -> session
				.invalidSessionUrl("/sign-in")
				.sessionFixation().changeSessionId()
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true)
				.expiredUrl("/sign-in"))
			.formLogin((form) -> form
				.loginPage("/sign-in")
				.defaultSuccessUrl("/home")
				.failureHandler(authenticationFailureHandler())
				.permitAll())
			.logout((logout) -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/sign-in")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true)
				.clearAuthentication(true));
		return http.build();
	}
}
