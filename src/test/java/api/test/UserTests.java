package api.test;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import api.endpoints.UserEndpoints;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class UserTests {

	public Logger logger;

	@BeforeClass
	public void setup() {
		logger = LogManager.getLogger(this.getClass());
	}

	@Epic("Users Managment")
	@Description("Chkeing the Function of Creation of a new User")
	@Feature("User Creation")
	@Issue("ID-210UC")
	@Test
	public void createusertests() {
		Assert.assertEquals(200, new UserEndpoints().createUser().statusCode());

	}

	@Test
	public void getUserByUsernameTest() {

		String username = "HussamAbdo";

		Response response = new UserEndpoints().getUserByUserName(username);
		Assert.assertEquals(200, response.statusCode());
		response.then().assertThat().body(JsonSchemaValidator
				.matchesJsonSchema(new File(System.getProperty("user.dir") + "\\Scheme\\getUser.json")));
		Assert.assertEquals(username, response.jsonPath().getString("username"));

	}

}
