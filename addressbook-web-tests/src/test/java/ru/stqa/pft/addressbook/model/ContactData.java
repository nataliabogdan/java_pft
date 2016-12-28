package ru.stqa.pft.addressbook.model;

public class ContactData {
  private  int id;
  private final String firstName;
  private final String secondName;
  private String group;
  private final String address;
  private final String phone;
  private final String email;


  public ContactData(int id, String firstName, String secondName, String address, String phone, String email, String group) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.group = group;
  }

  public ContactData(String firstName, String secondName, String address, String phone, String email, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.secondName = secondName;
    this.address = address;
    this.phone = phone;
    this.email = email;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", secondName='" + secondName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return secondName != null ? secondName.equals(that.secondName) : that.secondName == null;

  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
    return result;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
