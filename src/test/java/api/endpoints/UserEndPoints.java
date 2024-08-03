package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import   io.restassured.response.Response;
import  io.restassured.http.ContentType;

/**
 * UserEndPoints.java
 * Created for perform --> post ,update,get,and delete request to the user api.
 */

public class UserEndPoints {
	
	//method created for getting url from properties file
	static ResourceBundle getUrl()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(User payload)
	{
		String post_url = getUrl().getString("post_url");
		Response response=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		   .body(payload)
		 
		     .when()
		     .post(post_url);
		     return response;
	}
	
	public static Response readUser(String UserName)
	{
		String get_url = getUrl().getString("get_url");
		Response response=given()
		     .pathParam("username",UserName)
		 
		     .when()
		     .get(get_url);
		     
		     return response;
	}
	
	public static Response updateUser(String UserName,User payload)
	{
		String update_url = getUrl().getString("update_url");
		Response response=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .pathParam("username",UserName)
		   .body(payload)
		 
		     .when()
		     .put(update_url);
		     
		     return response;
	}
	
	public static Response deleteUser(String UserName)
	{
		String delete_url = getUrl().getString("delete_url");
		Response response=given()
		     .pathParam("username",UserName)
		 
		     .when()
		     .delete(delete_url);
		     
		     return response;
	}
	
	
	

}
