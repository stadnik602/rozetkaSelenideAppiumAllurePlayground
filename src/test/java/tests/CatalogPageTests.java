package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.qameta.allure.Description;
import pages.CatalogPage;
import pages.MainPage;
import util.WordingUtil;

public class CatalogPageTests extends BaseTest {

    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();

    @Description("Categories match with titles")
    @DisplayName("16 categories should be displayed on the Category page")
    @Test
    public void testCategories16items() {
        List<String> categoriesNameExpected = Stream.of(
                "Ноутбуки та комп’ютери", "Смартфони, ТВ і електроніка", "Товари для геймерів",
                "Побутова техніка", "Товари для дому", "Інструменти та автотовари",
                "Сантехніка та ремонт", "Дача, сад і город", "Спорт і захоплення",
                "Одяг, взуття та прикраси", "Краса та здоров’я", "Дитячі товари", "Зоотовари",
                "Офіс, школа, книги", "Алкогольні напої та продукти", "Нашим захисникам")
                .map(WordingUtil::toEncodedUtf8String)
                .collect(Collectors.toList());
        mainPage.closePopUp().openCatalog().checkCategoriesHaveTexts(categoriesNameExpected);
        catalogPage.isMainMenuIconSelected();
    }


}
