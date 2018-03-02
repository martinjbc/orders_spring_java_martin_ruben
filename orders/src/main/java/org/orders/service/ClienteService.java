package org.orders.service;

import java.util.List;

import org.orders.base.GenericService;
import org.orders.domain.Cliente;

public interface ClienteService extends GenericService<Cliente,Integer>{
	public List<Cliente> getAll();
}
