package restAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request {
	
 	@Test
	
	public void GetwhatgerDetails() 
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET, "/Hyderabad");
		
		String responseBody=response.getBody().asString();
		System.out.println("ResponseBody is:" +responseBody);
		
		Headers allheaders=response.headers();
		
		for(Header header:allheaders)
		{
			System.out.println(header.getName()+"       "+header.getValue());
		}
		
			
	}

}
