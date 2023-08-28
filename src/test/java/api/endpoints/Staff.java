package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ThisFieldRefForm;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONObject;

import api.utilites.ProperyFileReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Staff {

    private String token;

    public Staff() {
        // Call loginMainAdmin method to initialize the token
        loginMainAdmin();
    }

    public Response loginMainAdmin() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", "king@gmail.com");
        jsonObject.put("password", "testxdxd");

        Response response = given().contentType(ContentType.JSON).body(jsonObject.toString()).when().post(Routes.loginStaff);
        
        // Extract the token from the response body and store it in the instance variable
        this.token = response.jsonPath().getString("token");
        

        
        return response;
    }

    public Response login(String email,String password) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", email);
        jsonObject.put("password", password);

        Response response = given().contentType(ContentType.JSON).body(jsonObject.toString()).when().post(Routes.loginStaff);
        
        // Extract the token from the response body and store it in the instance variable
        this.token = response.jsonPath().getString("token");
        

        
        return response;
    }
    
    public Response getCurrentStaff() {
        return given().auth().oauth2(token).when().get(Routes.currentStaff);
    }

    public Response getAdmins() {
        return given().auth().oauth2(token).when().get(Routes.getAdmins);
    }

    public Response getAdminByID(String id) {
        return given().pathParam("id", id).auth().oauth2(token).when().get(Routes.getAdminById);
    }

    public Response createAdmin(String email, String mobile) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", email);
        jsonObject.put("email", email);
        jsonObject.put("mobile", mobile);
        jsonObject.put("role", "SUPER_ADMIN");
        jsonObject.put("password", "Asd123@@");

        return given().auth().oauth2(token).contentType(ContentType.JSON).body(jsonObject.toString()).when()
                .post(Routes.createAdmin);
    }

    public Response deleteAdminByID(String id) {
        return given().pathParam("id", id).auth().oauth2(token).when().delete(Routes.deleteAdminById);
    }

    public Response editAdmin(String email, String mobile, String id) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", email);
        jsonObject.put("email", email);
        jsonObject.put("mobile", mobile);
        jsonObject.put("role", "SUPER_ADMIN");
        jsonObject.put("password", "Asd123@@");

        return given().pathParam("id", id).auth().oauth2(token).contentType(ContentType.JSON)
                .body(jsonObject.toString()).when().put(Routes.editAdminById);
    }
}
