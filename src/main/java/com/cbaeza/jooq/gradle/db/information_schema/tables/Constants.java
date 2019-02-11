/*
 * This file is generated by jOOQ.
 */
package com.cbaeza.jooq.gradle.db.information_schema.tables;


import com.cbaeza.jooq.gradle.db.information_schema.InformationSchema;
import com.cbaeza.jooq.gradle.db.information_schema.tables.records.ConstantsRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Constants extends TableImpl<ConstantsRecord> {

    private static final long serialVersionUID = 400087297;

    /**
     * The reference instance of <code>INFORMATION_SCHEMA.CONSTANTS</code>
     */
    public static final Constants CONSTANTS = new Constants();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ConstantsRecord> getRecordType() {
        return ConstantsRecord.class;
    }

    /**
     * The column <code>INFORMATION_SCHEMA.CONSTANTS.CONSTANT_CATALOG</code>.
     */
    public final TableField<ConstantsRecord, String> CONSTANT_CATALOG = createField("CONSTANT_CATALOG", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.CONSTANTS.CONSTANT_SCHEMA</code>.
     */
    public final TableField<ConstantsRecord, String> CONSTANT_SCHEMA = createField("CONSTANT_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.CONSTANTS.CONSTANT_NAME</code>.
     */
    public final TableField<ConstantsRecord, String> CONSTANT_NAME = createField("CONSTANT_NAME", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.CONSTANTS.DATA_TYPE</code>.
     */
    public final TableField<ConstantsRecord, Integer> DATA_TYPE = createField("DATA_TYPE", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.CONSTANTS.REMARKS</code>.
     */
    public final TableField<ConstantsRecord, String> REMARKS = createField("REMARKS", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.CONSTANTS.SQL</code>.
     */
    public final TableField<ConstantsRecord, String> SQL = createField("SQL", org.jooq.impl.SQLDataType.VARCHAR(2147483647), this, "");

    /**
     * The column <code>INFORMATION_SCHEMA.CONSTANTS.ID</code>.
     */
    public final TableField<ConstantsRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>INFORMATION_SCHEMA.CONSTANTS</code> table reference
     */
    public Constants() {
        this(DSL.name("CONSTANTS"), null);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.CONSTANTS</code> table reference
     */
    public Constants(String alias) {
        this(DSL.name(alias), CONSTANTS);
    }

    /**
     * Create an aliased <code>INFORMATION_SCHEMA.CONSTANTS</code> table reference
     */
    public Constants(Name alias) {
        this(alias, CONSTANTS);
    }

    private Constants(Name alias, Table<ConstantsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Constants(Name alias, Table<ConstantsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Constants(Table<O> child, ForeignKey<O, ConstantsRecord> key) {
        super(child, key, CONSTANTS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return InformationSchema.INFORMATION_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Constants as(String alias) {
        return new Constants(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Constants as(Name alias) {
        return new Constants(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Constants rename(String name) {
        return new Constants(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Constants rename(Name name) {
        return new Constants(name, null);
    }
}
