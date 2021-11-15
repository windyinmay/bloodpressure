package hh.finalproject.bloodpressure;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.finalproject.bloodpressure.domain.BPRepository;
import hh.finalproject.bloodpressure.domain.BloodPressure;
import hh.finalproject.bloodpressure.domain.User;
import hh.finalproject.bloodpressure.domain.UserRepository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BloodpressureApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BloodpressureApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BloodpressureApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bloodPressureDemo(BPRepository bprepository, UserRepository urepository) {
		return (args) -> {
			
			User user1 = new User("Anh", "$2b$10$lkcQkpS33ORGQAOBkiFgUOlkAumgJ1d3.ivS85g0G/pi07x72ewPG", 25, "ADMIN");
			log.info("save users");
			urepository.save(user1);
			urepository.save(new User("Matias", "$2b$10$/iCk9bRRVtk8ztpnhLYQp.JBBbY6vklGtuUd7PjoXtAx4hmmK13z.\n" , 28, "GUEST"));
			
			log.info("save blood pressure");
			bprepository.save(new BloodPressure(user1, 120, 80, 70, LocalTime.now(), LocalDate.now()));
			bprepository.save(new BloodPressure(user1, 130, 99, 86, LocalTime.now(), LocalDate.now()));
			bprepository.save(new BloodPressure(user1, 90, 60, 110, LocalTime.now(), LocalDate.now()));
			bprepository.save(new BloodPressure(user1, 144, 97, 98, LocalTime.now(), LocalDate.now()));
			bprepository.save(new BloodPressure(user1, 125, 70, 88, LocalTime.now(), LocalDate.now()));


		};
	}
}
