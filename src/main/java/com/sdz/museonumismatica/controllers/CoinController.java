package com.sdz.museonumismatica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sdz.museonumismatica.Coin;
import com.sdz.museonumismatica.repositories.CoinRepository;

public class CoinController {
	@Autowired
	private CoinRepository coinRepo;
	
	@Autowired
	
	@RequestMapping("/")
	public String tablon(Model model) {

		model.addAttribute("coins", coinRepo.findAll());

		return "tablon";
	}
	
	@RequestMapping("/nuevoAnuncio")
	public String insertar(Model model) {
		
		List<Coin> coinList = coinRepo.findAll();
		
		model.addAttribute("coins", coinList);
		
		return("");
	}

}