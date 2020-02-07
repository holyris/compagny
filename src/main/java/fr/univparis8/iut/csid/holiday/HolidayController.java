package fr.univparis8.iut.csid.holiday;

import fr.univparis8.iut.csid.exception.IdMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    return holidayService.getAll();
  }

  @GetMapping("{id}")
  public HolidayDto getHoliday(@PathVariable Long id) {
    return HolidayMapper.toHolidayDto(holidayService.get(id));
  }


  @PostMapping
  public ResponseEntity<HolidayDto> createHolidays(@RequestBody HolidayDto holidayDto) throws URISyntaxException {

    if (holidayDto.getId() != null) {
      throw new IllegalArgumentException("Holiday id should not be populated when creating an salary");
    }

    List<Holiday> holidays = HolidayMapper.toHolidays(holidayDto);
    for (Holiday h : holidays
    ) {
      holidayService.create(h);
    }

    URI uri = new URI(ServletUriComponentsBuilder.fromCurrentRequest()
            .pathSegment("{id}")
            .buildAndExpand(holidayDto.getId())
            .toUri().getPath()
    );
    return ResponseEntity.created(uri).body(holidayDto);

  }

  @DeleteMapping("{id}")
  public  void deleteHoliday(@PathVariable Long id){
    holidayService.delete(id);
  }

  @PatchMapping("{id}")
  public HolidayDtoUpdate  partialUpdateHoliday(@PathVariable Long id, @RequestBody HolidayDtoUpdate holidayDto) throws URISyntaxException{
    if(holidayDto.getId() == null) {
      throw new IllegalArgumentException("Holiday id should be populated for HTTP PUT method: you cannot predict its id");
    }
    if(!id.equals(holidayDto.getId())) {
      throw new IdMismatchException("Path id and body id do not match");
    }

    Holiday updatedHoliday = holidayService.partialUpdate(HolidayMapper.toHoliday(holidayDto));
    return HolidayMapper.toHolidayDtoUpdate(updatedHoliday);
  }

  @PutMapping("{id}")
  public HolidayDtoUpdate updateHoliday(@PathVariable Long id, @RequestBody HolidayDtoUpdate holidayDto) {
    if(holidayDto.getId() == null) {
      throw new IllegalArgumentException("Holiday id should be populated for HTTP PUT method: you cannot predict its id");
    }

    if(!id.equals(holidayDto.getId())) {
      throw new IdMismatchException("Path id and body id do not match");
    }

    Holiday updatedHoliday = holidayService.partialUpdate(HolidayMapper.toHoliday(holidayDto));
    return HolidayMapper.toHolidayDtoUpdate(updatedHoliday);
  }


}
