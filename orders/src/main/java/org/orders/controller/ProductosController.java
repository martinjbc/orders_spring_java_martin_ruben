package org.orders.controller;

import org.orders.domain.Pedido;
import org.orders.domain.Producto;
import org.orders.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("productos")
@RequestMapping("/productos")
public class ProductosController {
	@Autowired
	@Qualifier("ProductoService")
	private ProductoService productoService; 
	
	@RequestMapping(value= {"/","/list"}, method=RequestMethod.GET)
	public String testHandler(Model model) {
		model.addAttribute("lista", this.productoService.getAll());
		return "product/list";
	}	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newHandler(Model model) {
		model.addAttribute("pedido", new Producto());
		model.addAttribute("actionurl", "/productos/create");
		return "order/formOld";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createhandler(@Validated @ModelAttribute("producto") Producto producto,BindingResult result,Model model) {
		model.addAttribute("action", "/productos/create");
		
		if (!result.hasErrors()) {
			this.productoService.add(producto);;
		}
		
		return "order/formOld";
	}
	
}
