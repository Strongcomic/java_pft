package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public record GroupData(String name, String header, String footer,String id) {
  @Override
  public String id() {
    return null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(name, groupData.name) && Objects.equals(id, groupData.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            '}';
  }


  public String getId() {
    return id;
  }
}