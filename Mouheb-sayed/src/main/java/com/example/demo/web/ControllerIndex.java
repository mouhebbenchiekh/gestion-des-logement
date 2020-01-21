package com.example.demo.web;


import javax.servlet.http.HttpServletRequest;

import org.hibernate.boot.model.source.internal.hbm.CompositeIdentifierSingularAttributeSourceManyToOneImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.dao.AgenceDao;
import com.example.demo.dao.ClientDao;
import com.example.demo.dao.LogementDao;
import com.example.demo.entites.Agence;
import com.example.demo.entites.Clients;
import com.example.demo.entites.User;

@Controller
@SessionAttributes("clientid")


public class ControllerIndex {
	@Autowired
	AgenceDao agence;
	@Autowired
	LogementDao log;
	@Autowired
	ClientDao cl;
	@RequestMapping(value="/index")
	public String index(Model m) {
		m.addAttribute("login",false);
		return "index";
	}
	@RequestMapping(value="/account")
	public String account(Model m) {
		m.addAttribute("login",false);
		Clients c= new Clients();
		User u=new User();
		Agence a=new Agence();
		m.addAttribute("Clients",c);
		m.addAttribute("User", u);
		m.addAttribute("agence", a);
		
		
		return "Account";
	}
	@RequestMapping(value="/register")
	public String register(Model m,Clients client) {
		m.addAttribute("login",false);
		cl.save(client) ;
		Clients c= new Clients();
		User u=new User();
		Agence a=new Agence();
		m.addAttribute("Clients",c);
		m.addAttribute("User", u);
		m.addAttribute("agence", a);
		return "Account" ;
		
	}
	@RequestMapping(value="/registeragence")
	public String registeragence(Model m,Agence ag) {
		m.addAttribute("login",false);
		agence.save(ag);
		Clients c= new Clients();
		User u=new User();
		Agence a=new Agence();
		m.addAttribute("Clients",c);
		m.addAttribute("User", u);
		m.addAttribute("agence", a);
		return "Account";
	}
	
	@RequestMapping(value="logout")
	public String logout(Model m,HttpServletRequest request) {
		request.getSession().invalidate();
		m.addAttribute("login",false);
		return "index";
	}
	@RequestMapping(value="profile")
	public String profile(Model m) {
m.addAttribute("login",true);
m.addAttribute("role", "client");
m.addAttribute("clientid");
return "profile";
	}
	@RequestMapping(value="profileagence")
	public String profileagence(Model m) {
m.addAttribute("login",true);
m.addAttribute("role", "agence");
m.addAttribute("clientid");
return "profileagence";
	}
	
	@RequestMapping(value="/auth")
	
	public String auth(Model m,User user) {
		System.out.println(user.getRole());
		String s=user.getRole();
		System.out.println(s);
		if(s.compareTo("client")==0){
		
			Clients c =cl.Authentification(user.getEmail(), user.getPassword());
		
		if(c ==null) {
			m.addAttribute("erreur", "password or email invalid");
			Clients cl=new Clients();
			User u=new User();
			Agence ag= new Agence();
			m.addAttribute("agence", ag);
			m.addAttribute("Clients",cl);
			m.addAttribute("User", u);
			m.addAttribute("login",false);
			return "Account";
		}else {
			
			m.addAttribute("clientid", c);
			m.addAttribute("login",true);
			m.addAttribute("role", "client");
			return "profile";
		}
		}
		else  {
			Agence a= agence.Authentification(user.getEmail(), user.getPassword());
			if(a ==null) {
				m.addAttribute("erreur", "password or email invalid");
				Clients cl=new Clients();
				User u=new User();
				Agence ag= new Agence();
				m.addAttribute("agence", ag);
				m.addAttribute("Clients",cl);
				m.addAttribute("User", u);
				m.addAttribute("login",false);
				return "Account";
			}else {
				
				m.addAttribute("clientid", a);
				m.addAttribute("login",true);
				m.addAttribute("role", "agence");
				return "profileagence";
			}
		}
	
	}

}
