package fr.univparis8.iut.csid.salary;

import fr.univparis8.iut.csid.employee.Employee;
import fr.univparis8.iut.csid.employee.EmployeeRepository;
import fr.univparis8.iut.csid.employee.EmployeeService;
import fr.univparis8.iut.csid.exception.ObjectNotFoundException;
import fr.univparis8.iut.csid.holiday.HolidayService;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class SalaryService {

  private final SalaryRepository salaryRepository;
  private final EmployeeService employeeService;
  private final HolidayService holidayService;

  public SalaryService(SalaryRepository salaryRepository, EmployeeService employeeService, HolidayService holidayService) {
    this.salaryRepository = salaryRepository;
    this.employeeService = employeeService;
    this.holidayService = holidayService;
  }

  public Salary get(Long id) {
    try {
      return SalaryMapper.toSalary(salaryRepository.getOne(id));
    } catch (PersistenceException ex) {
      throw new ObjectNotFoundException("Salary with id " + id + " not found");
    }
  }

  public Salary create(Salary salary) {
    Employee employee = employeeService.get(salary.getEmployee().getId());
    int numberOfHolidays = this.holidayService.countByMonthYear(employee, salary);
    double amount = (employee.getSalary() * (21-numberOfHolidays)) / 21;
    if(amount<=0)amount=0;
    salary = Salary.SalaryBuilder.create()
            .withId(salary.getId())
            .withEmployee(salary.getEmployee())
            .withAmount(amount)
            .withMonthYear(salary.getMonthYear())
            .withPaymentDate((salary.getPaymentDate()))
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
