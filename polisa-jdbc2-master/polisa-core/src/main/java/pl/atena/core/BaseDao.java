package pl.atena.core;

import java.sql.SQLException;
import java.util.List;

import pl.atena.domain.base.Entity;

public interface BaseDao<T extends Entity, F extends Object> {

	void create(T entity) throws SQLException;

	T retrieve(Long id) throws SQLException;

	boolean update(T entity) throws SQLException;

	boolean delete(T entity) throws SQLException;

	List<T> select(F filter) throws SQLException;

}
