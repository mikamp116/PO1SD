package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.repositories.CoinModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddCoinModelController {
    @Autowired
    private CoinModelRepository coinModelRepository;

    @RequestMapping("/coinModelAdded")
    public String addCoinModel(CoinModel coinModel, Model model) {

        coinModelRepository.save(coinModel);

        return "coinModelAdded";
}
}
