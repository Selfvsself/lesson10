package ru.homework.aplana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.homework.aplana.Basket;
import ru.homework.aplana.Product;
import ru.homework.aplana.utils.TestProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BasketPage extends BasePage {

    @FindBy(xpath = "//div[@class='cart-item']")
    private List<WebElement> listBuyingProduct;

    @FindBy(xpath = "//span[@class='total-middle-header-text']")
    private WebElement totalProduct;

    @FindBy(xpath = "//button[@data-test-id='checkcart-confirm-modal-confirm-button']")
    private WebElement acceptDelete;

    @FindBy(xpath = "//h1[contains(text(),'Корзина пуста')]")
    private List<WebElement> textEmptyBasket;

    public BasketPage() {
        super();
        waitDeleteProduct(0);
    }

    public boolean compareBasket() {
        ArrayList<Product> factBasket = getFactBasket();
        return Basket.getBasket().equals(factBasket);
    }

    public boolean compareNumberProduct() {
        return totalProduct.getText().contains(Basket.getBasket().getSize() + " товар");
    }

    public void deleteAllProduct() {
        while (listBuyingProduct.size() > 0) {
            int sizeBasket = listBuyingProduct.size();
            WebElement buttonDelete = listBuyingProduct.get(0).findElement(By.xpath(".//span[contains(text(), 'Удалить')]"));
            click(buttonDelete);
            click(acceptDelete);
            waitDeleteProduct(sizeBasket);
        }
    }

    public boolean checkEmptyBasket() {
        return (textEmptyBasket.size() == 1 && listBuyingProduct.size() == 0);
    }

    private ArrayList<Product> getFactBasket() {
        ArrayList<Product> arrayList = new ArrayList<>();
        for (WebElement element : listBuyingProduct) {
            WebElement title = element.findElement(By.xpath(".//a[@class='title']/span"));
            WebElement price = element.findElements(By.xpath(".//div[@class='price-block-part']/span")).get(0);
            Product product = new Product();
            product.setName(title.getText());
            product.setPrice(price.getText());
            arrayList.add(product);
        }
        return arrayList;
    }

    void waitDeleteProduct(int sizeList) {
        new WebDriverWait(driver, Integer.parseInt(TestProperties.getInstance().getProperties().getProperty("test.wait.for.until"))).until(new Function<WebDriver, Object>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return listBuyingProduct.size() != sizeList;
            }
        });
    }
}
