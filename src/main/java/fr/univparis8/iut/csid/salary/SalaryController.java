package fr.univparis8.iut.csid.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/salaries")
public class SalaryController {

  private final SalaryService salaryService;

  @Autowired
  public SalaryController(SalaryService salaryService) {
    this.salaryService = salaryService;
  }

  @GetMapping
  public List<SalaryDto> getAllSalaries() {
    return salaryService.getAll();
  }

  @GetMapping("{id}")
  public SalaryDto getSalary(@PathVariable Long id) {
    return SalaryMapper.toSalaryDto(salaryService.get(id));
  }

  @PostMapping
  public ResponseEntity<SalaryDto> createEmployee(@RequestBody SalaryDto salaryDto) throws URISyntaxException {

    Salary salary = SalaryMapper.toSalary(salaryDto);
    if(salaryDto.getId() != null) {
      throw new IllegalArgumentException("Salary id should not be populated when creating an salary");
    }

    if (salaryService.salaryAlreadyExists(salary)
    ) {
      throw new IllegalArgumentException("This salary already exists ");
    }
    Salary newSalary = salaryService.create(salary);

    URI uri = new URI(ServletUriComponentsBuilder.fromCurrentRequest()
            .pathSegment("{id}")
            .buildAndExpand(newSalary.getId())
            .toUri().getPath()
    );

    return ResponseEntity.created(uri).body(SalaryMapper.toSalaryDto(newSalary));
  }

//  @IdAndBodyMatcher
//  @PutMapping("{id}")
//  public SalaryDto updateSalary(@PathVariable Long id, @RequestBody SalaryDto salaryDTO) {
//    if(salaryDTO.getId() == null) {
//      throw new IllegalArgumentException("Salary id should be populated for HTTP PUT method: you cannot predict its id");
//    }
//
//    if(!id.equals(salaryDTO.getId())) {
//      throw new IdMismatchException("Path id and body id do not match");
//    }
//
//    Salary updatedSalary = salaryService.update(SalaryMapper.toSalary(salaryDTO));
//    return SalaryMapper.toSalaryDto(updatedSalary);
//  }
//
//  @PatchMapping("{id}")
//  public SalaryDto partialUpdateSalary(@PathVariable Long id, @RequestBody SalaryDto salaryDTO) {
//    if(salaryDTO.getId() == null) {
//      throw new IllegalArgumentException("Salary id should be populated for HTTP PUT method: you cannot predict its id");
//    }
//    if(!id.equals(salaryDTO.getId())) {
//      throw new IdMismatchException("Path id and body id do not match");
//    }
//
//    Salary updatedSalary = salaryService.partialUpdate(SalaryMapper.toSalary(salaryDTO));
//    return SalaryMapper.toSalaryDto(updatedSalary);
//  }
//
//  @DeleteMapping("{id}")
//  public void deleteSalary(@PathVariable Long id) {
//    salaryService.delete(id);
//  }

}
