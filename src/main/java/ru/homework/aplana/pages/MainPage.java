package ru.homework.aplana.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class='cookies-info']/button")
    private WebElement closeCookieInfo;

    public MainPage() {
        super();
        click(closeCookieInfo);
    }


}
