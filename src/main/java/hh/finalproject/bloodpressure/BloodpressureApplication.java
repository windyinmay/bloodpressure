package hh.finalproject.bloodpressure;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.finalproject.bloodpressure.domain.BPRepository;
import hh.finalproject.bloodpressure.domain.BloodPressure;

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
	public CommandLineRunner bloodPressureDemo(BPRepository bprepository) {
		return (args) -> {
			log.info("save blood pressure");
			
			LocalDate today = LocalDate.now();
			bprepository.save(new BloodPressure(120, 80, 70, LocalTime.now(), today));
			bprepository.save(new BloodPressure(130, 99, 86, LocalTime.now(), today));
			bprepository.save(new BloodPressure(90, 60, 110, LocalTime.now(), today));
			bprepository.save(new BloodPressure(144, 97, 98, LocalTime.now(), today));
			bprepository.save(new BloodPressure(125, 70, 88, LocalTime.now(), today));

		};
	}
}
