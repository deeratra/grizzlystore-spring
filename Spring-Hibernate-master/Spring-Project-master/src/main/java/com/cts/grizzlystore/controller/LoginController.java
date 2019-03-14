package com.cts.grizzlystore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzlystore.bean.Category;
import com.cts.grizzlystore.bean.Login;
import com.cts.grizzlystore.service.CategoryService;
import com.cts.grizzlystore.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="Admin-Login.html", method=RequestMethod.GET)	
	public String getLoginPage()
	{
		return "Admin-Login";
	}
	
	@RequestMapping(value="Admin-Login.html", method=RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute Login login,HttpSession httpSession) 
	{
		ModelAndView modelAndView = new ModelAndView();
		Login login1 = loginService.authenticate(login);
	
		if(login1!=null && login1.getUserStatus()<=3){
		if(login1.getUserType().equals("A"))
		{
			System.out.println("0");
			loginService.resetUserStatus(login1);
			modelAndView.setViewName("Admin-AddProduct");
			httpSession.setAttribute("user", login1);
			List<Category> category = categoryService.getCategory();
			//System.out.println(category.get(0));
			modelAndView.addObject("category",category);
		}
		
		else if(login1.getUserType().equals("V"))
		{
			loginService.resetUserStatus(login1);
			modelAndView.setViewName("Vendor-AddProduct");
		}
		
		else if(login1.getUserType().equals("U"))
		{
			loginService.resetUserStatus(login1);
			modelAndView.setViewName("Admin-AddProduct");
		}
		}
		else
		{
			login1= loginService.authenticateUserId(login);
			
			if(login1!=null && login1.getUserStatus()<=3)
				{
					loginService.increaseAttempt(login1);
					modelAndView.setViewName("Admin-Login");
					
				}
			else
			{
				System.out.println("!"+login1.getUserStatus());
				modelAndView.setViewName("Error");
			}
		}
		return modelAndView;
	
	}
	
	@RequestMapping(value="logout.html")
	public ModelAndView logouts(HttpSession httpsession){
		
		ModelAndView modelAndView = new ModelAndView();
		httpsession.removeAttribute("user");
		httpsession.invalidate();
		modelAndView.setViewName("Admin-Login");
		return modelAndView;
	}
}
