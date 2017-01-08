package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by plopik on 08.01.2017.
 */
public class ContactEmailAndDetailsInfoTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size()==0){
      app.contact().createShort(new ContactData().withFirstName("Natalia").withLastName("Bogdan")
              .withHomePhone("+375172079305").withMobilePhone("+375297320504").withWorkPhone("+375332131212")
              .withAddress("Minsk").withEmail("plo@gmail.com").withEmail2("tala@gmail.com").withEmail3("dot@gmail.com"));
    }
  }

  @Test
  public void testContactEmail(){
    ContactData contact = app.contact().allSet().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  @Test
  public void testContactDetailedInfo(){
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactDetailedInfo = app.contact().detailedInfoForm(contact);
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contactDetailedInfo.getDetailedInfo(), equalTo(mergeDetailedInfo(contactInfoFromEditForm)));
  }

  private String mergeDetailedInfo(ContactData contact) {
    return contact.getFirstName()+" "+contact.getLastName()+"\n"+contact.getAddress()+"\n\n"
            +"H: "+contact.getHomePhone()+"\n"+"M: "+contact.getMobilePhone()+"\n"+"W: "
            +contact.getWorkPhone()+"\n\n"+mergeEmails(contact);
  }

  private String mergeEmails(ContactData contact) {
    return Stream.of(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).filter((s) -> ! s.equals(""))
            .map(ContactEmailAndDetailsInfoTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  private static String cleaned(String email) {
    return email.replaceAll("\\s", "");
    }


}
