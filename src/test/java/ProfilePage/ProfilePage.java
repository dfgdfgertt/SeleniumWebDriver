package ProfilePage;

import Resource.CommonPage;

public class ProfilePage {
    CommonPage commonPage = CommonPage.getInstanse();
    ProfileLocator profileLocator = new ProfileLocator();

    public void logout(){
        goToProfilePage();
        waitLogoutBtnVisit();
        clickLogoutBtn();
        commonPage.quitBrowser();
    }

    private void goToProfilePage(){
        commonPage.goTo(profileLocator.getUrlPath());
    }

    private void waitLogoutBtnVisit(){
        commonPage.waitElementByIXpath(profileLocator.getLocatorLogoutBtn());
    }

    private void clickLogoutBtn(){
        commonPage.clickBtnByXpath(profileLocator.getLocatorLogoutBtn());
    }

}
