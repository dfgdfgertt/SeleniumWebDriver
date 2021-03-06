package Resource;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class CommonPage {

    private static CommonPage singleton = null;

    public WebDriver driver(){
        System.setProperty("webdriver.chrome.driver", "/driver/chromedriver");
        String downloadFilepath = "//User//username//automation-testing//";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("disable-popup-blocking");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cap);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    private WebDriver driver = driver();

    private String url = "https://demoqa.com/";
    private WebDriverWait wait = new WebDriverWait(driver,30);
    Actions key = new Actions(driver);

    public void goTo(String urlPath){
        driver.get(url+urlPath);
        driver.manage().window().maximize();
    }

    public void enterTextById(String id,String text){
        findElementById(id).sendKeys(text);
    }

    public String getText(String id){
        return findElementById(id).getText();
    }

    public void clickBtnById(String id){
        findElementById(id).click();
    }

    public void clickBtnByXpath(String xpath){
        findElementByXpath(xpath).click();
    }

    public void waitElementById(String id){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public void waitElementByIXpath(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }


    public WebElement findElementById(String id){
        return driver.findElement(By.id(id));
    }

    public WebElement findElementByXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }

    public void quitBrowser(){
        driver.quit();
    }

    public static CommonPage getInstanse(){
        if(singleton == null){
            singleton = new CommonPage();
        }
        return singleton;
    }

    public void clickCheckBtn(String xpath){
        WebElement ele =  driver.findElement(By.xpath(xpath));
        JavascriptExecutor eleExe = (JavascriptExecutor) driver;
        eleExe.executeScript("arguments[0].click()",ele);
    }

    public void pressReturn(){

        key.sendKeys(String.valueOf(Keys.RETURN)).perform();
    }
    public void pressDown(){
        key.sendKeys(String.valueOf(Keys.DOWN)).perform();
    }

    public void scrollDown(){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
