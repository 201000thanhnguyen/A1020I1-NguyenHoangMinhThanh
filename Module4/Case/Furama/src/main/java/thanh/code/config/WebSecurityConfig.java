package thanh.code.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import thanh.code.service.IServiceTypeService;
import thanh.code.service.impl.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailService myUserDetailService;

    public WebSecurityConfig(MyUserDetailService myUserDetailService) {
        this.myUserDetailService = myUserDetailService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        return new InMemoryTokenRepositoryImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/lib/**",
                        "/images/**",
                        "/",
                        "/Service/list/**",
                        "/AttachService/index"
                )
                .permitAll()
                .antMatchers(
                        "/Employee/**",
                        "/CustomerType/**",
                        "/Division/**",
                        "/EducationDegree/**",
                        "/Employee/**",
                        "/Position/**",
                        "/RentType/**",
                        "/Role/**",
                        "/Customer/**",
                        "/Contract/**",
                        "/ContractDetail/**",
                        "/ServiceType/**",

                        "/Service/create",
                        "/Service/edit/**",
                        "/Service/delete/**",
                        "/AttachService/create",
                        "/AttachService/edit/**",
                        "/AttachService/delete/**"
                )
                .hasRole("ADMIN")
                .antMatchers(
                        "/Service/index",
                        "/Service/detail/**"
                )
                .hasAnyRole("ADMIN", "USER")
                .anyRequest()
                .authenticated()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                .and().logout().deleteCookies("JSESSIONID")
                .and()
                .rememberMe()
                .tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(60 * 60 * 24);
    }

}
