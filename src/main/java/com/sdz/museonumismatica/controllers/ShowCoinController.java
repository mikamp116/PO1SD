package com.sdz.museonumismatica.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.Coin;
import com.sdz.museonumismatica.Supplier;
import com.sdz.museonumismatica.repositories.CoinModelRepository;
import com.sdz.museonumismatica.repositories.CoinRepository;
import com.sdz.museonumismatica.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowCoinController {
    @Autowired
    private CoinRepository coinRepo;
    @Autowired
    private CoinModelRepository coinModelRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    @RequestMapping("/coinQuery")
    public String queries(@RequestParam(value = "searchBy") String searchBy,
                          @RequestParam(value = "orderBy") String orderBy,
                          @RequestParam(value = "time") String time,
                          @RequestParam(value = "order") String order,
                          @RequestParam(value = "query") String query,
                          @RequestParam(value = "query2") String query2,
                          @RequestParam(value = "queryC") CoinModel queryCoin,
                          @RequestParam(value = "queryD") Date queryDate,
                          @RequestParam(value = "queryD2") Date queryDate2,
                          @RequestParam(value = "querySP") Supplier querySupplier,
                          Model model) {

        List<Coin> coins = new ArrayList<>();
        List<CoinModel> coinModels = coinModelRepository.findAll();
        List<Supplier> suppliers = supplierRepository.findAll();
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
                if (time.equals("None"))
                    coins = coinRepo.findAllByCoinYear(Integer.parseInt(query));
                else
                    switch (time) {
                        case "Before":
                            if(orderBy.equals("CoinYear"))
                                coins = coinRepo.findAllByCoinYearBefore(Integer.parseInt(query));
                            else{
                                switch(orderBy){
                                    case "Date":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByAcquisitionDateAsc(Integer.parseInt(query));
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByAcquisitionDateDesc(Integer.parseInt(query));
                                        break;
                                    case "CoinLocation":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByCoinLocationAsc(Integer.parseInt(query));
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByCoinLocationDesc(Integer.parseInt(query));
                                        break;
                                    case "PreservationState":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByPreservationStateAsc(Integer.parseInt(query));
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByPreservationStateDesc(Integer.parseInt(query));
                                        break;
                                }
                            }
                            break;
                        case "After":
                            if(orderBy.equals("CoinYear"))
                                coins = coinRepo.findAllByCoinYearAfter(Integer.parseInt(query));
                            else{
                                switch(orderBy){
                                    case "Date":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterOrderByAcquisitionDateAsc(Integer.parseInt(query));
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterOrderByAcquisitionDateDesc(Integer.parseInt(query));
                                        break;
                                    case "CoinLocation":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterOrderByCoinLocationAsc(Integer.parseInt(query));
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterOrderByCoinLocationDesc(Integer.parseInt(query));
                                        break;
                                    case "PreservationState":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterOrderByPreservationStateAsc(Integer.parseInt(query));
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterOrderByPreservationStateDesc(Integer.parseInt(query));
                                        break;
                                }
                            }
                            break;
                        case "Between":
                            if(orderBy.equals("CoinYear"))
                                coins = coinRepo.findAllByCoinYearBetween(Integer.parseInt(query), Integer.parseInt(query2));
                            else{
                                switch(orderBy){
                                    case "Date":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBetweenOrderByAcquisitionDateAsc(Integer.parseInt(query), Integer.parseInt(query2));
                                        else
                                            coins = coinRepo.findAllByCoinYearBetweenOrderByAcquisitionDateDesc(Integer.parseInt(query), Integer.parseInt(query2));
                                        break;
                                    case "CoinLocation":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBetweenOrderByCoinLocationAsc(Integer.parseInt(query), Integer.parseInt(query2));
                                        else
                                            coins = coinRepo.findAllByCoinYearBetweenOrderByCoinLocationDesc(Integer.parseInt(query), Integer.parseInt(query2));
                                        break;
                                    case "PreservationState":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBetweenOrderByPreservationStateAsc(Integer.parseInt(query), Integer.parseInt(query2));
                                        else
                                            coins = coinRepo.findAllByCoinYearBetweenOrderByPreservationStateDesc(Integer.parseInt(query), Integer.parseInt(query2));
                                        break;
                                }
                            }
                            break;
                    }
                break;
            case "AcquisitionDate":
                if (time.equals("None"))
                    coins = coinRepo.findAllByAcquisitionDate(queryDate);
                else
                    switch (time) {
                        case "Before":
                            if(orderBy.equals("AcquisitionDate"))
                                coins = coinRepo.findAllByAcquisitionDateBefore(queryDate);
                            else{
                                switch(orderBy){
                                    case "CoinYear":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByCoinYearAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByCoinYearDesc(queryDate);
                                        break;
                                    case "CoinLocation":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByCoinLocationAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByCoinLocationDesc(queryDate);
                                        break;
                                    case "PreservationState":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByPreservationStateAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByPreservationStateDesc(queryDate);
                                        break;
                                }
                            }
                            break;
                        case "After":
                            if(orderBy.equals("AcquisitionDate"))
                                coins = coinRepo.findAllByAcquisitionDateAfter(queryDate);
                            else{
                                switch(orderBy){
                                    case "CoinYear":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByCoinYearAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByCoinYearDesc(queryDate);
                                        break;
                                    case "CoinLocation":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByCoinLocationAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByCoinLocationDesc(queryDate);
                                        break;
                                    case "PreservationState":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByPreservationStateAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByPreservationStateDesc(queryDate);
                                        break;
                                }
                            }
                            break;
                        case "Between":
                            if(orderBy.equals("AcquisitionDate"))
                                coins = coinRepo.findAllByAcquisitionDateBetween(queryDate, queryDate2);
                            else{
                                switch(orderBy){
                                    case "CoinYear":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBetweenOrderByCoinYearAsc(queryDate, queryDate2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBetweenOrderByCoinYearDesc(queryDate, queryDate2);
                                        break;
                                    case "CoinLocation":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBetweenOrderByCoinLocationAsc(queryDate, queryDate2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBetweenOrderByCoinLocationDesc(queryDate, queryDate2);
                                        break;
                                    case "PreservationState":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBetweenOrderByPreservationStateAsc(queryDate, queryDate2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBetweenOrderByPreservationStateDesc(queryDate, queryDate2);
                                        break;
                                }
                            }
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
        model.addAttribute("coinModels", coinModels);
        model.addAttribute("suppliers", suppliers);
        return "/coinQueries";
    }

    @RequestMapping("/modifyC")
    public String modifyC(@RequestParam Long id, Model model) {
        Coin coin = coinRepo.getOne(id);
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coin", coin);
        return "showCoin";
    }
}