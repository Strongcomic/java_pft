package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if(app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstName("Contact1").withMiddleName(null).withLastName("0000000xxxxx").withNickname("Gamer3000"));
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifyedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withFirstName("Not").withMiddleName("Stonks").withLastName("Fallen").withNickname("Sfaseqwe123").withId(modifyedContact.getId());
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifyedContact);
    before.add(contact);
    Assert.assertEquals(after,before);
  }
}
