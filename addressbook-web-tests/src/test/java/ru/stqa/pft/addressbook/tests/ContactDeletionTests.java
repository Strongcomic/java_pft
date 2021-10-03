package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if(! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData(null,"Samuel","Smith","JohnWeak301"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().acceptAlert();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();


    Assert.assertEquals(after, before - 1);
  }
}
