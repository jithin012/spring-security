package com.mclabs.config;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.mclabs.filter.AuthoritiesLoggingAfterFilter;
import com.mclabs.filter.AuthoritiesLoggingAtFilter;
import com.mclabs.filter.JWTTokenGeneratorFilter;
import com.mclabs.filter.JWTTokenValidatorFilter;
import com.mclabs.filter.RequestValidationBeforeFilter;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/**
		 * Don't create a session/token by spring. We will handle session by jwt
		 * later....
		 */
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		/** <----- cors -----> */
		http.cors().configurationSource(new CorsConfigurationSource() {
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config = new CorsConfiguration();
				config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setAllowCredentials(true);
				config.setAllowedHeaders(Collections.singletonList("*"));
				config.setExposedHeaders(Arrays.asList("Authorization"));
				config.setMaxAge(3600L);
				return config;
			}
		});
		/** <----- csrf -----> */
//		http.csrf().ignoringAntMatchers("/contact"). // except the request for /contact
//				csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
// withHttpOnlyFalse - The browser will allow javascript originating from the same origin to access the cookie.
		http.csrf().disable();

		// <----- Filter Config ------>
		http.addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
				.addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
				.addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
				.addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
				.addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class);


		// Default configure
//		http.authorizeRequests()
//			.anyRequest()
//			.authenticated()
//			.and()
//			.formLogin()
//			.and()
//			.httpBasic();
		http
		.exceptionHandling()
			.accessDeniedPage("/access_denied")
			.accessDeniedHandler(new AccessDeniedHandlerimpl())
		.and()
			.authorizeRequests()
			.antMatchers("/myAccount").hasRole("USER").antMatchers("/myBalance")
			.hasAnyRole("USER", "ADMIN").antMatchers("/myLoans").hasRole("ROOT") // .authenticated()
			.antMatchers("/myCards").authenticated().antMatchers("/notices")
			.permitAll().antMatchers("/contact")
			.permitAll()
			.and()
			.formLogin()
				.successHandler(new AuthenticationSuccessHandlerImpl())
				.failureHandler(new AuthenticationFailureHandlerImpl())
				.defaultSuccessUrl("/home")
			.and()
			.httpBasic()
			.and()
			.logout()
				.logoutUrl("/api/logout")
				.logoutSuccessUrl("/");

		/**
		 * some more about auth requestand MUST TRY
		 * 
		 */
		// http
		// 	.headers()
		// 	.contentSecurityPolicy("script-src: http://mydomain...")
		// 	.and()
		// 	.frameOptions().sameOrigin()		// disable clickjacking
		// 	.cacheControl().disable()		// use cacheControl in rest controller
		// 	.and()
		// 	.authorizeRequests()
		// 	.mvcMatchers("/login")
		// 	.permitAll()
		// 	.anyRequest()
		// 	.authenticated()
		// 	.and()
		// 	.formLogin().loginPage("/login");

		/**
		 * Configuration to deny all the requests
		 */

		/*
		 * http .authorizeRequests() .anyRequest().denyAll() .and() .formLogin().and()
		 * .httpBasic();
		 */

		/**
		 * Configuration to permit all the requests
		 */

		/*
		 * http .authorizeRequests() .anyRequest().permitAll().and() .formLogin().and()
		 * .httpBasic();
		 */

	}

	// InMemortUserDetailsManager
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//		UserDetails user = User.withUsername("admin").password("12345").authorities("admin").build();
//		UserDetails user1 = User.withUsername("user").password("12345").authorities("read").build();
//		userDetailsService.createUser(user);
//		userDetailsService.createUser(user1);
//		auth.userDetailsService(userDetailsService);
//	}

/**
 * 
 * unblock all javascript css and html.
 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().mvcMatchers("/css/**", "/webjars/**", "/js/**");
	}

	/** http firewall - Blocks Non-ASCII characters */
	@Bean
	public HttpFirewall firewall() {
		StrictHttpFirewall firewall = new StrictHttpFirewall();
		firewall.setAllowSemicolon(true);		
		return firewall;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
