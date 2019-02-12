package com.cbaeza.mydb.controller;

import static io.restassured.RestAssured.get;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cbaeza.mydb.App;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, properties = {
    "server.port:8080" }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PersonControllerIT {

  private static final Logger LOG = LoggerFactory.getLogger(PersonControllerIT.class.getName());
  private static final String URL = "http://localhost:8080/persons";

  @Test
  public void testGetAllPersons() {
    String body = get(URL)
        .then()
        .statusCode(200)
        .extract()
        .body()
        .asString();
    LOG.info(body);
    assertNotNull(body);
    assertTrue(body.contains("\"id\":1"));
    assertTrue(body.contains("\"id\":2"));
    assertTrue(body.contains("\"id\":3"));
    assertTrue(body.contains("\"id\":4"));
  }

  @Test
  public void testGetPerson() {
    String body = get(URL + "/1")
        .then()
        .statusCode(200)
        .extract()
        .body()
        .asString();
    LOG.info(body);
    assertNotNull(body);
    assertTrue(body.contains("\"id\":1"));
  }

    @Test
    public void testGetUnknowPerson() {
        String body = get(URL + "/9999999")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();
        LOG.info(body);
        assertNotNull(body);
        assertTrue(body.contains("\"id\":-1"));
    }
}
