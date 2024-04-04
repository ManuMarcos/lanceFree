package com.manumarcos.lanceFree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LanceFreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LanceFreeApplication.class, args);
	}

}
