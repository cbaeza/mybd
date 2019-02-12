package com.cbaeza.mydb;

import static io.restassured.RestAssured.get;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, properties = {
    "server.port:8080" }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WebAppIT {

  private static final String URL = "http://localhost:8080";

  @Test
  public void testHelloController() {
    String body = get(URL)
        .then()
        .statusCode(200)
        .extract()
        .body()
        .asString();
    assertTrue("Unexpected message: " + body, body.contains("Hello from App HelloController"));
  }

  @Test
  public void test404() {
    String body = get(URL + "/bla")
        .then()
        .statusCode(404)
        .extract()
        .body()
        .asString();
  }
}
