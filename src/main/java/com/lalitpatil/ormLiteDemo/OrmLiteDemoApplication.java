package com.lalitpatil.ormLiteDemo;

import com.lalitpatil.ormLiteDemo.connection.DbConnection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class OrmLiteDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OrmLiteDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DbConnection dbConnection = new DbConnection();
	}
}
