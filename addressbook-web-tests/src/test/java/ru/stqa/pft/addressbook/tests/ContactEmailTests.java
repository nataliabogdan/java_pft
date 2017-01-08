package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by plopik on 08.01.2017.
 */
public class ContactEmailTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Natalia").withLastName("Bogdan")
              .withHomePhone("+375172079305").withMobilePhone("+375297320504").withWorkPhone("+375332131212")
              .withEmail("plo@gmail.com").withEmail2("tala@gmail.com").withEmail3("dot@gmail.com")
              .withGroup("[none]"));
    }
  }

  @Test
  public void testContactEmail(){
    ContactData contact = app.contact().allSet().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Stream.of(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).filter((s) -> ! s.equals(""))
            .map(ContactEmailTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  private static String cleaned(String email) {
    return email.replaceAll("\\s", "");
    }


}
