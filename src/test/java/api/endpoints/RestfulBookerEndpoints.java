package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class RestfulBookerEndpoints {
	

	public Response createtoken(JSONObject jsonObject) {

		return given().contentType(ContentType.JSON).body(jsonObject.toString()).when().post(Routes.Authorization);
	}
	
	
	
}
