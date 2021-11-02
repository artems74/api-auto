package main.java.ru.catapi.api.services;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.java.ru.catapi.api.models.response.ImageResponse;
import main.java.ru.catapi.api.utils.UrlFormatter;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * Class providing access to image api methods
 */
public class ImageApiService {
    private static final RequestSpecification GET_SPEC;

    static {
        GET_SPEC = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://api.thecatapi.com")
                .addFilter(new AllureRestAssured())
                .build();
    }

    /**
     * Search image by specified breed id
     * @param breedId - breed id
     * @return ImageResponse object containing image id, url
     */
    public static ImageResponse getImageByBreedId(String breedId) {
        Response image =
                given()
                        .spec(GET_SPEC)
                .when()
                        .param("breed_id", breedId)
                        .get(UrlFormatter.getImagesUrl())
                .then()
                        .statusCode(200)
                .extract().response();
        List<String> imageId = image.path("id");
        List<String> imageUrl = image.path("url");
        return new ImageResponse(imageId.get(0), imageUrl.get(0));
    }
}
