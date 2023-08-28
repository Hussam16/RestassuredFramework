package api.endpoints;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Games {

	private String token;

	public Games(String token) {

		this.token = token;
		// TODO Auto-generated constructor stub
	}

	public Response createGame(String name, String slug) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("image",
				"https://vqesportsplatform.s3.eu-west-3.amazonaws.com/Games/5ab4490e-3169-4b7a-9d3a-291ccda03f08.png");
		jsonObject.put("name", name);
		jsonObject.put("slug", slug);

		return given().auth().oauth2(this.token).contentType(ContentType.JSON).body(jsonObject.toString()).when()
				.post(Routes.createGame);

	}

	public Response getGames(String pageNumber, String limit) {

		return given().pathParam("pageNumber", pageNumber).pathParam("limit", limit).auth().oauth2(this.token)
				.contentType(ContentType.JSON).when().get(Routes.getGames);

	}

	public Response getSingleGame(String id) {

		return given().contentType(ContentType.JSON).pathParam("id", id).get(Routes.getSingleGame);
	}

	public Response deleteSingleGame(String id) {

		return given().contentType(ContentType.JSON).pathParam("id", id).delete(Routes.deleteSingleGame);
	}

	public Response editGame(String name, String slug, String id) {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("image",
				"https://vqesportsplatform.s3.eu-west-3.amazonaws.com/Games/5ab4490e-3169-4b7a-9d3a-291ccda03f08.png");
		jsonObject.put("name", name);
		jsonObject.put("slug", slug);

		return given().auth().oauth2(this.token).pathParam("id", id).contentType(ContentType.JSON)
				.body(jsonObject.toString()).when().put(Routes.editSingleGame);

	}

}
