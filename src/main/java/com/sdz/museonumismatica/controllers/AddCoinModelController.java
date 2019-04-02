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


/**
 * @author Víctor Fernández
 *
 *  Esta clase añade el nuevo modelo de moneda y manda a la plantilla de notificación el nuevo modelo.
 *  Si hubiera errores, vuelve a la plantilla de añadir y le muestra al usuario los errores
 */
@Controller
public class AddCoinModelController {
    @Autowired
    private CoinModelRepository coinModelRepository;

    @RequestMapping("/coinModelAdded")
    public String addCoinModel(@Valid @ModelAttribute("coinModel") CoinModel coinModel, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()){
            return "addCoinModel";
        }

        coinModelRepository.save(coinModel);
        model.addAttribute("addedCM", coinModel);

        return "coinModelAdded";
}
}
