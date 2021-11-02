package test.java.ru.catapi.autotests.cases;

import io.qameta.allure.Step;
import main.java.ru.catapi.api.models.response.CategoriesResponse;
import main.java.ru.catapi.api.services.CategoryApiService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTest extends AbstractTest {

    @Test
    public void testMethod() {
        getCategoriesId1Step("boxes");
    }

    @Step("Step 1: Get Categories list")
    public void getCategoriesId1Step(String expectedCategoryName) {
        CategoriesResponse categoriesResponse = CategoryApiService.getCategories();
        Assert.assertTrue(categoriesResponse.getName().contains(expectedCategoryName));
    }
}
