package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	User userPayload;
	Faker faker;
	Logger logger;
	
	
	@BeforeClass
	public void setUpData()
	{
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger = LogManager.getLogger(this.getClass());
		
	}
	@Test(priority=1)
	 public void testPostUser()
	{
		
		logger.info("************ Creating User **************");
		Response response = UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************ User Created **************");
	}
	
	
	@Test(priority=2)
	public void testGetUSerByName()
	{
		logger.info("************ User Info Reading **************");
		Response response = UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("************ User Info is Displayed **************");
	}
	@Test(priority=1)
	 public void testUpdateUser()
	{
		logger.info("************ User is Updating **************");
		//update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		
		Response response = UserEndPoints2.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
		logger.info("************ User is Updated **************");
		
		//response.then().log().body().statusCode(200);
		//or both are same uper is coming from restassured and below is coming from testng
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//checking data after update
		Response responseAfterUpdate = UserEndPoints2.readUser(this.userPayload.getUsername());
		//response.then().log().all();
		Assert.assertEquals(responseAfterUpdate.statusCode(), 200);
	
		
	} 
	
	
	@Test(priority=4)
	public void testdeleteUser()
	{
		logger.info("************ User is Deleting **************");
		Response response = UserEndPoints2.deleteUser(this.userPayload.getUsername());
	    Assert.assertEquals(response.getStatusCode(), 200);
	    logger.info("************ User is Deleted **************");
	}
	
	
	
	

}
