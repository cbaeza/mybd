package com.cbaeza.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cbaeza.dto.PersonDto;
import com.cbaeza.dto.ResponseDto;
import com.cbaeza.jooq.gradle.db.public_.tables.Person;
import com.cbaeza.util.MapUtils;

/**
 * Service responsible to retrieve person data from DB.
 */
@Service
public class PersonService {

  private static final Logger LOG = LoggerFactory.getLogger(PersonService.class.getName());

  @Value("${db.url}")
  private String url;

  @Value("${db.user}")
  private String user;

  @Value("${db.password}")
  private String password;

  public List<PersonDto> getAllPersons() {
    Result<Record> result = executeSelectQuery(Person.PERSON);
    return MapUtils.mapPersons(result);
  }

  public PersonDto getPerson(int id) {
    Result<Record> result = executeSelectQuery(Person.PERSON, Person.PERSON.ID.eq(id));
    return MapUtils.mapPerson(result);
  }

  public ResponseDto updatePerson(final int id, final PersonDto personDto) {
    if (personDto != null) {
      int i = executeUpdateQuery(Person.PERSON, Person.PERSON.ID.eq(id), Person.PERSON.NAME, personDto.getName());
      LOG.info(">>>> result update: " + i);
      return new ResponseDto(i + " row affected");
    }
    return new ResponseDto("personDto can not be null");
  }

  private Result<Record> executeSelectQuery(Table table) {
    return executeSelectQuery(table, null);
  }

  private Result<Record> executeSelectQuery(Table table, Condition condition) {
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      DSLContext create = DSL.using(conn, SQLDialect.H2);
      if (condition != null) {
        return create.select().from(table).where(condition).fetch();
      } else {
        return create.select().from(table).fetch();
      }
    } catch (Exception e) {
      LOG.error("executeSelectQuery", e);
    }
    return null;
  }

  private int executeUpdateQuery(Table table, Condition condition, Field row, String value) {
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      DSLContext create = DSL.using(conn, SQLDialect.H2);
      if (condition != null) {
        return create.update(table).set(row, value).where(condition).execute();
      }
    } catch (Exception e) {
      LOG.error("executeSelectQuery", e);
    }
    return -1;
  }

}
