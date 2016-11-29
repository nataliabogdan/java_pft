package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.gotoHomePage();
    app.initContactCreation();
    app.fillContactForm(new ContactData("Natalia", "Bogdan", "Minsk\nPritytskogo str 45 - 84", "+375296847584", "n.bogdan@gmail.com"));
    app.submit();
    app.returntoHomePage();
  }

}
