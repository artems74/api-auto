package main.java.ru.catapi.api.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class ApiKeyModel {
    @ToString.Exclude
    public static final String KEY_NAME = "x-api-key";
    private String keyValue;
}
