package requests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GET {

	@Test(enabled=true)
	void test01() {

		Response response = get("https://reqres.in/api/users");

		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		int statusCode = response.statusCode();
		AssertJUnit.assertEquals(statusCode, 200);
	}

	@Test(enabled=true)
	void test02() {

		given().
		get("https://reqres.in/api/users?page=2").then().statusCode(200)
		.body("data.id[0]", equalTo(7))
		.body("data.first_name", hasItems("Michael","Lindsay"));
	}


    @SuppressWarnings("unchecked")
    @Test(enabled=true)
    public void test_POST() {

        baseURI = "http://localhost:3000/";
        JSONObject request = new JSONObject();
        request.put("firstName", "Tom");
        request.put("lastName", "Cooper");
        request.put("subjectId", "3");

        given().contentType(ContentType.JSON).accept(ContentType.JSON).header("ContentType","application/json").
                body(request.toJSONString())
                .when()
                .post("/users")
                .then().statusCode(201).log().all();
    }

    @SuppressWarnings("unchecked")
    @Test(enabled=true)
    public void test_PATCH() {

        baseURI = "http://localhost:3000/";
        JSONObject request = new JSONObject();
        request.put("lastName", "Shepherd");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("ContentType","application/json").
                body(request.toJSONString())
                .when()
                .patch("/users/3")
                .then().statusCode(200).log().all();
    }

    @SuppressWarnings("unchecked")
    @Test(enabled=true)
    public void test_PUT() {

        baseURI = "http://localhost:3000/";
        JSONObject request = new JSONObject();
        request.put("firstName", "Mary");
        request.put("lastName", "Jane");
        request.put("subjectId", "3");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("ContentType","application/json").
                body(request.toJSONString()).
                when().
                patch("/users/3").
                then().statusCode(200).log().all();
    }

    @Test(enabled=true)
    public void test_DELETE() {

        baseURI = "http://localhost:3000/";

        when().delete("/users/3").
                then().
                statusCode(200).log().all();
    }


}
