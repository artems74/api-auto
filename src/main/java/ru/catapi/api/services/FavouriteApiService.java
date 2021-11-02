package main.java.ru.catapi.api.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.java.ru.catapi.api.auth.ApiKeyModel;
import main.java.ru.catapi.api.models.request.FavouritesRequest;
import main.java.ru.catapi.api.models.response.FavouritesResponse;
import main.java.ru.catapi.api.utils.UrlFormatter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FavouriteApiService {

    private static final RequestSpecification GET_SPEC;
    private static final ApiKeyModel API_KEY;

    static {
        GET_SPEC = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(UrlFormatter.API_BASE_URL)
                .build();

        API_KEY = new ApiKeyModel(System.getProperty("apiKey"));
    }

    public static Integer postFavouriteImageById(String id) {
        return given()
                        .spec(GET_SPEC)
                        .header(ApiKeyModel.KEY_NAME, API_KEY.getKeyValue())
                        .body(new FavouritesRequest(id))
                .when()
                        .post(UrlFormatter.getFavouritesUrl())
                .then()
                        .statusCode(200)
                        .body("message", equalTo("SUCCESS"))
                .extract().path("id");
    }

    public static FavouritesResponse getFavouritesImages() {
        Response favourites =
                given()
                        .spec(GET_SPEC)
                        .header(ApiKeyModel.KEY_NAME, API_KEY.getKeyValue())
                .when()
                        .get(UrlFormatter.getFavouritesUrl())
                .then()
                        .statusCode(200)
                .extract().response();
        return new FavouritesResponse(favourites.path("id"),
                favourites.path("image_id"),
                favourites.path("url"));
    }

    public static void deleteFavouriteImageByIdIfExist(Integer id) {
        // TODO: implement method
    }

    public static void deleteFavouriteImageById(Integer id) {
        given()
                .spec(GET_SPEC)
                .header(ApiKeyModel.KEY_NAME, API_KEY.getKeyValue())
        .when()
                .delete(UrlFormatter.getDeleteFavouriteUrl(id))
        .then()
                .statusCode(200)
                .body("message", equalTo("SUCCESS"));
    }
}
