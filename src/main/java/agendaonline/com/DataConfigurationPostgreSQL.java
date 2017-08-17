package agendaonline.com;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfigurationPostgreSQL {

	@Bean
  public DataSource dataSourceProd() throws URISyntaxException{
      
      URI dbUri = new URI(System.getenv("DATABASE_URL"));

      String username = dbUri.getUserInfo().split(":")[0];
      String password = dbUri.getUserInfo().split(":")[1];
      String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
      
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setUrl(dbUrl);
      dataSource.setUsername(username);
      dataSource.setPassword(password);
      dataSource.setInitialSize(20);
      
      return dataSource;
  }
}

