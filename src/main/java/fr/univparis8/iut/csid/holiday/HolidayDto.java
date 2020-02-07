package fr.univparis8.iut.csid.holiday;

import java.time.LocalDate;

public class HolidayDto {
  private Long id;
  private Long idEmployee;
  private LocalDate datetime;

  public HolidayDto() {
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


  public static final class HolidayDtoBuilder {
    private Long id;
    private Long idEmployee;
    private LocalDate datetime;

    private HolidayDtoBuilder() {
    }

    public static HolidayDtoBuilder create() {
      return new HolidayDtoBuilder();
    }

    public HolidayDtoBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public HolidayDtoBuilder withIdEmployee(Long idEmployee) {
      this.idEmployee = idEmployee;
      return this;
    }

    public HolidayDtoBuilder withDatetime(LocalDate datetime) {
      this.datetime = datetime;
      return this;
    }

    public HolidayDto build() {
      HolidayDto test = new HolidayDto();
      test.setId(id);
      test.setIdEmployee(idEmployee);
      test.setDatetime(datetime);
      return test;
    }
  }
}
