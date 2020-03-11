package RestAssuredTestingIpivot.RestAssuredTestingIpivot;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Req1 {

	@Test
	public void postCustomerDetails() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification httpReq = RestAssured.given();
		
		//Request body to POST request
		JSONObject requestParam = new JSONObject();
		requestParam.put("FirstName", "John");
		requestParam.put("LastName", "doe");
		requestParam.put("username", "johnny");
		requestParam.put("Paswd", "john@123");
		requestParam.put("Email", "testapi1@test.com");
		
		httpReq.header("content-type","application/json");
		httpReq.body(requestParam.toJSONString());
		
		//Response Object
		Response response = httpReq.request(Method.POST, "/register");
		
		System.out.println("respbody:  "+response.getBody().asString());
		System.out.println("actual respcode  "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(),201);
		
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode,"OPERATION_SUCCESS");
		
		
	}
		
	
	
	
}
