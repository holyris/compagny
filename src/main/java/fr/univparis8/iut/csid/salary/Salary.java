package fr.univparis8.iut.csid.salary;

import fr.univparis8.iut.csid.employee.Employee;

import java.util.Objects;

public class Salary {
  private final Long id;
  private final Employee employee;
  private final double amount;
  private final String monthYear;
  private final String paymentDate;

  public Salary(Long id, Employee employee, double amount, String monthYear, String paymentDate) {
    this.id = id;
    this.employee = employee;
    this.amount = amount;
    this.monthYear = monthYear;
    this.paymentDate = paymentDate;
  }

  public Long getId() {
    return id;
  }



  public Employee getEmployee() {
    return employee;
  }

  public double getAmount() {
    return amount;
  }

  public String getMonthYear() {
    return monthYear;
  }

  public String getPaymentDate() {
    return paymentDate;
  }


  public Salary mergeWith(Salary other) {
    return Salary.SalaryBuilder.create()
            .withId(id)
            .withEmployee(Objects.requireNonNullElse(other.employee, employee))
            .withAmount(Objects.requireNonNullElse(other.amount, amount))
            .withMonthYear(Objects.requireNonNullElse(other.monthYear, monthYear))
            .withPaymentDate(Objects.requireNonNullElse(other.paymentDate, paymentDate))
            .build();
  }


  public static final class SalaryBuilder {
    private Long id;
    private Employee employee;
    private double amount;
    private String monthYear;
    private String paymentDate;

    private SalaryBuilder() {
    }

    public static SalaryBuilder create() {
      return new SalaryBuilder();
    }

    public SalaryBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public SalaryBuilder withEmployee(Employee employee) {
      this.employee = employee;
      return this;
    }

    public SalaryBuilder withAmount(double amount) {
      this.amount = amount;
      return this;
    }

    public SalaryBuilder withMonthYear(String monthYear) {
      this.monthYear = monthYear;
      return this;
    }

    public SalaryBuilder withPaymentDate(String paymentDate) {
      this.paymentDate = paymentDate;
      return this;
    }

    public Salary build() {
      return new Salary(id, employee, amount, monthYear, paymentDate);
    }
  }
}
