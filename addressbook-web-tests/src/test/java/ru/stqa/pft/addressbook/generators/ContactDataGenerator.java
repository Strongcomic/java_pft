package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

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

    @Parameter(names = "-d", description = "Data format")
    public String format;

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
      if (format.equals("csv")) {
        saveAsCsv(contacts,new File(file));
      } else if (format.equals("xml")){
        saveAsXml(contacts,new File(file));
      } else {
        System.out.println("Unrecognize format " + format);
      }
    }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class);
    String xml = xStream.toXML(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
      Writer writer = new FileWriter(file);
      for (ContactData contact : contacts) {
        writer.write(String.format("%s; %s; %s;\n",contact.firstName(),contact.lastName(),contact.email1()));
      }
      writer.close();
    }

    private List<ContactData> generateContacts(int count) {
      List<ContactData> contacts = new ArrayList<>();
      for (int i = 0; i < count; i++) {
        contacts.add(new ContactData().withFirstName(String.format("Dyshnila %s", i))
                .withLastName(String.format("Kyrochkin %s", i)).withEmail1(String.format("DysnilaKyrochkin@mail.ru %s", i)));
      }
      return contacts;
    }

}
