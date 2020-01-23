package fr.univparis8.iut.csid.salary;


import javax.persistence.*;

@Entity
@Table(name = "salary")
public class SalaryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "amount")
  private double amount;
  @Column(name = "month")
  private int month;
  @Column(name = "year")
  private int year;
  @Column(name = "date")
  private String date;
  @Column(name = "daysOfWork")
  private int daysOfWork;

  public SalaryEntity(long id, double amount, int month, int year, String date, int daysOfWork) {
    this.id = id;
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
