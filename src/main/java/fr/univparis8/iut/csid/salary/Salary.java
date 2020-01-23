package fr.univparis8.iut.csid.salary;

import fr.univparis8.iut.csid.employee.Employee;

public class Salary {
  private final Employee employee;
  private final double amount;
  private final int month;
  private final int year;
  private final String date;
  private final int daysOfWork;


  public Salary(Employee employee, double amount, int month, int year, String date, int daysOfWork) {
    this.employee = employee;
    this.amount = amount;
    this.month = month;
    this.year = year;
    this.date = date;
    this.daysOfWork = daysOfWork;
  }

  public Employee getEmployee() {
    return employee;
  }

  public double getAmount() {
    return amount;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

  public String getDate() {
    return date;
  }

  public int getDaysOfWork() {
    return daysOfWork;
  }
}
