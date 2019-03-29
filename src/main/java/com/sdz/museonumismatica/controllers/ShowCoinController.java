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
        if (orderBy.equals("None"))
            coins = coinRepo.findAllByCoinModel(queryCoin);
        else
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
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coins);
        return "/coinQueries";
    }

    @RequestMapping("/ejemplarConsultaPorProveedor")
    public String consultaPorSupplier(@RequestParam(value = "orderBy") String orderBy, @RequestParam(value = "order") String order, @RequestParam(value = "querySP") long querySupplierID, Model model) {
        Supplier querySupplier = supplierRepository.getOne(querySupplierID);
        if (orderBy.equals("None"))
            coins = coinRepo.findAllBySupplier(querySupplier);
        else
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
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coins);
        return "/coinQueries";
    }

    @RequestMapping("/ejemplarConsultaPorAño")
    public String consultaPorAño(@RequestParam(value = "orderBy") String orderBy, @RequestParam(value = "time") String time,
                          @RequestParam(value = "order") String order, @RequestParam(value = "queryY") int queryY, Model model) {
        if (time.equals("None"))
            coins = coinRepo.findAllByCoinYear(queryY);
        else {
            switch (time) {
                case "Same":
                    if (orderBy.equals("CoinYear"))
                        coins = coinRepo.findAllByCoinYear(queryY);
                    else {
                        switch (orderBy) {
                            case "coinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearOrderByCoinYearAsc(queryY);
                                else
                                    coins = coinRepo.findAllByCoinYearOrderByCoinYearDesc(queryY);
                                break;
                            case "Date":
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
                    }
                case "Before":
                    if (orderBy.equals("Nothing"))
                        coins = coinRepo.findAllByCoinYearBefore(queryY);
                    else {
                        switch (orderBy) {
                            case "Year":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearBeforeOrderByCoinYearAsc(queryY);
                                else
                                    coins = coinRepo.findAllByCoinYearBeforeOrderByCoinYearDesc(queryY);
                                break;
                            case "Date":
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
                    }
                    break;
                case "After":
                    if (orderBy.equals("Nothing"))
                        coins = coinRepo.findAllByCoinYearAfter(queryY);
                    else {
                        switch (orderBy) {
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByCoinYearAfterOrderByCoinYearAsc(queryY);
                                else
                                    coins = coinRepo.findAllByCoinYearAfterOrderByCoinYearDesc(queryY);
                                break;
                            case "Date":
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
                    }
                break;
            }
        }
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coins);
        return "/coinQueries";
    }

    @RequestMapping("/ejemplarConsultaPorFecha")
    public String consultaPorFecha(@RequestParam(value = "orderBy") String orderBy, @RequestParam(value = "time") String time,
                                   @RequestParam(value = "order") String order, @RequestParam(value = "queryD") Date queryDate, Model model) {
        if (time.equals("None"))
            coins = coinRepo.findAllByAcquisitionDate(queryDate);
        else
            switch (time) {
                case "Same":
                    if(orderBy.equals("Nothing"))
                        coins = coinRepo.findAllByAcquisitionDate(queryDate);
                    else{
                        switch(orderBy){
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateOrderByCoinYearAsc(queryDate);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateOrderByCoinYearDesc(queryDate);
                                break;
                            case "Date":
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
                    }
                    break;
                case "Before":
                    if(orderBy.equals("Nothing"))
                        coins = coinRepo.findAllByAcquisitionDateBefore(queryDate);
                    else{
                        switch(orderBy){
                            case "CoinYear":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllByAcquisitionDateBeforeOrderByCoinYearAsc(queryDate);
                                else
                                    coins = coinRepo.findAllByAcquisitionDateBeforeOrderByCoinYearDesc(queryDate);
                                break;
                            case "Date":
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
                            case "Date":
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
                    }
                    break;
            }
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coins);
        return "/coinQueries";
    }

    @RequestMapping("/ejemplarConsultaPorLocalizacion")
    public String consultaPorLocalizacion(@RequestParam(value = "orderBy") String orderBy, @RequestParam(value = "order") String order, @RequestParam(value = "query") String query, Model model) {
        if (orderBy.equals("None"))
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
    public String consultaPorEstado(@RequestParam(value = "orderBy") String orderBy, @RequestParam(value = "order") String order, @RequestParam(value = "query") String query, Model model) {
        if (orderBy.equals("None"))
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

    @RequestMapping("/todosLosEjemplares")
    public String showAll(Model model) {
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coinRepo.findAll());
        return "/coinQueries";
    }

}