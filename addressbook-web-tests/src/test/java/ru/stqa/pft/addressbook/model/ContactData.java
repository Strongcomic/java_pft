package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public final class ContactData {
  private final String id;
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickname;

  public ContactData(String firstName, String middleName, String lastName, String nickname, String id) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
  }

  public ContactData(String firstName, String middleName, String lastName, String nickname) {
    this.id = null;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
  }

  public String firstName() {
    return firstName;
  }

  public String middleName() {
    return middleName;
  }

  public String lastName() {
    return lastName;
  }

  public String nickname() {
    return nickname;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  public String id() {
    return id;
  }


  public String getId() {
    return id;
  }
}

