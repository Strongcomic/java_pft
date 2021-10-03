package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public final class GroupData {
  private final String name;
  private final String header;
  private final String footer;
  private int id;

  public GroupData(String name, String header, String footer, int id) {
    this.name = name;
    this.header = header;
    this.footer = footer;
    this.id = id;
  }

  public int id() {
    return Integer.MAX_VALUE;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id && Objects.equals(name, groupData.name);
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


  public int getId() {
    return id;
  }

  public String name() {
    return name;
  }

  public String header() {
    return header;
  }

  public String footer() {
    return footer;
  }

  public void setId(int id) {
    this.id = id;
  }
}