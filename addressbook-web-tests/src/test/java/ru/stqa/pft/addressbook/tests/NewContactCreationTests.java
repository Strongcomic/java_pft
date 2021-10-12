package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NewContactCreationTests extends TestBase {

  @Test
  public void newTestContactCreation() {
    app.goTo().homePage();
    app.contact().initContactCreation();
    File photo = new File("src/test/resources/trust1.png");
    app.contact().fillContactForm(new ContactData().withFirstName("John").withLastName("Weak").withPhoto(photo));
    app.contact().sumbitContactCreation();
    app.goTo().homePage();

  }
}
