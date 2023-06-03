package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONObject;

import api.utilites.ProperyFileReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {

	public Response createUser() {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", "Hussam");
		jsonObject.put("email", "hussam16");
		return given().contentType(ContentType.JSON).body(jsonObject).when().post(Routes.createUser);

	}

	public Response createUserProperty() {

		String userCreateUrl = new ProperyFileReader().getUrl().getString("postUser");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", "Hussam");
		jsonObject.put("email", "hussam16");
		return given().contentType(ContentType.JSON).body(jsonObject).when().post(userCreateUrl);

	}

	public Response getUserByUserName(String userName) {

		return given().contentType(ContentType.JSON).pathParam("username", userName).get(Routes.getUser);

	}

}
