package fr.univparis8.iut.csid.holiday;

import fr.univparis8.iut.csid.employee.Employee;
import fr.univparis8.iut.csid.employee.EmployeeEntity;
import fr.univparis8.iut.csid.employee.EmployeeMapper;
import fr.univparis8.iut.csid.salary.Salary;
import fr.univparis8.iut.csid.salary.SalaryDto;
import fr.univparis8.iut.csid.salary.SalaryEntity;
import fr.univparis8.iut.csid.salary.SalaryMapper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(holiday.getStart());

    Calendar endCalendar = Calendar.getInstance();
    endCalendar.setTime(holiday.getEnd());

    // get all dates between
    while (calendar.before(endCalendar)) {
      Date result = calendar.getTime();
      if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
        holidays.add(
                Holiday.HolidayBuilder.create()
                        .withId(holiday.getId())
                        .withEmployee(employee)
                        .withDatetime(result)
                        .build()
        );
      }
      calendar.add(Calendar.DATE, 1);
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
