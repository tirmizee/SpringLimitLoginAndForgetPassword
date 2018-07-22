package com.tirmizee.core.jdbcrepository;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Persistable;
import org.springframework.jdbc.core.RowMapper;

import com.tirmizee.core.config.RepositoryConfig;
import com.tirmizee.core.jdbcrepository.sql.SqlGenerator;

/**
 * Extends AbstractJdbcRepository Connect to the Microsoft SQL Server database.
 * 
 * @author pratya yeekhaday
 */

public abstract class AbstractMssqlRepository<T extends Persistable<ID>,ID extends Serializable> extends AbstractJdbcRepository<T,ID> {

	public AbstractMssqlRepository(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper, SqlGenerator sqlGenerator,
			TableDescription table) {
		super(rowMapper, rowUnmapper, sqlGenerator, table);
	}

	public AbstractMssqlRepository(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper, String tableName,
			String idColumn) {
		super(rowMapper, rowUnmapper, tableName, idColumn);
	}

	public AbstractMssqlRepository(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper, String tableName) {
		super(rowMapper, rowUnmapper, tableName);
	}

	public AbstractMssqlRepository(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper, TableDescription table) {
		super(rowMapper, rowUnmapper, table);
	}

	public AbstractMssqlRepository(RowMapper<T> rowMapper, String tableName, String idColumn) {
		super(rowMapper, tableName, idColumn);
	}

	public AbstractMssqlRepository(RowMapper<T> rowMapper, String tableName) {
		super(rowMapper, tableName);
	}

	public AbstractMssqlRepository(RowMapper<T> rowMapper, TableDescription table) {
		super(rowMapper, table);
	}

	@Override 
	@Autowired @Qualifier(RepositoryConfig.MSSQL_DATASOURCE)
	protected void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
}
