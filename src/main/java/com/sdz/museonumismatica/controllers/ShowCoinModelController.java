package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.repositories.CoinModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;



/**
 * @author Víctor Fernández
 *
 *      Esta clase controla las consultas y redirecciona las modificaciones.
 *
 */

@Controller
public class ShowCoinModelController {

    @Autowired
    private CoinModelRepository repo;

    @RequestMapping("/modifyCoinModel")
    public String modify(@RequestParam(value="id") Long id, Model model){

        CoinModel coinModel = repo.getOne(id);
        model.addAttribute("oldCoinModel", coinModel);
        model.addAttribute("newCoinModel", new CoinModel());

        return "showCoinModelToModify";
    }


    @RequestMapping("/coinModelQuery")
    public String queries(@RequestParam("FaceValue") float faceValue,
                          @RequestParam("Currency") String currency,
                          @RequestParam("Weight") float weight,
                          @RequestParam("Diameter") float diameter,
                          @RequestParam("orderBy") String orderBy,
                          @RequestParam("order") int order,
                          Model model){

        List<CoinModel> coinModels = new ArrayList<>();



        model.addAttribute("qOrderBy", orderBy);
        model.addAttribute("qOrder", order);


        if (faceValue > 0){
            if (!currency.isEmpty()){
                switch (orderBy){
                    case "FaceValue":
                        if(order==1) coinModels = repo.findAllByFaceValueAndCurrencyContainingOrderByFaceValueAsc(faceValue, currency);
                        else coinModels = repo.findAllByFaceValueAndCurrencyContainingOrderByFaceValueDesc(faceValue, currency);
                        break;
                    case "Diameter":
                        if(order==1) coinModels = repo.findAllByFaceValueAndCurrencyContainingOrderByDiameterAsc(faceValue, currency);
                        else coinModels = repo.findAllByFaceValueAndCurrencyContainingOrderByDiameterDesc(faceValue, currency);
                        break;
                    case "Weight":
                        if(order==1) coinModels = repo.findAllByFaceValueAndCurrencyContainingOrderByWeightAsc(faceValue, currency);
                        else coinModels = repo.findAllByFaceValueAndCurrencyContainingOrderByWeightDesc(faceValue, currency);
                } model.addAttribute("qCurrency", currency);
            } else if(diameter > 0) {
                switch (orderBy) {
                    case "FaceValue":
                        if (order == 1)
                            coinModels = repo.findAllByFaceValueAndDiameterOrderByFaceValueAsc(faceValue, diameter);
                        else coinModels = repo.findAllByFaceValueAndDiameterOrderByFaceValueDesc(faceValue, diameter);
                        break;
                    case "Diameter":
                        if (order == 1)
                            coinModels = repo.findAllByFaceValueAndDiameterOrderByDiameterAsc(faceValue, diameter);
                        else coinModels = repo.findAllByFaceValueAndDiameterOrderByDiameterDesc(faceValue, diameter);
                        break;
                    case "Weight":
                        if (order == 1)
                            coinModels = repo.findAllByFaceValueAndDiameterOrderByWeightAsc(faceValue, diameter);
                        else coinModels = repo.findAllByFaceValueAndDiameterOrderByWeightDesc(faceValue, diameter);
                } model.addAttribute("qDiameter", diameter);
            } else if(weight > 0){
                switch (orderBy){
                    case "FaceValue":
                        if(order==1) coinModels = repo.findAllByFaceValueAndWeightOrderByFaceValueAsc(faceValue, weight);
                        else coinModels = repo.findAllByFaceValueAndWeightOrderByFaceValueDesc(faceValue, weight);
                        break;
                    case "Diameter":
                        if(order==1) coinModels = repo.findAllByFaceValueAndWeightOrderByDiameterAsc(faceValue, weight);
                        else coinModels = repo.findAllByFaceValueAndWeightOrderByDiameterDesc(faceValue, weight);
                        break;
                    case "Weight":
                        if(order==1) coinModels = repo.findAllByFaceValueAndWeightOrderByWeightAsc(faceValue, weight);
                        else coinModels = repo.findAllByFaceValueAndWeightOrderByWeightDesc(faceValue, weight);
                } model.addAttribute("qWeight", weight);
            } else {
                switch (orderBy) {
                    case "FaceValue":
                        coinModels = repo.findAllByFaceValue(faceValue);
                        break;
                    case "Diameter":
                        if (order == 1)
                            coinModels = repo.findAllByFaceValueOrderByDiameterAsc(faceValue);
                        else coinModels = repo.findAllByFaceValueOrderByDiameterDesc(faceValue);
                        break;
                    case "Weight":
                        if (order == 1)
                            coinModels = repo.findAllByFaceValueOrderByWeightAsc(faceValue);
                        else coinModels = repo.findAllByFaceValueOrderByWeightDesc(faceValue);
                }
            }
            model.addAttribute("qFaceValue", faceValue);
        }

        else if (!currency.isEmpty()) {
            if (diameter > 0) {
                switch (orderBy) {
                    case "FaceValue":
                        if (order == 1)
                            coinModels = repo.findAllByCurrencyContainingAndDiameterOrderByFaceValueAsc(currency, diameter);
                        else
                            coinModels = repo.findAllByCurrencyContainingAndDiameterOrderByFaceValueDesc(currency, diameter);
                        break;
                    case "Diameter":
                        if (order == 1)
                            coinModels = repo.findAllByCurrencyContainingAndDiameterOrderByDiameterAsc(currency, diameter);
                        else
                            coinModels = repo.findAllByCurrencyContainingAndDiameterOrderByDiameterDesc(currency, diameter);
                        break;
                    case "Weight":
                        if (order == 1)
                            coinModels = repo.findAllByCurrencyContainingAndDiameterOrderByWeightAsc(currency, diameter);
                        else
                            coinModels = repo.findAllByCurrencyContainingAndDiameterOrderByWeightDesc(currency, diameter);
                } model.addAttribute("qDiameter", diameter);
            } else if (weight > 0) {
                switch (orderBy) {
                    case "FaceValue":
                        if (order == 1)
                            coinModels = repo.findAllByCurrencyContainingAndWeightOrderByFaceValueAsc(currency, weight);
                        else
                            coinModels = repo.findAllByCurrencyContainingAndWeightOrderByFaceValueDesc(currency, weight);
                        break;
                    case "Diameter":
                        if (order == 1)
                            coinModels = repo.findAllByCurrencyContainingAndWeightOrderByDiameterAsc(currency, weight);
                        else
                            coinModels = repo.findAllByCurrencyContainingAndWeightOrderByDiameterDesc(currency, weight);
                        break;
                    case "Weight":
                        if (order == 1)
                            coinModels = repo.findAllByCurrencyContainingAndWeightOrderByWeightAsc(currency, weight);
                        else coinModels = repo.findAllByCurrencyContainingAndWeightOrderByWeightDesc(currency, weight);
                } model.addAttribute("qWeight", weight);
            } else{
                switch (orderBy) {
                    case "FaceValue":
                        if (order == 1) coinModels = repo.findAllByCurrencyContainingOrderByFaceValueAsc(currency);
                        else coinModels = repo.findAllByCurrencyContainingOrderByFaceValueDesc(currency);
                        break;
                    case "Diameter":
                        if (order == 1)
                            coinModels = repo.findAllByCurrencyContainingOrderByDiameterAsc(currency);
                        else coinModels = repo.findAllByCurrencyContainingOrderByDiameterDesc(currency);
                        break;
                    case "Weight":
                        if (order == 1)
                            coinModels = repo.findAllByCurrencyContainingOrderByWeightAsc(currency);
                        else coinModels = repo.findAllByCurrencyContainingOrderByWeightDesc(currency);
                }
            } model.addAttribute("qCurrency", currency);

        } else if (diameter > 0){

            if(weight > 0){
                switch (orderBy){
                    case "FaceValue":
                        if(order==1) coinModels = repo.findAllByDiameterAndWeightOrderByFaceValueAsc(diameter, weight);
                        else coinModels = repo.findAllByDiameterAndWeightOrderByFaceValueDesc(diameter, weight);
                        break;
                    case "Diameter":
                        if(order==1) coinModels = repo.findAllByDiameterAndWeightOrderByDiameterAsc(diameter, weight);
                        else coinModels = repo.findAllByDiameterAndWeightOrderByDiameterDesc(diameter, weight);
                        break;
                    case "Weight":
                        if(order==1) coinModels = repo.findAllByDiameterAndWeightOrderByWeightAsc(diameter, weight);
                        else coinModels = repo.findAllByDiameterAndWeightOrderByWeightDesc(diameter, weight);
                } model.addAttribute("qWeight", weight);

            } else {
                switch (orderBy) {
                    case "Diameter":
                        coinModels = repo.findAllByDiameter(diameter);
                        break;
                    case "FaceValue":
                        if (order == 1)
                            coinModels = repo.findAllByDiameterOrderByFaceValueAsc(diameter);
                        else coinModels = repo.findAllByDiameterOrderByFaceValueDesc(diameter);
                        break;
                    case "Weight":
                        if (order == 1)
                            coinModels = repo.findAllByDiameterOrderByWeightAsc(diameter);
                        else coinModels = repo.findAllByDiameterOrderByWeightDesc(diameter);
                }
            } model.addAttribute("qDiameter", diameter);
        }
        else if (weight > 0) {

                switch (orderBy) {
                    case "Weight":
                        coinModels = repo.findAllByWeight(weight);
                        break;
                    case "FaceValue":
                        if (order == 1)
                            coinModels = repo.findAllByWeightOrderByFaceValueAsc(weight);
                        else coinModels = repo.findAllByWeightOrderByFaceValueDesc(weight);
                        break;
                    case "Diameter":
                        if (order == 1)
                            coinModels = repo.findAllByWeightOrderByDiameterAsc(weight);
                        else coinModels = repo.findAllByWeightOrderByDiameterDesc(weight);
                }
             model.addAttribute("qWeight", weight);

        }
        //Si no se introduce ningún campo, mostramos todos los elementos
        else {
            coinModels = repo.findAll();
        }


        model.addAttribute("coinModels", coinModels);
        return "/coinModelQueries";
    }


}
