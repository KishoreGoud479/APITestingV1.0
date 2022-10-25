package restAPI;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
	
	@Test
	void googleMapTest()
	{
		//specify base URI
		RestAssured.baseURI="http://maps.googleapis.com";
		
		//Request object
		
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		
		Response response=httpRequest.request(Method.GET,"/");
		
		// Print response in console window
		
		String responseBody=response.getBody().asString();
		System.out.println("ResponseBody is:" +responseBody);
		
		// Validating headers
		String contentType=response.header("Content-Type");// capture content-type header
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		
		String contentEncoding=response.header("Content-Encoding");// capture content-encoding header
		Assert.assertEquals(contentEncoding, "gzip");
	
	}	

}
