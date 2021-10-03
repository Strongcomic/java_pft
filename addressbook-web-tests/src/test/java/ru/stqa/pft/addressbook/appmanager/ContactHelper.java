package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;


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

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void acceptAlert() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void sumbitContactModification() {
    click(By.name("update"));
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    sumbitContactCreation();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void getContactList() {

  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
