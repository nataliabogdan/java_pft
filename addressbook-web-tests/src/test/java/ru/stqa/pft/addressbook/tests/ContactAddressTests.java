package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by plopik on 08.01.2017.
 */
public class ContactAddressTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Natalia").withLastName("Bogdan")
              .withHomePhone("+375172079305").withMobilePhone("+375297320504").withWorkPhone("+375332131212")
              .withAddress("Minsk").withGroup("[none]"));
    }
  }
  @Test
 public void testContactAddress(){
    ContactData contact = app.contact().allSet().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }

}
