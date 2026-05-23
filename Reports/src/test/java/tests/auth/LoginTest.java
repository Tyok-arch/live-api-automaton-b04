package tests.auth;

import body.auth.LoginBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.io.FileWriter;
import java.io.IOException;

public class LoginTest {

    @Test
    public void loginTest() throws IOException {

        // set base uri
        RestAssured.baseURI =
                ConfigReader.getProperty("baseUrl");

        // generate payload login
        LoginBody loginBody = new LoginBody();

        // hit endpoint
        Response response = RestAssured.given()

                .header(
                        "Content-Type",
                        "application/json"
                )

                .body(
                        loginBody.loginData().toJSONString()
                )

                .when()
                .post("/v1/login")

                .then()
                .extract()
                .response();

        // print response
        System.out.println(
                "Response : " +
                        response.asPrettyString()
        );

        // extract token
        String token =
                response.jsonPath().getString("data.token");

        System.out.println("Token : " + token);

        // save token to json
        JSONObject tokenJson = new JSONObject();

        tokenJson.put("token", token);

        try (
                FileWriter file =
                        new FileWriter(
                                "src/main/resources/json/token.json"
                        )
        ) {

            file.write(
                    tokenJson.toJSONString()
            );

            file.flush();
        }

        System.out.println(
                "Token saved to token.json"
        );
    }
}