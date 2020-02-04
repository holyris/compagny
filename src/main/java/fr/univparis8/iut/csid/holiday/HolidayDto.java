package fr.univparis8.iut.csid.holiday;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class HolidayDto {
  private Long id;
  private Long idEmployee;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Date start;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Date end;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Date datetime;

  public HolidayDto() {
  }

  public HolidayDto(Long id, Long idEmployee, Date start, Date end, Date datetime) {
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

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public Date getDatetime() {
    return datetime;
  }

  public void setDatetime(Date datetime) {
    this.datetime = datetime;
  }

  public static final class HolidayDtoBuilder {
    private Long id;
    private Long idEmployee;
    private Date start;
    private Date end;
    private Date datetime;

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

    public HolidayDtoBuilder withStart(Date start) {
      this.start = start;
      return this;
    }

    public HolidayDtoBuilder withEnd(Date end) {
      this.end = end;
      return this;
    }

    public HolidayDtoBuilder withDatetime(Date datetime) {
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
