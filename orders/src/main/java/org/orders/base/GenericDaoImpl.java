package org.orders.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public  abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {
	
	/************inicio jdbctemplate******************/
		protected JdbcTemplate jdbcTemplate;
		
		//parametros
		protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		
		@Autowired
		public final void setDataSource(DataSource dataSource) {
		  this.jdbcTemplate = new JdbcTemplate(dataSource);
		  this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	  }
	/*************fin jdbctemplate*****************/
		
		
		
		
	/************INICIO llamar procedimientos******************/
	protected SimpleJdbcCall simpleJdbcCall;
	@Autowired
	protected DataSource dataSource;
	/************fin llamar procedimientos******************/
	
	
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Class<? extends E> daoType;

	/**
	 * By defining this class as abstract, we prevent Spring from creating instance
	 * of this class If not defined as abstract, getClass().getGenericSuperClass()
	 * would return Object. There would be exception because Object class does not
	 * hava constructor with parameters.
	 */
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		daoType = (Class<E>) pt.getActualTypeArguments()[0];
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(E entity) {
		currentSession().save(entity);
	}

	@Override
	public void saveOrUpdate(E entity) {
		currentSession().saveOrUpdate(entity);
	}

	@Override
	public void update(E entity) {
		currentSession().saveOrUpdate(entity);
	}

	@Override
	public void remove(E entity) {
		currentSession().delete(entity);
	}

	@Override
	public E find(K key) {
		return (E) currentSession().get(daoType, key);
	}

	@Override
	public List<E> getAll() {
		return currentSession().createCriteria(daoType).list();
	}
}