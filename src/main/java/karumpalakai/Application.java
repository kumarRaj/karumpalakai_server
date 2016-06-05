package karumpalakai;

import karumpalakai.dao.SentenceDao;
import org.apache.commons.dbcp.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.spring.DBIFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class Application {
    @Value("${db.url}")
    String dbUrl;

    @Value("${db.username}")
    String dbUsername;

    @Value("${db.password}")
    String dbPassword;

    @Value("${db.driverClassName}")
    String dbDriverClassName;


    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        return flyway;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbDriverClassName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean
    public DBIFactoryBean dbiFactoryBean(DataSource dataSource) {
        return new DBIFactoryBean(dataSource);
    }

    @Bean
    public SentenceDao modelsDAO(DBIFactoryBean dbi) {
        return (SentenceDao) createDAO(dbi, SentenceDao.class);
    }

    private Object createDAO(DBIFactoryBean dbi, Class daoClass) {
        try {
            return ((DBI) dbi.getObject()).onDemand(daoClass);
        } catch (Exception e) {
            throw new RuntimeException("Encountered exception while creating DAO: ", e);
        }
    }

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    }

}
