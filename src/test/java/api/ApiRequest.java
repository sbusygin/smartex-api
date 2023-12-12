package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static specification.Specifications.requestSpecification;

public class ApiRequest {

    public Response postApiTokenAuth(String userName, String password) {
        return RestAssured.given()
                .spec(requestSpecification())
                .header("picvario-api-host", "semiautoqatz.pcvr-stg-api.smartex-it.com")
                .body("{\n" +
                        " \"username\": \""+ userName +"\",\n" +
                        " \"password\": \""+ password +"\",\n" +
                        " \"captcha\": \"\"\n" +
                        "}")
                .post("/api-token-auth/");
    }

    public Response getIsAuth(String token) {
        return RestAssured.given()
                .spec(requestSpecification())
                .header("picvario-api-host", "semiautoqatz.pcvr-stg-api.smartex-it.com")
                .header("authorization", "Token "+ token)
                .get("/api/v1/users/is_auth");
    }

    public Response postContentImport(String token) {
        return RestAssured.given()
                .spec(requestSpecification())
                .header("picvario-api-host", "semiautoqatz.pcvr-stg-api.smartex-it.com")
                .header("authorization", "Token "+ token)
                .body(" {\n" +
                        "        \"title\": \"QABUSYGIN\",\n" +
                        "        \"content_type\": \"2\",\n" +
                        "        \"target_collections\": [\n" +
                        "            {\n" +
                        "                \"title\": \"QABYSYGIN\"\n" +
                        "            }\n" +
                        "        ],\n" +
                        "        \"total_size\": 791872,\n" +
                        "        \"assets\": [\n" +
                        "            {\n" +
                        "                \"tags\": [],\n" +
                        "                \"file_name\": \"img1.jpg\"\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"tags\": [],\n" +
                        "                \"file_name\": \"img2.jpg\"\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }")
                .post("/api/v1/content_import/collections/");
    }
}
