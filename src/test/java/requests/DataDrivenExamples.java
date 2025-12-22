package requests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DataDrivenExamples extends DataDrivenTests {

	@SuppressWarnings("unchecked")
	@Test(enabled=false,dataProvider="dataForPost")
	public void test_POST(String firstName,String lastName, int subjectId) {

		baseURI = "http://localhost:3000/";
		JSONObject request = new JSONObject();
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);

		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("ContentType","application/json").
		body(request.toJSONString())
		.when()
		.post("/users")
		.then().statusCode(201).log().all();

	}

	@Parameters({"userId"})
	@Test(enabled=true)
	public void test_DELETE(int userId) {

		System.out.println(userId);
		baseURI = "http://localhost:3000/";

		when().delete("/users/"+userId).
		then().
		statusCode(200).log().all();
	}

}
