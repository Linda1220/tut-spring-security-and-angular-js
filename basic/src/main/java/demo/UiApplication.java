package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

import javax.servlet.Servlet;

@SpringBootApplication
@RestController
@EntityScan(
		basePackageClasses = { UiApplication.class, Jsr310JpaConverters.class }
)
public class UiApplication {

	@RequestMapping("/resource")
	public Map<String,Object> home() {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
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
