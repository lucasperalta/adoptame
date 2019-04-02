package ar.edu.davinci.adoptame.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
      auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select p.email , u.password ,true from usuarios u inner join personas p on u.id=p.id where p.email=?")
                .authoritiesByUsernameQuery("select p.email ,r.nombre_rol from usuarios u inner join personas p on u.id=p.id inner join roles r on u.id_rol=r.id_rol where p.email=?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
              .antMatchers("/static/**").permitAll()
              .antMatchers("/css/**").permitAll() //Adding this line solved it
              .antMatchers("/img/**").permitAll() //Adding this line solved it
              .antMatchers("/js/**").permitAll() //Adding this line solved it
              .antMatchers("/admin/**").access("hasRole('ADMIN')")
              .antMatchers("/usuarios/**").access("hasRole('ADMIN')")
              .antMatchers("/servicios/**").access("hasRole('ADMIN')")
              .anyRequest().authenticated()
              .antMatchers("/**").permitAll().anyRequest().permitAll()

              .and()
                .formLogin().loginPage("/login").failureUrl("/login?error")
              .loginProcessingUrl("/ingresar")
                .usernameParameter("email").passwordParameter("password")
              .defaultSuccessUrl("/usuarios/nuevoUsuario")
              .permitAll()
              .and()
               .logout().invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedPage("/forbidden")
                 .and().csrf().disable() ;



    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}