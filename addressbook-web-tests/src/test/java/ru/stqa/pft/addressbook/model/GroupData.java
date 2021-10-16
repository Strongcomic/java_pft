package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jdk.jfr.Name;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {

  @Column(name = "group_name")
  private String name;
  @Column(name = "group_header")
  @Type(type = "text")
  private String header;
  @Column(name = "group_footer")
  @Type(type = "text")
  private String footer;
  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  private int id = Integer.MAX_VALUE;
  @ManyToMany(mappedBy = "groups")
  private Set<ContactData> contacts = new HashSet<ContactData>();


  public Contacts getContacts() {
    return new Contacts(contacts);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id && Objects.equals(name, groupData.name);
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            ", header='" + header + '\'' +
            ", footer='" + footer + '\'' +
            ", id=" + id +
            '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id);
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

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }
}
