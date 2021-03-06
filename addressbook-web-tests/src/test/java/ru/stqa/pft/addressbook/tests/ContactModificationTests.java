package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by plopik on 30.11.2016.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod

  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Natalia").withLastName("Bogdan").withGroup("[none]"));
    }
  }

  @Test //(enabled = false)
  public void testContactModification(){
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("Natalia").withLastName("Bogdan")
            .withHomePhone("+375172079305").withMobilePhone("+375297320504").withWorkPhone("+375332131212")
            .withEmail("plo@gmail.com").withEmail2("tala@gmail.com").withEmail3("dot@gmail.com")
            .withAddress("Minsk");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }
}
