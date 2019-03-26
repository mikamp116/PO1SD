package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.Coin;
import com.sdz.museonumismatica.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModifyCoinController {
    @Autowired
    private CoinRepository coinRepo;

    @RequestMapping("/modifyCoin")
    public String modifySupplier(Coin coin, Model model) {
        coinRepo.save(coin);
        return "coinModified";
    }
}
