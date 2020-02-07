package fr.univparis8.iut.csid.holiday;

import fr.univparis8.iut.csid.employee.Employee;
import fr.univparis8.iut.csid.employee.EmployeeMapper;
import fr.univparis8.iut.csid.exception.ObjectNotFoundException;
import fr.univparis8.iut.csid.salary.Salary;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.util.List;

@Service
public class HolidayService {
  private final HolidayRepository holidayRepository;

  public HolidayService(HolidayRepository holidayRepository) {
    this.holidayRepository = holidayRepository;
}

  public Holiday get(Long id) {
    try {
      return HolidayMapper.toHoliday(holidayRepository.getOne(id));
    } catch (PersistenceException ex) {
      throw new ObjectNotFoundException("Salary with id " + id + " not found");
    }
  }

  public Holiday create(Holiday holiday) {
    return HolidayMapper.toHoliday(holidayRepository.save(HolidayMapper.toHolidayEntity(holiday)));
  }

  public List<HolidayDto> getAll() {
    List<Holiday> salaries = HolidayMapper.toHolidaysList(holidayRepository.findAll());
    return HolidayMapper.toHolidaysDtoList(salaries);
  }

  public int countByMonthYear(Employee employee, Salary salary){

    LocalDate start = LocalDate.parse(salary.getMonthYear()+"-01");
    LocalDate end = LocalDate.parse(salary.getMonthYear()+"-"+start.lengthOfMonth());

    return this.holidayRepository.findAllByEmployeeAndDatetimeBetween(EmployeeMapper.toEmployeeEntity(employee),start,end).size();
  }
}
