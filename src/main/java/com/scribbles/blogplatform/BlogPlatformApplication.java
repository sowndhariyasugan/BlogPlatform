package com.scribbles.blogplatform;

import com.scribbles.blogplatform.User.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogPlatformApplication {
	private static final Logger log=
			LoggerFactory.getLogger(
				BlogPlatformApplication.class
			);

	public static void main(String[] args) {

		SpringApplication.run(BlogPlatformApplication.class, args);
		User u1=new User(1,"Dori","9965532721","dorimail@gmail.com");
		log.info("User is {}",u1);
	}

}
