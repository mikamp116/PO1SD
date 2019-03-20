package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.repositories.CoinModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private CoinModelRepository coinModelRepo;

    @RequestMapping("/coinModelQuery")
    public String queries(@RequestParam(value="searchBy") String searchBy,
                          @RequestParam(value="orderBy") String orderBy,
                          @RequestParam(value="order") String order,
                          @RequestParam(value="query") String query,
                          Model model){

        List<CoinModel> coinModels = new ArrayList<>();


        switch (searchBy){
            case "FaceValue":
                coinModels = coinModelRepo.findAllByFaceValue(Float.parseFloat(query));
                break;
            case "Currency":
                coinModels = coinModelRepo.findAllByCurrency(query);
                break;
            case "Diameter":
                String[] diam = query.split(", ");
                coinModels = coinModelRepo.findAllByDiameterBetween(Integer.parseInt(diam[0]), Integer.parseInt(diam[1]));
                break;
            case "Weight":
                String[] weight = query.split(", ");
                coinModels = coinModelRepo.findAllByWeightBetween(Integer.parseInt(weight[0]), Integer.parseInt(weight[1]));
                break;
            case "Metals":
                String[] metals = query.split(". ");
                coinModels = coinModelRepo.findByMetalsIn(Arrays.asList(metals));
                break;
            case "Description":
                coinModels = coinModelRepo.findByDescriptionContaining(query);
                break;
        }

        if(!searchBy.equals(orderBy)){
            switch (orderBy){
                case "FaceValue":
                    Comparator<CoinModel> faceValueComparator = (o1,o2)->(int) (o1.getFaceValue() - o2.getFaceValue());
                    if (order.equals("Asc"))
                        coinModels.sort(faceValueComparator);
                    else coinModels.sort(faceValueComparator.reversed());
                case "Currency":
                    Comparator<CoinModel> currencyComparator = (o1,o2)->(o1.getCurrency().compareTo(o2.getCurrency()));
                    if (order.equals("Asc"))
                        coinModels.sort(currencyComparator);
                    else coinModels.sort(currencyComparator.reversed());
                case "Diameter":
                    Comparator<CoinModel> diameterComparator = (o1,o2)->(int) (o1.getDiameter() - o2.getDiameter());
                    if (order.equals("Asc"))
                        coinModels.sort(diameterComparator);
                    else coinModels.sort(diameterComparator.reversed());
                case "Weight":
                    Comparator<CoinModel> weightComparator = (o1,o2)->(int) (o1.getWeight() - o2.getWeight());
                    if (order.equals("Asc"))
                        coinModels.sort(weightComparator);
                    else coinModels.sort(weightComparator.reversed());

            }

        }

        model.addAttribute("coinModels", coinModels);

        return "/coinModelQueries";
    }


}
