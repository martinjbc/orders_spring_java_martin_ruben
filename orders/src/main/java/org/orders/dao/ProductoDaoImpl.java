package org.orders.dao;

import java.util.List;

import org.hibernate.Query;
import org.orders.base.GenericDaoImpl;
import org.orders.domain.Producto;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoDaoImpl extends GenericDaoImpl<Producto, Integer> implements ProductoDao {

	@Override
	public List<Producto> findAll() {
		Query query = this.currentSession().createQuery("from producto");
		return query.list();
	}	
	

}
