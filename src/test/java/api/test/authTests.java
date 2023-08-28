package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Staff;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class authTests {
	
	Staff staff;
  @Test
  public void sucessfulLogin() {
	  
	  staff = new Staff();
	  Response res = staff.loginMainAdmin();
	  Assert.assertEquals(201, res.statusCode());
	  JsonPath json = res.jsonPath();
	  String accessToken=json.getString("token");
	  
  }
}
