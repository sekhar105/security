package security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@ComponentScan(basePackages = "security.secu.service")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(detailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.httpBasic().and().csrf().disable();
		http.formLogin().loginPage("/login.htm").usernameParameter("j_username").passwordParameter("j_password").loginProcessingUrl("/j_spring_security_login.htm").and().logout().logoutSuccessUrl("/logout.htm").invalidateHttpSession(true);
		http.authorizeRequests().antMatchers("/home.htm").permitAll().antMatchers("/account/find.htm").hasAnyAuthority("customer","clerk","manager");
	}
		
}
