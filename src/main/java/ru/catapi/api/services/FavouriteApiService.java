package main.java.ru.catapi.api.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.java.ru.catapi.api.models.request.FavouritesRequest;
import main.java.ru.catapi.api.models.response.FavouritesResponse;
import main.java.ru.catapi.api.utils.UrlFormatter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FavouriteApiService {

    private static final RequestSpecification GET_SPEC;

    static {
        GET_SPEC = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(UrlFormatter.API_BASE_URL)
                .build();
    }

    public static Integer postFavouriteImageById(String id) {
        return given()
                        .spec(GET_SPEC)
                        .header("x-api-key", "c2219f23-4e6d-4a2d-b44f-b8f38aa35ea8")
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
                        .header("x-api-key", "c2219f23-4e6d-4a2d-b44f-b8f38aa35ea8")
                .when()
                        .get(UrlFormatter.getFavouritesUrl())
                .then()
                        .statusCode(200)
                .extract().response();
        return new FavouritesResponse(favourites.path("id"),
                favourites.path("image_id"),
                favourites.path("url"));
    }

    public static void deleteFavouriteImageById(Integer id) {
        given()
                .spec(GET_SPEC)
                .header("x-api-key", "c2219f23-4e6d-4a2d-b44f-b8f38aa35ea8")
        .when()
                .delete(UrlFormatter.getDeleteFavouriteUrl(id))
        .then()
                .statusCode(200)
                .body("message", equalTo("SUCCESS"));
    }
}
