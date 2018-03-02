package org.orders.service;

import java.util.List;

import org.orders.base.GenericService;
import org.orders.domain.Producto;

public interface ProductoService  extends GenericService<Producto,Integer>{
	public List<Producto> getAll();

}
