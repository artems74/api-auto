package main.java.ru.catapi.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoriesResponse {
    private List<Integer> id;
    private List<String> name;
}
