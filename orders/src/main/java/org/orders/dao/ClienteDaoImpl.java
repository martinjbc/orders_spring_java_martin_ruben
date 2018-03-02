package org.orders.dao;

import java.util.List;

import org.hibernate.Query;
import org.orders.base.GenericDaoImpl;
import org.orders.domain.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> 
implements ClienteDao {

	@Override
	public List<Cliente> findAll() {
		Query query = currentSession().createQuery("from cliente");
		return query.list();
	}

}
