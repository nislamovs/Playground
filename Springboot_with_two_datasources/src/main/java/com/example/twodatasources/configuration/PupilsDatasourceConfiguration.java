package com.example.twodatasources.configuration;

import com.example.twodatasources.model.datasource2.Pupil;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

import static java.util.Objects.requireNonNull;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.twodatasources.repository.datasource2",
        entityManagerFactoryRef = "pupilEntityManagerFactory",
        transactionManagerRef = "pupilTransactionManager")
public class PupilsDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource2")
    public DataSourceProperties pupilDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource2.configuration")
    public DataSource pupilDataSource() {
        return pupilDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }

    @Bean(name = "pupilEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean pupilEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(pupilDataSource())
                .packages("com.example.twodatasources.model.datasource2").build();
    }

    @Bean
    public PlatformTransactionManager pupilTransactionManager(
            final @Qualifier("pupilEntityManagerFactory")
                    LocalContainerEntityManagerFactoryBean pupilEntityManagerFactory) {

        return new JpaTransactionManager(requireNonNull(pupilEntityManagerFactory.getObject()));
    }
}
