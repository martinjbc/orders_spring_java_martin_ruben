package org.orders.controller;


import java.beans.PropertyEditorSupport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.orders.domain.Categorias;
import org.orders.domain.Detalle;
import org.orders.domain.Pedido;
import org.orders.domain.Producto;
import org.orders.domain.Proveedores;
import org.orders.service.CategoriasService;
import org.orders.service.ProductoService;
import org.orders.service.ProveedoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("productos")
@RequestMapping("/productos")
public class ProductosController {
	
	@Autowired
	@Qualifier("ProductoService")
	private ProductoService productoService; 
	
	@Autowired
	@Qualifier("CategoriasService")
	private CategoriasService categoriasService;
	
	@Autowired
	@Qualifier("ProveedoresServices")
	private ProveedoresServices proveedoresServices;
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder  binder) throws     Exception {
		binder.registerCustomEditor(Categorias.class, "categorias", new PropertyEditorSupport() {
			public void setAsText(String text) {
				
			    Categorias categoria = categoriasService.get(Integer.parseInt(text));
			    setValue(categoria);
			}
		});
		
		binder.registerCustomEditor(Proveedores.class, "proveedores", new PropertyEditorSupport() {
			public void setAsText(String text) {
				
			    Proveedores proveedores = proveedoresServices.get(Integer.parseInt(text));
			    setValue(proveedores);
			}
		});
	} 
	
	@RequestMapping(value= {"/","/list"}, method=RequestMethod.GET)
	public String testHandler(Model model) {
		model.addAttribute("lista", this.productoService.getAll());
		return "product/list";
	}	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newHandler(Model model) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("categorias", this.categoriasService.getAll());
		model.addAttribute("proveedores", this.proveedoresServices.getAll());
		model.addAttribute("actionurl", "./create");
		return "product/formOld";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createhandler(@Validated @ModelAttribute("producto") Producto producto,BindingResult result,Model model) {
		model.addAttribute("action", "./create");
		
		if (!result.hasErrors()) {
			this.productoService.add(producto);
			return "redirect:/productos/list";
			
		}else {
			model.addAttribute("categorias", this.categoriasService.getAll());
			model.addAttribute("proveedores", this.proveedoresServices.getAll());
			return "product/formOld";
		}
		
		
	}
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editHandler(@PathVariable int id, Model model) {
		Producto producto = this.productoService.get(id);
		if (producto != null) {
			
			model.addAttribute("actionurl", "../update");
			model.addAttribute("producto", producto);
			model.addAttribute("categorias", this.categoriasService.getAll());
			model.addAttribute("proveedores", this.proveedoresServices.getAll());
			model.addAttribute("idProducto", id);

			return "product/formOld";
			
		} 
		
		return "product/list";		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateHandler(@Validated @ModelAttribute("producto") Producto producto,BindingResult result,Model model) {
		model.addAttribute("actionurl", "../update");
		model.addAttribute("categorias", this.categoriasService.getAll());
		model.addAttribute("proveedores", this.proveedoresServices.getAll());
		if (!result.hasErrors()) {
			this.productoService.update(producto);
			return "redirect:/productos/list";		
		}
		
		return "product/formOld";
	} 
	
	
	@RequestMapping(value="/delete/{id}",method={  RequestMethod.GET })
	public @ResponseBody Map<String,Object> eliminar(@PathVariable int id,HttpServletRequest req,HttpSession session){
		Map<String,Object> salida=new HashMap<String,Object>();

		try{
			Producto producto = this.productoService.get(id);
			
			if(producto!=null){
				this.productoService.remove(producto);
				salida.put("OK",1);
				salida.put("mensaje", "Eliminado Correctamente");
				
			}else{
				salida.put("OK",0);
				salida.put("mensaje", "No existe el producto a eliminar");
			}
			
		}catch(Exception ex){
			salida.put("OK", -1);
			salida.put("mensaje","error grave:" + ex.getMessage());
		}
		return salida;
	}
	
}
