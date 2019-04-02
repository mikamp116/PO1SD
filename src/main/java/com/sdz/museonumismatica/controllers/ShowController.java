package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.repositories.CoinModelRepository;
import com.sdz.museonumismatica.repositories.CoinRepository;
import com.sdz.museonumismatica.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.GregorianCalendar;

@Controller
public class ShowController {
    @Autowired
    private CoinModelRepository coinModelRepository;
    @Autowired
    private CoinRepository coinRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    @RequestMapping("/query")
    public String show(@RequestParam("entities") String entity, Model model) {

        if (entity.equals("coinModel")) {
            model.addAttribute("coinModels", coinModelRepository.findAll());
            return "coinModelQueries";
        } else if (entity.equals("coin")) {
            java.util.Date utilDate = new GregorianCalendar(1990, 1, 1).getTime();
            java.sql.Date date= new java.sql.Date(utilDate.getTime());
            model.addAttribute("qqueryD", date);
            model.addAttribute("qqueryY", 1990);
            model.addAttribute("coins", coinRepository.findAll());
            model.addAttribute("coinModels", coinModelRepository.findAll());
            model.addAttribute("suppliers", supplierRepository.findAll());
            return "coinQueries";
        } else {
            model.addAttribute("suppliers", supplierRepository.findAll());
            return "supplierQueries";
        }
    }

}
