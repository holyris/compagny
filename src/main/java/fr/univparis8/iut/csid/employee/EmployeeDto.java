package fr.univparis8.iut.csid.employee;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDto {

  private Long id;

  private String firstName;

  private String lastName;

  @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
  private int streetNumber;

  @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
  private String streetName;

  @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
  private int postcode;

  @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
  private String city;

  @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
  private String country;

  private double salary;


  public EmployeeDto() {
  }

  public EmployeeDto(Long id, String firstName, String lastName, int streetNumber, String streetName, int postcode, String city, String country, double salary) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.streetNumber = streetNumber;
    this.streetName = streetName;
    this.postcode = postcode;
    this.city = city;
    this.country = country;
    this.salary = salary;
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

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  @JsonProperty( access = JsonProperty.Access.READ_ONLY)
  public String addressLine1(){
    return streetNumber + " " + streetName;
  }

  @JsonProperty( access = JsonProperty.Access.READ_ONLY)
  public String addressLine2(){
    return postcode + " " + city + " " + country;
  }


  public static final class EmployeeDtoBuilder {
    private Long id;
    private String firstName;
    private String lastName;
    private int streetNumber;
    private String streetName;
    private int postcode;
    private String city;
    private String country;
    private double salary;

    private EmployeeDtoBuilder() {
    }

    public static EmployeeDtoBuilder create() {
      return new EmployeeDtoBuilder();
    }

    public EmployeeDtoBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public EmployeeDtoBuilder withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public EmployeeDtoBuilder withLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public EmployeeDtoBuilder withStreetNumber(int streetNumber) {
      this.streetNumber = streetNumber;
      return this;
    }

    public EmployeeDtoBuilder withStreetName(String streetName) {
      this.streetName = streetName;
      return this;
    }

    public EmployeeDtoBuilder withPostcode(int postcode) {
      this.postcode = postcode;
      return this;
    }

    public EmployeeDtoBuilder withCity(String city) {
      this.city = city;
      return this;
    }

    public EmployeeDtoBuilder withCountry(String country) {
      this.country = country;
      return this;
    }

    public EmployeeDtoBuilder withSalary(double salary) {
      this.salary = salary;
      return this;
    }

    public EmployeeDto build() {
      EmployeeDto employeeDto = new EmployeeDto();
      employeeDto.setId(id);
      employeeDto.setFirstName(firstName);
      employeeDto.setLastName(lastName);
      employeeDto.setStreetNumber(streetNumber);
      employeeDto.setStreetName(streetName);
      employeeDto.setPostcode(postcode);
      employeeDto.setCity(city);
      employeeDto.setCountry(country);
      employeeDto.setSalary(salary);
      return employeeDto;
    }
  }
}
