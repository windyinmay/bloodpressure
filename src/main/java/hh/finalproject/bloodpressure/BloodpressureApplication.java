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
			
			User user1 = new User("Anh", "$2a$10$e8AjiBnDUtURW/GtFc8VGerrY1p0tDYI2eP/NIPSh3.fE4rbRBh3C", 25, "ADMIN");
			log.info("save users");
			urepository.save(user1);
			User user2 = new User("Matias", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6" , 28, "GUEST");
			urepository.save(user2);
			
			log.info("save blood pressure");
			bprepository.save(new BloodPressure(user2, 120, 80, 70, LocalTime.now(), LocalDate.now()));
			bprepository.save(new BloodPressure(user2, 130, 99, 86, LocalTime.now(), LocalDate.now()));
			bprepository.save(new BloodPressure(user1, 90, 60, 110, LocalTime.now(), LocalDate.now()));
			bprepository.save(new BloodPressure(user1, 144, 97, 98, LocalTime.now(), LocalDate.now()));
			bprepository.save(new BloodPressure(user1, 125, 70, 88, LocalTime.now(), LocalDate.now()));


		};
	}
}
