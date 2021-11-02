package main.java.ru.catapi.api.utils;

/**
 * CLass for formatting urls
 */
public class UrlFormatter {
    public static final String API_BASE_URL = "https://api.thecatapi.com";
    public static final String API_VERSION  = "v1";
    public static final String BREADS_METHODS  = "breeds";
    public static final String IMAGES_METHODS  = "images";
    public static final String FAVOURITES_METHODS  = "favourites";
    public static final String CATEGORIES_METHODS  = "categories";

    public static String getBreedsUrl() {
        return String.format("%s/%s/%s/search", API_BASE_URL, API_VERSION, BREADS_METHODS);
    }

    public static String getImagesUrl() {
        return String.format("%s/%s/%s/search", API_BASE_URL, API_VERSION, IMAGES_METHODS);
    }

    public static String getFavouritesUrl() {
        return String.format("%s/%s/%s", API_BASE_URL, API_VERSION, FAVOURITES_METHODS);
    }

    public static String getDeleteFavouriteUrl(Integer id) {
        return String.format("%s/%d", getFavouritesUrl(), id);
    }

    public static String getCategoriesUrl() {
        return String.format("%s/%s/%s", API_BASE_URL, API_VERSION, CATEGORIES_METHODS);
    }
}
