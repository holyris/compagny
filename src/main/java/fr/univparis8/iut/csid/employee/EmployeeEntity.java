package fr.univparis8.iut.csid.employee;

import fr.univparis8.iut.csid.salary.SalaryEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @OneToMany(mappedBy = "employee")
  private Set<SalaryEntity> salaries;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "street_number")
  private int streetNumber;

  @Column(name = "street_name")
  private String streetName;

  @Column(name = "postcode")
  private int postcode;

  @Column(name = "city")
  private String city;

  @Column(name = "country")
  private String country;

  @Column(name = "salary")
  private double salary;


  public EmployeeEntity() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(int streetNumber) {
    this.streetNumber = streetNumber;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public int getPostcode() {
    return postcode;
  }

  public void setPostcode(int postcode) {
    this.postcode = postcode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Address getAddress() {
    return new Address(streetNumber, streetName, postcode, city, country);
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public static final class EmployeeEntityBuilder {
    private Long id;
    private String firstName;
    private String lastName;
    private int streetNumber;
    private String streetName;
    private int postcode;
    private String city;
    private String country;
    private double salary;

    private EmployeeEntityBuilder() {
    }

    public static EmployeeEntityBuilder create() {
      return new EmployeeEntityBuilder();
    }

    public EmployeeEntityBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public EmployeeEntityBuilder withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public EmployeeEntityBuilder withLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public EmployeeEntityBuilder withAddress(Address address) {
      this.streetNumber = address.getStreetNumber();
      this.streetName = address.getStreetName();
      this.postcode = address.getPostcode();
      this.city = address.getCity();
      this.country = address.getCountry();
      return this;
    }

    public EmployeeEntityBuilder withStreetNumber(int streetNumber) {
      this.streetNumber = streetNumber;
      return this;
    }

    public EmployeeEntityBuilder withStreetName(String streetName) {
      this.streetName = streetName;
      return this;
    }

    public EmployeeEntityBuilder withPostCode(int postcode) {
      this.postcode = postcode;
      return this;
    }

    public EmployeeEntityBuilder withCity(String city) {
      this.city = city;
      return this;
    }

    public EmployeeEntityBuilder withCountry(String country) {
      this.country = country;
      return this;
    }

    public EmployeeEntityBuilder withSalary(double salary) {
      this.salary = salary;
      return this;
    }

    public EmployeeEntity build() {
      EmployeeEntity employeeEntity = new EmployeeEntity();
      employeeEntity.setId(id);
      employeeEntity.setFirstName(firstName);
      employeeEntity.setLastName(lastName);
      employeeEntity.setStreetNumber(streetNumber);
      employeeEntity.setStreetName(streetName);
      employeeEntity.setPostcode(postcode);
      employeeEntity.setCity(city);
      employeeEntity.setCountry(country);
      employeeEntity.setSalary(salary);
      return employeeEntity;
    }
  }
}
