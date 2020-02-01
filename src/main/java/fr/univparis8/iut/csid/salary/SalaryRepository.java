package fr.univparis8.iut.csid.salary;

import fr.univparis8.iut.csid.employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Long> {
}
