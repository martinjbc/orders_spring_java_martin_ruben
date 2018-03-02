package org.orders.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.orders.entity.Productos;
import org.springframework.jdbc.core.RowMapper;

public class ProductosMapper implements RowMapper<Productos>{

	@Override
	  public Productos mapRow(ResultSet rs, int i) throws SQLException {
		  Productos bean = new Productos();
		  bean.setIdProducto(rs.getInt("idProducto"));
		  bean.setNombreproducto(rs.getString("nombreproducto"));
		  bean.setIdProveedor(rs.getInt("idProveedor"));
		  bean.setIdCategoria(rs.getInt("idCategoria"));
		  bean.setPrecio(rs.getDouble("preciounidad"));
		  bean.setStock(rs.getInt("stock"));
		  bean.setSuspendido(rs.getInt("suspendido"));
		  return bean;
	  }
	
}