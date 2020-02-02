package fr.univparis8.iut.csid.salary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Long> {
  @Query(value = "SELECT COUNT(*) FROM SalaryEntity s JOIN s.employee e WHERE e.id=:id AND s.monthYear=:monthYear")
  int salaryAlreadyExists(
          @Param("id") Long id,
          @Param("monthYear") String monthYear
  );
}
