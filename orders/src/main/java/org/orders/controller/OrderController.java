package org.orders.controller;

import java.beans.PropertyEditorSupport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.orders.domain.Cliente;
import org.orders.domain.Detalle;
import org.orders.domain.Pedido;
import org.orders.service.ClienteService;
import org.orders.service.PedidoService;
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

@Controller("Order")
public class OrderController {

	@Autowired
	@Qualifier("PedidoService")	
	private PedidoService pedidoService;
	
	@Autowired
	@Qualifier("ClienteService")
	private ClienteService clienteService;
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder  binder) throws     Exception {
		binder.registerCustomEditor(Cliente.class, "cliente", new PropertyEditorSupport() {
			public void setAsText(String text) {
				
			    Cliente cliente = clienteService.get(Integer.parseInt(text));
			    setValue(cliente);
			}
		});
	} 
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String testHandler(Model model) {
		System.out.println(this.pedidoService.getAll().size());
		for (Pedido pedido : this.pedidoService.getAll()) {
			System.out.println(pedido.getDestinatario() + " " + pedido.getCliente().getNombrecompania());
		}
		model.addAttribute("list", this.pedidoService.getAll());
		return "order/list";
	}	
	
	@RequestMapping(value="/pedidos/list", method=RequestMethod.GET)
	public String listHandler(Model model) {
		model.addAttribute("orders", this.pedidoService.getAll());
		return "order/list";
	}
	
	@RequestMapping(value="/pedidos/new", method=RequestMethod.GET)
	public String newHandler(Model model) {
		model.addAttribute("pedido", new Pedido());
		model.addAttribute("action", "/pedidos/create");
		model.addAttribute("clientes", this.clienteService.getAll());

		return "order/formOld";
	}	
	
	@RequestMapping(value="/pedidos/create", method=RequestMethod.POST)
	public String createhandler(@Validated @ModelAttribute("pedido") Pedido pedido,BindingResult result,Model model) {
		model.addAttribute("action", "/pedidos/create");
		model.addAttribute("clientes", this.clienteService.getAll());
		if (!result.hasErrors()) {
			this.pedidoService.saveOrUpdate(pedido);
		}
		
		return "order/formOld";
	}
	
	@RequestMapping(value="/pedidos/edit/id/{id}", method=RequestMethod.GET)
	public String editHandler(@PathVariable int id, Model model) {
		Pedido pedido = this.pedidoService.get(id);
		if (pedido != null) {
			System.out.println(pedido.getDestinatario());
			model.addAttribute("action", "/pedidos/update");
			model.addAttribute("pedido", pedido);
			model.addAttribute("clientes", this.clienteService.getAll());
			model.addAttribute("detalles",pedido.getDetalles());
			model.addAttribute("pedidoId", id);
			
			for (Detalle detalle : pedido.getDetalles()) {
				System.out.println("cantidad " + detalle.getCantidad());
			}
			
			return "order/formOld";
		} 
		
		return "order/list";		
	}
	
	@RequestMapping(value="/pedidos/update", method=RequestMethod.POST)
	public String updateHandler(@Validated @ModelAttribute("pedido") Pedido pedido,BindingResult result,Model model) {
		model.addAttribute("action", "/pedidos/update");
		model.addAttribute("clientes", this.clienteService.getAll());
		if (!result.hasErrors()) {
			this.pedidoService.update(pedido);
		}
		
		return "order/formOld";
	} 

}
