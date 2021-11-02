package test.java.ru.catapi.autotests.docs.cases;

import io.qameta.allure.Step;
import main.java.ru.catapi.api.models.response.FavouritesResponse;
import main.java.ru.catapi.api.models.response.ImageResponse;
import main.java.ru.catapi.api.services.BreedApiService;
import main.java.ru.catapi.api.services.FavouriteApiService;
import main.java.ru.catapi.api.services.ImageApiService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatApiTest {
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
        System.out.println("STEP 1: START");
        this.breedId = BreedApiService.getBreedIdByName(breedName);
        System.out.println("STEP 1: " + this.breedId);
        System.out.println("STEP 1: END");
    }

    @Step("Step 2: Get image id, url")
    public void getBreedId2Step() {
        System.out.println("STEP 2: START");
        ImageResponse image = ImageApiService.getImageByBreedId(this.breedId);
        this.imageId = image.getId();
        this.imageUrl = image.getUrl();
        System.out.println("STEP 2: " + this.imageId);
        System.out.println("STEP 2: " + this.imageUrl);
        System.out.println("STEP 2: END");
    }

    @Step("Step 3: Post image to favourites")
    public void postImgToFavourites3Step() {
        System.out.println("STEP 3: START");
        this.favouriteId = FavouriteApiService.postFavouriteImageById(this.imageId);
        System.out.println("STEP 3: " + this.favouriteId);
        System.out.println("STEP 3: END");
    }

    @Step("Step 4: Get favourite images")
    public void getFavouriteImg4Step() {
        System.out.println("STEP 4: START");
        FavouritesResponse favouritesResponse = FavouriteApiService.getFavouritesImages();
        System.out.println(favouritesResponse.getFavouriteId());
        Assert.assertTrue(favouritesResponse.getFavouriteId().contains(this.favouriteId));
        Assert.assertTrue(favouritesResponse.getImageId().contains(this.imageId));
        System.out.println("STEP 4: END");
    }

    @Step("Step 5: Delete favourite image")
    public void deleteFavouriteImage5Step() {
        System.out.println("STEP 5: START");
        FavouriteApiService.deleteFavouriteImageById(this.favouriteId);
        System.out.println("STEP 5: END");
    }

    @Step("Step 6:")
    public void getFavouriteImg6Step() {
        System.out.println("STEP 6: START");
        FavouritesResponse favouritesResponse = FavouriteApiService.getFavouritesImages();
        System.out.println(favouritesResponse.getFavouriteId());
        Assert.assertFalse(favouritesResponse.getFavouriteId().contains(this.favouriteId));
        System.out.println("STEP 6: END");
    }
}
