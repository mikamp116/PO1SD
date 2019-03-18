package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.repositories.CoinModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.TreeSet;

@Controller
public class AddCoinModelController {
    @Autowired
    private CoinModelRepository coinModelRepository;

    @RequestMapping("/coinModelAdded")
    public String addCoinModel(@RequestParam(value = "faceValue") float faceValue,
                               @RequestParam(value = "currency") String currency,
                               @RequestParam(value = "diameter") float diameter,
                               @RequestParam(value = "weight") float weight,
                               @RequestParam(value = "metals") String metals,
                               @RequestParam(value = "descripcion") String descripcion) {

        String[] metalsArray = metals.split(", ");
        TreeSet<String> metalsSet = new TreeSet<>();
        for (int i = 0; i < metalsArray.length; i++) {
            metalsSet.add(metalsArray[i]);
        }

        CoinModel coinModel = new CoinModel(faceValue, currency, diameter, weight, metalsSet, descripcion);
        coinModelRepository.save(coinModel);

        return "coinModelAdded";
}
}
