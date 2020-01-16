package com.example.demo.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.dao.AgenceDao;
import com.example.demo.dao.LogementDao;
import com.example.demo.entites.Agence;
import com.example.demo.entites.Logement;



@Controller
@SessionAttributes("clientid")

public class AgenceController {
	@Autowired
	LogementDao log;
	@Autowired
	AgenceDao ag;
	
	
	@RequestMapping(value="/ajoutlogement")
	public String ajoutLogement(Model m,@RequestParam(name="ag")Long age) {
		Logement l =new Logement();
		l.agence=ag.getOne(age);
		m.addAttribute("logement",l );
		return "logement";
		
		
	}
	@RequestMapping(value="/registerlogement")
	public String register(Model m,Logement l) {
		
		log.save(l);
		
		Agence a=l.agence;
		m.addAttribute("agence", a);
		
		
		return "profileagence";
	}
	@RequestMapping(value="affiche")
	public String affiche(Model m) {
		List<Logement> liste =log.findAll();
		m.addAttribute("liste",liste);
	m.addAttribute("clientid");
		return "afficher";
	}
	@RequestMapping(value="logement")
	public String logement(Model m,@RequestParam(name="id")Long id) {
		Logement l=log.getOne(id);
		
		m.addAttribute("clientid");
		m.addAttribute("logement",l);
		return "afficherlogement";
	}
	@RequestMapping(value="delete")
	public String delete(Model m,@RequestParam(name="id")Long id,@RequestParam(name="ag")Long ida) {
		System.out.print("mouheb");
		log.deleteById(id);
		Agence a=ag.getOne(ida);
		m.addAttribute("agence", a);
		return "profileagence";
	}
	@RequestMapping(value="edit")
	public String edit(Model m,@RequestParam(name="id")Long id) {
		Logement l=log.getOne(id);
		m.addAttribute("logement",l );
		Agence a=l.agence;
		m.addAttribute("fct", "edit");
		m.addAttribute("ag",a);
		System.out.print(a);
		return "logement";
	}
	
	

}
