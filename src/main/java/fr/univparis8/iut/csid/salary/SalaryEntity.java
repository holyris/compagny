package fr.univparis8.iut.csid.salary;


import fr.univparis8.iut.csid.employee.Employee;
import fr.univparis8.iut.csid.employee.EmployeeEntity;

import javax.persistence.*;

@Entity
@Table(name = "salary")
public class SalaryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(fetch=FetchType.EAGER)
  @JoinColumn
  private EmployeeEntity employee;
  @Column(name = "amount")
  private double amount;
  @Column(name = "month_year")
  private String monthYear;
  @Column(name = "payment_date")
  private String paymentDate;
  @Column(name = "daysOfWork")
  private int daysOfWork;


  public SalaryEntity(Long id, EmployeeEntity employee, double amount, String monthYear, String paymentDate, int daysOfWork) {
    this.id = id;
    this.employee = employee;
    this.amount = amount;
    this.monthYear = monthYear;
    this.paymentDate = paymentDate;
    this.daysOfWork = daysOfWork;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EmployeeEntity getEmployee() {
    return employee;
  }

  public void setEmployee(EmployeeEntity employee) {
    this.employee = employee;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getMonthYear() {
    return monthYear;
  }

  public void setMonthYear(String monthYear) {
    this.monthYear = monthYear;
  }

  public String getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(String paymentDate) {
    this.paymentDate = paymentDate;
  }

  public int getDaysOfWork() {
    return daysOfWork;
  }

  public void setDaysOfWork(int daysOfWork) {
    this.daysOfWork = daysOfWork;
  }


  public static final class SalaryEntityBuilder {
    private Long id;
    private EmployeeEntity employee;
    private double amount;
    private String monthYear;
    private String paymentDate;
    private int daysOfWork;

    private SalaryEntityBuilder() {
    }

    public static SalaryEntityBuilder create() {
      return new SalaryEntityBuilder();
    }

    public SalaryEntityBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public SalaryEntityBuilder withEmployee(EmployeeEntity employee) {
      this.employee = employee;
      return this;
    }

    public SalaryEntityBuilder withAmount(double amount) {
      this.amount = amount;
      return this;
    }

    public SalaryEntityBuilder withMonthYear(String monthYear) {
      this.monthYear = monthYear;
      return this;
    }

    public SalaryEntityBuilder withPaymentDate(String paymentDate) {
      this.paymentDate = paymentDate;
      return this;
    }

    public SalaryEntityBuilder withDaysOfWork(int daysOfWork) {
      this.daysOfWork = daysOfWork;
      return this;
    }

    public SalaryEntity build() {
      return new SalaryEntity(id, employee, amount, monthYear, paymentDate, daysOfWork);
    }
  }
}
