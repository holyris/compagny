package fr.univparis8.iut.csid.holiday;

import fr.univparis8.iut.csid.employee.Employee;
import fr.univparis8.iut.csid.employee.EmployeeEntity;
import fr.univparis8.iut.csid.employee.EmployeeMapper;
import fr.univparis8.iut.csid.salary.Salary;
import fr.univparis8.iut.csid.salary.SalaryDto;
import fr.univparis8.iut.csid.salary.SalaryEntity;
import fr.univparis8.iut.csid.salary.SalaryMapper;
import org.apache.tomcat.jni.Local;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HolidayMapper {

  public static HolidayDto toHolidayDto(Holiday holiday) {
    return HolidayDto.HolidayDtoBuilder.create()
            .withId(holiday.getId())
            .withIdEmployee(holiday.getEmployee().getId())
            .withDatetime(holiday.getDatetime())
            .build();
  }


  public static List<Holiday> toHolidays(HolidayDto holiday) {
    List<Holiday> holidays = new ArrayList<>();
    Employee employee = Employee.EmployeeBuilder.create()
            .withId(holiday.getIdEmployee())
            .build();

    Stream<LocalDate> stream= holiday.getStart().datesUntil(holiday.getEnd());

    List<LocalDate> list = stream.filter(b -> b.getDayOfWeek() != DayOfWeek.SUNDAY && b.getDayOfWeek() != DayOfWeek.SATURDAY)
            .collect(Collectors.toList());

    for (LocalDate date: list) {
      holidays.add(
                Holiday.HolidayBuilder.create()
                        .withId(holiday.getId())
                        .withEmployee(employee)
                        .withDatetime(date)
                        .build()
        );
    }

    return holidays;
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

  public static List<HolidayDto> toHolidaysDtoList(List<Holiday> holidayEntities) {
    return holidayEntities.stream()
            .map(HolidayMapper::toHolidayDto)
            .collect(Collectors.toList());
  }
}
