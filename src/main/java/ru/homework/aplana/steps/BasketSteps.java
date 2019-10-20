package ru.homework.aplana.steps;

import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;
import org.junit.Assert;
import ru.homework.aplana.pages.BasketPage;

public class BasketSteps {
    BasketPage basketPage = new BasketPage();

    @Когда("Сравнить наличие товаров в корзине")
    @Step("Сравниваем наличие купленных товаров")
    public void compareBasket() {
        Assert.assertTrue(basketPage.compareBasket());
    }

    @Когда("Сравнить количество товаров в корзине")
    @Step("Сравниваем количество купленных товаров")
    public void compareNumberProduct() {
        Assert.assertTrue(basketPage.compareNumberProduct());
    }

    @Когда("Удалить все товары из корзины")
    @Step("Удаляем все товары из корзины")
    public void deleteAllProductOnBasket() {
        basketPage.deleteAllProduct();
    }

    @Когда("Проверить что корзина пуста")
    @Step("Проверяем что корзина пуста")
    public void checkIsEmptyBasket() {
        basketPage.checkEmptyBasket();
    }
}
