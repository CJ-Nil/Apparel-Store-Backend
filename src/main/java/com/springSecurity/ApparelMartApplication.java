package com.springSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.springSecurity.fileSystem.FileStorageProperties;


@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class ApparelMartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApparelMartApplication.class, args);
	}
}
