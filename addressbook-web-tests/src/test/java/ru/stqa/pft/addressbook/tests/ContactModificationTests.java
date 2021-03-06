package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstName("Contact1").withMiddleName(null).withLastName("0000000xxxxx").withNickname("Gamer3000"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifyedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withFirstName("Not").withMiddleName("Stonks").withLastName("Fallen").withNickname("Sfaseqwe123").withId(modifyedContact.getId());
    app.goTo().homePage();
    app.contact().modify(contact);
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.db().contacts ();
    assertThat(after, equalTo(before.withOut(modifyedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
