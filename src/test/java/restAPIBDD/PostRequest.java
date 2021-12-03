package restAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	@Test
	public void PostCall() {
		
		Logger logger = Logger.getLogger("APILogs");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		logger.info("**************************** Started POST Call ****************************");
		
		Map<String, Object> PostBody = new HashMap<String, Object>();
		PostBody.put("name", "Dev");
		PostBody.put("salary", "20000");
		
		RestAssured.given()
				   .baseUri("https://reqres.in")
				   .contentType(ContentType.JSON)
				   .accept(ContentType.JSON)
				   .body(PostBody)
				   .when()
				   .post("/api/users")
				   .then()
				   .statusCode(201)
				   .log()
				   .all();
		
	}

}
