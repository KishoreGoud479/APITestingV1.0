package restAPI;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getweatherdetails()
	{
		//specify base URI
		 RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		
		//Request object
		
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		
		Response response=httpRequest.request(Method.GET,"/lunger-house");
		
		// Print response in console window
		
		String responseBody=response.getBody().asString();
		System.out.println("ResponseBody is:" +responseBody);
		
		// Status Code
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		
		String statusLine=response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}

}
