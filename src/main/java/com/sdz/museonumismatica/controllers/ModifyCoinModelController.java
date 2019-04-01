package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.repositories.CoinModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ModifyCoinModelController {
    @Autowired
    private CoinModelRepository repo;

    @RequestMapping("/updateCoinModel")
    public String updateCoinModel(@Valid @ModelAttribute("coinModel") CoinModel coinModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return "showCoinModelToModify";
        }
        repo.save(coinModel);

        return "coinModelModified";
    }
}