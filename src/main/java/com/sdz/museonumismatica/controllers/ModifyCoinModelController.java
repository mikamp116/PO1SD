package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.repositories.CoinModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModifyCoinModelController {
    @Autowired
    private CoinModelRepository repo;

    @RequestMapping("/updateCoinModel")
    public String updateCoinModel(@ModelAttribute CoinModel coinModel, BindingResult errors, Model model) {

        repo.save(coinModel);

        return "coinModelModified";
    }
}