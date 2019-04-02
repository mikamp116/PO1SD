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

/**
 * @author Víctor Fernández Fernández
 *
 *  Esta clase contorlar la modificación de modelos. Recibe los nuevos valores y los guarda,
 *  y también añade los valores antiguos y los nuevos a la pantilla que notifica al usuario de la correcta modificación.
 *  Si hubiera errores, vuelve a la plantilla de modificar y le muestra al usuario los errores
 */
@Controller
public class ModifyCoinModelController {
    @Autowired
    private CoinModelRepository repo;

    @RequestMapping("/updateCoinModel")
    public String updateCoinModel(@Valid @ModelAttribute("coinModel") CoinModel coinModel, BindingResult bindingResult, Model model) {

        CoinModel aux = repo.getOne(coinModel.getId());
        CoinModel oldCoinModel = new CoinModel(aux.getFaceValue(), aux.getCurrency(), aux.getDiameter(), aux.getWeight(), aux.getMetals(), aux.getDescription());
        model.addAttribute("oldCoinModel", oldCoinModel);

        if (bindingResult.hasErrors()){
            return "showCoinModelToModify";
        }

        repo.save(coinModel);


        model.addAttribute("newCoinModel", coinModel);

        return "coinModelModified";
    }
}