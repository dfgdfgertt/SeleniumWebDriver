package TestSuite;

import FormPage.FormPage;
import LoginPage.LoginPage;
import ProfilePage.ProfilePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EnterFormVer2 {
    LoginPage   loginPage   = new LoginPage();
    ProfilePage profilePage = new ProfilePage();
    FormPage    formPage    = new FormPage();

    @BeforeTest
    public void setUp(){
        loginPage.login();
    }

    @Test
    public void enterForm(){
        formPage.enterForm();
        System.out.println("The gioi cua long");
    }

    @AfterTest
    public void tearDown(){
        profilePage.logout();
    }
}
