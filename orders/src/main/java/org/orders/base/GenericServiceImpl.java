package org.orders.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public  abstract class GenericServiceImpl<E, K, D extends GenericDao<E, K>> implements GenericService<E, K> {

	@Autowired
	protected D genericDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdate(E entity) {
		genericDao.saveOrUpdate(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<E> getAll() {
		return genericDao.getAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public E get(K id) {
		return genericDao.find(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void add(E entity) {
		genericDao.add(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(E entity) {
		genericDao.update(entity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(E entity) {
		genericDao.remove(entity);
	}
}