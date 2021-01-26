package security.demo.configs;

import security.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframeworksecurity.authentication.dao.DaoAuthenticationProvider;
import org.springframeworksecurity.config.annotation.web.builders.HttpSecurity;
import org.springframeworksecurity.config.annotation.web.configuration.EnableWebSecurity;
import org.springframeworksecurity.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframeworksecurity.crypto.bcrypt.BCryptPasswordEncoder;
import security.demo.services.UserService;


@EnableWebSecurity
@RequiredArgsConstructor
public class DaoSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private Logger logger = LoggerFactory.getLogger(DaoSecurityConfig.class.getName());


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("Dao Auth Provider");
        http.authorizeRequests()
                .antMatchers("/api/v1/score/dec").hasRole("ADMIN")
                .antMatchers("/api/v1/score/inc").hasRole("ADMIN")
                .antMatchers("/api/v1/score/current").hasRole("ADMIN")
                .antMatchers("/api/v1/score/**").authenticated()
                .and()
                .formLogin().permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }

}
