package StepDef;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import API.ReqresAPI;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import io.restassured.module.jsv.JsonSchemaValidator;

import Utils.Constant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class ReqresStep extends ReqresAPI {
    @Steps
    ReqresAPI reqresAPI;

    //get list user - positive case
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPage(String page) {
        reqresAPI.getListUser(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(reqresAPI.GET_LIST_USERS);
    }

    @Then("Should return status code {int} and Success get list user with page {int}")
    public void shouldReturnStatusCodeAndSuccessGetListUserWithPage(int arg0, int page) {
        SerenityRest.then().statusCode(200)
                .body("page",equalTo(page));
    }

    //get list user exceeds total pages - negative case
    @Then("Should return status code {int} not found and Failed get list user with page {int}")
    public void shouldReturnStatusCodeNotFoundAndFailedGetListUserWithPage(int arg0, int page) {
        SerenityRest.then().statusCode(404)
                .body("page",not(page));
    }

    //get single user with id
    @Given("Get single user with id {int}")
    public void getSingleUserWithId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(reqresAPI.GET_SINGLE_USER);
    }

    @Then("Should return status code {int} and Success get single user with id {int}")
    public void shouldReturnStatusCodeAndSuccessGetSingleUserWithIdId(int arg0, int id) {
        SerenityRest.then().statusCode(200)
                .body("data.id",equalTo(id));
    }
    //post create new user - positive case
    @Given("Post Create new user with valid json schema")
    public void postCreateNewUserWithValidJsonSchema() {
        File json = new File(Constant.JSON_DATA + "/CreateUser.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request create new user")
    public void sendRequestCreateNewUser() {

        SerenityRest.when().post(POST_CREATE_USER);
    }

    @Then("Should return status code {int} created And Success create new user with valid json schema")
    public void shouldReturnStatusCodeCreatedAndSuccessCreateNewUserWithValidJsonSchema(int arg0) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(Constant.JSON_DATA +"/CreateUser.json"));
        JSONObject jsonObject = (JSONObject) obj;
        String nameJson = (String) jsonObject.get("name");
        String jobJson = (String) jsonObject.get("job");
        SerenityRest.then().statusCode(201)
                .body("name",equalTo(nameJson))
                .body("job",equalTo(jobJson));
    }
    //update user - positive case
    @Given("Put edit user id {int} with valid json schema")
    public void putEditUserIdWithValidJsonSchema(int id) {
        File json = new File(Constant.JSON_DATA + "/UpdateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {

        SerenityRest.when().put(PUT_UPDATE_USER);
    }


    //delete user
    @Given("Delete user id {int}")
    public void deleteUserIdId(int id) {

        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {

        SerenityRest.when().delete(DELETE_USER);
    }

    @Then("Should return status code {int} no content")
    public void shouldReturnStatusCodeNoContent(int statusCode) {
        SerenityRest.then().statusCode(204);
    }
    @Then("Should return status code {int} created")
    public void shouldReturnStatusCreated(int statusCode) {
        SerenityRest.then().statusCode(201);
    }
    @Then("Should return status code {int} OK")
    public void shouldReturnStatusCodeOk(int statusCode) {
        SerenityRest.then().statusCode(200);
    }
    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then().body(Constant.NAME,equalTo(name));
        SerenityRest.then().body(Constant.JOB,equalTo(job));
    }
    @Given("Get list user with parameter {string}")
    public void getListUserWithParameter(String page) {
        reqresAPI.getListUser(page);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(200);
    }

    @And("Response body should contain first name {string} and last name {string}")
    public void responseBodyShouldContainFirstNameAndLastName(String firstName, String lastName) {
        SerenityRest.then().body(Constant.FIRST_NAME,equalTo(firstName));
        SerenityRest.then().body(Constant.LAST_NAME,equalTo(lastName));
    }

    @Given("Post create new user with valid json file")
    public void postCreateNewUserWithValidJsonFile() {
        File jsonFiles = new File( ReqresAPI.DIR+"/src/test/resources/Json/CreateUser.json");
        reqresAPI.postCreateUser(jsonFiles);
    }
    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(201);
    }


    @Given("Put update user with id {int} and with valid json file")
    public void putUpdateUserWithIdAndWithValidJsonFile(int id) {
        File jsonFiles = new File(ReqresAPI.DIR+"/src/test/resources/Json/UpdateUser.json");
        reqresAPI.putUpdateUser(id, jsonFiles);
    }

    @Then("Status code should be {int} No content")
    public void statusCodeShouldBeNoContent(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}
