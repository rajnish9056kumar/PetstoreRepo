package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.User;
import   io.restassured.response.Response;
import  io.restassured.http.ContentType;

/**
 * UserEndPoints.java
 * Created for perform --> post ,update,get,and delete request to the user api.
 */

public class UserEndPoints2 {
	
	public static Response createUser(User payload)
	{
		Response response=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		   .body(payload)
		 
		     .when()
		     .post(Routes.post_url);
		     
		     return response;
	}
	
	public static Response readUser(String UserName)
	{
		Response response=given()
		     .pathParam("username",UserName)
		 
		     .when()
		     .get(Routes.get_url);
		     
		     return response;
	}
	
	public static Response updateUser(String UserName,User payload)
	{
		Response response=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .pathParam("username",UserName)
		   .body(payload)
		 
		     .when()
		     .put(Routes.update_url);
		     
		     return response;
	}
	
	public static Response deleteUser(String UserName)
	{
		Response response=given()
		     .pathParam("username",UserName)
		 
		     .when()
		     .delete(Routes.delete_url);
		     
		     return response;
	}
	
	
	

}
