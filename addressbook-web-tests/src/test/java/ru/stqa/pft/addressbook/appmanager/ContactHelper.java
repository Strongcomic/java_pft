package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

  public void selectContactById(int id) {
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for(WebElement e : elements)
    {
      WebElement checkbox = e.findElements(By.tagName("td")).get(0).findElement(By.tagName("input"));

      if(id == Integer.parseInt(checkbox.getAttribute("value")))
      {
        checkbox.click();
        return;
      }
    }
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

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModificationById(contact.getId());
    fillContactForm(contact);
    sumbitContactModification();
    returnToHomePage();
  }

  private void initContactModificationById(int id) {
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for(WebElement e : elements)
    {
      List<WebElement> row = e.findElements(By.tagName("td"));
      WebElement checkbox = row.get(0).findElement(By.tagName("input"));

      if(id == Integer.parseInt(checkbox.getAttribute("value")))
      {
        row.get(7).click();
        return;
      }
    }
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    acceptAlert();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
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
