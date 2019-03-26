package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.repositories.CoinModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Víctor Fernández
 */

@Controller
public class ShowCoinModelController {

    @Autowired
    private CoinModelRepository repo;

    @RequestMapping("/modifyCoinModel")
    public String modify(@RequestParam(value="id") Long id, Model model){

        CoinModel coinModel = repo.findById(id).get();
        model.addAttribute("coinModel", coinModel);

        return "showCoinModelToModify";
    }

    @RequestMapping("/coinModelQuery")
    public String queries(@RequestParam(value="searchBy") String searchBy,
                          @RequestParam(value="orderBy") String orderBy,
                          @RequestParam(value="order") int order,
                          @RequestParam(value="query") String query,
                          Model model){

    List<CoinModel> coinModels = new ArrayList<>();
/*
    switch (searchBy){
        case "FaceValue":
            float faceValue = Float.parseFloat(query);
            // Ordenar por diametro
            if (orderBy.equals("Diameter")){
                if (order==1) coinModels = repo.findAllByFaceValueOrderByDiameterAsc(faceValue);
                else coinModels = repo.findAllByFaceValueOrderByDiameterDesc(faceValue);
            }
            // Ordenar por peso
            else if (orderBy.equals("Weight")){
                if (order==1) coinModels = repo.findAllByFaceValueOrderByWeightAsc(faceValue);
                else coinModels = repo.findAllByFaceValueOrderByWeightDesc(faceValue);
            }
            // Sin orden especifico
            else if(orderBy.equals("FaceValue")) coinModels = repo.findAllByFaceValue(faceValue);
            else{
                // error handling
            }
            break;
        case "Currency":
            // Ordenar por diametro
            if (orderBy.equals("Diameter")){
                if (order==1) coinModels = repo.findAllByCurrencyContainingOrderByDiameterAsc(query);
                else coinModels = repo.findAllByCurrencyContainingOrderByDiameterDesc(query);
            }
            // Ordenar por peso
            else if (orderBy.equals("Weight")){
                if (order==1) coinModels = repo.findAllByCurrencyContainingOrderByWeightAsc(query);
                else coinModels = repo.findAllByCurrencyContainingOrderByWeightDesc(query);
            }
            // Ordenar por valor facial
            else if(orderBy.equals("FaceValue")){
                if (order==1) coinModels = repo.findAllByCurrencyContainingOrderByFaceValueAsc(query);
                else coinModels = repo.findAllByCurrencyContainingOrderByFaceValueDesc(query);
            }
            else{
                // error handling
            }
            break;
        case "Diameter":
            if (orderBy.equals("Diameter")){
                if (special==3){
                    coinModels = repo.findAllByDiameterGreaterThanEqual();
                } else if (special==2){
                    coinModels = repo.findAllByDiameterLessThanEqual();
                } else if (special==1){
                    coinModels = repo.findAllByDiameterBetween();
                }
            }
            // Ordenar por peso
            else if (orderBy.equals("Weight")){
                if (special==3){
                    if (order==1) coinModels = repo.findAllByDiameterGreaterThanEqualOrderByWeightAsc();
                    else coinModels = repo.findAllByDiameterGreaterThanEqualOrderByWeightDesc();
                } else if (special==2){
                    if (order==1) coinModels = repo.findAllByDiameterLessThanEqualOrderByWeightAsc();
                    else coinModels = repo.findAllByDiameterLessThanEqualOrderByWeightAsc();
                } else if (special==1){
                    if (order==1) coinModels = repo.findAllByDiameterBetweenOrderByWeightAsc();
                    else coinModels = repo.findAllByDiameterBetweenOrderByWeightDesc();
                }

            }
            // Ordenar por valor facial
            else if(orderBy.equals("FaceValue")){
                if (special==3){
                    if (order==1) coinModels = repo.findAllByDiameterGreaterThanEqualOrderByFaceValueAsc();
                    else coinModels = repo.findAllByDiameterGreaterThanEqualOrderByFaceValueDesc();
                } else if (special==2){
                    if (order==1) coinModels = repo.findAllByDiameterLessThanEqualOrderByFaceValueAsc();
                    else coinModels = repo.findAllByDiameterLessThanEqualOrderByFaceValueAsc();
                } else if (special==1){
                    if (order==1) coinModels = repo.findAllByDiameterBetweenOrderByFaceValueAsc();
                    else coinModels = repo.findAllByDiameterBetweenOrderByFaceValueDesc();
                }
            }
            break;
        case "Weight":
            if (orderBy.equals("Diameter")){
                if (special==3){
                    if (order==1) coinModels = repo.findAllByWeightGreaterThanEqualOrderByWeightAsc();
                    else coinModels = repo.findAllByWeightGreaterThanEqualOrderByWeightDesc();
                } else if (special==2){
                    if (order==1) coinModels = repo.findAllByWeightLessThanEqualOrderByWeightAsc();
                    else coinModels = repo.findAllByWeightLessThanEqualOrderByWeightAsc();
                } else if (special==1){
                    if (order==1) coinModels = repo.findAllByWeightBetweenOrderByWeightAsc();
                    else coinModels = repo.findAllByWeightBetweenOrderByWeightDesc();
                }
            }
            // Ordenar por peso
            else if (orderBy.equals("Weight")){
                if (special==3){
                    coinModels = repo.findAllByWeightGreaterThanEqual();
                } else if (special==2){
                    coinModels = repo.findAllByWeightLessThanEqual();
                } else if (special==1){
                    coinModels = repo.findAllByWeightBetween();
                }

            }
            // Ordenar por valor facial
            else if(orderBy.equals("FaceValue")){
                if (special==3){
                    if (order==1) coinModels = repo.findAllByWeightGreaterThanEqualOrderByFaceValueAsc();
                    else coinModels = repo.findAllByWeightGreaterThanEqualOrderByFaceValueDesc();
                } else if (special==2){
                    if (order==1) coinModels = repo.findAllByWeightLessThanEqualOrderByFaceValueAsc();
                    else coinModels = repo.findAllByWeightLessThanEqualOrderByFaceValueAsc();
                } else if (special==1){
                    if (order==1) coinModels = repo.findAllByWeightBetweenOrderByFaceValueAsc();
                    else coinModels = repo.findAllByWeightBetweenOrderByFaceValueDesc();
                }
            }
            break;
        case "Metals":
            coinModels = repo.findByMetalsIn();
            break;
        case "Description":
            coinModels = repo.findByDescriptionContaining(query);
            break;
        default:
            //error
            break;
    }
*/

        model.addAttribute("coinModels", coinModels);
        return "/coinModelQueries";
    }


}
