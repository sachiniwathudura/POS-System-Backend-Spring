package lk.ijse.posspringbackend.config;

import jakarta.persistence.EntityManagerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "lk.ijse.posspringbackend")
@EnableJpaRepositories(basePackages = "lk.ijse.posspringbackend")
@EnableTransactionManagement
public class WebAppRootConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public DataSource dataSource(){
        var dmbs = new DriverManagerDataSource();
        dmbs.setUsername("com.mysql.cj.jdbc.Driver");
        dmbs.setUrl("jdbc:mysql://localhost:3306/POSBackEndSpring?createDatabaseIfNotExist=true");
        dmbs.setUsername("root");
        dmbs.setPassword("Ijse@1234");
        return dmbs;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {// meka thiynne ORM tool ek config krgnna , hibernate project ekt gnne mekn

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("lk.ijse.gdse.posspringbackend.entity");//application eke entities scan,entity tik load krgnne mekn
        factory.setDataSource(dataSource());
        return factory;
    }
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {//transaction manage krnn
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

}
