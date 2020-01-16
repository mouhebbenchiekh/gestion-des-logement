package com.example.demo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.dao.AgenceDao;
import com.example.demo.dao.ClientDao;
import com.example.demo.dao.LogementDao;
import com.example.demo.entites.Clients;
import com.example.demo.entites.Contrat;
import com.example.demo.entites.Logement;

@Controller
@SessionAttributes("clientid")
public class ContratController {
	
	@Autowired
	LogementDao log;
	@Autowired
	AgenceDao ag;
	@Autowired
	ClientDao cl;
	@RequestMapping("/commander")
	public String commender(Model m,@RequestParam(name="id")Long loge,HttpServletRequest request) {
		Clients c=(Clients) request.getSession().getAttribute("clientid");
		
	
		Logement l=log.getOne(loge);
		
    
		Contrat con =new Contrat();
		con.client=c;
		con.logement=l;
		m.addAttribute("contrat", con);
		return "commander";
	}

}
