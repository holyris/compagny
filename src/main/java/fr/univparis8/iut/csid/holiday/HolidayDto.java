package fr.univparis8.iut.csid.holiday;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class HolidayDto {
  private Long id;
  private Long idEmployee;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private LocalDate start;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private LocalDate end;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private LocalDate datetime;

  public HolidayDto() {
  }

  public HolidayDto(Long id, Long idEmployee, LocalDate start, LocalDate end, LocalDate datetime) {
    this.id = id;
    this.idEmployee = idEmployee;
    this.start = start;
    this.end = end;
    this.datetime = datetime;
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

  public LocalDate getStart() {
    return start;
  }

  public void setStart(LocalDate start) {
    this.start = start;
  }

  public LocalDate getEnd() {
    return end;
  }

  public void setEnd(LocalDate end) {
    this.end = end;
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
    private LocalDate start;
    private LocalDate end;
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

    public HolidayDtoBuilder withStart(LocalDate start) {
      this.start = start;
      return this;
    }

    public HolidayDtoBuilder withEnd(LocalDate end) {
      this.end = end;
      return this;
    }

    public HolidayDtoBuilder withDatetime(LocalDate datetime) {
      this.datetime = datetime;
      return this;
    }

    public HolidayDto build() {
      HolidayDto holidayDto = new HolidayDto();
      holidayDto.setId(id);
      holidayDto.setIdEmployee(idEmployee);
      holidayDto.setStart(start);
      holidayDto.setEnd(end);
      holidayDto.setDatetime(datetime);
      return holidayDto;
    }
  }
}
