package org.orders.service;

import java.util.List;

import org.orders.base.GenericService;
import org.orders.entity.Productos;

public interface ProductosService  extends GenericService<Productos,Integer>{
	public List<Productos> listarJdbc();
	public List<Productos> listarProcedure();
}
