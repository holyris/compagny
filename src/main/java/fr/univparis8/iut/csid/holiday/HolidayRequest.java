package fr.univparis8.iut.csid.holiday;

import fr.univparis8.iut.csid.employee.Employee;

import java.time.LocalDate;

public class HolidayRequest {
  private final Employee employee;

  private final LocalDate start;

  private final LocalDate end;

  public HolidayRequest(Employee employee, LocalDate start, LocalDate end) {
    this.employee = employee;
    this.start = start;
    this.end = end;
  }

  public Employee getEmployee() {
    return employee;
  }

  public LocalDate getStart() {
    return start;
  }

  public LocalDate getEnd() {
    return end;
  }


  public static final class HolidayRequestBuilder {
    private Employee employee;
    private LocalDate start;
    private LocalDate end;

    private HolidayRequestBuilder() {
    }

    public static HolidayRequestBuilder create() {
      return new HolidayRequestBuilder();
    }

    public HolidayRequestBuilder withEmployee(Employee employee) {
      this.employee = employee;
      return this;
    }

    public HolidayRequestBuilder withStart(LocalDate start) {
      this.start = start;
      return this;
    }

    public HolidayRequestBuilder withEnd(LocalDate end) {
      this.end = end;
      return this;
    }

    public HolidayRequest build() {
      return new HolidayRequest(employee, start, end);
    }
  }
}
