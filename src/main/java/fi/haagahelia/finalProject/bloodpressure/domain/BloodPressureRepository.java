package fi.haagahelia.finalProject.bloodpressure.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BloodPressureRepository extends CrudRepository<Bloodpressure, Long> {
	List<Bloodpressure> findByMeasurementDate(LocalDate MeasurementDate);
}
