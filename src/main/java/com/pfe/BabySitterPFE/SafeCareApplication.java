package com.pfe.BabySitterPFE;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class SafeCareApplication {

	public static void main(String[] args) {SpringApplication.run(SafeCareApplication.class, args);}
		/*@Bean
		public CommandLineRunner runner(RoleRepository roleRepository){
			return args -> {
				if (roleRepository.findByName("PARENT").isEmpty()){
					roleRepository.save(
							Role.builder().name("PARENT").build()
					);
				} else if (roleRepository.findByName("BABYSITTER").isEmpty()) ;{
					roleRepository.save(
							Role.builder().name("BABYSITTER").build());
				}
			};
		}*/
	}


