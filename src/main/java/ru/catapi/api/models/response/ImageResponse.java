package main.java.ru.catapi.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageResponse {
    private String id;
    private String url;
}
