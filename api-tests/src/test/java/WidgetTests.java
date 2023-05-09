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
public class WidgetTests {

    private final TemplateUtils templateUtils = new TemplateUtils();

    public static final String BASE_URL = "http://localhost:8080";
    public static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NjgyNzY0NTcsInVzZXJfbmFtZSI6InN1cGVyYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOSVNUUkFUT1IiXSwianRpIjoiZDlkYjY3MTAtZGUzMy00NDNjLTk2MzEtNDk2Y2Q4M2MyZmEyIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.p5a0gYUApIfiRt5S1rPTFnugYwBg7brEZVuN9fy8nuQ";
    public static final String DESCRIPTION = "description";
    public static final String NAME = "name";

    String initialDescription = "New Widget784";
    String initialName = "Widget784";
    String newDescription = "Updated784 Description of widget";
    String newName = "Updated784 Name of widget";


    private String getCreateWidgetEndpoint() {
        return "/api/v1/default_personal/widget";
    }

    private String getActionWithWidgetIdEndpoint() {
        return "/api/v1/default_personal/widget/" + whatIsThe("id");
    }


    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "bearer" + TOKEN)
                .build();
    }

    @Test
    public void actionsWidgetTest() {
        //create widget
        final Map<String, Object> initialValues = new HashMap<>();
        initialValues.put(DESCRIPTION, initialDescription);
        initialValues.put(NAME, initialName);
        try {
            String createPayload = templateUtils
                    .getResolvedTemplate("models/widget/create_widget.json", initialValues);
            Response createWidgetResponse = given().spec(requestSpecification())
                    .body(createPayload)
                    .when().post(getCreateWidgetEndpoint());
            Object id = createWidgetResponse.jsonPath().get("id");
            createWidgetResponse.then().assertThat().statusCode(201);
            log.info("The widget " + id + " was created successfully");
            rememberThatThe("id", id);
        } catch (IOException e) {
            log.error("Creation widget action has error" + e.getMessage());
            e.getStackTrace();
        }
        //update widget
        final Map<String, Object> updatedValues = new HashMap<>();
        updatedValues.put(DESCRIPTION, newDescription);
        updatedValues.put(NAME, newName);
        try {
            String updatePayload = templateUtils
                    .getResolvedTemplate("models/widget/update_widget.json", updatedValues);
            Response createWidgetResponse = given().spec(requestSpecification()).body(updatePayload)
                    .when().put(getActionWithWidgetIdEndpoint());
            createWidgetResponse.then().assertThat().statusCode(200);
            log.info("The widget " + whatIsThe("id") + " was updated successfully");
        } catch (IOException e) {
            log.error("Update widget action has error" + e.getMessage());
            e.getStackTrace();
        }


    }


}
