package fr.univparis8.iut.csid.holiday;

import fr.univparis8.iut.csid.employee.EmployeeEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "holiday")
public class HolidayEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private EmployeeEntity employee;

  @Column(name = "datetime")
  private LocalDate datetime;

  public HolidayEntity() {
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

  public LocalDate getDatetime() {
    return datetime;
  }

  public void setDatetime(LocalDate datetime) {
    this.datetime = datetime;
  }

  public static final class HolidayEntityBuilder {
    private Long id;
    private EmployeeEntity employee;
    private LocalDate datetime;

    private HolidayEntityBuilder() {
    }

    public static HolidayEntityBuilder create() {
      return new HolidayEntityBuilder();
    }

    public HolidayEntityBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public HolidayEntityBuilder withEmployee(EmployeeEntity employee) {
      this.employee = employee;
      return this;
    }

    public HolidayEntityBuilder withDatetime(LocalDate datetime) {
      this.datetime = datetime;
      return this;
    }

    public HolidayEntity build() {
      HolidayEntity holidayEntity = new HolidayEntity();
      holidayEntity.setId(id);
      holidayEntity.setEmployee(employee);
      holidayEntity.setDatetime(datetime);
      return holidayEntity;
    }
  }
}
