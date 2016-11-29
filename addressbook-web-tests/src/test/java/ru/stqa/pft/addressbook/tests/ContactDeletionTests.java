package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by plopik on 30.11.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void contactDeletion(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelper().gotoHomePage();
  }
}
