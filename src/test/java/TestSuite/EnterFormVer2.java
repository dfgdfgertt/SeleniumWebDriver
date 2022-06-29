package TestSuite;

import FormPage.FormPage;
import LoginPage.LoginPage;
import ProfilePage.ProfilePage;
import com.automation.test.TestAction;
import com.automation.test.TestCase;
import com.automation.test.TestVerification;
import com.automation.test.publisher.Publisher;
import com.automation.test.reader.SimpleReader;
import com.automation.test.verifier.SimpleVerifier;
import org.testng.annotations.*;

public class EnterFormVer2 {
    LoginPage   loginPage   = new LoginPage();
    ProfilePage profilePage = new ProfilePage();
    FormPage    formPage    = new FormPage();

    @DataProvider(name = "connectionsTestData")
    public Object[][] createConnectionsTestData() {
        return new Object[][]{
                {
                        "Case 1",
                        "Enter form and submit"
                }
        };
    }

    @BeforeMethod
    public void setUp(){
        loginPage.login();
    }

    @Test(dataProvider = "connectionsTestData")
    public void enterForm(String name, String Desc){
        TestCase tc = new TestCase(name, Desc);

        formPage.enterForm();
        TestAction testAction = new TestAction("Input value",null);
        SimpleReader reader = new SimpleReader<>();
        reader.setData(formPage.getName());
        SimpleVerifier verifier = new SimpleVerifier<>();
        verifier.setExpected("Name");
        TestVerification<?> testVerification = new TestVerification<>(reader,verifier);
        testAction.addVerification(testVerification);


        tc.addStep(testAction);
        tc.run();
    }

    @AfterMethod
    public void tearDown(){
        profilePage.logout();
    }
}
