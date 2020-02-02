package fr.univparis8.iut.csid.employee;

import fr.univparis8.iut.csid.salary.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
  @Query(value = "SELECT s FROM SalaryEntity s JOIN s.employee e WHERE e.id = :id ")
  List<SalaryEntity> getSalaries(
          @Param("id") Long id
  );
}
