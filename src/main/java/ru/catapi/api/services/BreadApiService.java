package main.java.ru.catapi.api.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import main.java.ru.catapi.api.utils.UrlFormatter;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BreadApiService {
    private static final RequestSpecification GET_SPEC;

    static {
        GET_SPEC = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(UrlFormatter.API_BASE_URL)
                .build();
    }

    public static String getBreedIdByName(String name) {
        List<String> breedId =
                given()
                        .spec(GET_SPEC)
                .when()
                        .param("q", name)
                        .get(UrlFormatter.getBreedsUrl())
                .then()
                        .statusCode(200)
                .extract().path("id");
        return breedId.get(0);
    }
}
