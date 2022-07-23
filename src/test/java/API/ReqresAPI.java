package API;

import java.io.File;
import java.net.URI;

import Utils.Constant;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ReqresAPI {

    public static final String DIR = System.getProperty("user.dir");

    public  String GET_LIST_USERS = Constant.URL+"/api/users?page={page}";
    public String GET_SINGLE_USER = Constant.URL+"/api/users/{id}";
    public static String POST_CREATE_USER = Constant.URL+"/api/users";
    public static String PUT_UPDATE_USER = Constant.URL+"/api/users/{id}";
    public static String DELETE_USER = Constant.URL+"/api/users/{id}";
    public static  String JSON_FILE = DIR+"/src/test/resources/json/";
    public static  String GET_LIST_SOURCE = Constant.URL+"/api/unknown";
    public static String GET_SINGLE_SOURCE = Constant.URL+"/api/unknown/{id}";
    @Step("Get list user")
    public void getListUser(String page){
        SerenityRest.given()
                .pathParam("page",page);
    }
    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Post Create user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put Update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id) {
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get list source")
    public void getListSource(String page){
        SerenityRest.given()
                .pathParam("page",page);
    }
    @Step("Get single source")
    public void getSingleSource(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
}