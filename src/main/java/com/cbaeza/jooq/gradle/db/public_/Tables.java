/*
 * This file is generated by jOOQ.
 */
package com.cbaeza.jooq.gradle.db.public_;


import com.cbaeza.jooq.gradle.db.public_.tables.FlywaySchemaHistory;
import com.cbaeza.jooq.gradle.db.public_.tables.Person;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in PUBLIC
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>PUBLIC.PERSON</code>.
     */
    public static final Person PERSON = com.cbaeza.jooq.gradle.db.public_.tables.Person.PERSON;

    /**
     * The table <code>PUBLIC.flyway_schema_history</code>.
     */
    public static final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = com.cbaeza.jooq.gradle.db.public_.tables.FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;
}
