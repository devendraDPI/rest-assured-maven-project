package restAPIBDD;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest {
	
	@Test
	public void PostCall() {
		
		Logger logger = Logger.getLogger("APILogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("**************************** Started GET Call ****************************");
		
		RestAssured.given()
		   .baseUri("https://reqres.in")
		   .when()
		   .get("/api/users")
		   .then()
		   .statusCode(200)
		   .log()
		   .all();
		
	}

}
