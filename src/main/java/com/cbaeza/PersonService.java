package com.cbaeza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
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
    Result<Record> result = executeQuery(Person.PERSON);
    return MapUtils.mapPersons(result);
  }

  public PersonDto getPerson(int id) {
    Result<Record> result = executeQuery(Person.PERSON, Person.PERSON.ID.eq(id));
    return MapUtils.mapPerson(result);
  }

  private Result<Record> executeQuery(Table table) {
    return executeQuery(table, null);
  }

  private Result<Record> executeQuery(Table table, Condition condition) {
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      DSLContext create = DSL.using(conn, SQLDialect.H2);
      if (condition != null) {
        return create.select().from(table).where(condition).fetch();
      } else {
        return create.select().from(table).fetch();
      }
    } catch (Exception e) {
      LOG.error("executeQuery", e);
    }
    return null;
  }

}
