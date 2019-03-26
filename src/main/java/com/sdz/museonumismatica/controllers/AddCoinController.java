package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.Coin;
import com.sdz.museonumismatica.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddCoinController {
    @Autowired
    private CoinRepository coinRepository;

    @RequestMapping("/coinAdded")
    public String addCoin(Coin coin, Model model) {

        coinRepository.save(coin);

        return "coinAdded";
    }
}
