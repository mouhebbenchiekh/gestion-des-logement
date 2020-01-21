package com.example.demo.web;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.dao.AgenceDao;
import com.example.demo.dao.ClientDao;
import com.example.demo.dao.ContratDao;
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
	@Autowired
	ContratDao contrat;
	@RequestMapping("/commander")
	public String commender(Model m,@RequestParam(name="id")Long loge,HttpServletRequest request) {
		Clients c=(Clients) request.getSession().getAttribute("clientid");
		
	
		Logement l=log.getOne(loge);
		
    
		Contrat con =new Contrat();
		con.client=c;
		con.logement=l;
		m.addAttribute("contrat", con);
		m.addAttribute("login",true);
		m.addAttribute("role", "client");
		return "commander";
	}
	@RequestMapping("confirm")
	public String profile(Model m,Contrat c) {
		m.addAttribute("clientid");
		Collection<Contrat> ct= contrat.findByLogement_Logement(c.logement.getId());
			
		
		
			for (Contrat contrat : ct) {
				if((contrat.getDatedebut().before(c.getDatedebut()))&&(contrat.getDatefin().after(c.getDatedebut()))) {
					m.addAttribute(c);
					m.addAttribute("erreur", true);
					m.addAttribute("login",true);
					m.addAttribute("role", "client");
					return "commander";
				}
				
			}
			contrat.save(c);
			m.addAttribute("login",true);
			m.addAttribute("role", "client");
			return "profile";
			
		
		
		
		
	}

}
