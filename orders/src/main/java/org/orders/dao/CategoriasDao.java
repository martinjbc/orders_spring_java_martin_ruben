package org.orders.dao;

import java.util.List;

import org.orders.base.GenericDao;
import org.orders.domain.Categorias;


public interface CategoriasDao extends GenericDao<Categorias, Integer> {
	public List<Categorias> listaPersonalizada();
}
