package api.test;

import java.io.File;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import api.endpoints.RestfulBookerEndpoints;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class RestfulBookTestcases {

	@Test(enabled = false)
	public void LoginTestcase() {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", "admin");
		jsonObject.put("password", "password123");

		Response response = new RestfulBookerEndpoints().createtoken(jsonObject);
		response.then().assertThat().body(JsonSchemaValidator
				.matchesJsonSchema(new File(System.getProperty("user.dir") + "\\Scheme\\Acesstoken.json")));
		Assert.assertEquals(200, response.statusCode());

	}
}
