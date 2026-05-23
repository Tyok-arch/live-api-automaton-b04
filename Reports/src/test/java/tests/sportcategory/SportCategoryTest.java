package tests.sportcategory;
import base.BaseTest;
import body.sportcategory.SportCategoryBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TokenHelper;

public class SportCategoryTest extends BaseTest {

    String categoryId;

    @Test
    public void createSportCategoryTest() {

        // get token
        String token = TokenHelper.getToken();

        // generate random name
        String randomName =
                "Sport_" + System.currentTimeMillis();

        // generate body
        SportCategoryBody sportCategoryBody =
                new SportCategoryBody();

        // hit endpoint
        Response response = RestAssured.given()

                .header(
                        "Authorization",
                        "Bearer " + token
                )

                .header(
                        "Content-Type",
                        "application/json"
                )

                .body(
                        sportCategoryBody
                                .createSportCategoryData(randomName)
                                .toJSONString()
                )

                .when()
                .post("/v1/sport-categories/create")

                .then()
                .extract()
                .response();

        // print response
        System.out.println(
                "Create response : " +
                        response.asPrettyString()
        );

        // get category id
        categoryId =
                response.jsonPath()
                        .getString("result.id");

        // assertion
        Assert.assertNotNull(
                categoryId,
                "Category id should not be null"
        );

        System.out.println(
                "Create Category Id : " +
                        categoryId
        );
    }
}
