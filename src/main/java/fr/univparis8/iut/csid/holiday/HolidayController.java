package fr.univparis8.iut.csid.holiday;

import fr.univparis8.iut.csid.salary.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
    List<Holiday> newHolidays = new ArrayList<>();
    for (Holiday h : holidays
    ) {
      newHolidays.add(holidayService.create(h));
    }

    URI uri = new URI(ServletUriComponentsBuilder.fromCurrentRequest()
            .pathSegment("{id}")
            .buildAndExpand(holidayDto.getId())
            .toUri().getPath()
    );
    return ResponseEntity.created(uri).body(holidayDto);

  }
}
