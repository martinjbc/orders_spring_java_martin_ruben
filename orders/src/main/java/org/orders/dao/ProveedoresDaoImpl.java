package org.orders.dao;

import org.orders.base.GenericDaoImpl;
import org.orders.domain.Proveedores;
import org.springframework.stereotype.Repository;

@Repository("ProveedoresDao")
public class ProveedoresDaoImpl  extends GenericDaoImpl<Proveedores, Integer> implements ProveedoresDao{

}
