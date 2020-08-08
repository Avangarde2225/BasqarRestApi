import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.http.Cookies;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class CountryTest {


    private Cookies cookies;

    @BeforeClass
    public void authenticate(){
        RestAssured.baseURI="https://basqar.techno.study";
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username","nigeria_tenant_admin");
        credentials.put("password","TnvLOl54WxR75vylop2A");

         cookies = given()
                .body(credentials)
                .contentType(ContentType.JSON)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .extract().response().getDetailedCookies();
        System.out.println(cookies.asList());
    }

    @Test
    public void getBasePath(){
        given()
                .when()

                .then()
        .statusCode(200)
        ;
    }



    @Test
    public void getCountries(){
    given()
            .cookies(cookies)
            .when()
            .get("/school-service/api/countries")
            .then()
    .statusCode(200)
    ;

}
}
