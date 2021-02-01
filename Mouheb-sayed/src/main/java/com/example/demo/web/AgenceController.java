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
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.dao.AgenceDao;
import com.example.demo.dao.ContratDao;
import com.example.demo.dao.LogementDao;
import com.example.demo.entites.Agence;
import com.example.demo.entites.Contrat;
import com.example.demo.entites.Logement;



@Controller
@SessionAttributes("clientid")

public class AgenceController {
	@Autowired
	LogementDao log;
	@Autowired
	AgenceDao ag;
	@Autowired
	ContratDao con;
	
	
	@RequestMapping(value="/ajoutlogement")
	public String ajoutLogement(Model m,HttpServletRequest request) {
		Logement l =new Logement();
		l.agence=(Agence) request.getSession().getAttribute("clientid");
		m.addAttribute("login",true);
		m.addAttribute("role", "agence");
		m.addAttribute("logement",l );
		return "logement";
		
		
	}
	@RequestMapping(value="/registerlogement")
	public String register(Model m,Logement l,HttpServletRequest request) {
		
		log.save(l);
		Agence a=(Agence) request.getSession().getAttribute("clientid");
		Agence al=ag.getOne(a.getId());
		
		
		m.addAttribute("login",true);
		m.addAttribute("role", "agence");
		m.addAttribute("clientid",al);
		
		
		return "profileagence";
	}
	@RequestMapping(value="affiche")
	public String affiche(Model m,HttpServletRequest request) {
		List<Logement> liste =log.findAll();
		m.addAttribute("liste",liste);
		if(request.getSession(false)==null) {
			m.addAttribute("login",false);
			return "afficher";
		}
		
	m.addAttribute("clientid");
	m.addAttribute("login",true);
	m.addAttribute("role", "client");
		return "afficher";
	}
	@RequestMapping(value="logement")
	public String logement(Model m,@RequestParam(name="id")Long id,HttpServletRequest request) {
		Logement l=log.getOne(id);
		m.addAttribute("logement",l);
		if(request.getSession(false)==null) {
			m.addAttribute("login",false);
			return "afficherlogement";
		}
		m.addAttribute("login",true);
		m.addAttribute("clientid");
		
		m.addAttribute("role", "client");
		return "afficherlogement";
	}
	@RequestMapping(value="delete")
	public String delete(Model m,@RequestParam(name="id")Long id,HttpServletRequest request) {
		System.out.print("mouheb");
		log.deleteById(id);
		Agence a=(Agence) request.getSession().getAttribute("clientid");
		Agence al=ag.getOne(a.getId());
		m.addAttribute("clientid",al);
		m.addAttribute("login",true);
		m.addAttribute("role", "agence");
		return "profileagence";
	}
	@RequestMapping(value="edit")
	public String edit(Model m,@RequestParam(name="id")Long id) {
		Logement l=log.getOne(id);
		m.addAttribute("logement",l );
	
		m.addAttribute("fct", "edit");
		m.addAttribute("clientid");
		m.addAttribute("login",true);
		m.addAttribute("role", "agence");
		return "logement";
	}
	@RequestMapping(value="affichercommande")
	public String affichercommande(Model m,HttpServletRequest request) {
		Agence a =(Agence) request.getSession().getAttribute("clientid");
		m.addAttribute("agence",a);
		Collection<Contrat> cl=con.getbyagence(a.getId());
		
		m.addAttribute("login",true);
		m.addAttribute("role", "agence");
		m.addAttribute("contrats", cl);
		return "affichercommande";
		
	}
	@RequestMapping(value="approuve")
	public String approuve(Model m,HttpServletRequest request,@RequestParam(name="id")Long id) {
		Contrat c=con.getOne(id);
		c.setEtat("approuved");
		
		
		Agence a =(Agence) request.getSession().getAttribute("clientid");
		m.addAttribute("agence",a);
		Collection<Contrat> cl=con.getbyagence(a.getId());
		
		m.addAttribute("login",true);
		m.addAttribute("role", "agence");
		m.addAttribute("contrats", cl);
		return "affichercommande";
		
	}
	
	@RequestMapping(value="refuse")
	public String refuse(Model m,HttpServletRequest request,@RequestParam(name="id")Long id) {
		
		Contrat c=con.getOne(id);
		c.setEtat("refused");
		Agence a =(Agence) request.getSession().getAttribute("clientid");
		m.addAttribute("agence",a);
		Collection<Contrat> cl=con.getbyagence(a.getId());
		
		m.addAttribute("login",true);
		m.addAttribute("role", "agence");
		m.addAttribute("contrats", cl);
		return "affichercommande";
		
	}
	
	
	

}
