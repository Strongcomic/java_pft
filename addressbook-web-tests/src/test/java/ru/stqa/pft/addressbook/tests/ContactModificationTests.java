package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Johny","TestJohny","LastNameIsJohny","UsernameTest0001"));
    app.getContactHelper().sumbitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
