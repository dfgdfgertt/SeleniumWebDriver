package Resource;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonPage {

    private static CommonPage singleton = null;
    private WebDriver driver = new ChromeDriver();
    private String url = "https://demoqa.com/";
    private WebDriverWait wait = new WebDriverWait(driver,30);
    Actions key = new Actions(driver);

    public void goTo(String urlPath){
        driver.get(url+urlPath);
    }

    public void enterTextById(String id,String text){
        findElementById(id).sendKeys(text);
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
