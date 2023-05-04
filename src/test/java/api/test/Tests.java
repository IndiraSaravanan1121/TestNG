package api.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	public Logger logger;

	@BeforeClass
	public void setupData() {
		logger =  LogManager.getLogger(this.getClass());
		// data.setId();
	}

	@Test(priority = 1)
	public void testGetRequest() throws IOException {
		Response response = UserEndPoints.readUser();
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), StatusCode.StatusCode_OK);
		logger = LogManager.getLogger(this.getClass());
		logger.info("Get Request Completed");
	}

	@Test(dataProvider="Data",dataProviderClass = DataProviders.class)
	public void testPostUser(String name, String job) throws IOException {
		TestData testData = new TestData();
		testData.setName(name);
		testData.setJob(job);

		Response response = UserEndPoints.createNewUser(testData);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), StatusCode.StatusCode_CREATED);
		logger.info("Post Request Completed");
	}

	@Test(priority=3)
	public void testPutRequest() throws IOException {

		Response response = UserEndPoints.updateUser();
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), StatusCode.StatusCode_OK);
		logger.info("Put Request Completed");
	}

	@Test(priority = 4)
	public void testDeleteRequest() throws IOException {
		
		Response response = UserEndPoints.deleteUser();
		response.then().log().all();

		Assert.assertEquals(response.statusCode(), StatusCode.StatusCode_NOCONTENT);
		logger.info("Delete Request Completed");
	}
	
	

}
