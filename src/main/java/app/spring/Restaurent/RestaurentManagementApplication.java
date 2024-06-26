package app.spring.Restaurent;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static java.lang.Thread.sleep;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableScheduling

public class RestaurentManagementApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(RestaurentManagementApplication.class, args);
	}

}
