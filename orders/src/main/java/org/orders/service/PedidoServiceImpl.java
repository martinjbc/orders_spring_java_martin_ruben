package org.orders.service;

import java.util.List;

import org.orders.base.GenericServiceImpl;
import org.orders.dao.CategoriasDao;
import org.orders.dao.PedidoDao;
import org.orders.dao.PedidoDaoImpl;
import org.orders.entity.Categorias;
import org.orders.domain.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("PedidoService")
public class PedidoServiceImpl extends GenericServiceImpl<Pedido, Integer, PedidoDao> implements PedidoService {
	
	@Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Pedido> getAll() {
		return this.genericDao.findAll();
	}
}
