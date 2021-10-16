package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

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
    type(By.name("email"),contactData.email1());
    type(By.name("address"),contactData.allAddresses());
    attach(By.name("photo"), contactData.photo());
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
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModificationById(contact.getId());
    fillContactForm(contact);
    sumbitContactModification();
    contactCache = null;
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
    contactCache = null;
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstName = element.findElement(By.xpath("./td[3]")).getText();
      String lastName = element.findElement(By.xpath("./td[2]")).getText();
      String allPhones = element.findElement(By.xpath("./td[6]")).getText();
      String allAddresses = element.findElement(By.xpath("./td[4]")).getText();
      String allEmails = element.findElement(By.xpath("./td[5]")).getText();
      contactCache.add(new ContactData().withFirstName(firstName).withLastName(lastName).withId(id)
              .withAllPhones(allPhones).withAllAddresses(allAddresses).withAllEmails(allEmails));
    }
    return new Contacts(contactCache);
  }


  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAllAddresses(address)
            .withEmail1(email1).withEmail2(email2).withEmail3(email3);
  }

  public void selectGroup(String groupName) {
    new Select(wd.findElement(By.name("group"))).selectByVisibleText(groupName);
  }

  public void addContactToGroup(ContactData contact, GroupData group) {
    selectContactById(contact.getId());
    String groupName= group.name();
    new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(group.name());
    wd.findElement(By.name("add")).click();
  }
  public void removeContactFromGroup(ContactData contact, GroupData groupUnassigned) {
    selectGroup(groupUnassigned.name());
    selectContactById(contact.getId());
    wd.findElement(By.name("remove")).click();
  }



  public boolean isContactInGroup(ContactData contact, GroupData group){
    if (contact.getGroups().size()==0){
      return false;
    }
    Groups contactGroups= contact.getGroups();
    for (GroupData contactGroup:contactGroups) {
      if (contactGroup.equals(group)){
        return true;
      }
    }
    return false;
  }
}
