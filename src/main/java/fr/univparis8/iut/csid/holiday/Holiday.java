package fr.univparis8.iut.csid.holiday;

import fr.univparis8.iut.csid.employee.Employee;

import java.time.LocalDate;

public class Holiday {
  private final Long id;
  private final Employee employee;
  private final LocalDate datetime;

  public Holiday(Long id, Employee employee, LocalDate datetime) {
    this.id = id;
    this.employee = employee;
    this.datetime = datetime;
  }

  public Long getId() {
    return id;
  }

  public Employee getEmployee() {
    return employee;
  }

  public LocalDate getDatetime() {
    return datetime;
  }

  public static final class HolidayBuilder {
    private Long id;
    private Employee employee;
    private LocalDate datetime;

    private HolidayBuilder() {
    }

    public static HolidayBuilder create() {
      return new HolidayBuilder();
    }

    public HolidayBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public HolidayBuilder withEmployee(Employee employee) {
      this.employee = employee;
      return this;
    }

    public HolidayBuilder withDatetime(LocalDate datetime) {
      this.datetime = datetime;
      return this;
    }

    public Holiday build() {
      return new Holiday(id, employee, datetime);
    }
  }
}
