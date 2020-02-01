package fr.univparis8.iut.csid.salary;

import fr.univparis8.iut.csid.employee.Employee;

public class SalaryDTO {
  private Long id;
  private Long idEmployee;
  private double amount;
  private String monthYear;
  private String paymentDate;
  private int daysOfWork;

  public SalaryDTO(Long id, Long idEmployee, double amount, String monthYear, String paymentDate, int daysOfWork) {
    this.id = id;
    this.idEmployee = idEmployee;
    this.amount = amount;
    this.monthYear = monthYear;
    this.paymentDate = paymentDate;
    this.daysOfWork = daysOfWork;
  }

  public SalaryDTO() {
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

  public static final class SalaryDTOBuilder {
    private Long id;
    private Long idEmployee;
    private double amount;
    private String monthYear;
    private String paymentDate;
    private int daysOfWork;

    private SalaryDTOBuilder() {
    }

    public static SalaryDTOBuilder create() {
      return new SalaryDTOBuilder();
    }

    public SalaryDTOBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public SalaryDTOBuilder withIdEmployee(Long idEmployee) {
      this.idEmployee = idEmployee;
      return this;
    }

    public SalaryDTOBuilder withAmount(double amount) {
      this.amount = amount;
      return this;
    }

    public SalaryDTOBuilder withMonthYear(String monthYear) {
      this.monthYear = monthYear;
      return this;
    }

    public SalaryDTOBuilder withPaymentDate(String paymentDate) {
      this.paymentDate = paymentDate;
      return this;
    }

    public SalaryDTOBuilder withDaysOfWork(int daysOfWork) {
      this.daysOfWork = daysOfWork;
      return this;
    }

    public SalaryDTO build() {
      SalaryDTO salaryDTO = new SalaryDTO();
      salaryDTO.setId(id);
      salaryDTO.setIdEmployee(idEmployee);
      salaryDTO.setAmount(amount);
      salaryDTO.setMonthYear(monthYear);
      salaryDTO.setPaymentDate(paymentDate);
      salaryDTO.setDaysOfWork(daysOfWork);
      return salaryDTO;
    }
  }
}
