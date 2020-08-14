package br.com.techlabs.mailnotification;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.techlabs.mailnotification.storage.StorageService;

@SpringBootApplication
public class MailnotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailnotificationApplication.class, args);
	}

	
}
