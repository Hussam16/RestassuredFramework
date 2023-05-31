package api.test;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import api.endpoints.UserEndpoints;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature; 
import io.qameta.allure.Issue;

public class UserTests {

	public Logger logger;
	
	
	@BeforeClass
	public void setup() {
		logger= LogManager.getLogger(this.getClass());
	}
	
	
	@Epic("Users Managment")
	@Description("Chkeing the Function of Creation of a new User")
	@Feature("User Creation")
	@Issue("ID-210UC")
	@Test
	public void createusertests() {
		
		logger.info("**************Creating user **************");

		Assert.assertEquals(200, new UserEndpoints().createUser().statusCode());
		
		
		logger.info("************** User Created **************");
	}

	@Test
	public void createusertests2() {
		
		logger.info("**************Koftaaaaa **************");

		Assert.assertEquals(200, new UserEndpoints().createUser().statusCode());
	}

	@Test
	public void createusertests3() {

		logger.info("**************Belta7ina **************");
		Assert.assertEquals(200, new UserEndpoints().createUser().statusCode());
	}

	@Test
	public void createusertests4() {
		logger.info("************** Shurbaaaaaa **************");

		Assert.assertEquals(200, new UserEndpoints().createUser().statusCode());
	}

	@Test
	public void createusertests5() {
		logger.info("************** Belganbarii  **************");
		Assert.assertEquals(200, new UserEndpoints().createUser().statusCode());
	}
	
	
	@Test
	public void createusertests6() {
		logger.info("************** Belganbarii  **************");
		Assert.assertEquals(200, new UserEndpoints().createUserProperty().statusCode());
	}
}
