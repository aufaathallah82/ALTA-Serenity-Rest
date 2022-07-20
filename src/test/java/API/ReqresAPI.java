package API;

import java.io.File;

import Utils.Constant;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ReqresAPI {

    public String GET_LIST_USERS = Constant.URL+"/api/users?page={page}";
    public String GET_SINGLE_USER = Constant.URL+"/api/users/{id}";
    public String POST_CREATE_NEW_USER = Constant.URL+"/api/users";
    public String PUT_UPDATE_USER = Constant.URL+"/api/users/{id}";
    public String DELETE_USER = Constant.URL+"/api/users/{id}";

    @Step("Get list user")
    public void getListUser(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }
    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Post Create new user")
    public void postCreateNewUser(File json) {
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
}