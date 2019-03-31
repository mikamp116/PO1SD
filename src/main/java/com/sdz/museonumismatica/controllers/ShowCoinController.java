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
    List<Coin> coins = new ArrayList<>();

    @RequestMapping("/ejemplarConsultaPorModelo")
    public String consultaPorModelo(@RequestParam(value = "orderBy") String orderBy, @RequestParam(value = "order") String order, @RequestParam(value = "queryC") long queryCoinID, Model model) {
        CoinModel queryCoin = coinModelRepository.getOne(queryCoinID);
        switch (orderBy) {
                /*case "CoinModel":
                    if (order.equals("Asc"))
                        coins = coinRepo.findAllByCoinModelOrderByCoinModelAsc(queryCoin);
                    else
                        coins = coinRepo.findAllByCoinModelOrderByCoinModelDesc(queryCoin);
                    break;*/
            case "CoinYear":
                if (order.equals("Asc"))
                    coins = coinRepo.findAllByCoinModelOrderByCoinYearAsc(queryCoin);
                else
                    coins = coinRepo.findAllByCoinModelOrderByCoinYearDesc(queryCoin);
                break;
            case "AcquisitionDate":
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
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coins);
        return "/coinQueries";
    }

    @RequestMapping("/ejemplarConsultaPorProveedor")
    public String consultaPorSupplier(@RequestParam(value = "orderBy") String orderBy, @RequestParam(value = "order") String order, @RequestParam(value = "querySP") long querySupplierID, Model model) {
        Supplier querySupplier = supplierRepository.getOne(querySupplierID);
        switch (orderBy) {
                /*case "Supplier":
                    if (order.equals("Asc"))
                        coins = coinRepo.findAllBySupplierOrderBySupplierAsc(querySupplier);
                    else
                        coins = coinRepo.findAllBySupplierOrderBySupplierDesc(querySupplier);
                    break;*/
            case "CoinYear":
                if (order.equals("Asc"))
                    coins = coinRepo.findAllBySupplierOrderByCoinYearAsc(querySupplier);
                else
                    coins = coinRepo.findAllBySupplierOrderByCoinYearDesc(querySupplier);
                break;
            case "AcquisitionDate":
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
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coins);
        return "/coinQueries";
    }

    @RequestMapping("/ejemplarConsultaPorAño")
    public String consultaPorAño(@RequestParam(value = "orderBy") String orderBy, @RequestParam(value = "time") String time,
                                 @RequestParam(value = "order") String order, @RequestParam(value = "queryY") int queryY, Model model) {
        switch (time) {
            case "Same":
                switch (orderBy) {
                    case "coinYear":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByCoinYearOrderByCoinYearAsc(queryY);
                        else
                            coins = coinRepo.findAllByCoinYearOrderByCoinYearDesc(queryY);
                        break;
                    case "AcquisitionDate":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByCoinYearOrderByAcquisitionDateAsc(queryY);
                        else
                            coins = coinRepo.findAllByCoinYearOrderByAcquisitionDateDesc(queryY);
                        break;
                    case "CoinLocation":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByCoinYearOrderByCoinLocationAsc(queryY);
                        else
                            coins = coinRepo.findAllByCoinYearOrderByCoinLocationDesc(queryY);
                        break;
                    case "PreservationState":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByCoinYearOrderByPreservationStateAsc(queryY);
                        else
                            coins = coinRepo.findAllByCoinYearOrderByPreservationStateDesc(queryY);
                        break;
                }
            case "Before":
                switch (orderBy) {
                    case "Year":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByCoinYearBeforeOrderByCoinYearAsc(queryY);
                        else
                            coins = coinRepo.findAllByCoinYearBeforeOrderByCoinYearDesc(queryY);
                        break;
                    case "AcquisitionDate":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByCoinYearBeforeOrderByAcquisitionDateAsc(queryY);
                        else
                            coins = coinRepo.findAllByCoinYearBeforeOrderByAcquisitionDateDesc(queryY);
                        break;
                    case "CoinLocation":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByCoinYearBeforeOrderByCoinLocationAsc(queryY);
                        else
                            coins = coinRepo.findAllByCoinYearBeforeOrderByCoinLocationDesc(queryY);
                        break;
                    case "PreservationState":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByCoinYearBeforeOrderByPreservationStateAsc(queryY);
                        else
                            coins = coinRepo.findAllByCoinYearBeforeOrderByPreservationStateDesc(queryY);
                        break;
                }
                break;
            case "After":
                switch (orderBy) {
                    case "CoinYear":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByCoinYearAfterOrderByCoinYearAsc(queryY);
                        else
                            coins = coinRepo.findAllByCoinYearAfterOrderByCoinYearDesc(queryY);
                        break;
                    case "AcquisitionDate":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByCoinYearAfterOrderByAcquisitionDateAsc(queryY);
                        else
                            coins = coinRepo.findAllByCoinYearAfterOrderByAcquisitionDateDesc(queryY);
                        break;
                    case "CoinLocation":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByCoinYearAfterOrderByCoinLocationAsc(queryY);
                        else
                            coins = coinRepo.findAllByCoinYearAfterOrderByCoinLocationDesc(queryY);
                        break;
                    case "PreservationState":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByCoinYearAfterOrderByPreservationStateAsc(queryY);
                        else
                            coins = coinRepo.findAllByCoinYearAfterOrderByPreservationStateDesc(queryY);
                        break;
                }
                break;
        }
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coins);
        return "/coinQueries";
    }

    @RequestMapping("/ejemplarConsultaPorFecha")
    public String consultaPorFecha(@RequestParam(value = "orderBy") String orderBy, @RequestParam(value = "time") String time,
                                   @RequestParam(value = "order") String order, @RequestParam(value = "queryD") Date queryDate, Model model) {
        switch (time) {
            case "Same":
                switch (orderBy) {
                    case "CoinYear":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByAcquisitionDateOrderByCoinYearAsc(queryDate);
                        else
                            coins = coinRepo.findAllByAcquisitionDateOrderByCoinYearDesc(queryDate);
                        break;
                    case "AcquisitionDate":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByAcquisitionDateOrderByAcquisitionDateAsc(queryDate);
                        else
                            coins = coinRepo.findAllByAcquisitionDateOrderByAcquisitionDateDesc(queryDate);
                        break;
                    case "CoinLocation":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByAcquisitionDateOrderByCoinLocationAsc(queryDate);
                        else
                            coins = coinRepo.findAllByAcquisitionDateOrderByCoinLocationDesc(queryDate);
                        break;
                    case "PreservationState":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByAcquisitionDateOrderByPreservationStateAsc(queryDate);
                        else
                            coins = coinRepo.findAllByAcquisitionDateOrderByPreservationStateDesc(queryDate);
                        break;
                }
                break;
            case "Before":
                switch (orderBy) {
                    case "CoinYear":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByCoinYearAsc(queryDate);
                        else
                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByCoinYearDesc(queryDate);
                        break;
                    case "AcquisitionDate":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByAcquisitionDateAsc(queryDate);
                        else
                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByAcquisitionDateDesc(queryDate);
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
                break;
            case "After":
                switch (orderBy) {
                    case "CoinYear":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByCoinYearAsc(queryDate);
                        else
                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByCoinYearDesc(queryDate);
                        break;
                    case "AcquisitionDate":
                        if (order.equals("Asc"))
                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByAcquisitionDateAsc(queryDate);
                        else
                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByAcquisitionDateDesc(queryDate);
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
                break;
        }
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coins);
        return "/coinQueries";
    }

    @RequestMapping("/ejemplarConsultaPorLocalizacion")
    public String consultaPorLocalizacion(@RequestParam(value = "orderBy") String orderBy, @RequestParam(value = "order") String order,
                                          @RequestParam(value = "query") String query, Model model) {
        switch (orderBy) {
            case "CoinYear":
                if (order.equals("Asc"))
                    coins = coinRepo.findAllByCoinLocationOrderByCoinYearAsc(query);
                else
                    coins = coinRepo.findAllByCoinLocationOrderByCoinYearDesc(query);
                break;
            case "AcquisitionDate":
                if (order.equals("Asc"))
                    coins = coinRepo.findAllByCoinLocationOrderByAcquisitionDateAsc(query);
                else
                    coins = coinRepo.findAllByCoinLocationOrderByAcquisitionDateDesc(query);
                break;
            case "CoinLocation":
                if (order.equals("Asc"))
                    coins = coinRepo.findAllByCoinLocationOrderByCoinLocationAsc(query);
                else
                    coins = coinRepo.findAllByCoinLocationOrderByCoinLocationDesc(query);
                break;
            case "PreservationState":
                if (order.equals("Asc"))
                    coins = coinRepo.findAllByCoinLocationOrderByPreservationStateAsc(query);
                else
                    coins = coinRepo.findAllByCoinLocationOrderByPreservationStateDesc(query);
                break;
        }
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coins);
        return "/coinQueries";
    }

    @RequestMapping("/ejemplarConsultaPorEstado")
    public String consultaPorEstado(@RequestParam(value = "orderBy") String orderBy, @RequestParam(value = "order") String order,
                                    @RequestParam(value = "query") String query, Model model) {
        switch (orderBy) {
            case "CoinYear":
                if (order.equals("Asc"))
                    coins = coinRepo.findAllByPreservationStateOrderByCoinYearAsc(query);
                else
                    coins = coinRepo.findAllByPreservationStateOrderByCoinYearDesc(query);
                break;
            case "AcquisitionDate":
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
            case "PreservationState":
                if (order.equals("Asc"))
                    coins = coinRepo.findAllByPreservationStateOrderByPreservationStateAsc(query);
                else
                    coins = coinRepo.findAllByPreservationStateOrderByPreservationStateDesc(query);
                break;
        }
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coins);
        return "/coinQueries";
    }

    @RequestMapping("/ejemplarConsultaDual")
    public String consultaDual(@RequestParam(value = "value1") String value1, @RequestParam(value = "value2") String value2,
                               @RequestParam(value = "orderBy") String orderBy, @RequestParam(value = "order") String order,
                               @RequestParam(value = "queryC") long queryCoinID, @RequestParam(value = "querySP") long querySupplierID,
                               @RequestParam(value = "queryY") int queryY, @RequestParam(value = "queryD") Date queryDate,
                               @RequestParam(value = "query") String query, @RequestParam(value = "query2") String query2, Model model) {
        CoinModel queryCoin = coinModelRepository.getOne(queryCoinID);
        Supplier querySupplier = supplierRepository.getOne(querySupplierID);
        switch (orderBy) {
            case "CoinYear":
                switch (value1) {
                    case "CoinModel":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelOrderByCoinYearAsc(queryCoin);
                                else
                                    coins = coinRepo.findAllByCoinModelOrderByCoinYearDesc(queryCoin);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByCoinYearAsc(queryCoin, querySupplier);
                                else
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByCoinYearDesc(queryCoin, querySupplier);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinYearAsc(queryCoin, queryY);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinYearDesc(queryCoin, queryY);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinYearAsc(queryCoin, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinYearDesc(queryCoin, queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByCoinYearAsc(queryCoin, query);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByCoinYearDesc(queryCoin, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByCoinYearAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByCoinYearDesc(queryCoin, query2);
                                break;
                        }
                        break;
                    case "Supplier":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByCoinYearAsc(queryCoin, querySupplier);
                                else
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByCoinYearDesc(queryCoin, querySupplier);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierOrderByCoinYearAsc(querySupplier);
                                else
                                    coins = coinRepo.findAllBySupplierOrderByCoinYearDesc(querySupplier);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinYearAsc(querySupplier, queryY);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinYearDesc(querySupplier, queryY);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinYearAsc(querySupplier, queryDate);
                                else
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinYearDesc(querySupplier, queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByCoinYearAsc(querySupplier, query);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByCoinYearDesc(querySupplier, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinYearAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinYearDesc(queryCoin, query2);
                                break;
                        }
                        break;
                    case "CoinYear":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinYearAsc(queryCoin, queryY);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinYearDesc(queryCoin, queryY);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinYearAsc(querySupplier, queryY);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinYearDesc(querySupplier, queryY);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearOrderByCoinYearAsc(queryY);
                                else
                                    coins = coinRepo.findAllByCoinYearOrderByCoinYearDesc(queryY);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinYearAsc(queryY, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinYearDesc(queryY, queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinYearAsc(queryY, query);
                                else
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinYearDesc(queryY, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinYearAsc(queryY, query2);
                                else
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinYearDesc(queryY, query2);
                                break;
                        }
                        break;
                    case "AcquisitionDate":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinYearAsc(queryCoin, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinYearDesc(queryCoin, queryDate);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinYearAsc(querySupplier, queryDate);
                                else
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinYearDesc(querySupplier, queryDate);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinYearAsc(queryY, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinYearDesc(queryY, queryDate);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateOrderByCoinYearAsc(queryDate);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateOrderByCoinYearDesc(queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByCoinYearAsc(queryDate, query);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByCoinYearDesc(queryDate, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByCoinYearAsc(queryDate, query2);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByCoinYearDesc(queryDate, query2);
                                break;
                        }
                        break;
                    case "CoinLocation":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByCoinYearAsc(queryCoin, query);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByCoinYearDesc(queryCoin, query);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByCoinYearAsc(querySupplier, query);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByCoinYearDesc(querySupplier, query);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinYearAsc(queryY, query);
                                else
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinYearDesc(queryY, query);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByCoinYearAsc(queryDate, query);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByCoinYearDesc(queryDate, query);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinLocationOrderByCoinYearAsc(query);
                                else
                                    coins = coinRepo.findAllByCoinLocationOrderByCoinYearDesc(query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByCoinYearAsc(query, query2);
                                else
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByCoinYearDesc(query, query2);
                                break;
                        }
                        break;
                    case "PreservationState":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByCoinYearAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByCoinYearDesc(queryCoin, query2);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinYearAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinYearDesc(queryCoin, query2);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinYearAsc(queryY, query2);
                                else
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinYearDesc(queryY, query2);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByCoinYearAsc(queryDate, query2);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByCoinYearDesc(queryDate, query2);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByCoinYearAsc(query, query2);
                                else
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByCoinYearDesc(query, query2);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByPreservationStateOrderByCoinYearAsc(query2);
                                else
                                    coins = coinRepo.findAllByPreservationStateOrderByCoinYearDesc(query2);
                                break;
                        }
                        break;
                }
                break;
            case "AcquisitionDate":
                switch (value1) {
                    case "CoinModel":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelOrderByAcquisitionDateAsc(queryCoin);
                                else
                                    coins = coinRepo.findAllByCoinModelOrderByAcquisitionDateDesc(queryCoin);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByAcquisitionDateAsc(queryCoin, querySupplier);
                                else
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByAcquisitionDateDesc(queryCoin, querySupplier);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByAcquisitionDateAsc(queryCoin, queryY);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByAcquisitionDateDesc(queryCoin, queryY);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByAcquisitionDateAsc(queryCoin, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByAcquisitionDateDesc(queryCoin, queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByAcquisitionDateAsc(queryCoin, query);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByAcquisitionDateDesc(queryCoin, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByAcquisitionDateAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByAcquisitionDateDesc(queryCoin, query2);
                                break;
                        }
                        break;
                    case "Supplier":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByAcquisitionDateAsc(queryCoin, querySupplier);
                                else
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByAcquisitionDateDesc(queryCoin, querySupplier);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierOrderByAcquisitionDateAsc(querySupplier);
                                else
                                    coins = coinRepo.findAllBySupplierOrderByAcquisitionDateDesc(querySupplier);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByAcquisitionDateAsc(querySupplier, queryY);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByAcquisitionDateDesc(querySupplier, queryY);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByAcquisitionDateAsc(querySupplier, queryDate);
                                else
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByAcquisitionDateDesc(querySupplier, queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByAcquisitionDateAsc(querySupplier, query);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByAcquisitionDateDesc(querySupplier, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByAcquisitionDateAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByAcquisitionDateDesc(queryCoin, query2);
                                break;
                        }
                        break;
                    case "CoinYear":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByAcquisitionDateAsc(queryCoin, queryY);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByAcquisitionDateDesc(queryCoin, queryY);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByAcquisitionDateAsc(querySupplier, queryY);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByAcquisitionDateDesc(querySupplier, queryY);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearOrderByAcquisitionDateAsc(queryY);
                                else
                                    coins = coinRepo.findAllByCoinYearOrderByAcquisitionDateDesc(queryY);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByAcquisitionDateAsc(queryY, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByAcquisitionDateDesc(queryY, queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByAcquisitionDateAsc(queryY, query);
                                else
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByAcquisitionDateDesc(queryY, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByAcquisitionDateAsc(queryY, query2);
                                else
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByAcquisitionDateDesc(queryY, query2);
                                break;
                        }
                        break;
                    case "AcquisitionDate":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByAcquisitionDateAsc(queryCoin, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByAcquisitionDateDesc(queryCoin, queryDate);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByAcquisitionDateAsc(querySupplier, queryDate);
                                else
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByAcquisitionDateDesc(querySupplier, queryDate);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByAcquisitionDateAsc(queryY, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByAcquisitionDateDesc(queryY, queryDate);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateOrderByAcquisitionDateAsc(queryDate);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateOrderByAcquisitionDateDesc(queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByAcquisitionDateAsc(queryDate, query);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByAcquisitionDateDesc(queryDate, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByAcquisitionDateAsc(queryDate, query2);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByAcquisitionDateDesc(queryDate, query2);
                                break;
                        }
                        break;
                    case "CoinLocation":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByAcquisitionDateAsc(queryCoin, query);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByAcquisitionDateDesc(queryCoin, query);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByAcquisitionDateAsc(querySupplier, query);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByAcquisitionDateDesc(querySupplier, query);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByAcquisitionDateAsc(queryY, query);
                                else
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByAcquisitionDateDesc(queryY, query);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByAcquisitionDateAsc(queryDate, query);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByAcquisitionDateDesc(queryDate, query);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinLocationOrderByAcquisitionDateAsc(query);
                                else
                                    coins = coinRepo.findAllByCoinLocationOrderByAcquisitionDateDesc(query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByAcquisitionDateAsc(query, query2);
                                else
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByAcquisitionDateDesc(query, query2);
                                break;
                        }
                        break;
                    case "PreservationState":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByAcquisitionDateAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByAcquisitionDateDesc(queryCoin, query2);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByAcquisitionDateAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByAcquisitionDateDesc(queryCoin, query2);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByAcquisitionDateAsc(queryY, query2);
                                else
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByAcquisitionDateDesc(queryY, query2);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByAcquisitionDateAsc(queryDate, query2);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByAcquisitionDateDesc(queryDate, query2);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByAcquisitionDateAsc(query, query2);
                                else
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByAcquisitionDateDesc(query, query2);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByPreservationStateOrderByAcquisitionDateAsc(query2);
                                else
                                    coins = coinRepo.findAllByPreservationStateOrderByAcquisitionDateDesc(query2);
                                break;
                        }
                        break;
                }
                break;
            case "CoinLocation":
                switch (value1) {
                    case "CoinModel":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelOrderByCoinLocationAsc(queryCoin);
                                else
                                    coins = coinRepo.findAllByCoinModelOrderByCoinLocationDesc(queryCoin);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByCoinLocationAsc(queryCoin, querySupplier);
                                else
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByCoinLocationDesc(queryCoin, querySupplier);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinLocationAsc(queryCoin, queryY);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinLocationDesc(queryCoin, queryY);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinLocationAsc(queryCoin, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinLocationDesc(queryCoin, queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByCoinLocationAsc(queryCoin, query);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByCoinLocationDesc(queryCoin, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByCoinLocationAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByCoinLocationDesc(queryCoin, query2);
                                break;
                        }
                        break;
                    case "Supplier":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByCoinLocationAsc(queryCoin, querySupplier);
                                else
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByCoinLocationDesc(queryCoin, querySupplier);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierOrderByCoinLocationAsc(querySupplier);
                                else
                                    coins = coinRepo.findAllBySupplierOrderByCoinLocationDesc(querySupplier);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinLocationAsc(querySupplier, queryY);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinLocationDesc(querySupplier, queryY);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinLocationAsc(querySupplier, queryDate);
                                else
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinLocationDesc(querySupplier, queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByCoinLocationAsc(querySupplier, query);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByCoinLocationDesc(querySupplier, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinLocationAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinLocationDesc(queryCoin, query2);
                                break;
                        }
                        break;
                    case "CoinYear":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinLocationAsc(queryCoin, queryY);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinLocationDesc(queryCoin, queryY);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinLocationAsc(querySupplier, queryY);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinLocationDesc(querySupplier, queryY);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearOrderByCoinLocationAsc(queryY);
                                else
                                    coins = coinRepo.findAllByCoinYearOrderByCoinLocationDesc(queryY);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinLocationAsc(queryY, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinLocationDesc(queryY, queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinLocationAsc(queryY, query);
                                else
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinLocationDesc(queryY, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinLocationAsc(queryY, query2);
                                else
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinLocationDesc(queryY, query2);
                                break;
                        }
                        break;
                    case "AcquisitionDate":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinLocationAsc(queryCoin, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinLocationDesc(queryCoin, queryDate);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinLocationAsc(querySupplier, queryDate);
                                else
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinLocationDesc(querySupplier, queryDate);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinLocationAsc(queryY, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinLocationDesc(queryY, queryDate);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateOrderByCoinLocationAsc(queryDate);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateOrderByCoinLocationDesc(queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByCoinLocationAsc(queryDate, query);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByCoinLocationDesc(queryDate, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByCoinLocationAsc(queryDate, query2);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByCoinLocationDesc(queryDate, query2);
                                break;
                        }
                        break;
                    case "CoinLocation":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByCoinLocationAsc(queryCoin, query);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByCoinLocationDesc(queryCoin, query);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByCoinLocationAsc(querySupplier, query);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByCoinLocationDesc(querySupplier, query);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinLocationAsc(queryY, query);
                                else
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinLocationDesc(queryY, query);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByCoinLocationAsc(queryDate, query);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByCoinLocationDesc(queryDate, query);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinLocationOrderByCoinLocationAsc(query);
                                else
                                    coins = coinRepo.findAllByCoinLocationOrderByCoinLocationDesc(query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByCoinLocationAsc(query, query2);
                                else
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByCoinLocationDesc(query, query2);
                                break;
                        }
                        break;
                    case "PreservationState":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByCoinLocationAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByCoinLocationDesc(queryCoin, query2);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinLocationAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinLocationDesc(queryCoin, query2);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinLocationAsc(queryY, query2);
                                else
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinLocationDesc(queryY, query2);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByCoinLocationAsc(queryDate, query2);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByCoinLocationDesc(queryDate, query2);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByCoinLocationAsc(query, query2);
                                else
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByCoinLocationDesc(query, query2);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByPreservationStateOrderByCoinLocationAsc(query2);
                                else
                                    coins = coinRepo.findAllByPreservationStateOrderByCoinLocationDesc(query2);
                                break;
                        }
                        break;
                }
                break;
            case "PreservationState":
                switch (value1) {
                    case "CoinModel":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelOrderByPreservationStateAsc(queryCoin);
                                else
                                    coins = coinRepo.findAllByCoinModelOrderByPreservationStateDesc(queryCoin);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByPreservationStateAsc(queryCoin, querySupplier);
                                else
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByPreservationStateDesc(queryCoin, querySupplier);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByPreservationStateAsc(queryCoin, queryY);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByPreservationStateDesc(queryCoin, queryY);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByPreservationStateAsc(queryCoin, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByPreservationStateDesc(queryCoin, queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByPreservationStateAsc(queryCoin, query);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByPreservationStateDesc(queryCoin, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByPreservationStateAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByPreservationStateDesc(queryCoin, query2);
                                break;
                        }
                        break;
                    case "Supplier":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByPreservationStateAsc(queryCoin, querySupplier);
                                else
                                    coins = coinRepo.findAllByCoinModelAndSupplierOrderByPreservationStateDesc(queryCoin, querySupplier);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierOrderByPreservationStateAsc(querySupplier);
                                else
                                    coins = coinRepo.findAllBySupplierOrderByPreservationStateDesc(querySupplier);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByPreservationStateAsc(querySupplier, queryY);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByPreservationStateDesc(querySupplier, queryY);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByPreservationStateAsc(querySupplier, queryDate);
                                else
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByPreservationStateDesc(querySupplier, queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByPreservationStateAsc(querySupplier, query);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByPreservationStateDesc(querySupplier, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByPreservationStateAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByPreservationStateDesc(queryCoin, query2);
                                break;
                        }
                        break;
                    case "CoinYear":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByPreservationStateAsc(queryCoin, queryY);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinYearOrderByPreservationStateDesc(queryCoin, queryY);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByPreservationStateAsc(querySupplier, queryY);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinYearOrderByPreservationStateDesc(querySupplier, queryY);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearOrderByPreservationStateAsc(queryY);
                                else
                                    coins = coinRepo.findAllByCoinYearOrderByPreservationStateDesc(queryY);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByPreservationStateAsc(queryY, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByPreservationStateDesc(queryY, queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByPreservationStateAsc(queryY, query);
                                else
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByPreservationStateDesc(queryY, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByPreservationStateAsc(queryY, query2);
                                else
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByPreservationStateDesc(queryY, query2);
                                break;
                        }
                        break;
                    case "AcquisitionDate":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByPreservationStateAsc(queryCoin, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByPreservationStateDesc(queryCoin, queryDate);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByPreservationStateAsc(querySupplier, queryDate);
                                else
                                    coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByPreservationStateDesc(querySupplier, queryDate);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByPreservationStateAsc(queryY, queryDate);
                                else
                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByPreservationStateDesc(queryY, queryDate);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateOrderByPreservationStateAsc(queryDate);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateOrderByPreservationStateDesc(queryDate);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByPreservationStateAsc(queryDate, query);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByPreservationStateDesc(queryDate, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByPreservationStateAsc(queryDate, query2);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByPreservationStateDesc(queryDate, query2);
                                break;
                        }
                        break;
                    case "CoinLocation":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByPreservationStateAsc(queryCoin, query);
                                else
                                    coins = coinRepo.findAllByCoinModelAndCoinLocationOrderByPreservationStateDesc(queryCoin, query);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByPreservationStateAsc(querySupplier, query);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByPreservationStateDesc(querySupplier, query);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByPreservationStateAsc(queryY, query);
                                else
                                    coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByPreservationStateDesc(queryY, query);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByPreservationStateAsc(queryDate, query);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByPreservationStateDesc(queryDate, query);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinLocationOrderByPreservationStateAsc(query);
                                else
                                    coins = coinRepo.findAllByCoinLocationOrderByPreservationStateDesc(query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByPreservationStateAsc(query, query2);
                                else
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByPreservationStateDesc(query, query2);
                                break;
                        }
                        break;
                    case "PreservationState":
                        switch (value2) {
                            case "CoinModel":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByPreservationStateAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllByCoinModelAndPreservationStateOrderByPreservationStateDesc(queryCoin, query2);
                                break;
                            case "Supplier":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByPreservationStateAsc(queryCoin, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByPreservationStateDesc(queryCoin, query2);
                                break;
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByPreservationStateAsc(queryY, query2);
                                else
                                    coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByPreservationStateDesc(queryY, query2);
                                break;
                            case "AcquisitionDate":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByPreservationStateAsc(queryDate, query2);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByPreservationStateDesc(queryDate, query2);
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByPreservationStateAsc(query, query2);
                                else
                                    coins = coinRepo.findAllByCoinLocationAndPreservationStateOrderByPreservationStateDesc(query, query2);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByPreservationStateOrderByPreservationStateAsc(query2);
                                else
                                    coins = coinRepo.findAllByPreservationStateOrderByPreservationStateDesc(query2);
                                break;
                        }
                        break;
                }
                break;
        }
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coins);
        return "/coinQueries";
    }

    @RequestMapping("/todosLosEjemplares")
    public String showAll(Model model) {
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coinRepo.findAll());
        return "/coinQueries";
    }

}