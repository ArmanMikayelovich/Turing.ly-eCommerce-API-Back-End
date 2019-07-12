package ly.turing.integrationTests.controllersTests;

import ly.turing.Application;
import ly.turing.controllers.AttributeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@TestPropertySource(value = {"classpath:application.properties"})
@SpringBootTest
public class AttributeControllerIT {

    @Autowired
    private AttributeController attributeController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllAttributes() {

    }
}
