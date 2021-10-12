package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    public static void main(String[] args) throws IOException {
      ContactDataGenerator generator = new ContactDataGenerator();
      JCommander JCommander = new JCommander(generator);
      try {
        JCommander.parse(args);
      } catch (ParameterException ex) {
        JCommander.usage();
        return;
      }
      generator.run();

    }

    private void run() throws IOException {
      List<ContactData> contacts = generateContacts(count);
      save(contacts,new File(file));
    }

    private void save(List<ContactData> contacts, File file) throws IOException {
      Writer writer = new FileWriter(file);
      for (ContactData contact : contacts) {
        writer.write(String.format("%s; %s; %s;\n",contact.firstName(),contact.lastName(),contact.email1()));
      }
      writer.close();
    }

    private List<ContactData> generateContacts(int count) {
      List<ContactData> contacts = new ArrayList<>();
      for (int i = 0; i < count; i++) {
        contacts.add(new ContactData().withFirstName(String.format("Душнила %s", i))
                .withLastName(String.format("Курочкин %s", i)).withEmail1(String.format("DysnilaKyrochkin@mail.ru %s", i)));
      }
      return contacts;
    }

}
