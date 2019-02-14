package com.cbaeza.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jooq.Record;
import org.jooq.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cbaeza.jooq.gradle.db.public_.tables.Person;
import com.cbaeza.mydb.App;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, properties = {
    "server.port:8080" }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DataBaseServiceTest {

  @Autowired
  private DataBaseService dataBaseService;

  @Test
  public void executeSelectQuery() {
    assertNotNull(dataBaseService);
    Result<Record> records = dataBaseService.executeSelectQuery(Person.PERSON);
    assertNotNull(records);
    assertEquals(4, records.size());
  }

  @Test
  public void executeSelectQuery1() {
    assertNotNull(dataBaseService);
    Result<Record> records = dataBaseService.executeSelectQuery(Person.PERSON, null);
    assertNotNull(records);
    assertEquals(4, records.size());
  }

  @Test
  public void executeUpdateQuery() {
    assertNotNull(dataBaseService);
    int i = dataBaseService.executeUpdateQuery(Person.PERSON, null, null, null);
    assertEquals(-1, i);
  }
}