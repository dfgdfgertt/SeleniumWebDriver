package TestSuite;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EnterForm {
    private WebDriver driver = new ChromeDriver();
    private String url = "https://demoqa.com/";
    private WebDriverWait wait = new WebDriverWait(driver,30);

    @BeforeTest
    public void setUp(){
        String userName = "dfgdfgertt";
        String password = "xiaolinchanneoAB3#";
        goTo("login");

        enterTextById("userName",userName);
        enterTextById("password",password);
        clickBtnById("login");
        waitElementById("userName-value");

//        driver.findElement(By.id("userName")).sendKeys(userName);
//        driver.findElement(By.id("password")).sendKeys(password);
//        driver.findElement(By.id("login")).click();

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName-value")));

        String result = driver.findElement(By.id("userName-value")).getText();
        Assert.assertEquals(result,userName);
    }

    @Test
    public void enterForm() throws InterruptedException {
        //value
        String firstName = "Long";
        String lastName = "Tran";
        String userMail = "thegioicualong@gmail.com";
        String userNumber = "0399498114";
        String subjects = "Maths";
        String image = "";
        String address = "thế giới của long, Hồ Thị Bưng";
        String state = "Haryana";
        String hobbies = "Music";
        String city = "Karnal";
        String day = "19";
        String month = "11";
        String year = "2003";
        //location
        String id_firstName = "firstName";
        String id_lastName = "lastName";
        String id_userMail = "userEmail";
        String id_gender = "gender-radio-1";
        String id_userNumber = "userNumber";
        String id_dateOfBirth = "dateOfBirthInput";
        String id_subjects = "subjectsInput";
        String xpath_hobbies = "//*[@id=\"hobbiesWrapper\"]/div[2]//label[contains(text(),'" + hobbies + "')]";
        String id_image = "uploadPicture";
        String id_address = "currentAddress";
        String id_submitBtn = "submit";
        String id_closeBtn = "closeLargeModal";
        String xpath_day = "//*[@class=\"react-datepicker__week\"]//div[contains(text(),'"+ day +"')]";
        String xpath_month = "//select/option[@value="+ month +"]";
        String xpath_year = "//select/option[@value='"+ year +"']";
        String xpath_subjectsClick = "//*[@id=\"subjectsContainer\"]/div[2]/div//div[contains(text(),'"+ subjects +"')]";
        String id_state = "//*[@id=\"state\"]";
        String id_city = "//*[@id=\"city\"]";
        String xpath_stateValue = "";
        String xpath_cityValue = "";




        goTo("automation-practice-form");
        enterTextById(id_firstName,firstName);
        enterTextById(id_lastName,lastName);
        enterTextById(id_userMail,userMail);
        //waitElementById(id_gender);
        WebElement gender =  driver.findElement(By.xpath("//*[@id=\"gender-radio-1\"]"));
        JavascriptExecutor jGender = (JavascriptExecutor) driver;
        jGender.executeScript("arguments[0].click()",gender);
        //driver.findElement(By.cssSelector("#gender-radio-1")).click();
        //clickBtnById(id_gender);
        enterTextById(id_userNumber,userNumber);
        //driver.findElement(By.id(id_dateOfBirth)).clear();
        findElementById(id_dateOfBirth).click();
        //select/option[@value='2003']
        //select/option[@value=10]
        //*[@class="react-datepicker__week"]//div[contains(text(),'19')]

        clickBtnByXpath(xpath_year);
        clickBtnByXpath(xpath_month);
        clickBtnByXpath(xpath_day);
        enterTextById(id_subjects,subjects);
        //selectByVisibleText(id_subjects,subjects);
        enterTextById(id_subjects, String.valueOf(Keys.RETURN));
        //clickBtnByXpath(xpath_subjectsClick);
        WebElement eleHobbies =  driver.findElement(By.xpath(xpath_hobbies));
        JavascriptExecutor jHobbies = (JavascriptExecutor) driver;
        jHobbies.executeScript("arguments[0].click()",eleHobbies);
        //enterTextById(id_image,image);
        enterTextById(id_address,address);
        jHobbies.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        clickBtnByXpath(id_state);
        Actions keyDown = new Actions(driver);
        //keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();
        keyDown.sendKeys(String.valueOf(Keys.RETURN)).perform();
        //selectByVisibleText(id_state,state);
        clickBtnByXpath(id_city);
        keyDown.sendKeys(String.valueOf(Keys.RETURN)).perform();
       // selectByVisibleText(id_city,city);
        clickBtnById(id_submitBtn);


//
//        driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select/option[104]")).click();
//        driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/option[11]")).click();
//        driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[4]")).click();
        //driver.findElement(By.cssSelector(".react-datepicker__year-select"));
        //enterTextById(id_dateOfBirth,"19nov1998");




    }
//
//    @AfterTest
//    public void tearDown(){
//        String btnLogoutXpath = "//*[@id=\"books-wrapper\"]//*[@id=\"submit\"]";
//        goTo("profile");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnLogoutXpath)));
//        driver.findElement(By.xpath(btnLogoutXpath)).click();
//        driver.quit();
//    }


    public void selectByVisibleText (String xpath, String text) throws InterruptedException {
        Select sl = new Select(driver.findElement(By.xpath(xpath)));
        sl.selectByVisibleText(text);
        Thread.sleep(5000);
    }

    public void clickBtnByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void goTo(String urlPath){
        driver.get(url+urlPath);
    }

    public void enterTextById(String id,String text){
        findElementById(id).sendKeys(text);
    }

    public void clickBtnById(String id){
        findElementById(id).click();
    }

    public void waitElementById(String id){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public WebElement findElementById(String id){
        return driver.findElement(By.id(id));
    }




}
