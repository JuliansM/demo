package com.valid.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final JdbcTemplate template;

	public DemoApplication(JdbcTemplate template) {
		this.template = template;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.execute("DROP TABLE persons IF EXISTS");
		template.execute("CREATE TABLE persons(id INTEGER(11) PRIMARY KEY auto_increment, name VARCHAR(255), last_name VARCHAR(255), processed BOOLEAN NOT NULL)");
	}
}
