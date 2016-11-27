package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    gotoHomePage();
    initContactCreation();
    fillContactForm(new ContactData("Natalia", "Bogdan", "Minsk\nPritytskogo str 45 - 84", "+375296847584", "n.bogdan@gmail.com"));
    submit();
    returntoHomePage();
  }

}
