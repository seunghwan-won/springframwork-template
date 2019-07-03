package seunghwan.won.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DBConfig implements TransactionManagementConfigurer {
    private final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false";
    private final String USER_NAME = "tester";
    private final String PASSWORD = "1234";

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }

    private PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
