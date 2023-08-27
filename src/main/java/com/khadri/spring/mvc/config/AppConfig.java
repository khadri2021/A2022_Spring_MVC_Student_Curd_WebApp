package com.khadri.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = { "com.khadri.spring.mvc" })
@PropertySource("classpath:DB.properties")
public class AppConfig {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public ModelAndView modelAndView() {
		return new ModelAndView();
	}

	@Bean
	public DbProperties dbProperties() {
		return new DbProperties();
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DbProperties dbProperties) {

		DriverManagerDataSource dataSource = new DriverManagerDataSource(dbProperties.getUrl(),
				dbProperties.getUserName(), dbProperties.getPassword());
		
		dataSource.setDriverClassName(dbProperties.getDriverClass());

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);

		return jdbcTemplate;
	}

}
