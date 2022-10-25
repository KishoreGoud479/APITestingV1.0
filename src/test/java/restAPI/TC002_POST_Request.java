package restAPI;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	
	@Test
	void RegistrationSuccessful()
	{
		//specify base URI
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Request object
		
		RequestSpecification httpRequest=RestAssured.given();
		
		//Request payload sending along with post request
		
		JSONObject requestParams=new JSONObject();
		requestParams.put("Firstname", "Kishore");
		requestParams.put("Lastname", "Naragoni");
		requestParams.put("Username", "Kishorexyz");
		requestParams.put("Password", "Kishore@xyz");
		requestParams.put("Email", "Kishore122@gmail.com");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		//Response object
		Response response=httpRequest.request(Method.POST,"/register");
		
		// Print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("ResponseBody is:" +responseBody);
		
		// Status Code validation
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		// Successcode validation
		
		String successcode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successcode, "OPERATION_SUCCESS");
			
	}
}
