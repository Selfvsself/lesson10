package ru.homework.aplana.pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.homework.aplana.Basket;
import ru.homework.aplana.Product;
import ru.homework.aplana.steps.Hooks;
import ru.homework.aplana.utils.TestProperties;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BasePage {
    WebDriver driver;

    @FindBy(xpath = "//input[@data-test-id='header-search-input']")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[@data-test-id='header-search-go']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//a[@href='/cart']")
    private WebElement basket;

    public BasePage(){
        driver = Hooks.getDriver();
        PageFactory.initElements(driver, this);
        Basket.getBasket();
    }

    public void searchItem(String nameItem) {
        fillField(inputSearch, nameItem);
        click(buttonSearch);
    }

    public void fillField(WebElement element, String value)  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        while (!element.getAttribute("value").equals("")) {
            element.sendKeys(Keys.BACK_SPACE);
        }
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }

    public void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        Wait<WebDriver> wait = new WebDriverWait(driver, Integer.parseInt(TestProperties.getInstance().getProperties().getProperty("test.wait.for.until")));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void selectByValue(WebElement element, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public String getText(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        return element.getText();
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void goToBasket() {
        click(basket);
    }

    public void printReport() {
        getByte(Basket.getBasket().getAllInfo());
    }

    @Attachment
    public static String getByte(String report) {
        return report;
    }
}
