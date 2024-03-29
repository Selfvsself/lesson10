import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/*
Итоговое задание
Сценарий 1
 1 Перейдите на сервис http://www.ozon.ru (http://www.ozon.ru/)/
 2 Выполните поиск по «iphone»
 3 Ограничить цену до 60 000
 4 Отметить чекбокс – Высокий рейтинг
 5 Отметить чекбокс – 3Гб
 6 Из результатов поиска добавьте в корзину первые 8 нечетных  товаров.
 7 Запомнить название товаров
 8 Перейдите в корзину, убедитесь, что все добавленные ранее товары находятся в корзине
 9 Проверить, что отображается текст «Ваша корзина  - 8 товаров»
 10 Удалите все товары из корзины
 11 Проверьте, что корзина не содержит никаких товаров
 12 В аллюр отчет добавить шаг, в котором будет приложен файл с информацией о всех добавленных товарах (наименование и цена). Также указать товар с наибольшей ценой.
Сценарий 2
 1 Перейдите на сервис http://www.ozon.ru (http://www.ozon.ru/)/
 2 Выполните поиск по «беспроводные наушники»
 3 Ограничить цену – до 10 000
 4 Бренды : Beats, Samsung
       4.1 Отметить чекбокс - Высокий рейтинг
 5 Из результатов поиска добавьте в корзину первые 8 четных товаров.
 6 Перейдите в корзину, убедитесь, что все добавленные ранее товары находятся в корзине
 7 Запомнить название товаров
 8 Перейдите в корзину, убедитесь, что все добавленные ранее товары находятся в корзине
 9 Проверить, что отображается текст «Ваша корзина  - 8 товаров»
 10 Удалите все товары из корзины
 11 Проверьте, что корзина не содержит никаких товаров
 12 В аллюр отчет добавить шаг, в котором будет приложен файл с информацией о всех добавленных товарах (наименование и цена). Также указать товар с наибольшей ценой.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "ru.homework.aplana.steps"
)
public class CucumberRunner {
}
