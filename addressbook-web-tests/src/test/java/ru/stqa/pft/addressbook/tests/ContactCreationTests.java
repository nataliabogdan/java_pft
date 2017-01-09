package ru.stqa.pft.addressbook.tests;




import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {


  @Test //(enabled = false)
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/adminemails.png");
    ContactData contact = new ContactData()
            .withFirstName("Natalia").withLastName("Bogdan")
            .withHomePhone("+375172079305").withMobilePhone("+375297320504").withWorkPhone("+375332131212")
            .withEmail("plo@gmail.com").withEmail2("tala@gmail.com").withEmail3("dot@gmail.com")
            .withPhoto(photo).withGroup("[none]");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Natalia'").withLastName("Bogdan").withGroup("[none]");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
  /*@Test
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/adminemails.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }*/
}
