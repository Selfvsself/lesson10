package ru.homework.aplana.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.homework.aplana.Basket;
import ru.homework.aplana.Product;
import ru.homework.aplana.utils.TestProperties;

import java.util.List;
import java.util.function.Function;

public class SearchPage extends BasePage {
    public final static int RANGE_FROM = 0;
    public final static int RANGE_UP = 1;

    @FindBy(xpath = "//label[@class='checkbox-label']")
    private List<WebElement> listCheckBox;

    @FindBy(xpath = "//aside[@class='aside']/div[@class='filter m-range']")
    private List<WebElement> mRangeFilters;

    @FindBy(xpath = "//aside[@class='aside']/div[@class='filter m-bool']")
    private List<WebElement> mBoolFilters;

    @FindBy(xpath = "//div[@class='sort']//span")
    private List<WebElement> listApplyFilters;

    @FindBy(xpath = "//div[@class='tile-wrapper']")
    private List<WebElement> listProduct;

    @FindBy(xpath = "//div[@class='title']/parent::div")
    private List<WebElement> listCategoriesFilters;

    @FindBy(xpath = "//div[@class='input-wrap search-input']//input")
    private WebElement  inputSelectBrand;

    @FindBy(xpath = "//div[@class='title' and contains(text(),'Бренды')]/parent::div//span[@data-test-id='filter-block-brand-show-all']")
    private List<WebElement> listForCheckViewAllBrands;
    private String pathToClickBrand = "//span[contains(text(),'%s')]";

    public void buyFirstEightProduct(int firstProductIndex, int maxProduct) {
        int numberBuyProduct = 0;
        for (int i = firstProductIndex; i < listProduct.size(); i+=2) {
            if (numberBuyProduct == maxProduct) {
                break;
            }
            List<WebElement> buttons = listProduct.get(i).findElements(By.xpath(".//button/span[text()='В корзину']"));
            if (buttons.size() > 0) {
                WebElement title = listProduct.get(i).findElement(By.xpath(".//a[@data-test-id='tile-name']"));
                WebElement price = listProduct.get(i).findElement(By.xpath(".//span[@data-test-id='tile-price']"));
                Product product = new Product();
                product.setName(title.getText());
                product.setPrice(price.getText());
                Basket.putProduct(product);
                click(buttons.get(0));
                numberBuyProduct++;
            }
        }
    }

    public void selectBrandProduct(String nameBrand) {
        if (listForCheckViewAllBrands.size() > 0) {
            click(listForCheckViewAllBrands.get(0));
        }
        int sizeListApplyFilter = listApplyFilters.size();
        inputSelectBrand.clear();
        inputSelectBrand.sendKeys(nameBrand);
        click(driver.findElement(By.xpath(String.format(pathToClickBrand, nameBrand))));
        waitChangeFilterElement(listApplyFilters, sizeListApplyFilter);
    }

    public void selectRangeFrom(String nameField, String prefix, String value) {
        for (WebElement element : mRangeFilters) {
            WebElement titleElement = element.findElement(By.xpath(".//div[@class='title']"));
            String title = getNormalText(titleElement.getText());
            if (title.equalsIgnoreCase(nameField)) {
                List<WebElement> listSubElement = element.findElements(By.xpath("//div[@class='input-item']"));
                for (WebElement subElement : listSubElement) {
                    if (subElement.findElement(By.xpath("./label")).getText().equalsIgnoreCase(prefix)) {
                        WebElement input = subElement.findElement(By.xpath(".//input"));
                        int sizeListApplyFilter = listApplyFilters.size();
                        fillField(input, value);
                        waitChangeFilterElement(listApplyFilters, sizeListApplyFilter);
                        return;
                    }
                }
            }
        }
        Assert.fail("Нет фильтра с именем " + nameField);
    }

    public void clickCheckBox(String nameCheckBox) {
        for (WebElement element : listCheckBox) {
            WebElement title = element.findElement(By.xpath("./span[contains(@class,'text')]"));
            if (getNormalText(title.getText()).equalsIgnoreCase(getNormalText(nameCheckBox))) {
                int sizeListApplyFilter = listApplyFilters.size();
                click(element.findElement(By.xpath("./span[contains(@class,'checkmark')]")));
                waitChangeFilterElement(listApplyFilters, sizeListApplyFilter);
                return;
            }
        }
        Assert.fail("Нет chekbox с именем " + nameCheckBox);
    }

    private String getNormalText(String str) {
        StringBuilder answer = new StringBuilder();
        char[] arrayChar = str.toCharArray();
        for (char ch : arrayChar) {
            if (Character.isLetterOrDigit(ch)) {
                answer.append(ch);
            }
        }
        return answer.toString();
    }

    void waitChangeFilterElement(List<WebElement> listWebElements, int sizeList) {
        new WebDriverWait(driver, Integer.parseInt(TestProperties.getInstance().getProperties().getProperty("test.wait.for.until"))).until(new Function<WebDriver, Object>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return listWebElements.size() != sizeList;
            }
        });
    }
}
