package com.cts.grizzlystore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzlystore.bean.Product;
import com.cts.grizzlystore.service.ProductService;

@Controller
public class ProductController {
	 @Autowired
	  private ProductService productService; 

	@RequestMapping(value="addProduct.html", method=RequestMethod.GET)
	
	public String geProductPage()
	{
		return "addProduct";
	}
	

	@RequestMapping(value="updateProduct.html", method=RequestMethod.GET)
	public String getUpdatePage()
	{
		return "updateProduct";
	}
	
	/*@RequestMapping(value="deleteProduct.html", method=RequestMethod.GET)
	public String getDeletePage()
	{
		return "deleteProduct";
	}*/
	
	/*@RequestMapping(value="viewProduct.html", method=RequestMethod.GET)
	public String getViewPage(Model model)
	{
		// model.addAttribute("product", new Product());
	      model.addAttribute("products", productService.getAllProducts());

	      return "viewProduct";
	}*/
	
	
	
	
	@RequestMapping(value="updateProduct.html", method=RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute Product product) 
	{
		ModelAndView modelAndView = new ModelAndView();
		if("success".equals(productService.updateProduct(product)))
			System.out.println("updated product");
			modelAndView.setViewName("admin");
	
	return modelAndView;
	}
	
	/*@RequestMapping(value="deleteProduct.html", method=RequestMethod.POST)
	public ModelAndView deleteProduct(@ModelAttribute Product product) 
	{
		ModelAndView modelAndView = new ModelAndView();
		if("success".equals(productService.deleteProduct(product.getProductId())))
			System.out.println("deleted product");
			modelAndView.setViewName("admin");
		return modelAndView;
	}*/
	
	@RequestMapping(value="AddProduct.html", method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute Product product)
	{
		ModelAndView modelAndView = new ModelAndView();
		if("success".equals(productService.addProduct(product)));
		{
			System.out.println("Added Product");
			modelAndView.setViewName("Admin-ListProducts");
			List<Product> products = productService.getAllProducts();
			modelAndView.addObject("product",products);
			return modelAndView;
		}
		
	}
	@RequestMapping(value="Admin-ListProducts.html", method=RequestMethod.GET)
	public ModelAndView ListProduct(@ModelAttribute Product product)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Admin-ListProducts");
		List<Product> products = productService.getAllProducts();
		modelAndView.addObject("product",products);
		return modelAndView;
		
	}
	@RequestMapping(value="viewProduct.html", method=RequestMethod.GET)
	public ModelAndView getViewPage(@RequestParam("id") String id)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Admin-ViewProduct");
		Product products = productService.findProduct(id);
		modelAndView.addObject("product",products);
		return modelAndView;
	}
	
	@RequestMapping(value="deleteProduct.html",method=RequestMethod.GET)
	public ModelAndView deleteProduct(@RequestParam("id") String id)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Admin-ListProducts");
		productService.deleteProduct(id);
		
		List<Product> products = productService.getAllProducts();
		modelAndView.addObject("product",products);
		return modelAndView;
		
	}
	
	
}
	