package dao;

import java.util.List;

public interface GenericDao<T> {
	void save(T entity);

	void update(T entity);

	void delete(T entity);

	List<T> findAll();
}
