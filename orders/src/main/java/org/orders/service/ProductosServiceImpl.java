package org.orders.service;

import java.util.List;

import org.orders.base.GenericServiceImpl;
import org.orders.dao.ProductosDao;
import org.orders.entity.Productos;
import org.springframework.stereotype.Service;

@Service("ProductosService")
public class ProductosServiceImpl  extends GenericServiceImpl<Productos, Integer, ProductosDao>
implements ProductosService  {
	@Override
	public List<Productos> listarJdbc() {
		return genericDao.listarJdbc();
	}
	@Override
	public List<Productos> listarProcedure() {
		return genericDao.listarProcedure();
	}
}
