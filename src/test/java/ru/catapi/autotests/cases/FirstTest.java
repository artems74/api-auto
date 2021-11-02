package test.java.ru.catapi.autotests.cases;

import io.qameta.allure.Step;
import main.java.ru.catapi.api.models.response.FavouritesResponse;
import main.java.ru.catapi.api.models.response.ImageResponse;
import main.java.ru.catapi.api.services.BreedApiService;
import main.java.ru.catapi.api.services.FavouriteApiService;
import main.java.ru.catapi.api.services.ImageApiService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {
    private String breedId;
    private String imageId;
    private String imageUrl;
    private Integer favouriteId;

    @Test
    public void testMethod() {
        String breedName = "Australian Mist";
        getBreedId1Step(breedName);
        getBreedId2Step();
        postImgToFavourites3Step();
        getFavouriteImg4Step();
        deleteFavouriteImage5Step();
        getFavouriteImg6Step();
    }

    @Step("Step 1: Get breed id")
    public void getBreedId1Step(String breedName) {
        this.breedId = BreedApiService.getBreedIdByName(breedName);
    }

    @Step("Step 2: Get image id, url")
    public void getBreedId2Step() {
        ImageResponse image = ImageApiService.getImageByBreedId(this.breedId);
        this.imageId = image.getId();
        this.imageUrl = image.getUrl();
    }

    @Step("Step 3: Post image to favourites")
    public void postImgToFavourites3Step() {
        this.favouriteId = FavouriteApiService.postFavouriteImageById(this.imageId);
    }

    @Step("Step 4: Get favourite images")
    public void getFavouriteImg4Step() {
        FavouritesResponse favouritesResponse = FavouriteApiService.getFavouritesImages();
        Assert.assertTrue(favouritesResponse.getFavouriteId().contains(this.favouriteId));
        Assert.assertTrue(favouritesResponse.getImageId().contains(this.imageId));
    }

    @Step("Step 5: Delete favourite image")
    public void deleteFavouriteImage5Step() {
        FavouriteApiService.deleteFavouriteImageById(this.favouriteId);
    }

    @Step("Step 6:")
    public void getFavouriteImg6Step() {
        FavouritesResponse favouritesResponse = FavouriteApiService.getFavouritesImages();
        Assert.assertFalse(favouritesResponse.getFavouriteId().contains(this.favouriteId));
    }
}
