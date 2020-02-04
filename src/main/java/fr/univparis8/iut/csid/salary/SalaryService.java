package fr.univparis8.iut.csid.salary;

import fr.univparis8.iut.csid.employee.EmployeeRepository;
import fr.univparis8.iut.csid.employee.EmployeeService;
import fr.univparis8.iut.csid.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class SalaryService {

  private final SalaryRepository salaryRepository;
  private final EmployeeService employeeService;


  public SalaryService(SalaryRepository salaryRepository, EmployeeService employeeService) {
    this.salaryRepository = salaryRepository;
    this.employeeService = employeeService;
  }

  public Salary get(Long id) {
    try {
      return SalaryMapper.toSalary(salaryRepository.getOne(id));
    } catch (PersistenceException ex) {
      throw new ObjectNotFoundException("Salary with id " + id + " not found");
    }
  }

  public Salary create(Salary salary) {
    double amount = (employeeService.get(salary.getEmployee().getId()).getSalary() * salary.getDaysOfWork()) / 21;
    salary = Salary.SalaryBuilder.create()
            .withId(salary.getId())
            .withEmployee(salary.getEmployee())
            .withAmount(amount)
            .withMonthYear(salary.getMonthYear())
            .withPaymentDate((salary.getPaymentDate()))
            .withDaysOfWork(salary.getDaysOfWork())
            .build();
    return SalaryMapper.toSalary(salaryRepository.save(SalaryMapper.toSalaryEntity(salary)));
  }

  public List<SalaryDto> getAll() {
    List<Salary> salaries = SalaryMapper.toSalariesList(salaryRepository.findAll());
    return SalaryMapper.toSalariesDtoList(salaries);
  }

  public boolean salaryAlreadyExists(Salary salary) {
    try{
      return salaryRepository.salaryAlreadyExists(salary.getEmployee().getId(), salary.getMonthYear())==1;
    } catch (PersistenceException ex) {
      throw new ObjectNotFoundException("Salary with id " + salary.getId() + " not found");
    }
  }
}
