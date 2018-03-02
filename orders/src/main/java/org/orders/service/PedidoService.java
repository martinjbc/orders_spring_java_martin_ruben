package org.orders.service;

import java.util.List;

import org.orders.base.GenericService;
import org.orders.domain.Pedido;

public interface PedidoService  extends GenericService<Pedido,Integer>{

	public List<Pedido> getAll();
}
