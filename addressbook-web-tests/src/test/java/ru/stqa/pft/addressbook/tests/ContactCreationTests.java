package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData(null,"Samuel","Smith","JohnWeak301"));
    app.getContactHelper().sumbitContactCreation();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();


    Assert.assertEquals(after, before + 1);
  }
}
