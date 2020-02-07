package fr.univparis8.iut.csid.holiday;

import java.time.LocalDate;

public class HolidayDtoUpdate {
  private Long id;
  private Long idEmployee;
  private LocalDate datetime;

  public HolidayDtoUpdate() {
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

  public LocalDate getDatetime() {
    return datetime;
  }

  public void setDatetime(LocalDate datetime) {
    this.datetime = datetime;
  }


  public static final class HolidayDtoUpdateBuilder {
    private Long id;
    private Long idEmployee;
    private LocalDate datetime;

    private HolidayDtoUpdateBuilder() {
    }

    public static HolidayDtoUpdateBuilder create() {
      return new HolidayDtoUpdateBuilder();
    }

    public HolidayDtoUpdateBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public HolidayDtoUpdateBuilder withIdEmployee(Long idEmployee) {
      this.idEmployee = idEmployee;
      return this;
    }

    public HolidayDtoUpdateBuilder withDatetime(LocalDate datetime) {
      this.datetime = datetime;
      return this;
    }

    public HolidayDtoUpdate build() {
      HolidayDtoUpdate holidayDtoUpdate = new HolidayDtoUpdate();
      holidayDtoUpdate.setId(id);
      holidayDtoUpdate.setIdEmployee(idEmployee);
      holidayDtoUpdate.setDatetime(datetime);
      return holidayDtoUpdate;
    }
  }
}
