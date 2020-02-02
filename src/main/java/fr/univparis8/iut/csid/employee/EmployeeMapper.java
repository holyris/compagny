package fr.univparis8.iut.csid.employee;

import java.util.List;
import java.util.stream.Collectors;

public final class EmployeeMapper {

  public static EmployeeDto toEmployeeDto(Employee employee) {
    Address address = employee.getAddress();

    return EmployeeDto.EmployeeDtoBuilder.create()
            .withId(employee.getId())
            .withFirstName(employee.getFirstName())
            .withLastName(employee.getLastName())
            .withStreetNumber(address.getStreetNumber())
            .withStreetName(address.getStreetName())
            .withPostcode(address.getPostcode())
            .withCity(address.getCity())
            .withCountry(address.getCountry())
            .withSalary(employee.getSalary())
            .build();
  }

  public static Employee toEmployee(EmployeeDto employee) {
    Address address = new Address(employee.getStreetNumber(),employee.getStreetName(), employee.getPostcode(), employee.getCity(), employee.getCountry());

    return Employee.EmployeeBuilder.create()
            .withId(employee.getId())
            .withFirstName(employee.getFirstName())
            .withLastName(employee.getLastName())
            .withAddress(address)
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
            .withStreetNumber(employee.getAddress().getStreetNumber())
            .withStreetName(employee.getAddress().getStreetName())
            .withPostcode(employee.getAddress().getPostcode())
            .withCity(employee.getAddress().getCity())
            .withCountry(employee.getAddress().getCountry())
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
