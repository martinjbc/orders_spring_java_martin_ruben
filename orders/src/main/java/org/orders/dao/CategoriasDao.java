package org.orders.dao;

import java.util.List;

import org.orders.base.GenericDao;
import org.orders.entity.Categorias;

public interface CategoriasDao extends GenericDao<Categorias, Integer> {
	public List<Categorias> listaPersonalizada();
}
