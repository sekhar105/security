package security.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages ={"security.repositroy"})
@ComponentScan(basePackages ={"security.service"})
public class RootConfig {

	@Bean
	public DataSource dataSource(@Value("${db.driverClassName}") String driverClassName,@Value("${db.url}")String url,@Value("${db.username}")String username,@Value("${db.password}")String password) {
		 DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		 dataSource.setDriverClassName(driverClassName);
		 return dataSource;
	}
	
	@Bean("entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityBean(DataSource dataSource) {
		
		LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean= new LocalContainerEntityManagerFactoryBean();
		containerEntityManagerFactoryBean.setDataSource(dataSource);
		
		
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		containerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
	containerEntityManagerFactoryBean.setPackagesToScan("security.entites");	
		return containerEntityManagerFactoryBean;
		
	}
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
		return transactionManager;
	}
	
	
	
}
