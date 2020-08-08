import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class CountryTest {



    @BeforeClass
    public void authenticate(){
        RestAssured.baseURI="https://basqar.techno.study";
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username","nigeria_tenant_admin");
        credentials.put("password","TnvLOl54WxR75vylop2A");

        given()
                .body(credentials)
                .contentType(ContentType.JSON)
                .when()
                .post("/auth/login")
                .then()
        .statusCode(200)
        ;
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
            .when()
            .get("/school-service/api/countries")
            .then()
    .statusCode(200)
    ;

}
}
