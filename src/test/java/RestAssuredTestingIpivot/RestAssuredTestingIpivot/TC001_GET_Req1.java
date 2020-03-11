package RestAssuredTestingIpivot.RestAssuredTestingIpivot;


	import org.testng.Assert;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.http.Method;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	public class TC001_GET_Req1 {

		@Test
		public void getWeatherDetails() {
			RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
			
			//Request Object
			RequestSpecification httpReq = RestAssured.given();
			
			//Response Object
			Response response = httpReq.request(Method.GET, "/chennai");
			
			System.out.println("resp1  "+response.getBody().asString());
			System.out.println("resp2  "+response.getStatusCode());
			System.out.println("resp3  "+response.getStatusLine());
			
			Assert.assertEquals(response.getStatusCode(),200);
		
		
		
		}
}
