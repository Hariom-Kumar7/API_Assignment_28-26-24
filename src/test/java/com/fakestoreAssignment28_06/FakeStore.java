package com.fakestoreAssignment28_06;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSenderOptions;

public class FakeStore {
		
	       String baseURL ="https://fake-store-api.mock.beeceptor.com";
  
	@Test
	public void Get_a_list_of_products_available(){
		//here performing get https request for get all details
		//ststus log is ensure and match the actual status respond code and expected respond status code
		given().header("Content-Type","application/json").
		when().get("https://fake-store-api.mock.beeceptor.com/api/products").then().log().all();
	}
	@Test
	public void Get_a_list_of_shopping_buckets_carts() {
		given().header("Content-Type","application/json").
		when().get("https://fake-store-api.mock.beeceptor.com/api/carts").then().statusCode(200).log().all();
	}
	@Test()
	public void Check_order_status_and_retrieve_order_details() {
		given().header("Content-Type","application/json").
		when().get("https://fake-store-api.mock.beeceptor.com/api/orders/status\\?order_id=1").then().statusCode(200).log().all();
	}
	@Test
	public void Get_a_list_of_orders_placed_by_users_and_their_status() {
		given().header("Content-Type","application/json").
		when().get("https://fake-store-api.mock.beeceptor.com/api/orders").then().statusCode(200).log().all();
	}
	
	@Test
	public void Create_a_new_order() {
		// Create JSON body using JSONObject
        JSONObject requestBody = new JSONObject();
        requestBody.put("user_id", 1);
        
        
        // Create JSON array for items
        //JSONArray itemsArray = new JSONArray();
        
		
        // Create first item
        JSONObject item1 = new JSONObject();
        item1.put("product_id", 1);
        item1.put("quantity", 2);
        
        
        // Create second item
        JSONObject item2 = new JSONObject();
        item2.put("product_id", 3);
        item2.put("quantity", 1);
        
        // Add items to the array
        //itemsArray.put(item1);
        //eitemsArray.put(item2);

        // Add items array to the request body
        requestBody.put("items", item1);
        requestBody.put("items", item2);
       
         
        given().header("Content-Type","application/json").
        contentType(ContentType.JSON).body(requestBody.toJSONString()).
        put("https://fake-store-api.mock.beeceptor.com/api/orders").then().log().all();

	}
}
