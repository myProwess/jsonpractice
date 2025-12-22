package requests;

import org.testng.annotations.DataProvider;
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

public class DataDrivenTests {

	@DataProvider(name="dataForPost")
	public Object[][] dataForPOST() 
	{
		return new Object[][] {
			{"Graham","Bell",1},
			{"Henry","Ford",1}
		};
	}

	@DataProvider(name="dataForDelete")
	public Object[] dataForDelete() {
		return new Object[] {
				4,5
		};
	}

}
