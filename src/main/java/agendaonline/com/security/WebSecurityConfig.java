package agendaonline.com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private ImplementUserDetailsService iuds;
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.GET, "/").permitAll()
			.antMatchers(HttpMethod.GET, "/getEventos.json").permitAll()
			.antMatchers(HttpMethod.GET, "/agenda").permitAll()//lista consultas
			.antMatchers(HttpMethod.GET, "/login").permitAll()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.antMatchers(HttpMethod.POST, "/agenda").hasRole("USER")//cadastro consulta
			.antMatchers(HttpMethod.GET, "/pacientes/*").hasRole("USER")//lista pacientes cadastrados
			.antMatchers(HttpMethod.POST, "/pacientes").hasRole("USER")//cadastro pacientes
			.antMatchers(HttpMethod.GET, "/procedimentos").hasRole("USER")//lista procedimentos cadastrados
			.antMatchers(HttpMethod.POST, "/procedimentos").hasRole("USER")//cadastro procedimentos
			.antMatchers(HttpMethod.GET, "/convenios").hasRole("USER")//lista convenios cadastrados
			.antMatchers(HttpMethod.POST, "/convenios").hasRole("USER")//cadastro convenios
			.antMatchers(HttpMethod.GET, "/consulta/*").hasRole("USER")//detalhes consulta
			.antMatchers(HttpMethod.POST, "/consulta/*").hasRole("ADMIN")//cadastro prontuario do paciente
			.antMatchers(HttpMethod.GET, "/usuario/*").hasRole("ADMIN")//lista usuarios
			.antMatchers(HttpMethod.POST, "/usuario").hasRole("ADMIN")//cadastro usuarios
			.anyRequest().authenticated()
			.and().formLogin().permitAll()
		    .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(iuds)
        .passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
    public void configure(WebSecurity builder) throws Exception {
        builder.ignoring().antMatchers("/materialize/**",
        		"/jquery/**", "/style/**", "/static/**", "/js/**");
    }
}
