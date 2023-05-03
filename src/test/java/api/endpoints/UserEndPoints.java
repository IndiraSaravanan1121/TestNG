package api.endpoints;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.utils.DataProviders;
import com.utils.ReadPropertyFile;

import api.payload.TestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	Routes route = new Routes();

	public static Response createUser() throws IOException {
		
        File f = new File(".\\body.json");	
		FileReader fr = new FileReader(f);		
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(data.toString())
		.when()
			.post(ReadPropertyFile.properties("post_url", Routes.CONFIG_PATH));

		return response;
	}

	public static Response readUser() throws IOException {
		Response response = when()
		.get(ReadPropertyFile.properties("get_url", Routes.CONFIG_PATH));
	return response;
	}
	public static Response updateUser(TestData payload) throws IOException {
		
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
//		.body(payload.toString())
	.when()
		.put(ReadPropertyFile.properties("put_url", Routes.CONFIG_PATH));
	return response;	

	}

	public static Response deleteUser() throws IOException {
		Response response = when().
			delete(ReadPropertyFile.properties("delete_url", Routes.CONFIG_PATH));

     return response;
	}
	
	public static Response createNewUser(TestData payload) throws IOException {
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload.toString())
	    .when()
	    	.post(ReadPropertyFile.properties("post_url", Routes.CONFIG_PATH));
		return response;
		
	}

}
