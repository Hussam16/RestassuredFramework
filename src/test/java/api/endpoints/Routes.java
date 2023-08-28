package api.endpoints;

public class Routes {

	public static String baseURL = "https://academy-api.codpark.com";


	
	// Staff EndPoints
	public static String loginStaff = baseURL + "/v1/staff/login";
	public static String currentStaff = baseURL + "/v1/staff/me";
	public static String getAdmins = baseURL + "/v1/staff/get-admins";
	public static String getAdminById = baseURL + "/v1/staff/get-admin/{id}";
	public static String createAdmin = baseURL + "/v1/staff/add-admin";
	public static String deleteAdminById = baseURL + "/v1/staff/remove-admin/{id}";
	public static String editAdminById = baseURL + "/v1/staff/edit-admin/{id}";
		
	
	
	// Games EndPoints
	
	public static String createGame = baseURL + "/v1/game";
	public static String getGames = baseURL + "/v1/game?page={pageNumber}&limit={limit}";
	public static String getSingleGame = baseURL + "/v1/game/{id}";
	public static String editSingleGame = baseURL + "/v1/game/{id}";
	public static String deleteSingleGame = baseURL + "/v1/game/{id}";
	
	
	// Instructor EndPoints
	
	public static String createInstructor = baseURL + "/v1/instructor";	
	
	
	
	

}
