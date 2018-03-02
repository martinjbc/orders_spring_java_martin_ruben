package org.orders.dao;

import java.util.List;

import org.orders.base.GenericDao;
import org.orders.entity.Productos;

public interface ProductosDao  extends GenericDao<Productos, Integer>{
	public List<Productos> listarJdbc();
	public List<Productos> listarProcedure();
}
