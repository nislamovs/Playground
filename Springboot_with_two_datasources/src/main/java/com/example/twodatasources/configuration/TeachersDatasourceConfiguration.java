package com.example.twodatasources.configuration;

import com.example.twodatasources.model.datasource1.Teacher;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

import static java.util.Objects.requireNonNull;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.twodatasources.repository.datasource1",
        entityManagerFactoryRef = "teacherEntityManagerFactory",
        transactionManagerRef = "teacherTransactionManager")
public class TeachersDatasourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource1")
    public DataSourceProperties teacherDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource1.configuration")
    public DataSource teacherDataSource() {
        return teacherDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }

    @Bean(name = "teacherEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean teacherEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(teacherDataSource())
                .packages("com.example.twodatasources.model.datasource1").build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager teacherTransactionManager(
            final @Qualifier("teacherEntityManagerFactory")
                    LocalContainerEntityManagerFactoryBean teacherEntityManagerFactory) {

        return new JpaTransactionManager(requireNonNull(teacherEntityManagerFactory.getObject()));
    }
}
