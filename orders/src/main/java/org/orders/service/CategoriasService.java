package org.orders.service;

import java.util.List;

import org.orders.base.GenericService;
import org.orders.domain.Categorias;


public interface CategoriasService extends GenericService<Categorias,Integer>{
	public List<Categorias> listaPersonalizada();
}
