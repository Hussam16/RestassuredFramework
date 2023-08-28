package api.endpoints;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Instructor {

	private String token;

	public Instructor(String token) {

		this.token = token;
	}

	public Response createInstructor(String name,int years,int sessions,String slug) {

		JSONObject description = new JSONObject();
		description.put("en", "Hello world");
		description.put("ar", "Hello world in Arabic");

		JSONArray language = new JSONArray();
		language.put("English");
		language.put("Arabic");

		JSONArray games = new JSONArray();
		games.put("64d8b303da423277c7757f9d");

		JSONObject requestData = new JSONObject();
		requestData.put("name", name);
		requestData.put("avatar", "https://vqesportsplatform.s3.eu-west-3.amazonaws.com/Instructor/6a8fe062-b2bd-4db3-8e1e-1f31762fa804.png");
		requestData.put("yearsCoaching", years);
		requestData.put("sessionsCompleted", sessions);
		requestData.put("slug", slug);
		requestData.put("language", language);
		requestData.put("games", games);
		requestData.put("description", description);
		
	return	given().auth().oauth2(this.token).contentType(ContentType.JSON).body(requestData.toString()).when().post(Routes.createInstructor);

	}

}
