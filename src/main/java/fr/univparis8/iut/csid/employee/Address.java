package fr.univparis8.iut.csid.employee;

public class Address {
  private int streetNumber;
  private String streetName;
  private int postcode;
  private String city;
  private String country;

  public Address() {

  }

  public Address(int streetNumber, String streetName, int postcode, String city, String country) {
    this.streetNumber = streetNumber;
    this.streetName = streetName;
    this.postcode = postcode;
    this.city = city;
    this.country = country;
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

  public String toAddressLine1() {
    return streetNumber + " " + streetName;
  }

  public String toAddressLine2() {
    return postcode + " " + city + " " + country;

  }

  @Override
  public String toString() {
    return "Address{" +
            "streetNumber=" + streetNumber +
            ", streetName='" + streetName + '\'' +
            ", postcode=" + postcode +
            ", city='" + city + '\'' +
            ", country='" + country + '\'' +
            '}';
  }
}
