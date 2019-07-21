package ly.turing.integrationTests.controllersTests;

import ly.turing.Application;
import ly.turing.controllers.AttributeController;
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

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@TestPropertySource(value = {"classpath:application.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AttributeControllerIT {

    private int port = 8080;

    private String attributesResource = "http://localhost:" + port + "/attributes";
    private String attributeWithId = attributesResource + "/";
    private String attributeWithValues = attributesResource + "/values/";
    private String attributeWithProduct = attributesResource + "/inProduct/";


    @Autowired
    private AttributeController attributeController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllAttributes() throws URISyntaxException {

        ResponseEntity responseEntity = restTemplate.getForEntity(new URI(attributesResource), Object.class);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            fail("Incorrent response from server" + responseEntity.getBody().toString());
        }
    }

    @Test
    public void getAttributeDtoWithId_checkCorrectId() throws URISyntaxException {
        URI uri = new URI(attributeWithId + 1);
        ResponseEntity responseEntity = restTemplate.getForEntity(uri, Object.class);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            fail(responseEntity.toString());
        }
    }

    @Test
    public void getAttributeDtoWithId_checkIncorrectId() throws URISyntaxException {
        URI uri = new URI(attributeWithId + "-1");
        ResponseEntity responseEntity = restTemplate.getForEntity(uri, Object.class);
        if (responseEntity.getStatusCode() != HttpStatus.BAD_REQUEST) {
            fail(responseEntity.toString());
        }

         uri = new URI(attributeWithId + "dsaf");
         responseEntity = restTemplate.getForEntity(uri, Object.class);
        if (responseEntity.getStatusCode() != HttpStatus.BAD_REQUEST) {
            fail(responseEntity.toString());
        }
    }

}
