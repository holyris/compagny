package fr.univparis8.iut.csid.salary;

import fr.univparis8.iut.csid.employee.Employee;
import fr.univparis8.iut.csid.employee.EmployeeEntity;
import fr.univparis8.iut.csid.employee.EmployeeMapper;

import java.util.List;
import java.util.stream.Collectors;

public class SalaryMapper {

  public static SalaryDto toSalaryDto(Salary salary) {
    return SalaryDto.SalaryDtoBuilder.create()
            .withId((salary.getId()))
            .withIdEmployee(salary.getEmployee().getId())
            .withFirstNameEmployee(salary.getEmployee().getFirstName())
            .withLastNameEmployee(salary.getEmployee().getLastName())
            .withAmount(salary.getAmount())
            .withMonthYear(salary.getMonthYear())
            .withPaymentDate(salary.getPaymentDate())
            .withDaysOfWork(salary.getDaysOfWork())
            .build();

  }

  public static Salary toSalary(SalaryDto salary) {
    Employee employee = Employee.EmployeeBuilder.create()
            .withId(salary.getIdEmployee())
            .build();
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
    EmployeeEntity employee = EmployeeEntity.EmployeeEntityBuilder.create()
            .withId(salary.getEmployee().getId())
            .build();

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

  public static List<SalaryDto> toSalariesDtoList(List<Salary> salaryEntities) {
    return salaryEntities.stream()
            .map(SalaryMapper::toSalaryDto)
            .collect(Collectors.toList());
  }


}
