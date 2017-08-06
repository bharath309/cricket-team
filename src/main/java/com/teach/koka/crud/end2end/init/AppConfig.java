package com.teach.koka.crud.end2end.init;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@ComponentScan("com.teach.koka.crud.end2end")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class AppConfig {

	private static final String DATABASE_DRIVER = "db.driver";
	private static final String DATABASE_URL = "db.url";
	private static final String DATABASE_USERNAME = "db.username";
	private static final String DATABASE_PASSWORD = "db.password";

	private static final String HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String SHOW_SQL = "hibernate.show_sql";
	private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	private static final String HBM2DDL = "hibernate.hbm2ddl.auto";
	private static final String FORMAT_SQL ="hibernate.format_sql";
	private static final String SCHEMA ="hibernate.default_schema";
	
	
	@Autowired
	Environment env;

	/**
	 * An alternative to the DriverManager facility, a DataSource object is the
	 * preferred means of getting a connection.
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(DATABASE_PASSWORD));

		return dataSource;
	}

	@Bean
	public Properties hibProperties() {
		Properties prop = new Properties();
		prop.put(HIBERNATE_DIALECT, env.getRequiredProperty(HIBERNATE_DIALECT));
		prop.put(SHOW_SQL, env.getRequiredProperty(SHOW_SQL));
		prop.put(HBM2DDL, env.getRequiredProperty(HBM2DDL));
		prop.put(FORMAT_SQL, env.getRequiredProperty(FORMAT_SQL));
		prop.put(SCHEMA, env.getRequiredProperty(SCHEMA));
		return prop;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(env
				.getRequiredProperty(ENTITYMANAGER_PACKAGES_TO_SCAN));
		sessionFactory.setHibernateProperties(hibProperties());
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager transactionManager(){
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(sessionFactory().getObject());
		return manager;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());

		return jdbcTemplate;
	}

	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);

		return viewResolver;
	}

	@Bean
	public TilesViewResolver getTilesViewResolver() {
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		tilesViewResolver.setOrder(0);
		return tilesViewResolver;
	}

	@Bean
	public TilesConfigurer getTilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();

		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles.xml" });
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("application");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

}
