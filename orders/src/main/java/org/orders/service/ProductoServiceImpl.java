package org.orders.service;

import java.util.List;

import org.orders.base.GenericServiceImpl;
import org.orders.dao.ProductoDao;
import org.orders.domain.Producto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("ProductoService")
public class ProductoServiceImpl  extends GenericServiceImpl<Producto, Integer, ProductoDao>
implements ProductoService  {
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Producto> getAll() {
		return genericDao.findAll();
	}
}
