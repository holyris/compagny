package fr.univparis8.iut.csid.salary;

import fr.univparis8.iut.csid.exception.ObjectNotFoundException;

import javax.persistence.PersistenceException;
import java.util.List;

public class SalaryService {

  private final SalaryRepository salaryRepository;

  public SalaryService(SalaryRepository salaryRepository) {
    this.salaryRepository = salaryRepository;
  }

  public Salary get(Long id) {
    try {
      return SalaryMapper.toSalary(salaryRepository.getOne(id));
    } catch (PersistenceException ex) {
      throw new ObjectNotFoundException("Salary with id " + id + " not found");
    }
  }

  public Salary create(Salary salary) {
    return SalaryMapper.toSalary(salaryRepository.save(SalaryMapper.toSalaryEntity(salary)));
  }

  public List<SalaryDTO> getAll() {
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
    Salary mergedSalary = currentSalary.mergedWith(salary);

    SalaryEntity newSalary = salaryRepository.save(SalaryMapper.toSalaryEntity(mergedSalary));

    return SalaryMapper.toSalary(newSalary);
  }

  public void delete(Long id) {
    if (salaryRepository.existsById(id)) {
      salaryRepository.deleteById(id);
    }
  }
}
