package test.java.ru.catapi.autotests.cases;

import io.qameta.allure.Step;
import main.java.ru.catapi.api.models.response.CategoriesResponse;
import main.java.ru.catapi.api.services.CategoryApiService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTest {

    @Test
    public void testMethod() {
        getCategoriesId1Step();
    }

    @Step("Step 1: Get Categories list")
    public void getCategoriesId1Step() {
        String expectedCategoryName = "boxes";
        System.out.println("STEP 4: START");
        CategoriesResponse categoriesResponse = CategoryApiService.getCategories();
        System.out.println(categoriesResponse.getId());
        System.out.println(categoriesResponse.getName());
        Assert.assertTrue(categoriesResponse.getName().contains(expectedCategoryName));
        System.out.println("STEP 4: END");
    }
}
