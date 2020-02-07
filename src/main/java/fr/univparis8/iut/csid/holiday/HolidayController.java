package fr.univparis8.iut.csid.holiday;

import fr.univparis8.iut.csid.exception.IdMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

  private final HolidayService holidayService;

  @Autowired
  public HolidayController(HolidayService holidayService) {
    this.holidayService = holidayService;
  }

  @GetMapping
  public List<HolidayDto> getAllSalaries() {
    return HolidayMapper.toHolidaysDtoList(holidayService.getAll());
  }

  @GetMapping("{id}")
  public HolidayDto getHoliday(@PathVariable Long id) {
    return HolidayMapper.toHolidayDto(holidayService.get(id));
  }

  @PostMapping
  public ResponseEntity<List<HolidayDto>> createHolidays(@RequestBody HolidayRequestDto holidayDto) throws URISyntaxException {


    List<HolidayDto> response = HolidayMapper.toHolidaysDtoList(holidayService.create(HolidayMapper.toHolidayRequest(holidayDto)));

    return ResponseEntity.ok(response);

  }

  @DeleteMapping("{id}")
  public  void deleteHoliday(@PathVariable Long id){
    holidayService.delete(id);
  }

  @PatchMapping("{id}")
  public HolidayDto partialUpdateHoliday(@PathVariable Long id, @RequestBody HolidayDto test) throws URISyntaxException{
    if(test.getId() == null) {
      throw new IllegalArgumentException("Holiday id should be populated for HTTP PUT method: you cannot predict its id");
    }
    if(!id.equals(test.getId())) {
      throw new IdMismatchException("Path id and body id do not match");
    }

    Holiday updatedHoliday = holidayService.partialUpdate(HolidayMapper.toHoliday(test));
    return HolidayMapper.toHolidayDto(updatedHoliday);
  }

  @PutMapping("{id}")
  public HolidayDto updateHoliday(@PathVariable Long id, @RequestBody HolidayDto test) {
    if(test.getId() == null) {
      throw new IllegalArgumentException("Holiday id should be populated for HTTP PUT method: you cannot predict its id");
    }

    if(!id.equals(test.getId())) {
      throw new IdMismatchException("Path id and body id do not match");
    }

    Holiday updatedHoliday = holidayService.partialUpdate(HolidayMapper.toHoliday(test));
    return HolidayMapper.toHolidayDto(updatedHoliday);
  }


}
