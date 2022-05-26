package FormPage;


import Resource.CommonPage;

public class FormPage {
    CommonPage common = CommonPage.getInstanse();
    FormData data = new FormData();
    FormLocator locator = new FormLocator();

    public void enterForm(){
        goToFormPage();
        enterFirstName();
        enterLastName();
        enterEmail();
        clickGender();
        enterMobile();
        selectDateOfBirth();
        enterSubjects();
        common.scrollDown();
        clickHobbies();
        enterImage();
        enterAddress();
//        selectState();
//        selectCity();
//        clickSubmit();
        //clickCloseBtn();
    }

    private void goToFormPage(){
        common.goTo(data.getUrlPath());
    }

    private void enterFirstName(){
        if (data.getFirstName() != "") {
            common.enterTextById(locator.getId_firstName(), data.getFirstName());
        }
    }

    private void enterLastName(){
        if (data.getLastName() != "") {
            common.enterTextById(locator.getId_lastName(), data.getLastName());
        }
    }

    private void enterEmail(){
        if (data.getUserMail() != "") {
            common.enterTextById(locator.getId_userMail(), data.getUserMail());
        }
    }

    private void clickGender(){
        if (data.getGender() != "") {
            common.clickCheckBtn(locator.getXpath_gender());
        }
    }

    private void enterMobile(){
        if (data.getUserNumber() != "") {
            common.enterTextById(locator.getId_userNumber(), data.getUserNumber());
        }
    }
    private void selectDateOfBirth(){
        if (data.getDay() != "" && data.getYear() != "" && data.getMonth() != "") {
            common.clickBtnById(locator.getId_dateOfBirth());
            common.clickBtnByXpath(locator.getXpath_year());
            common.clickBtnByXpath(locator.getXpath_month());
            common.clickBtnByXpath(locator.getXpath_day());
        }
    }

    private void enterSubjects(){
        if (data.getSubjects() != "") {
            common.enterTextById(locator.getId_subjects(), data.getSubjects());
            common.pressReturn();
        }
    }

    private void clickHobbies(){
        if (data.getHobbies() != "") {
            common.clickCheckBtn(locator.getXpath_hobbies());
        }
    }

    private void enterImage(){
        if (data.getImage() != "") {
            common.enterTextById(locator.getId_image(), data.getImage());
        }
    }

    private void enterAddress(){
        if (data.getAddress() != "") {

            common.enterTextById(locator.getId_address(), data.getAddress());
        }
    }

    private void selectState(){
        if (data.getState() != "") {
            common.scrollDown();
            //common.clickBtnById(locator.getId_state());
            common.clickBtnByXpath(locator.getXpath_stateValue());
            common.pressReturn();
        }
    }

    private void selectCity(){
        if (data.getCity() != "") {
            common.clickBtnByXpath(locator.getXpath_cityValue());
            common.pressReturn();
        }
    }

    private void clickSubmit(){
        common.clickBtnById(locator.getId_submitBtn());
    }

    private void clickCloseBtn(){
        common.clickBtnById(locator.getId_closeBtn());
    }

}
