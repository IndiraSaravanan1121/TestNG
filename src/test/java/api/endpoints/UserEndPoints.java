package api.endpoints;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ResourceBundle;

import org.json.JSONObject;
import org.json.JSONTokener;

import api.payload.TestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("config");
		return routes;
	}
	
	Routes route = new Routes();

	public static Response createNewUser(TestData payload) throws IOException {
		
		String post_url = getURL().getString("post_url");
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
	    .when()
	    	.post(post_url);
		return response;	
	}	

	public static Response readUser() throws IOException {
		String get_url = getURL().getString("get_url");

		Response response = when()
		.get(get_url);
	return response;
	}
	
	public static Response updateUser() throws IOException {
		String put_url = getURL().getString("put_url");

		  File f = new File(".\\body.json");	
			FileReader fr = new FileReader(f);		
			JSONTokener jt = new JSONTokener(fr);
			JSONObject data = new JSONObject(jt);
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(data)
	.when()
		.put(put_url);
	return response;	

	}

	public static Response deleteUser() throws IOException {
		String delete_url = getURL().getString("delete_url");

		Response response = when().
			delete(delete_url);

     return response;
	}

}
