package fr.univparis8.iut.csid.salary;

import fr.univparis8.iut.csid.employee.*;

import java.util.List;
import java.util.stream.Collectors;

public class SalaryMapper {

  public static SalaryDTO toSalaryDTO(Salary salary) {
    return SalaryDTO.SalaryDTOBuilder.create()
            .withId((salary.getId()))
            .withIdEmployee(((salary.getEmployee().getId())))
            .withAmount(salary.getAmount())
            .withMonthYear(salary.getMonthYear())
            .withPaymentDate(salary.getPaymentDate())
            .withDaysOfWork(salary.getDaysOfWork())
            .build();

  }

  public static Salary toSalary(SalaryDTO salary) {
    Employee employee = new Employee(salary.getIdEmployee(), null, null ,null, salary.getAmount());
    return Salary.SalaryBuilder.create()
            .withId(salary.getId())
            .withEmployee(employee)
            .withAmount(salary.getAmount())
            .withMonthYear(salary.getMonthYear())
            .withPaymentDate(salary.getPaymentDate())
            .withDaysOfWork(salary.getDaysOfWork())
            .build();
  }

  public static Salary toSalary(SalaryEntity salary) {
    Employee employee = EmployeeMapper.toEmployee(salary.getEmployee());
    return Salary.SalaryBuilder.create()
            .withId(salary.getId())
            .withEmployee(employee)
            .withAmount(salary.getAmount())
            .withMonthYear(salary.getMonthYear())
            .withPaymentDate(salary.getPaymentDate())
            .withDaysOfWork(salary.getDaysOfWork())
            .build();
  }

  public static SalaryEntity toSalaryEntity(Salary salary) {
    EmployeeEntity employee = EmployeeMapper.toEmployeeEntity(salary.getEmployee());
    return SalaryEntity.SalaryEntityBuilder.create()
            .withId(salary.getId())
            .withEmployee(employee)
            .withAmount(salary.getAmount())
            .withMonthYear(salary.getMonthYear())
            .withPaymentDate(salary.getPaymentDate())
            .withDaysOfWork(salary.getDaysOfWork())
            .build();
  }

  public static List<Salary> toSalariesList(List<SalaryEntity> salaryEntities) {
    return salaryEntities.stream()
            .map(SalaryMapper::toSalary)
            .collect(Collectors.toList());
  }

  public static List<SalaryDTO> toSalariesDtoList(List<Salary> salaryEntities) {
    return salaryEntities.stream()
            .map(SalaryMapper::toSalaryDTO)
            .collect(Collectors.toList());
  }


}
