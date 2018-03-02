package org.orders.dao;

import java.util.List;

import org.orders.base.GenericDao;
import org.orders.domain.Producto;

public interface ProductoDao  extends GenericDao<Producto, Integer>{
	public List<Producto> findAll();
}
