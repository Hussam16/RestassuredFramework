package api.utilites;

import java.util.ResourceBundle;

public class ProperyFileReader {

	public ResourceBundle getUrl() {

		ResourceBundle routes = ResourceBundle.getBundle("routes"); // Load properties file // name of the properties
																	// file
		return routes;

	}

}
