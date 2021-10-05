package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public final class ContactData {

  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String middleName;
  private String lastName;
  private String nickname;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
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

  public int getId() {
    return id;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
}

