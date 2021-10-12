package restAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class TC_VideoGameAPI {
	
	
	//@Test
	public void test_GetAllGames() {
		baseURI ="http://localhost:8080/app";
		given().
		  accept(ContentType.JSON).
		when().
		  get("/videogames").
		then().
		  statusCode(200).
		  log().all();
	}
	
	//@Test
	public void post_VideoGames() {
		
		HashMap data = new HashMap();
		
		data.put("id", "100");
		data.put("name", "SpiderMan");
		data.put("releaseDate", "2021-10-12T01:32:02.218Z");
		data.put("reviewScore", "2");
		data.put("category", "Action");
		data.put("rating", "Top10");
		
		
		Response res =
		given()
		  .contentType("application/json")
		  .body(data)
		.when()
		   .post("http://localhost:8080/app/videogames")
		.then()
		   .statusCode(200)
		   .log().body()
		   .extract().response();
		
		String jsonString = res.asString();
		Assert.assertEquals(jsonString.contains("Record Added Successfully"), true);
		
		
	}
	
	//@Test
		public void test_GetGame() {
			baseURI ="http://localhost:8080/app/videogames";
			given().
			  accept(ContentType.JSON).
			when().
			  get("/100").
			then()
			  .statusCode(200)
			  .body("videoGame.name", equalTo("SpiderMan") )
			 . log().all();
		}
		
		
	//@Test
	public void put_Game() {
		
		HashMap gameData = new HashMap();
		gameData.put("id", "100");
		gameData.put("name", "SpiderMan2");
		gameData.put("releaseDate", "2021-10-12T01:32:02.218Z");
		gameData.put("reviewScore", "5");
		gameData.put("category", "Action");
		gameData.put("rating", "Top10");
		
		
		
		given()
		   .contentType("application/json")
		   .body(gameData)
		   
		.when()
		  .put("http://localhost:8080/app/videogames/100")
		.then()
		  .statusCode(200)
		  .log().body()
		  .body("videoGame.name", equalTo("SpiderMan2") );
		
	}
	
	@Test
	public void delete_Game() {
		
		Response res=
		given()
		.when()
		  .delete("http://localhost:8080/app/videogames/100")
		.then()
		  .statusCode(200)
		  .log().body()
		  .extract().response();
		
		String jsonString = res.asString();
		Assert.assertEquals(jsonString.contains("Record Deleted Successfully"),true);
	}
		
	

}
