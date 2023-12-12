package test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.auth.AuthPojo;

public class TestSmartex extends BaseTest {

    @Test(description= "Тест получения токена и авторизация")
    public void testCheckCorrectData() {
        Response data = apiRequest.postApiTokenAuth("semiautoqatz@tz.com", "Pa$$w0rd!");
        data.then().assertThat().statusCode(200);

        String token = data.jsonPath().getString("token");

        Response isAuth = apiRequest.getIsAuth(token);
        isAuth.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json-schema-is-auth.json"));
        isAuth.then().assertThat().statusCode(200);

        AuthPojo authPojo = isAuth.as(AuthPojo.class);
        softAssert.assertEquals(authPojo.first_name, "T");
        softAssert.assertEquals(authPojo.last_name, "Z");
        softAssert.assertAll();

    }

    @Test(description= "Тест импорт файла")
    public void testImportFile() {
        Response data = apiRequest.postApiTokenAuth("semiautoqatz@tz.com", "Pa$$w0rd!");
        data.then().assertThat().statusCode(200);

        String token = data.jsonPath().getString("token");

        Response importData = apiRequest.postContentImport(token);
        data.then().assertThat().statusCode(200);

    }
}
