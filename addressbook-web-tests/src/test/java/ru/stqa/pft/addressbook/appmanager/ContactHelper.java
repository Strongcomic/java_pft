package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.firstName());
    type(By.name("middlename"), contactData.middleName());
    type(By.name("lastname"), contactData.lastName());
    type(By.name("nickname"), contactData.nickname());
  }

  public void sumbitContactCreation() {
    click(By.name("submit"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void acceptAlert() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("(//tr[@name='entry']//img[@alt='Edit'])[last()]"));
  }

  public void sumbitContactModification() {
    click(By.name("update"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    sumbitContactCreation();
    returnToHomePage();
  }

  public void modify(int index, ContactData contact) {
    selectContact(index);
    initContactModification();
    fillContactForm(contact);
    sumbitContactModification();
    returnToHomePage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContacts();
    acceptAlert();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String firstName = element.findElement(By.xpath("./td[3]")).getText();
      String lastName = element.findElement(By.xpath("./td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withFirstName(firstName).withLastName(lastName).withId(id));
    }
    return contacts;
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
