package org.orders.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.orders.domain.Categorias;
import org.orders.service.CategoriasService;
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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("categorias")
@RequestMapping("categorias")
public class CategoriasController {
	
	 public static final String viewPath = "category";

	@Autowired
	@Qualifier("CategoriasService")
	private CategoriasService categoriasService;
	
	@RequestMapping(value= {"/","/list"}, method=RequestMethod.GET)
	public String testHandler(Model model) {
		model.addAttribute("lista", this.categoriasService.getAll());
		return viewPath+"/list";
	}	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newHandler(Model model) {
		model.addAttribute("categorias", new Categorias());
		model.addAttribute("actionurl", "./create");
		return viewPath+"/formOld";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createhandler(@Validated @ModelAttribute("categorias") Categorias categorias,BindingResult result,Model model) {
		model.addAttribute("action", "./create");
		
		if (!result.hasErrors()) {
			this.categoriasService.add(categorias);
			return "redirect:/"+viewPath+"/list";
			
		}else {
			return viewPath+"/formOld";
		}
		
		
	}
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editHandler(@PathVariable int id, Model model) {
		Categorias categorias = this.categoriasService.get(id);
		if (categorias != null) {
			
			model.addAttribute("actionurl", "../update");
			model.addAttribute("categorias", categorias);
			model.addAttribute("idcategoria", id);

			return viewPath+"/formOld";
			
		} 
		
		return viewPath+"/list";		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateHandler(@Validated @ModelAttribute("categorias") Categorias categorias,BindingResult result,Model model) {
		model.addAttribute("actionurl", "../update");
		if (!result.hasErrors()) {
			this.categoriasService.update(categorias);
			return "redirect:/"+viewPath+"/list";		
		}
		
		return viewPath+"/formOld";
	} 
	
	
	@RequestMapping(value="/delete/{id}",method={  RequestMethod.GET })
	public @ResponseBody Map<String,Object> eliminar(@PathVariable int id,HttpServletRequest req,HttpSession session){
		Map<String,Object> salida=new HashMap<String,Object>();

		try{
			Categorias categorias= this.categoriasService.get(id);
			
			if(categorias!=null){
				this.categoriasService.remove(categorias);
				salida.put("OK",1);
				salida.put("mensaje", "Eliminado Correctamente");
				
			}else{
				salida.put("OK",0);
				salida.put("mensaje", "No existe la categoria a eliminar");
			}
			
		}catch(Exception ex){
			salida.put("OK", -1);
			salida.put("mensaje","error grave:" + ex.getMessage());
		}
		return salida;
	}
}
