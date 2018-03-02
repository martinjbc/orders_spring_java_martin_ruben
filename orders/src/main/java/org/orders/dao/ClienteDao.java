package org.orders.dao;

import java.util.List;

import org.orders.base.GenericDao;
import org.orders.domain.Cliente;

public interface ClienteDao extends GenericDao<Cliente, Integer> {
	public List<Cliente> findAll();
}
