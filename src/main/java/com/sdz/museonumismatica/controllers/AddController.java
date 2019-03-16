package com.sdz.museonumismatica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddController {
    @RequestMapping("/anadir")
    public String add(@RequestParam("entities") String entity) {
        if (entity.equals("coinModel"))
            return "addCoinModel";
        if (entity.equals("coin"))
            return "addCoin";
        return "addSupplier";
    }
}
