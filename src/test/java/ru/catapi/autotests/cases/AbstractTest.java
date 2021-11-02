package test.java.ru.catapi.autotests.cases;

import io.qameta.allure.Attachment;

public class AbstractTest {

    @Attachment
    public static String getResources(String... resourceName) {
        StringBuilder result = new StringBuilder();
        for (String resource : resourceName) {
            result.append(resource).append("\n");
        }
        return result.toString();
    }
}
