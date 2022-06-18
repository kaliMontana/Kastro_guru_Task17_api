package in.reqres.apiTests;

import in.reqres.config.ApiConfig;
import in.reqres.helper.models.Users;
import in.reqres.helper.util.HttpCode;
import io.restassured.path.json.JsonPath;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static in.reqres.helper.dataProviders.ApiBodyRequests.*;
import static in.reqres.helper.util.HttpCode.*;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.Is.is;

public class ReqresInApiTests {
	private ApiConfig config = ConfigFactory.create(ApiConfig.class);

	final String NAME = "name";
	final String JOB = "job";
	final String WORKER_NAME = "Sapiens";
	final String DIRECTOR_JOB = "Director";
	final String TEAM_LEADER_JOB = "Team leader";
	final String ERROR_TYPE = "Missing email or username";
	final String ERROR = "error";
	final String DATA_PATH = "data";


	@Test
	public void createTest() {

		given()
				.log().uri()
				.log().body()
				.body(CREATE_BODY.getValue())
				.contentType(JSON)
				.when()
				.post(config.getBaseUrl() + config.getCreateService())
				.then()
				.log().status()
				.log().body()
				.statusCode(CREATED.getValue())
				.body(NAME, is(WORKER_NAME),
						JOB, is(TEAM_LEADER_JOB)
				);
	}

	@Test
	public void updateTest() {

		String bodyResponse = given()
				.log().uri()
				.log().body()
				.body(UPDATE_BODY.getValue())
				.contentType(JSON)
				.when()
				.put(config.getBaseUrl() + config.getService())
				.then()
				.log().status()
				.log().body()
				.statusCode(OK.getValue())
				.extract().response().getBody().jsonPath().getJsonObject(JOB);

		Assertions.assertEquals(DIRECTOR_JOB, bodyResponse);
	}

	@Test
	public void deleteTest() {

		given()
				.log().uri()
				.when()
				.delete(config.getBaseUrl() + config.getService())
				.then()
				.log().status()
				.statusCode(DELETED.getValue());
	}

	@Test
	public void unsuccessfulRegisterTest() {

		String bodyResponse = given()
				.log().uri()
				.log().body()
				.body(UNSUCCESSFUL_REGISTRATION_BODY.getValue())
				.contentType(JSON)
				.when()
				.post(config.getBaseUrl() + config.getRegistrationService())
				.then()
				.log().status()
				.log().body()
				.statusCode(BAD_REQUEST.getValue())
				.extract().response().getBody().jsonPath().getJsonObject(ERROR);

		Assertions.assertEquals(ERROR_TYPE, bodyResponse);
	}

	@Test
	public void listUsersTest() {

		JsonPath jsonPath = given()
				.log().uri()
				.when()
				.get(config.getBaseUrl() + config.getUsersService())
				.then()
				.log().status()
				.log().body()
				.statusCode(HttpCode.OK.getValue())
				.extract().response().getBody().jsonPath();

		Users[] users = jsonPath.getObject("data", Users[].class);

		Assertions.assertNotNull(users);
		Assertions.assertEquals(7, users[0].getId());
	}


}
