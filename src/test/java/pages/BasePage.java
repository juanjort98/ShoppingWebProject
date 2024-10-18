package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    static {
        WebDriverManager.chromedriver().setup();
        ;
        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void navigateToPage(String url) {
        driver.get(url);
    }

    public WebElement findLocator(String locator) {
        
        WebElement findedLocator = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        return findedLocator;
    }

    

    public void clickElement(String locator) {
        findLocator(locator).click();
    }

    public void write(String locator, String textToWrite) {
        findLocator(locator).clear();
        findLocator(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String value) {
        Select dropdown = new Select(findLocator(locator));
        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(String locator, int index) {
        Select dropdown = new Select(findLocator(locator));
        dropdown.selectByIndex(index);
    }

    public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(findLocator(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> dropdownValues = new ArrayList<>();
        for (WebElement options : dropdownOptions) {
            dropdownValues.add(options.getText());
        }
        return dropdownValues;
    }

    public boolean isElementPresent(String locator) {

        try {

            WebElement element = findLocator(locator);
            return element != null;

        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void scrollToElement(String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", findLocator(locator));
        wait.until(ExpectedConditions.elementToBeClickable(findLocator(locator)));
    }

    public void hoverElement(String locator){

        Actions builder = new Actions(driver);
        builder.moveToElement(findLocator(locator)).perform();;

    }

    public static void closeBrowser() {
        driver.quit();
    }
}
