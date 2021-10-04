package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData(null,null,"0000000xxxxx","Gamer228"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData("0010","Sm1ith","1123","UsernameTest10001", before.get(before.size() - 1).getId());
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().sumbitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();


    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<>(before),new HashSet<>(after));
  }
}
