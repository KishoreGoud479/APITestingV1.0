package datadriventest;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddNewEmployee {

	void postNewEmployees() 
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		JSONObject requestParams=new JSONObject();
		requestParams.put("name", "SMITH123");
		requestParams.put("salary", "50000");
		requestParams.put("age", "23");
		
		httpRequest.header("content-Type", "application/json");
		
		httpRequest.body(requestParams.toJSONString());
		
		Response response=httpRequest.request(Method.POST, "/create");
		
		String responseBody=response.getBody().asString();
		Assert.assertEquals(responseBody.contains("SMITHXYZ"), true);
		Assert.assertEquals(responseBody.contains("50000"), true);
		Assert.assertEquals(responseBody.contains("23"), true);
		
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
	}
}
