package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData(null,null,"0000000xxxxx","Gamer228"));
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Johny","TestJohny","LastNameIsJohny","UsernameTest0001"));
    app.getContactHelper().sumbitContactModification();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();


    Assert.assertEquals(after, before);
  }
}
