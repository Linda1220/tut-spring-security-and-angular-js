package demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import demo.controller.AbstractController;
import static demo.controller.AbstractController.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

import javax.servlet.Servlet;

@SpringBootApplication
@RestController
public class UiApplication {


	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        private Gson gson = new Gson();


        private AuthenticationSuccessHandler authenticationSuccessHandler = new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                AbstractController.Message ok = new AbstractController.Message("OK", authentication);
                response.getWriter().write(gson.toJson(authentication));
            }
        };

        private AuthenticationFailureHandler authenticationFailureHandler = new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                AbstractController.Message failed = new AbstractController.Message("FAILED", exception);
                response.getWriter().write(gson.toJson(failed));
            }
        };

        private AccessDeniedHandler accessDeniedHandler = new AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
                response.sendRedirect("/#/error-page");
            }
        };


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http
                    .formLogin()
                    .loginPage("/#/login")
                    .loginProcessingUrl("/login")
                    .permitAll()
                    .successHandler(authenticationSuccessHandler)
                    .failureHandler(authenticationFailureHandler)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/index.html", "/", "/partial/**", "/js/**", "/css/**", "/validator/**", "/register").permitAll()
                    .anyRequest().hasRole("USER")
                    .and()
                    .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                    .and()
                    .csrf().disable();
            // @formatter:on
        }

        @Autowired
        private DataSource dataSource;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery("select username, password, enabled from users where username = ?")
                    .authoritiesByUsernameQuery("select username, role from users where username = ?");
        }
    }


}


@Configuration
@ConditionalOnClass({Servlet.class})
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
class VelocityConfiguration implements EnvironmentAware {

	private RelaxedPropertyResolver environment;

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = new RelaxedPropertyResolver(environment,
				"spring.velocity.");
	}

	@Bean
	VelocityConfigurer velocityConfig() {
		return new VelocityConfigurer();
	}

	@Bean
	VelocityViewResolver velocityViewResolver() {
		VelocityViewResolver resolver = new VelocityViewResolver();
		resolver.setSuffix(this.environment.getProperty("suffix", ".html"));
		resolver.setPrefix(this.environment.getProperty("prefix", "/static/"));
		// Needs to come before any fallback resolver (e.g. a
		// InternalResourceViewResolver)
		resolver.setOrder(Ordered.LOWEST_PRECEDENCE - 20);

		return resolver;
	}
}
