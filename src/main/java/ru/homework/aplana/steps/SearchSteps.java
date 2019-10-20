package ru.homework.aplana.steps;

import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;
import ru.homework.aplana.pages.SearchPage;

public class SearchSteps {
    SearchPage searchPage = new SearchPage();

    @Когда("Ограничить поле \"(.+)\" от \"(.+)\"")
    @Step("Ограничиваем товары по полю {0} от {1}")
    public void selectRangeFrom(String nameFiled, String value) {
        searchPage.selectRangeFrom(nameFiled, "от", value);
    }

    @Когда("Ограничить поле \"(.+)\" до \"(.+)\"")
    @Step("Ограничиваем товары по полю {0} до {1}")
    public void selectRangeUp(String nameFiled, String value) {
        searchPage.selectRangeFrom(nameFiled, "до", value);
    }

    @Когда("Отметить чекбокс \"(.+)\"")
    @Step("Отмечаем checkbox {0}")
    public void clickCheckbox(String nameFiled) {
        searchPage.clickCheckBox(nameFiled);
    }

    @Когда("Добавить в корзину первые \"(.+)\" нечетных")
    @Step("Добавить в корзину первые {0} нечетных")
    public void addToCardOdd(int maxProduct) {
        searchPage.buyFirstEightProduct(0, maxProduct);
    }

    @Когда("Добавить в корзину первые \"(.+)\" четных")
    @Step("Добавить в корзину первые {0} четные")
    public void addToCardEven(int maxProduct) {
        searchPage.buyFirstEightProduct(1, maxProduct);
    }

    @Когда("Выбрать бренд \"(.+)\"")
    @Step("Выбираем бренд {0}")
    public void clickShowAll(String nameBrand) {
        searchPage.selectBrandProduct(nameBrand);
    }
}
