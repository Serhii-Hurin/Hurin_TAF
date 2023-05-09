import static io.restassured.RestAssured.given;
import static utils.Storage.rememberThatThe;
import static utils.Storage.whatIsThe;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import utils.TemplateUtils;

@Slf4j
public class DashboardTests {

    private final TemplateUtils templateUtils = new TemplateUtils();

    public static final String BASE_URL = "http://localhost:8080";
    public static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NjgyNzY0NTcsInVzZXJfbmFtZSI6InN1cGVyYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOSVNUUkFUT1IiXSwianRpIjoiZDlkYjY3MTAtZGUzMy00NDNjLTk2MzEtNDk2Y2Q4M2MyZmEyIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.p5a0gYUApIfiRt5S1rPTFnugYwBg7brEZVuN9fy8nuQ";
    String initialDescription = "My New2 Dashboard";
    String initialName = "Dashboard20";
    String newDescription = "Updated Description";
    String newName = "Updated20 Name";
    public static final String DESCRIPTION = "description";
    public static final String NAME = "name";


    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "bearer" + TOKEN)
                .build();
    }

    private String getCreateDashboardEndpoint() {
        return "/api/v1/default_personal/dashboard";
    }

    private String getActionWithDashboardIdEndpoint() {
        return "/api/v1/default_personal/dashboard/" + whatIsThe("id");
    }


    @Test
    public void actionsDashboardTest() {
        //create dashboard
        final Map<String, Object> initialValues = new HashMap<>();
        initialValues.put(DESCRIPTION, initialDescription);
        initialValues.put(NAME, initialName);
        try {
            String createPayload = templateUtils
                    .getResolvedTemplate("models/dashboard/create_dashboard.json", initialValues);
            Response createDashboardResponse = given().spec(requestSpecification()).body(createPayload)
                    .when().post(getCreateDashboardEndpoint());
            Object id = createDashboardResponse.jsonPath().get("id");
            createDashboardResponse.then().assertThat().statusCode(201);
            log.info("The dashboard " + id + " was created successfully");
            rememberThatThe("id", id);
        } catch (IOException e) {
            log.error("Creation dashboard action has error" + e.getMessage());
            e.getStackTrace();
        }
        //update dashboard
        final Map<String, Object> updatedValues = new HashMap<>();
        updatedValues.put(DESCRIPTION, newDescription);
        updatedValues.put(NAME, newName);
        try {
            String updatePayload = templateUtils
                    .getResolvedTemplate("models/dashboard/update_dashboard.json", updatedValues);
            Response createDashboardResponse = given().spec(requestSpecification()).body(updatePayload)
                    .when().put(getActionWithDashboardIdEndpoint());
            createDashboardResponse.then().assertThat().statusCode(200);
            log.info("The dashboard " + whatIsThe("id") + " was updated successfully");
        } catch (IOException e) {
            log.error("Update dashboard action has error" + e.getMessage());
            e.getStackTrace();
        }

        //delete dashboard
        Response createDashboardResponse = given().spec(requestSpecification())
                .delete(getActionWithDashboardIdEndpoint());
        createDashboardResponse.then().assertThat().statusCode(200);
        log.info("The dashboard " + whatIsThe("id") + " was successfully deleted");
    }

}
