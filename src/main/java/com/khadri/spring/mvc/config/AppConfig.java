package com.khadri.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = { "com.khadri.spring.mvc" })
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
	public JdbcTemplate jdbcTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(
				"jdbc:mysql://localhost:3306/2022batch_association", "root", "root");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);

		return jdbcTemplate;
	}

}
