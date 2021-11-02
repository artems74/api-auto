package main.java.ru.catapi.api.services;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.java.ru.catapi.api.auth.ApiKeyModel;
import main.java.ru.catapi.api.models.response.CategoriesResponse;
import main.java.ru.catapi.api.utils.UrlFormatter;

import static io.restassured.RestAssured.given;

/**
 * Class providing access to category api methods
 */
public class CategoryApiService {

    private static final RequestSpecification GET_SPEC;
    private static final ApiKeyModel API_KEY;

    static {
        GET_SPEC = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(UrlFormatter.API_BASE_URL)
                .addFilter(new AllureRestAssured())
                .build();

        API_KEY = new ApiKeyModel(System.getProperty("apiKey"));
    }

    /**
     * Get categories list
     * @return CategoriesResponse object containing lists of categories id, name
     */
    public static CategoriesResponse getCategories() {
        Response categories =
                given()
                        .spec(GET_SPEC)
                        .header(ApiKeyModel.KEY_NAME, API_KEY.getKeyValue())
                .when()
                        .get(UrlFormatter.getCategoriesUrl())
                .then()
                        .statusCode(200)
                .extract().response();
        return new CategoriesResponse(categories.path("id"), categories.path("name"));
    }

}
