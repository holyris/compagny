package fr.univparis8.iut.csid.employee;

import java.util.Objects;

public class Employee {

  private final Long id;
  private final String firstName;
  private final String lastName;
  private final Address address;
  private final double salary;

  public Employee(Long id, String firstName, String lastName, Address address, double salary) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.salary = salary;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Address getAddress() {
    return address;
  }

  public double getSalary() {
    return salary;
  }

  public Employee mergeWith(Employee other) {
    return EmployeeBuilder.create()
            .withId(id)
            .withLastName(Objects.requireNonNullElse(other.lastName, lastName))
            .withFirstName(Objects.requireNonNullElse(other.firstName, firstName))
            .withAddress((Objects.requireNonNullElse(other.address, address)))
            .build();
  }

  public static final class EmployeeBuilder {
    private Long id;
    private String firstName;
    private String lastName;
    private Address address;
    private double salary;

    private EmployeeBuilder() {
    }

    public static EmployeeBuilder create() {
      return new EmployeeBuilder();
    }

    public EmployeeBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public EmployeeBuilder withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public EmployeeBuilder withLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public EmployeeBuilder withAddress(Address address) {
      this.address = address;
      return this;
    }

    public EmployeeBuilder withSalary(double salary) {
      this.salary = salary;
      return this;
    }

    public Employee build() {
      return new Employee(id, firstName, lastName, address, salary);
    }
  }
}
