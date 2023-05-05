package stepdefination;
import static io.restassured.RestAssured.given;

import java.util.Map;
import java.util.HashMap;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class stepdefination {
	public static String baseurl="https://api.github.com";
	public static String token = "**********************************************";
	public static String Reponame;
	public static String ShaValue;
	public static int autolinkid;
	RequestSpecification requestspecification;
	Response response;
	JsonPath jsonpath;
	

	@Given("Make a post request with the resource1 {string}")
	public void make_a_post_request_with_the_resource1(String resourcepath) {
		 response = given()
		            .baseUri(baseurl)
		            .header("Authorization", "Bearer " + token)
		            .contentType(ContentType.JSON)
		            .body("{\n" +
		                    "  \"name\": \"Hello-World-by\",\n" +
		                    "  \"description\": \"This is your first repo!\"\n" +
		                    "}")
		            .when()
		            .post(resourcepath);
	}
	@Then("Print the response in console2")
	public void print_the_response_in_console2() {
		 jsonpath= new JsonPath(response.getBody().asString());
		 System.out.println(response.getBody().asString());
	}
	@Then("Store Necessary data in the variable3")
	public void store_necessary_data_in_the_variable3() {
		 jsonpath= new JsonPath(response.getBody().asString());
			
	     Reponame = jsonpath.get("name");
	     System.out.println(Reponame);
	}
	@Then("The response status code should be4 {int}")
	public void the_response_status_code_should_be4(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}
	@Then("Check Wether the RepoName is stored in variable5 {string}")
	public void check_wether_the_repo_name_is_stored_in_variable5(String string) {
		Assert.assertEquals(Reponame, string);
	}




	
	
	// Update a repository
	@Given("Make a PATCH request with the resource6 {string}")
	public void make_a_patch_request_with_the_resource6(String string) {
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .body("{\n" +
	                    "  \"name\": \"Updated-Hello-World-by\",\n" +
	                    "  \"description\": \"This is your updated repo!\"\n" +
	                    "}")
	            .when()
	            .patch(string);
	}
	@Then("Print the response in console7")
	public void print_the_response_in_console7() {
		jsonpath= new JsonPath(response.getBody().asString());
		System.out.println(response.getBody().asString());
	}
	@Then("Store Necessary data in the variable8")
	public void store_necessary_data_in_the_variable8() {
		jsonpath= new JsonPath(response.getBody().asString());
		
	    Reponame = jsonpath.get("name");
	    System.out.println(Reponame);
	}
	@Then("The response status code should be9 {int}")
	public void the_response_status_code_should_be9(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}
	@Then("Check Wether the updated RepoName is stored in variable10 {string}")
	public void check_wether_the_updated_repo_name_is_stored_in_variable10(String string) {
		Assert.assertEquals(Reponame, string);
	}



	
	
// 4. Get a repository
	@Given("Make a GET request with the resource11 {string}")
	public void make_a_get_request_with_the_resource11(String string) {
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(string+Reponame);
	}
	@Then("Print the response in console12")
	public void print_the_response_in_console12() {
		jsonpath= new JsonPath(response.getBody().asString());
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should be13 {int}")
	public void the_response_status_code_should_be13(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	
	

	// Create file contents
	@Given("Make a PUT request with the resource14 {string}")
	public void make_a_put_request_with_the_resource14(String string) {
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .body("{\n" +
	                    "  \"message\": \"File Successfully Created\",\n" +
	                    "  \"content\": \"SGVsbG8gV29ybGQ=\"\n" +
	                    "}")
	            .when()
	            .put(string);
	}
	@Then("Print the response in console15")
	public void print_the_response_in_console15() {
		jsonpath= new JsonPath(response.getBody().asString());
		System.out.println(response.getBody().asString());
	}
	@Then("Store Necessary data in the variable16")
	public void store_necessary_data_in_the_variable16() {
        jsonpath= new JsonPath(response.getBody().asString());
	    ShaValue = jsonpath.get("content.sha");
	}
	@Then("The response status code should be17 {int}")
	public void the_response_status_code_should_be17(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}
	@Then("Check Wether the sha value is stored in variable18")
	public void check_wether_the_sha_value_is_stored_in_variable18() {
		System.out.println(ShaValue);
	}



	
	
	

	// 5. CREATE A FORK
	@Given("Make a POST request with the resource19 {string}")
	public void make_a_post_request_with_the_resource19(String string) {
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .body("{\n" +
	                    "  \"organization\": \"jitenderji1137-org-For-API-Testing\",\n" +
	                    "  \"name\": \"New-Fork\"\n" +
	                    "}")
	            .when()
	            .post(string);
	}
	@Then("Print the response in console20")
	public void print_the_response_in_console20() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should be21 {int}")
	public void the_response_status_code_should_be21(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	
	

//  6. LIST FORKS
	@Given("Make a GET request For FORKS with the resource22 {string}")
	public void make_a_get_request_for_forks_with_the_resource22(String string){
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(string);
	}
	@Then("Print the response in console23")
	public void print_the_response_in_console23() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should be24 {int}")
	public void the_response_status_code_should_be24(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	
	

	// 7. List repositories for a user
	@Given("Make a GET request for user repositories with the resource25 {string}")
	public void make_a_get_request_for_user_repositories_with_the_resource25(String string) {
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(string);
	}
	@Then("Print the response in console26")
	public void print_the_response_in_console26() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should be27 {int}")
	public void the_response_status_code_should_be27(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	
	// List repository languages
	@Given("Make a GET request for repositories languages with the resource28 {string}")
	public void make_a_get_request_for_repositories_languages_with_the_resource28(String string) {
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(string);
	}
	@Then("Print the response in console29")
	public void print_the_response_in_console29() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should be30 {int}")
	public void the_response_status_code_should_be30(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	

	// 9. List public repositories
	@Given("Make a GET request for public repositories with the resource31 {string}")
	public void make_a_get_request_for_public_repositories_with_the_resource31(String string) {
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(string);
	}
	@Then("Print the response in console32")
	public void print_the_response_in_console32() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should be33 {int}")
	public void the_response_status_code_should_be33(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	
	

	// Delete a FORK
	@Given("Make a Delete request with the resource34 {string}")
	public void make_a_delete_request_with_the_resource34(String string){
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .when()
	            .delete(string);
	}
	@Given("The response status code should be35 {int}")
	public void the_response_status_code_should_be35(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	
	
	


	// 11. Delete a file
	@Given("Make a Delete file request with the resource36 {string}")
	public void make_a_delete_file_request_with_the_resource36(String string) {
		Map<String, Object> jsonData = new HashMap<String, Object>();
		jsonData.put("message", "deleted file");
		jsonData.put("sha", ShaValue);
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .body(jsonData)
	            .when()
	            .delete(string);
	}
	@Given("The response status code should be37 {int}")
	public void the_response_status_code_should_be37(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	
	

	// Extra. Create a release
	@Given("Make a POST request to create a release with the resource38 {string}")
	public void make_a_post_request_to_create_a_release_with_the_resource38(String string) {
		Map<String, Object> jsonData = new HashMap<String, Object>();
		jsonData.put("tag_name", "GitHub");
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .body(jsonData)
	            .when()
	            .post(string);
	}
	@Then("Print the response in console39")
	public void print_the_response_in_console39() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should be40 {int}")
	public void the_response_status_code_should_be40(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	
	

	// 12. List repository tags
	@Given("Make a GET request for repositories tags with the resource41 {string}")
	public void make_a_get_request_for_repositories_tags_with_the_resource41(String string) {
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(string);
	}
	@Then("Print the response in console42")
	public void print_the_response_in_console42() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should be43 {int}")
	public void the_response_status_code_should_be43(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	
	

	// Create an autolink reference for a repository
	@Given("Make a POST request For autolink with the resource44 {string}")
	public void make_a_post_request_for_autolink_with_the_resource44(String resourcepath){
		response = given()
	            .baseUri(baseurl)
	           .header("Authorization", "Bearer " + token)
	           .contentType(ContentType.JSON)
	            .body("{\n" +
	                    "  \"key_prefix\": \"Github-Api-Testing\",\n" +
	                    "  \"url_template\": \"https://example.com/Api?query=<num>\"\n" +
	                    "}")
	            .when()
	            .post(resourcepath);
	}
	@Then("Print the response in console45")
	public void print_the_response_in_console45() {
		System.out.println(response.getBody().asString());
	}
	@Then("Store Necessary data in the variable46")
	public void store_necessary_data_in_the_variable46() {
		jsonpath= new JsonPath(response.getBody().asString());
		autolinkid = jsonpath.get("id");
//		System.out.println(jsonpath.get("id"));
	}
	@Then("The response status code should be47 {int}")
	public void the_response_status_code_should_be47(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	

	// 18. Replace all repository topics
	@Given("Make a PUT request for repositories topics with the resource48 {string}")
	public void make_a_put_request_for_repositories_topics_with_the_resource48(String string) {
		Map<String, Object> jsonData = new HashMap<String, Object>();
		String[] myStringArray = {"github", "github-api", "github-api-testing"};
		jsonData.put("names",myStringArray);
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .body(jsonData)
	            .when()
	            .put(string);
	}
	@Then("Print the response in console49")
	public void print_the_response_in_console49() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should be50 {int}")
	public void the_response_status_code_should_be50(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	
	

	// Get all repository topics
	@Given("Make a GET request for repositories topics with the resource51 {string}")
	public void make_a_get_request_for_repositories_topics_with_the_resource51(String string) {
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(string);
	}
	@Then("Print the response in console52")
	public void print_the_response_in_console52() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should be53 {int}")
	public void the_response_status_code_should_be53(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	
	

	// 15. Get an autolink reference of a repository
	@Given("Make a GET request for repositories autolink with the resource54 {string}")
	public void make_a_get_request_for_repositories_autolink_with_the_resource54(String string) {
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(string+autolinkid);
	}
	@Then("Print the response in console55")
	public void print_the_response_in_console55() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should be56 {int}")
	public void the_response_status_code_should_be56(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	

	// 16. Delete an autolink reference from a repository
	@Given("Make a Delete request to delete autolink with the resource57 {string}")
	public void make_a_delete_request_to_delete_autolink_with_the_resource57(String string) {
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .when()
	            .delete(string+autolinkid);
	}
	@Then("The Delete response status code should be58 {int}")
	public void the_delete_response_status_code_should_be58(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	

	// 17. Get a repository
	@Given("Make a GET request  with the resource59 {string}")
	public void make_a_get_request_with_the_resource59(String string) {
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .when()
	            .get(string);
	}
	@Then("Print the response in console60")
	public void print_the_response_in_console60() {
		System.out.println(response.getBody().asString());
	}
	@Then("The response status code should be61 {int}")
	public void the_response_status_code_should_be61(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
	
	


	@Given("Make a Delete request to delete repo with the resource62 {string}")
	public void make_a_delete_request_to_delete_repo_with_the_resource62(String string) {
		response = given()
	            .baseUri(baseurl)
	            .header("Authorization", "Bearer " + token)
	            .contentType(ContentType.JSON)
	            .when()
	            .delete(string);
	}
	@Then("The Delete response status code should be63 {int}")
	public void the_delete_response_status_code_should_be63(int int1) {
		Assert.assertEquals(int1, response.getStatusCode());
	}



	
}














