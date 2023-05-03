package api.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.DataProviders;

import api.endpoints.StatusCode;
import api.endpoints.UserEndPoints;
import api.payload.TestData;
import io.restassured.response.Response;

public class Tests {

	TestData data;

	@BeforeClass
	public void setupData() {
		// data.setId();
	}

//	@Test(priority = 1)
//	public void testGetRequest() throws IOException {
//
//		Response response = UserEndPoints.readUser();
//		response.then().log().all();
//
//		Assert.assertEquals(response.statusCode(), StatusCode.StatusCode_OK);
//	}
//
//	@Test(priority = 2)
//	public void testPostRequest() throws IOException {
//
//		Response response = UserEndPoints.createUser();
//		response.then().log().all();
//
//		Assert.assertEquals(response.statusCode(), StatusCode.StatusCode_CREATED);
//	}
//
//	@Test(priority = 3, dataProvider = "Data", dataProviderClass = DataProviders.class)
//	public void testPutRequest(String name, String job) throws IOException {
//
//		TestData testData = new TestData();
//		testData.setName(name);
//		testData.setJob(job);
//
//		Response response = UserEndPoints.updateUser(testData);
//		response.then().log().all();
//
//		Assert.assertEquals(response.statusCode(), StatusCode.StatusCode_OK);
//	}
//
//	@Test(priority = 4)
//	public void testDeleteRequest() throws IOException {
//		Response response = UserEndPoints.deleteUser();
//		response.then().log().all();
//
//		Assert.assertEquals(response.statusCode(), StatusCode.StatusCode_NOCONTENT);
//	}
	@Test(dataProvider="Data",dataProviderClass = DataProviders.class)
	public void testPostUser(String name, String job) throws IOException {
		TestData testData = new TestData();
		testData.setName(name);
		testData.setJob(job);

		Response response = UserEndPoints.createNewUser(testData);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), StatusCode.StatusCode_CREATED);
	}

}
