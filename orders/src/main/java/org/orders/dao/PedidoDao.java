package org.orders.dao;

import java.util.List;

import org.orders.base.GenericDao;

import org.orders.domain.Pedido;

public interface PedidoDao extends GenericDao<Pedido, Integer> {
	public List<Pedido> findAll();
}
