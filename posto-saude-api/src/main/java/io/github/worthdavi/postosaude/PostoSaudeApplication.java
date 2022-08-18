package io.github.worthdavi.postosaude;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PostoSaudeApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(PostoSaudeApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PostoSaudeApplication.class, args);	
	}
	
}
