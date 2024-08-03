package api.endpoints;

/**
 *  Swagger URI         -->    https://petstore.swagger.io/
 *  Create user(Post)   -->    https://petstore.swagger.io/v2/user
 *  Get User(get)       -->    https://petstore.swagger.io/v2/user/{username}
 *  update User(put)    -->    https://petstore.swagger.io/v2/user/{username}
 *  delete USer(Delete) -->    https://petstore.swagger.io/v2/user/{username}
 
 */

public class Routes {
	
	//User Module
	
	public static String  base_url   = "https://petstore.swagger.io/v2";
	
	public static String post_url    = base_url+"/user";
	public static String get_url     = base_url+"/user/{username}";
	public static String update_url  = base_url+"/user/{username}"; 
	public static String delete_url  = base_url+"/user/{username}"; 

}
