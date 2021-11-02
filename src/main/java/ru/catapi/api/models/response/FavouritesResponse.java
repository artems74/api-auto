package main.java.ru.catapi.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FavouritesResponse {
    private List<Integer> favouriteId;
    private List<String> imageId;
    private List<String> imageUrl;
}
