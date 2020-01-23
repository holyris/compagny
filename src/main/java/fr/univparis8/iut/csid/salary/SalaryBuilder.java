package fr.univparis8.iut.csid.salary;

import fr.univparis8.iut.csid.employee.Employee;

public class SalaryBuilder {
  private Employee employee;
  private double amount;
  private int month;
  private int year;
  private String date;
  private int daysOfWork;

  public SalaryBuilder setEmployee(Employee employee) {
    this.employee = employee;
    return this;
  }

  public SalaryBuilder setAmount(double amount) {
    this.amount = amount;
    return this;
  }

  public SalaryBuilder setMonth(int month) {
    this.month = month;
    return this;
  }

  public SalaryBuilder setYear(int year) {
    this.year = year;
    return this;
  }

  public SalaryBuilder setDate(String date) {
    this.date = date;
    return this;
  }

  public SalaryBuilder setDaysOfWork(int daysOfWork) {
    this.daysOfWork = daysOfWork;
    return this;
  }

  public Salary createSalary() {
    return new Salary(employee, amount, month, year, date, daysOfWork);
  }
}