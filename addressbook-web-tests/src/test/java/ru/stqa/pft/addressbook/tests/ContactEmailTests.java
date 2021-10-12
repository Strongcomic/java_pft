package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

  @Test
  public void testContactEmails() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.allEmails(),equalTo(cleaned(mergeEmails(contactInfoFromEditForm))));

  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.email1(),contact.email2(),contact.email3())
            .stream().filter((s -> !s.equals(""))).collect(Collectors.joining("\n"));
  }

  public static String cleaned(String email) {
    return email.replaceAll(" +"," ").trim();
  }
}
