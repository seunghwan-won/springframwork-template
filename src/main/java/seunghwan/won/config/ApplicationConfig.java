package seunghwan.won.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DBConfig.class)
@ComponentScan(basePackages = {"seunghwan.won.dao"})
public class ApplicationConfig {
}
