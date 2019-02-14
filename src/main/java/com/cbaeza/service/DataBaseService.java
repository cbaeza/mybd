package com.cbaeza.service;

import java.sql.Connection;
import java.sql.DriverManager;

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

/**
 * Data Base service responsible to encapsulate DB calls
 */
@Service
public class DataBaseService {

  private static final Logger LOG = LoggerFactory.getLogger(DataBaseService.class.getName());

  @Value("${db.url}")
  private String url;

  @Value("${db.user}")
  private String user;

  @Value("${db.password}")
  private String password;

  public Result<Record> executeSelectQuery(final Table table) {
    return executeSelectQuery(table, null);
  }

  public Result<Record> executeSelectQuery(final Table table, final Condition condition) {
    if (table == null) {
      LOG.error("Table is mandatory and can't be null");
      return null;
    }

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

  @SuppressWarnings("unchecked")
  public int executeUpdateQuery(final Table table, final Condition condition, final Field row, final String value) {
    if (table == null || row == null || value == null) {
      LOG.error("Parameter is mandatory and can't be null table: {}, row: {}, condition: {}", table, row, value);
      return -1;
    }
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
