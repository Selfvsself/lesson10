package ru.homework.aplana.steps;

import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;
import ru.homework.aplana.pages.MainPage;

public class MainSteps {

    MainPage mainPage = new MainPage();

    @Когда("Выполните поиск по \"(.+)\"")
    @Step("Выполняем поиск продукта - {0}")
    public void stepSearchItem(String item) {
        mainPage.searchItem(item);
    }

    @Когда("Перейти в корзину")
    @Step("Перешли в корзину")
    public void gotoBasket() {
        mainPage.goToBasket();
    }

    @Когда("Добавить отчет")
    @Step("Товары положенные в корзину")
    public void printReport() {
        mainPage.printReport();
    }
}
