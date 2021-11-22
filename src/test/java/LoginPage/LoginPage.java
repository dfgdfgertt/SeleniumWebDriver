package LoginPage;

import ProfilePage.ProfileLocator;
import Resource.CommonPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {
    CommonPage common = CommonPage.getInstanse();
    LoginData data = new LoginData();
    LoginLocator locator = new LoginLocator();
    ProfileLocator profileLocator = new ProfileLocator();

    public void login(){
        goToLoginPage();
        enterUsername();
        enterPassword();
        clickLoginBtn();
        verifyLoginSuccess();
    }


    private void goToLoginPage(){
        common.goTo(data.getUrlPath());
    }

    private void verifyLoginSuccess(){
        common.waitElementById(profileLocator.getIdUserName());
        String result = common.findElementById(profileLocator.getIdUserName()).getText();
        Assert.assertEquals(result,data.getUserName());
    }

    private void clickLoginBtn(){
        common.clickBtnById(locator.getIdLoginBtn());
    }

    private void enterUsername(){
        common.enterTextById(locator.getIdUserName(), data.getUserName());
    }

    private void enterPassword(){
        common.enterTextById(locator.getIdPassword(), data.getPassword());
    }

}
