package fr.univparis8.iut.csid.salary;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalaryDto {
  private Long id;
  private Long idEmployee;

  @JsonProperty( access = JsonProperty.Access.READ_ONLY)
  private String firstNameEmployee;

  @JsonProperty( access = JsonProperty.Access.READ_ONLY)
  private String lastNameEmployee;

  @JsonProperty( access = JsonProperty.Access.READ_ONLY)
  private double amount;
  private String monthYear;
  private String paymentDate;
  private int daysOfWork;

  public SalaryDto(Long id, Long idEmployee, String firstNameEmployee, String lastNameEmployee, double amount, String monthYear, String paymentDate, int daysOfWork) {
    this.id = id;
    this.idEmployee = idEmployee;
    this.firstNameEmployee = firstNameEmployee;
    this.lastNameEmployee = lastNameEmployee;
    this.amount = amount;
    this.monthYear = monthYear;
    this.paymentDate = paymentDate;
    this.daysOfWork = daysOfWork;
  }

  public SalaryDto() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getIdEmployee() {
    return idEmployee;
  }

  public void setIdEmployee(Long idEmployee) {
    this.idEmployee = idEmployee;
  }

  public String getFirstNameEmployee() {
    return firstNameEmployee;
  }

  public void setFirstNameEmployee(String firstNameEmployee) {
    this.firstNameEmployee = firstNameEmployee;
  }

  public String getLastNameEmployee() {
    return lastNameEmployee;
  }

  public void setLastNameEmployee(String lastNameEmployee) {
    this.lastNameEmployee = lastNameEmployee;
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

  public static final class SalaryDtoBuilder {
    private Long id;
    private Long idEmployee;
    private String firstNameEmployee;
    private String lastNameEmployee;
    private double amount;
    private String monthYear;
    private String paymentDate;
    private int daysOfWork;

    private SalaryDtoBuilder() {
    }

    public static SalaryDtoBuilder create() {
      return new SalaryDtoBuilder();
    }

    public SalaryDtoBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public SalaryDtoBuilder withIdEmployee(Long idEmployee) {
      this.idEmployee = idEmployee;
      return this;
    }

    public SalaryDtoBuilder withFirstNameEmployee(String firstNameEmployee) {
      this.firstNameEmployee = firstNameEmployee;
      return this;
    }

    public SalaryDtoBuilder withLastNameEmployee(String lastNameEmployee) {
      this.lastNameEmployee = lastNameEmployee;
      return this;
    }

    public SalaryDtoBuilder withAmount(double amount) {
      this.amount = amount;
      return this;
    }

    public SalaryDtoBuilder withMonthYear(String monthYear) {
      this.monthYear = monthYear;
      return this;
    }

    public SalaryDtoBuilder withPaymentDate(String paymentDate) {
      this.paymentDate = paymentDate;
      return this;
    }

    public SalaryDtoBuilder withDaysOfWork(int daysOfWork) {
      this.daysOfWork = daysOfWork;
      return this;
    }

    public SalaryDto build() {
      SalaryDto salaryDto = new SalaryDto();
      salaryDto.setId(id);
      salaryDto.setIdEmployee(idEmployee);
      salaryDto.setFirstNameEmployee(firstNameEmployee);
      salaryDto.setLastNameEmployee(lastNameEmployee);
      salaryDto.setAmount(amount);
      salaryDto.setMonthYear(monthYear);
      salaryDto.setPaymentDate(paymentDate);
      salaryDto.setDaysOfWork(daysOfWork);
      return salaryDto;
    }
  }
}
