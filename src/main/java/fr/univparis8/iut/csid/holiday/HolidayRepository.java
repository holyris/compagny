package fr.univparis8.iut.csid.holiday;

import fr.univparis8.iut.csid.employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HolidayRepository extends JpaRepository<HolidayEntity, Long> {
  List<HolidayEntity> findAllByEmployeeAndDatetimeBetween(EmployeeEntity employee, LocalDate start, LocalDate end);
}
