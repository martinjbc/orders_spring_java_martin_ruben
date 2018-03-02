package org.orders.controller;

import org.orders.domain.Detalle;
import org.orders.domain.DetalleId;
import org.orders.domain.Pedido;
import org.orders.domain.Producto;
import org.orders.entity.Productos;
import org.orders.service.PedidoService;
import org.orders.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("detalle")
public class DetalleController {
	
	@Autowired
	@Qualifier("PedidoService")		
	private PedidoService pedidoService;
	
	@Autowired
	@Qualifier("ProductoService")
	private ProductoService productoService;
	
	@RequestMapping(value="/detalle/new/pedidoid/{pedidoId}", method = RequestMethod.GET)
	public String newHandler(@PathVariable int pedidoId, Model model) {
		Pedido pedido = pedidoService.get(pedidoId);
		Detalle detalle = new Detalle();
		detalle.setPedido(pedido);
		System.out.println(" size " + this.productoService.getAll().size());
		model.addAttribute("action", "/detalle/create");
		model.addAttribute("detalle", detalle);
		
		for (Producto producto : this.productoService.getAll()) {
			System.out.println(producto.getNombreproducto());
		}
		
		model.addAttribute("productos", this.productoService.getAll());
		
		return "order/formDetalle";
	}
	
	@RequestMapping(value="/detalle/create", method = RequestMethod.POST)
	public String createHandler(@Validated @ModelAttribute("detalle") Detalle detalle,
								@RequestParam("producto.idProducto") int idProducto,
								@RequestParam("pedido.idpedido") int idPedido,
								BindingResult result,  Model model) {
		
		System.out.println(" size " + this.productoService.getAll().size());
		model.addAttribute("action", "/detalle/create");
		model.addAttribute("detalle", detalle);
		System.out.println("producto  " + idProducto + " pedido " + idPedido);
		model.addAttribute("productos", this.productoService.getAll());
		if (!result.hasErrors()) {
			Producto producto = this.productoService.get(idProducto);
			Pedido pedido = pedidoService.get(idPedido);
			System.out.println("producto selec " + idPedido);
			
			System.out.println("descr prod " + this.productoService.getAll().get(idProducto).getNombreproducto());
			detalle.setProducto(producto);
			detalle.setPedido(pedido);
			DetalleId detalleId = new DetalleId(idPedido, idProducto);
			detalle.setIdDetalle(detalleId);
			pedido.getDetalles().add(detalle);
			
			pedidoService.saveOrUpdate(pedido);
			
			return "redirect:/pedidos/edit/id/" + idPedido;
		}
		
		return "order/formDetalle";
	}
}
