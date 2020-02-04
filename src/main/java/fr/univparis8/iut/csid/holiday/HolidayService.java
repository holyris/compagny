package fr.univparis8.iut.csid.holiday;

import fr.univparis8.iut.csid.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
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
}
