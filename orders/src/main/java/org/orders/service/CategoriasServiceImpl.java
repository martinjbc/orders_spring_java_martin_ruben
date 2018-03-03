package org.orders.service;

import java.util.List;

import org.orders.base.GenericServiceImpl;
import org.orders.dao.CategoriasDao;
import org.orders.domain.Categorias;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("CategoriasService")
public class CategoriasServiceImpl extends GenericServiceImpl<Categorias, Integer, CategoriasDao> implements CategoriasService {
	
	@Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Categorias> listaPersonalizada() {
        return genericDao.listaPersonalizada();
    }
}
