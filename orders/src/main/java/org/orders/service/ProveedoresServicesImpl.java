package org.orders.service;

import org.orders.base.GenericServiceImpl;
import org.orders.dao.ProveedoresDao;
import org.orders.domain.Proveedores;
import org.springframework.stereotype.Service;

@Service("ProveedoresServices")
public class ProveedoresServicesImpl  extends GenericServiceImpl<Proveedores, Integer, ProveedoresDao> implements ProveedoresServices{

}
