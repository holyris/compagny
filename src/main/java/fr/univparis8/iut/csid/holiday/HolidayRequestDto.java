package fr.univparis8.iut.csid.holiday;


import java.time.LocalDate;

public class HolidayRequestDto {
  private Long idEmployee;

  private LocalDate start;

  private LocalDate end;


  public HolidayRequestDto() {
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


  public static final class HolidayRequestDtoBuilder {
    private Long idEmployee;
    private LocalDate start;
    private LocalDate end;

    private HolidayRequestDtoBuilder() {
    }

    public static HolidayRequestDtoBuilder create() {
      return new HolidayRequestDtoBuilder();
    }

    public HolidayRequestDtoBuilder withIdEmployee(Long idEmployee) {
      this.idEmployee = idEmployee;
      return this;
    }

    public HolidayRequestDtoBuilder withStart(LocalDate start) {
      this.start = start;
      return this;
    }

    public HolidayRequestDtoBuilder withEnd(LocalDate end) {
      this.end = end;
      return this;
    }

    public HolidayRequestDto build() {
      HolidayRequestDto holidayRequestDto = new HolidayRequestDto();
      holidayRequestDto.setIdEmployee(idEmployee);
      holidayRequestDto.setStart(start);
      holidayRequestDto.setEnd(end);
      return holidayRequestDto;
    }
  }
}
