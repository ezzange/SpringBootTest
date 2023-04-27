package Domo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorize -> authorize
					.antMatchers("/css/**").permitAll()					
					.antMatchers("/","/admin").permitAll()
					//.antMatchers("/").permitAll()
					//.antMatchers("/admin").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
			)
			;
		return http.build();
	}
}
