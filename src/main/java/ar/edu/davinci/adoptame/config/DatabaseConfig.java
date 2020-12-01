package ar.edu.davinci.adoptame.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {


        @Value("${spring.datasource.url}")
        private String dbUrl;
  /*
        @Value("${spring.datasource.username}")
        private String user;

        @Value("${spring.datasource.password}")
        private String pasw;
*/
        @Bean
        public DataSource dataSource() {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbUrl);
          //  config.setPassword(pasw);
          //  config.setUsername(user);
            return new HikariDataSource(config);
        }

}
