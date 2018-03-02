package org.orders.service;

import java.util.List;

import org.orders.base.GenericServiceImpl;
import org.orders.dao.ClienteDao;
import org.orders.domain.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("ClienteService")
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Integer, ClienteDao> 
implements ClienteService {
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Cliente> getAll() {
		return this.genericDao.findAll();
	}
}
