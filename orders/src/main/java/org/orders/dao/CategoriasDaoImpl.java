package org.orders.dao;

import java.util.List;

import org.hibernate.Query;
import org.orders.base.GenericDaoImpl;
import org.orders.domain.Categorias;
import org.springframework.stereotype.Repository;

@Repository("CategoriasDao")
public class CategoriasDaoImpl extends GenericDaoImpl<Categorias, Integer> 
implements CategoriasDao{
	
	@Override
    public List<Categorias> listaPersonalizada() {
        Query employeeTaskQuery = currentSession().createQuery(
                "from Categorias c where idcategoria>=:varIdCategoria");
        employeeTaskQuery.setParameter("varIdCategoria", 0);
        return employeeTaskQuery.list();
    }
}
