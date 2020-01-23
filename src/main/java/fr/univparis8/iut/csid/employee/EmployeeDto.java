package fr.univparis8.iut.csid.employee;

public class EmployeeDto {

  private Long id;

  private String firstName;

  private String lastName;

  private String addressLine1;

  private String addressLine2;

  private double salary;

  public EmployeeDto() {
  }

  public EmployeeDto(Long id, String firstName, String lastName, String addressLine1, String addressLine2, double salary) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
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

  public String getAddressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public Address getAddress() {
    Address address = new Address();
    String addressLine = addressLine1 + ' ' + addressLine2;
    StringBuilder tampon;
    int itr = 0;
    char charAt;

    for (int attributeNumber = 0; attributeNumber < 5; attributeNumber++) {
      tampon = new StringBuilder();
      while (itr < addressLine.length() && (charAt = addressLine.charAt(itr)) != ' ') {
        tampon.append(charAt);
        itr++;
      }
      itr++;

      if (attributeNumber == 0)
        address.setStreetNumber(Integer.parseInt(tampon.toString()));
      else if (attributeNumber == 1)
        address.setStreetName(tampon.toString());
      if (attributeNumber == 2)
        address.setPostcode(Integer.parseInt(tampon.toString()));
      else if (attributeNumber == 3)
        address.setCity(tampon.toString());
      else if (attributeNumber == 4)
        address.setCountry(tampon.toString());
    }
    return address;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public static final class EmployeeDtoBuilder {
    private Long id;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
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

    public EmployeeDtoBuilder withAddressLine1(String addressLine1) {
      this.addressLine1 = addressLine1;
      return this;
    }

    public EmployeeDtoBuilder withAddressLine2(String addressLine2) {
      this.addressLine2 = addressLine2;
      return this;
    }

    public EmployeeDtoBuilder withSalary(double salary){
      this.salary = salary;
      return this;
    }

    public EmployeeDto build() {
      return new EmployeeDto(id, firstName, lastName, addressLine1, addressLine2, salary);
    }
  }
}
