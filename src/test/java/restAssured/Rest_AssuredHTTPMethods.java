package restAssured;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.apache.poi.xssf.model.ThemesTable.ThemeElement;
import org.json.simple.JSONObject;

public class Rest_AssuredHTTPMethods {
	
	//@Test
	public void getUsers_Tests() {
		baseURI ="http://localhost:3000/";
		
		given().
		   get("/users").
		then().
		   statusCode(200).
		   log().all();
	}
	
	//@Test
	public void postUser_Test() {
		baseURI ="http://localhost:3000/";
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("firstname", "Babar");
		requestParams.put("lastname", "Azam");
		requestParams.put("subjectId", 3);
		
		given().
		   contentType(ContentType.JSON).
		   accept(ContentType.JSON).
		   header("Content-Type","application/json").
		   body(requestParams.toJSONString()).
		   
		when().
		     post("/users").
		then().
		   statusCode(201).
		   log().all();
	}
	
	//@Test
	public void putUser_Test() {
		baseURI ="http://localhost:3000/";
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("firstname", "Babar");
		requestParams.put("lastname", "Azammmmmm");
		requestParams.put("subjectId", 2);
		
		given().
		   contentType(ContentType.JSON).
		   accept(ContentType.JSON).
		   header("Content-Type","application/json").
		   body(requestParams.toJSONString()).
		   
		when().
		     put("/users/4").
		then().
		   statusCode(200).
		   log().all();
	}
	
	//@Test
	public void patchUser_Test() {
		baseURI ="http://localhost:3000/";
		
		JSONObject requestParams = new JSONObject();
		//requestParams.put("firstname", "Babar");
		requestParams.put("lastname", "Azam");
		//requestParams.put("subjectId", 2);
		
		given().
		   contentType(ContentType.JSON).
		   accept(ContentType.JSON).
		   header("Content-Type","application/json").
		   body(requestParams.toJSONString()).
		   
		when().
		     patch("/users/4").
		then().
		   statusCode(200).
		   log().all();
	}
	
	@Test
	public void deleteUser_Test() {
		
		baseURI ="http://localhost:3000/";
		
		when().
		  delete("/users/4").
		then().
		   statusCode(200).
		   log().all();
		
	}
	
	

}
