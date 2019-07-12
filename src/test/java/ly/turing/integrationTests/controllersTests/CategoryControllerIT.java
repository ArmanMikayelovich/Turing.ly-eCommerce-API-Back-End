package ly.turing.integrationTests.controllersTests;

import ly.turing.Application;
import ly.turing.util.ErrorObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashSet;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@TestPropertySource(value = {"classpath:application.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CategoryControllerIT {

    private int port = 8080;

    @Autowired
    private TestRestTemplate restTemplate;

    private String URL = "http://localhost:" + port + "/";


    @Test
    public void getAllCategories() throws URISyntaxException {
        URI resource = new URI(URL + "categories");

        Object responseObject = restTemplate.getForObject(resource, Object.class);
        if (responseObject instanceof ErrorObject) {
            fail();
        }
    }

    @Test
    public void getFirstCategory() throws URISyntaxException {
        //checking true condition
        URI resource = new URI(URL + "categories/" + 1);
        ResponseEntity responseObject = restTemplate.getForEntity(resource, Object.class);
        if (responseObject.getStatusCode() == HttpStatus.BAD_REQUEST) {
            fail();
        }

//        when not object with that id, should be return ErrorObject with 400 status
        resource = new URI(URL + "categories/-1");
        responseObject = restTemplate.getForEntity(resource, Object.class);
        if (responseObject.getStatusCode() != HttpStatus.BAD_REQUEST) {
            String failMessage = "unknown error. status should be 400, but comes - "
                    + responseObject.getStatusCodeValue();
            if (responseObject.getBody() != null) {
                assertTrue(ErrorObject.isErrorObject(responseObject.getBody()));
            }
            fail(failMessage);
        }
    }

    @Test
    public void getCategoryFromProductId() throws URISyntaxException {
        //true
        URI uri = new URI(URL + "categories/inProduct/1");
        ResponseEntity responseEntity = restTemplate.getForEntity(uri, Object.class);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            fail(responseEntity.getStatusCode().toString());
        }
        //Category with these id not exist
        responseEntity = restTemplate.getForEntity(URL + "categories/inProduct/-1", Object.class);
        if (responseEntity.getStatusCode() != HttpStatus.BAD_REQUEST) {
            if (!ErrorObject.isErrorObject(responseEntity.getBody())) {
                fail("Response body isn't ErrorObject");
            }
            fail("Not true answer from server");
        }

        responseEntity = restTemplate.getForEntity(URL + "categories/inProduct/sddf12", Object.class);
        if (responseEntity.getStatusCode() != HttpStatus.BAD_REQUEST) {
            if (!ErrorObject.isErrorObject(responseEntity.getBody())) {
                fail("Response body not a ErrorObject");
            }
            fail("Not true answer from server");
        }
    }

    @Test
    public void getCategoryWithDepartmentID() throws URISyntaxException {
        //true
        URI uri = new URI(URL + "categories/inDepartment/1");
        ResponseEntity responseEntity = restTemplate.getForEntity(uri, Object.class);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            fail(responseEntity.getStatusCode().toString());
        }

        //false
        uri = new URI(URL + "categories/inDepartment/-1");
        responseEntity = restTemplate.getForEntity(uri, Object.class);
        if (responseEntity.getStatusCode() != HttpStatus.BAD_REQUEST) {
            fail(responseEntity.getStatusCode().toString());
            if (!ErrorObject.isErrorObject(responseEntity.getBody())) {
                fail("Response body not a ErrorObject");
            }
            fail("Not true answer from server");
        }


        //false
        uri = new URI(URL + "categories/inDepartment/-as1");
        responseEntity = restTemplate.getForEntity(uri, Object.class);
        if (responseEntity.getStatusCode() != HttpStatus.BAD_REQUEST) {
            fail(responseEntity.getStatusCode().toString());
            if (!ErrorObject.isErrorObject(responseEntity.getBody())) {
                fail("Response body not a ErrorObject");
            }
            fail("parameter is not ID");
        }
    }
}
