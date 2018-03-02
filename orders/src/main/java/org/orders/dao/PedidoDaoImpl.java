package org.orders.dao;

import java.util.List;

import org.hibernate.Query;

import org.orders.base.GenericDaoImpl;
import org.orders.domain.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoDaoImpl extends GenericDaoImpl<Pedido, Integer> implements PedidoDao {

	@Override
	public List<Pedido> findAll() {
		Query query = currentSession().createQuery("from pedido");
		return query.list();
	}
}
