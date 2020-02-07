package fr.univparis8.iut.csid.holiday;

import fr.univparis8.iut.csid.employee.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HolidayMapper {

  public static HolidayRequestDto toHolidayRequestDto(HolidayRequest holiday) {
    return HolidayRequestDto.HolidayRequestDtoBuilder.create()
            .withIdEmployee(holiday.getEmployee().getId())
            .withStart(holiday.getStart())
            .withEnd(holiday.getEnd())
            .build();
  }

  public static HolidayRequest toHolidayRequest(HolidayRequestDto holiday){
    Employee employee = Employee.EmployeeBuilder.create()
            .withId(holiday.getIdEmployee())
            .build();
    return HolidayRequest.HolidayRequestBuilder.create()
            .withEmployee(employee)
            .withStart(holiday.getStart())
            .withEnd(holiday.getEnd())
            .build();
  }

  public static Holiday toHoliday(HolidayDto holiday){
    Employee employee = Employee.EmployeeBuilder.create()
            .withId(holiday.getIdEmployee())
            .build();

    return Holiday.HolidayBuilder.create()
            .withId(holiday.getId())
            .withEmployee(employee)
            .withDatetime(holiday.getDatetime())
            .build();
  }

  public static HolidayDto toHolidayDto(Holiday holiday){
    return HolidayDto.HolidayDtoBuilder.create()
            .withId(holiday.getId())
            .withIdEmployee(holiday.getEmployee().getId())
            .withDatetime(holiday.getDatetime())
            .build();
  }

  public static Holiday toHoliday(HolidayEntity holiday) {
    Employee employee = EmployeeMapper.toEmployee(holiday.getEmployee());

    return Holiday.HolidayBuilder.create()
            .withId(holiday.getId())
            .withEmployee(employee)
            .withDatetime(holiday.getDatetime())
            .build();

  }

  public static HolidayEntity toHolidayEntity(Holiday holiday) {
    EmployeeEntity employee = EmployeeEntity.EmployeeEntityBuilder.create()
            .withId(holiday.getEmployee().getId())
            .build();
    return HolidayEntity.HolidayEntityBuilder.create()
            .withId(holiday.getId())
            .withEmployee(employee)
            .withDatetime(holiday.getDatetime())
            .build();
  }

  public static List<Holiday> toHolidaysList(List<HolidayEntity> holidayEntities) {
    return holidayEntities.stream()
            .map(HolidayMapper::toHoliday)
            .collect(Collectors.toList());
  }

  public static List<HolidayDto> toHolidaysDtoList(List<Holiday> holidays) {
    return holidays.stream()
            .map(HolidayMapper::toHolidayDto)
            .collect(Collectors.toList());
  }

  public static List<HolidayEntity> toHolidaysEntity(List<Holiday> holidays){
    return holidays.stream()
            .map(HolidayMapper::toHolidayEntity)
            .collect(Collectors.toList()) ;
  }
}
