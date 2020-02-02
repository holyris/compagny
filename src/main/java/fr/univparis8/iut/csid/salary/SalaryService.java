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

  public Salary update(Salary salary) {
    if (!salaryRepository.existsById(salary.getId())) {
      throw new ObjectNotFoundException("Salary with id " + salary.getId() + " does not exist");
    }
    SalaryEntity savedSalary = salaryRepository.save(SalaryMapper.toSalaryEntity((salary)));
    return SalaryMapper.toSalary(savedSalary);
  }

  public Salary partialUpdate(Salary salary) {
    if (!salaryRepository.existsById(salary.getId())) {
      throw new ObjectNotFoundException("Salary with id " + salary.getId() + " does not exist");
    }

    Salary currentSalary = SalaryMapper.toSalary(salaryRepository.getOne(salary.getId()));
    Salary mergedSalary = currentSalary.mergeWith(salary);

    SalaryEntity newSalary = salaryRepository.save(SalaryMapper.toSalaryEntity(mergedSalary));

    return SalaryMapper.toSalary(newSalary);
  }

  public void delete(Long id) {
    if (salaryRepository.existsById(id)) {
      salaryRepository.deleteById(id);
    }
  }

  public boolean salaryAlreadyExists(Salary salary) {
    try{
      return salaryRepository.salaryAlreadyExists(salary.getEmployee().getId(), salary.getMonthYear())==1;
    } catch (PersistenceException ex) {
      throw new ObjectNotFoundException("Salary with id " + salary.getId() + " not found");
    }
  }
}
