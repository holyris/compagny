package fr.univparis8.iut.csid.salary;

public class SalaryEntityBuilder {
  private long id;
  private double amount;
  private int month;
  private int year;
  private String date;
  private int daysOfWork;

  public SalaryEntityBuilder setId(long id) {
    this.id = id;
    return this;
  }

  public SalaryEntityBuilder setAmount(double amount) {
    this.amount = amount;
    return this;
  }

  public SalaryEntityBuilder setMonth(int month) {
    this.month = month;
    return this;
  }

  public SalaryEntityBuilder setYear(int year) {
    this.year = year;
    return this;
  }

  public SalaryEntityBuilder setDate(String date) {
    this.date = date;
    return this;
  }

  public SalaryEntityBuilder setDaysOfWork(int daysOfWork) {
    this.daysOfWork = daysOfWork;
    return this;
  }

  public SalaryEntity createSalaryEntity() {
    return new SalaryEntity(id, amount, month, year, date, daysOfWork);
  }
}