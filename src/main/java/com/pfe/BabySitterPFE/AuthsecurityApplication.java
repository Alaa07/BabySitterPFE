package com.pfe.BabySitterPFE;

import com.pfe.BabySitterPFE.role.Role;
import com.pfe.BabySitterPFE.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AuthsecurityApplication {

	public static void main(String[] args) {SpringApplication.run(AuthsecurityApplication.class, args);}
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


