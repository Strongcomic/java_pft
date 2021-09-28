package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("John","Samuel","Smith","JohnWeak301"));
    app.getContactHelper().sumbitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}