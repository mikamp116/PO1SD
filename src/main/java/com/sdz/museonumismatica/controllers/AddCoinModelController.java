package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.repositories.CoinModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.TreeSet;

@Controller
public class AddCoinModelController {
    @Autowired
    private CoinModelRepository coinModelRepository;

    @RequestMapping("/coinModelAdded")
    public String addCoinModel(@Valid @ModelAttribute("coinModel") CoinModel coinModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            System.out.println("hay errores");
            return "addCoinModel";
        }

        coinModelRepository.save(coinModel);

        return "coinModelAdded";
}
}
