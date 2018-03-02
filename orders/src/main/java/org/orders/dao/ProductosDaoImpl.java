package org.orders.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.orders.base.GenericDaoImpl;
import org.orders.entity.Productos;
import org.orders.mapper.ProductosMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
@Repository("ProductosDao")
public class ProductosDaoImpl extends GenericDaoImpl<Productos, Integer> implements ProductosDao {

	private String PACKAGE  = "PRODUCTOS_API";
	private String SP_LISTAR_PRODUCTOS = "SP_LISTAR_PRODUCTOS";
	
	
	@Override
	public List<Productos> listarJdbc() {
		List<Productos> lista=null;
		
		MapSqlParameterSource parametros = new MapSqlParameterSource()
				//.addValue("P_ANIO", m.get("P_ANIO"))
				.addValue("P_MAY_ID_PRODUCTO", 72);
		
		String sql = "select IdProducto,NombreProducto,IdProveedor,IdCategoria,PrecioUnidad,stock,Suspendido from productos where IdProducto>:P_MAY_ID_PRODUCTO";
		//parametros.addValue("P_MAY_ID_PRODUCTO", 70);
  		lista= this.namedParameterJdbcTemplate.query(sql,parametros, new ProductosMapper());
		return lista;
	}
	
	@Override
	public List<Productos> listarProcedure() {
		simpleJdbcCall = new SimpleJdbcCall(dataSource);
		simpleJdbcCall.withCatalogName(PACKAGE)
		.withProcedureName(SP_LISTAR_PRODUCTOS)
		.declareParameters(	new SqlParameter("P_MAY_ID_PRODUCTO", OracleTypes.INTEGER),
				//new SqlParameter("varIdProducto", OracleTypes.INTEGER),
				new SqlOutParameter("O_CURSOR", OracleTypes.CURSOR, new ProductosMapper())
	     );
		
		MapSqlParameterSource inData = new MapSqlParameterSource()
		//.addValue("P_ANIO", m.get("P_ANIO"))
		.addValue("P_MAY_ID_PRODUCTO", 72);
		
		Map<String, Object> outData = simpleJdbcCall.execute(inData);
		List<Productos> lista = (List<Productos>) outData.get("O_CURSOR");
		double total = Double.parseDouble(outData.get("O_TOTAL").toString()) ;
		System.out.println("mira el total del procedure:"+total);
		return lista;
	}

}
