package org.datenmuehle.addressvalidation;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Address extends Validateable
{
  private static final long serialVersionUID = 1L;

  private String name;
  private String street;
  private String zipcode;
  private String city;

  public String getId()
  {
    return "pickup";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStreet()
  {
    return street;
  }

  public void setStreet(String street)
  {
    this.street = street;
  }

  public String getZipcode()
  {
    return zipcode;
  }

  public void setZipcode(String zipcode)
  {
    this.zipcode = zipcode;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }
}
