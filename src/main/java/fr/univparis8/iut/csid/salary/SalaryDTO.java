package fr.univparis8.iut.csid.salary;

import fr.univparis8.iut.csid.employee.Employee;

public class SalaryDTO {
  private long id;
  private Employee employee;
  private double amount;
  private int month;
  private int year;
  private String date;
  private int daysOfWork;

  public SalaryDTO() {
  }

  public SalaryDTO(long id, Employee employee, double amount, int month, int year, String date, int daysOfWork) {
    this.id = id;
    this.employee = employee;
    this.amount = amount;
    this.month = month;
    this.year = year;
    this.date = date;
    this.daysOfWork = daysOfWork;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public int getDaysOfWork() {
    return daysOfWork;
  }

  public void setDaysOfWork(int daysOfWork) {
    this.daysOfWork = daysOfWork;
  }
}
