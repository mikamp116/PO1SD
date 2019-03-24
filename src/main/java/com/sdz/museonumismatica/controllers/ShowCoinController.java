package com.sdz.museonumismatica.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.Coin;
import com.sdz.museonumismatica.Supplier;
import com.sdz.museonumismatica.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ShowCoinController {
    @Autowired
    private CoinRepository coinRepo;

    @RequestMapping("/coinQuery")
    public String queries(@RequestParam(value = "searchBy") String searchBy,
                          @RequestParam(value = "orderBy") String orderBy,
                          @RequestParam(value = "time") String time,
                          @RequestParam(value = "order") String order,
                          @RequestParam(value = "query") String query,
                          @RequestParam(value = "queryC") CoinModel queryCoin,
                          @RequestParam(value = "queryD") Date queryDate,
                          @RequestParam(value = "querySP") Supplier querySupplier,
                          Model model) {

        List<Coin> coins = new ArrayList<>();

        switch (searchBy) {
            case "CoinModel":
                if (orderBy.equals("CoinModel"))
                    coins = coinRepo.findAllByCoinModel(queryCoin);
                else
                    switch (orderBy) {
                        case "CoinYear":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllByCoinModelOrderByCoinYearAsc(queryCoin);
                            else
                                coins = coinRepo.findAllByCoinModelOrderByCoinYearDesc(queryCoin);
                            break;
                        case "Date":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllByCoinModelOrderByAcquisitionDateAsc(queryCoin);
                            else
                                coins = coinRepo.findAllByCoinModelOrderByAcquisitionDateDesc(queryCoin);
                            break;
                        case "CoinLocation":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllByCoinModelOrderByCoinLocationAsc(queryCoin);
                            else
                                coins = coinRepo.findAllByCoinModelOrderByCoinLocationDesc(queryCoin);
                            break;
                        case "PreservationState":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllByCoinModelOrderByPreservationStateAsc(queryCoin);
                            else
                                coins = coinRepo.findAllByCoinModelOrderByPreservationStateDesc(queryCoin);
                            break;
                    }
                break;
            case "CoinYear":
                if (orderBy.equals("CoinYear"))
                        coins = coinRepo.findAllByCoinYear(Integer.parseInt(query));
                    else
                        switch (time) {
                        case "Between":
                            coins = coinRepo.findAllByCoinYearBetween(Integer.parseInt(query), Integer.parseInt(query));
                            break;
                        case "After":
                            coins = coinRepo.findAllByCoinYearAfter(Integer.parseInt(query));
                            break;
                        case "Before":
                            coins = coinRepo.findAllByCoinYearBefore(Integer.parseInt(query));
                            break;
                    }
                break;
            case "AcquisitionDate":
                if (orderBy.equals("AcquisitionDate"))
                    coins = coinRepo.findAllByAcquisitionDate(queryDate);
                else
                    switch (orderBy) {
                        case "Between":
                            coins = coinRepo.findAllByAcquisitionDateBetween(queryDate, queryDate);
                            break;
                        case "After":
                            coins = coinRepo.findAllByAcquisitionDateAfter(queryDate);
                            break;
                        case "Before":
                            coins = coinRepo.findAllByAcquisitionDateBefore(queryDate);
                            break;
                    }
                break;
            case "CoinLocation":
                if (orderBy.equals("CoinLocation"))
                    coins = coinRepo.findAllByCoinLocation(query);
                else
                    switch (orderBy) {
                        case "CoinYear":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllByCoinLocationOrderByCoinYearAsc(query);
                            else
                                coins = coinRepo.findAllByCoinLocationOrderByCoinYearDesc(query);
                            break;
                        case "Date":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllByCoinLocationOrderByAcquisitionDateAsc(query);
                            else
                                coins = coinRepo.findAllByCoinLocationOrderByAcquisitionDateDesc(query);
                            break;
                        case "PreservationState":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllByCoinLocationOrderByPreservationStateAsc(query);
                            else
                                coins = coinRepo.findAllByCoinLocationOrderByPreservationStateDesc(query);
                            break;
                    }
                break;
            case "PreservationState":
                if (orderBy.equals("PreservationState"))
                    coins = coinRepo.findAllByPreservationState(query);
                else
                    switch (orderBy) {
                        case "CoinYear":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllByPreservationStateOrderByCoinYearAsc(query);
                            else
                                coins = coinRepo.findAllByPreservationStateOrderByCoinYearDesc(query);
                            break;
                        case "Date":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllByPreservationStateOrderByAcquisitionDateAsc(query);
                            else
                                coins = coinRepo.findAllByPreservationStateOrderByAcquisitionDateDesc(query);
                            break;
                        case "CoinLocation":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllByPreservationStateOrderByCoinLocationAsc(query);
                            else
                                coins = coinRepo.findAllByPreservationStateOrderByCoinLocationDesc(query);
                            break;
                    }
                break;
            case "Supplier":
                if (orderBy.equals("Supplier"))
                    coins = coinRepo.findAllBySupplier(querySupplier);
                else
                    switch (orderBy) {
                        case "CoinYear":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllBySupplierOrderByCoinYearAsc(querySupplier);
                            else
                                coins = coinRepo.findAllBySupplierOrderByCoinYearDesc(querySupplier);
                            break;
                        case "Date":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllBySupplierOrderByAcquisitionDateAsc(querySupplier);
                            else
                                coins = coinRepo.findAllBySupplierOrderByAcquisitionDateDesc(querySupplier);
                            break;
                        case "CoinLocation":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllBySupplierOrderByCoinLocationAsc(querySupplier);
                            else
                                coins = coinRepo.findAllBySupplierOrderByCoinLocationDesc(querySupplier);
                            break;
                        case "PreservationState":
                            if (order.equals("Asc"))
                                coins = coinRepo.findAllBySupplierOrderByPreservationStateAsc(querySupplier);
                            else
                                coins = coinRepo.findAllBySupplierOrderByPreservationStateDesc(querySupplier);
                            break;
                    }
                break;
        }
        model.addAttribute("coins", coins);
        return "/coinQueries";
    }

    @RequestMapping("/modify")
    public String modify(@RequestParam int coinYear, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinYear(coinYear);
        Coin coin;
        if (!coins.isEmpty()) {
            coin = coins.get(0);
        } else {
            coin = new Coin();
        }
        model.addAttribute("coin", coin);
        coinRepo.delete(coin);

        return "showCoin";
    }
}