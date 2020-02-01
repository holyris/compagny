package fr.univparis8.iut.csid.salary;

import fr.univparis8.iut.csid.annotation.IdAndBodyMatcher;
import fr.univparis8.iut.csid.exception.IdMismatchException;
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
  public List<SalaryDTO> getAllSalaries() {
    return salaryService.getAll();
  }

  @GetMapping("{id}")
  public SalaryDTO getSalary(@PathVariable Long id) {
    return SalaryMapper.toSalaryDTO(salaryService.get(id));
  }

  @PostMapping
  public ResponseEntity<SalaryDTO> createEmployee(@RequestBody SalaryDTO salaryDto) throws URISyntaxException {

    if(salaryDto.getId() != null) {
      throw new IllegalArgumentException("Salary id should not be populated when creating an salary");
    }

    Salary newSalary = salaryService.create(SalaryMapper.toSalary(salaryDto));

    URI uri = new URI(ServletUriComponentsBuilder.fromCurrentRequest()
            .pathSegment("{id}")
            .buildAndExpand(newSalary.getId())
            .toUri().getPath()
    );

    return ResponseEntity.created(uri).body(SalaryMapper.toSalaryDTO(newSalary));
  }

  @IdAndBodyMatcher
  @PutMapping("{id}")
  public SalaryDTO updateSalary(@PathVariable Long id, @RequestBody SalaryDTO salaryDTO) {
    if(salaryDTO.getId() == null) {
      throw new IllegalArgumentException("Salary id should be populated for HTTP PUT method: you cannot predict its id");
    }

    if(!id.equals(salaryDTO.getId())) {
      throw new IdMismatchException("Path id and body id do not match");
    }

    Salary updatedSalary = salaryService.update(SalaryMapper.toSalary(salaryDTO));
    return SalaryMapper.toSalaryDTO(updatedSalary);
  }

  @PatchMapping("{id}")
  public SalaryDTO partialUpdateSalary(@PathVariable Long id, @RequestBody SalaryDTO salaryDTO) {
    if(salaryDTO.getId() == null) {
      throw new IllegalArgumentException("Salary id should be populated for HTTP PUT method: you cannot predict its id");
    }
    if(!id.equals(salaryDTO.getId())) {
      throw new IdMismatchException("Path id and body id do not match");
    }

    Salary updatedSalary = salaryService.partialUpdate(SalaryMapper.toSalary(salaryDTO));
    return SalaryMapper.toSalaryDTO(updatedSalary);
  }

  @DeleteMapping("{id}")
  public void deleteSalary(@PathVariable Long id) {
    salaryService.delete(id);
  }

}
