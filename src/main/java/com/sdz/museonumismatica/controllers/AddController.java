package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.repositories.CoinModelRepository;
import com.sdz.museonumismatica.repositories.CoinRepository;
import com.sdz.museonumismatica.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddController {
    @Autowired
    private CoinModelRepository coinModelRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    @RequestMapping("/anadir")
    public String add(@RequestParam("entities") String entity, Model model) {
        if (entity.equals("coinModel")) {
            model.addAttribute("coinModel", new CoinModel());
            return "addCoinModel";
        }
        if (entity.equals("coin")) {
            model.addAttribute("coinModels", coinModelRepository.findAll());
            model.addAttribute("suppliers", supplierRepository.findAll());
            return "addCoin";
        }
        return "addSupplier";
    }

    @RequestMapping("/anadir/{str}")
    public String addFromURL(@PathVariable(value= "str") String str){
        return "add" + str;

    }
}
