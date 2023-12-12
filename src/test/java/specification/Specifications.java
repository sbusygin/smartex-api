package specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class Specifications {

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("https://semiautoqatz.pcvr-stg.smartex-it.com")//---> Base URL
                .setRelaxedHTTPSValidation()//Можно отключить проверку сертификата
                .setContentType(JSON)// Установка Content Type
                .build();
    }

//    Можно написать спецификацию для ответа
//    public static ResponseSpecification responseSpecificationScOk()
}
