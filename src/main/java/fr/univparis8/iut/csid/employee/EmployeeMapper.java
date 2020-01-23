package fr.univparis8.iut.csid.employee;

import java.util.List;
import java.util.stream.Collectors;

public final class EmployeeMapper {

  public static EmployeeDto toEmployeeDto(Employee employee) {
    return EmployeeDto.EmployeeDtoBuilder.create()
            .withId(employee.getId())
            .withFirstName(employee.getFirstName())
            .withLastName(employee.getLastName())
            .withAddressLine1(employee.getAddress().toAddressLine1())
            .withAddressLine2(employee.getAddress().toAddressLine2())
            .withSalary(employee.getSalary())
            .build();
  }

  public static Employee toEmployee(EmployeeDto employee) {
    return Employee.EmployeeBuilder.create()
            .withId(employee.getId())
            .withFirstName(employee.getFirstName())
            .withLastName(employee.getLastName())
            .withAddress(employee.getAddress())
            .withSalary(employee.getSalary())
            .build();
  }

  public static Employee toEmployee(EmployeeEntity employee) {
    return Employee.EmployeeBuilder.create()
            .withId(employee.getId())
            .withFirstName(employee.getFirstName())
            .withLastName(employee.getLastName())
            .withAddress(employee.getAddress())
            .withSalary(employee.getSalary())
            .build();
  }

  public static EmployeeEntity toEmployeeEntity(Employee employee) {
    return EmployeeEntity.EmployeeEntityBuilder.create()
            .withId(employee.getId())
            .withFirstName(employee.getFirstName())
            .withLastName(employee.getLastName())
            .withAddress(employee.getAddress())
            .withSalary(employee.getSalary())
            .build();
  }

  public static List<Employee> toEmployeesList(List<EmployeeEntity> employeeEntities) {
    return employeeEntities.stream()
            .map(EmployeeMapper::toEmployee)
            .collect(Collectors.toList());
  }

  public static List<EmployeeDto> toEmployeesDtoList(List<Employee> employeeEntities) {
    return employeeEntities.stream()
            .map(EmployeeMapper::toEmployeeDto)
            .collect(Collectors.toList());
  }



}
