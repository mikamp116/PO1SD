package com.sdz.museonumismatica.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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

/**
 * @author Jorge Chavero Morcillo
 *
 * Implementacion de mostrar ejemplares
 */
@Controller
public class ShowCoinController {
    @Autowired
    private CoinRepository coinRepo;
    @Autowired
    private CoinModelRepository coinModelRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    List<Coin> coins = new ArrayList<>();

    //Muestra los coin usando diferentes criterios
    @RequestMapping("/coinQuery")
    public String consultaDual(@RequestParam(value = "value1") String value1, @RequestParam(value = "value2") String value2,
                               @RequestParam(value = "orderBy") String orderBy, @RequestParam(value = "order") String order,
                               @RequestParam(value = "time") String time, @RequestParam(value = "time2") String time2,
                               @RequestParam(value = "queryC") long queryCoinID, @RequestParam(value = "querySP") long querySupplierID,
                               @RequestParam(value = "queryY") int queryY, @RequestParam(value = "queryD") Date queryDate,
                               @RequestParam(value = "query") String query, @RequestParam(value = "query2") String query2, Model model) {
        CoinModel queryCoin = coinModelRepository.getOne(queryCoinID);
        Supplier querySupplier = supplierRepository.getOne(querySupplierID);

        //Para que la pagina recuerde lo que el usuario selecciono
        model.addAttribute("qOrderBy", orderBy);
        model.addAttribute("qOrder", order);
        model.addAttribute("qvalue", value1);
        model.addAttribute("qvalue2", value2);
        model.addAttribute("qtime", time);
        model.addAttribute("qtime2", time2);
        model.addAttribute("qqueryY", queryY);
        model.addAttribute("qqueryD", queryDate);
        model.addAttribute("qquery", query);
        model.addAttribute("qquery1", query2);

        switch (orderBy) { //Ordenar por
            case "CoinYear":
                switch (value1) { //Primer valor
                    case "CoinModel":
                        switch (value2) { //Segundo valor
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
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByCoinYearAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByCoinYearDesc(queryCoin, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByCoinYearAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByCoinYearDesc(queryCoin, queryY);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinYearAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinYearDesc(queryCoin, queryY);
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByCoinYearAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByCoinYearDesc(queryCoin, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByCoinYearAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByCoinYearDesc(queryCoin,queryDate);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinYearAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinYearDesc(queryCoin, queryDate);
                                        break;
                                }
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
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByCoinYearAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByCoinYearDesc(querySupplier, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByCoinYearAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByCoinYearDesc(querySupplier, queryY);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinYearAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinYearDesc(querySupplier, queryY);
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByCoinYearAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByCoinYearDesc(querySupplier, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByCoinYearAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByCoinYearDesc(querySupplier, queryDate);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinYearAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinYearDesc(querySupplier, queryDate);
                                        break;
                                }
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByCoinYearAsc(querySupplier, query);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByCoinYearDesc(querySupplier, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinYearAsc(querySupplier, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinYearDesc(querySupplier, query2);
                                break;
                        }
                        break;
                    case "CoinYear":
                        switch (value2) {
                            case "CoinModel":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinYearAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinYearDesc(queryCoin, queryY);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByCoinYearAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByCoinYearDesc(queryCoin, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByCoinYearAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByCoinYearDesc(queryCoin, queryY);
                                        break;
                                }
                                break;
                            case "Supplier":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinYearAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinYearDesc(querySupplier, queryY);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByCoinYearAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByCoinYearDesc(querySupplier, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByCoinYearAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByCoinYearDesc(querySupplier, queryY);
                                        break;
                                }
                                break;
                            case "CoinYear":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearOrderByCoinYearAsc(queryY);
                                        else
                                            coins = coinRepo.findAllByCoinYearOrderByCoinYearDesc(queryY);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByCoinYearAsc(queryY);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByCoinYearDesc(queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterOrderByCoinYearAsc(queryY);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterOrderByCoinYearDesc(queryY);
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time) {
                                    case "Same":
                                        switch (time2) {
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                    case "Before":
                                        switch (time2) {
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                    case "After":
                                        switch (time2) {
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case "CoinLocation":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinYearAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinYearDesc(queryY, query);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByCoinYearAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByCoinYearDesc(queryY, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByCoinYearAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByCoinYearDesc(queryY, query);
                                        break;
                                }
                                break;
                            case "PreservationState":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinYearAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinYearDesc(queryY, query2);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByCoinYearAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByCoinYearDesc(queryY, query2);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByCoinYearAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByCoinYearDesc(queryY, query2);
                                        break;
                                }
                                break;
                        }
                        break;
                    case "AcquisitionDate":
                        switch (value2) {
                            case "CoinModel":
                                switch (time2) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinYearAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinYearDesc(queryCoin, queryDate);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByCoinYearAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByCoinYearDesc(queryCoin, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByCoinYearAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByCoinYearDesc(queryCoin, queryDate);
                                        break;
                                }
                                break;
                            case "Supplier":
                                switch (time2) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinYearAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinYearDesc(querySupplier, queryDate);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByCoinYearAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByCoinYearDesc(querySupplier, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByCoinYearAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByCoinYearDesc(querySupplier, queryDate);
                                        break;
                                }
                                break;
                            case "CoinYear":
                                switch (time) {
                                    case "Before":
                                        switch (time2) {
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                    case "After":
                                        switch (time2) {
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                        }
                                    case "Same":
                                        switch (time2) {
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinYearAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinYearDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByCoinYearAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByCoinYearDesc(queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByCoinYearAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByCoinYearDesc(queryDate);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateOrderByCoinYearAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateOrderByCoinYearDesc(queryDate);
                                        break;
                                }
                                break;
                            case "CoinLocation":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByCoinYearAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByCoinYearDesc(queryDate, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByCoinYearAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByCoinYearDesc(queryDate, query);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByCoinYearAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByCoinYearDesc(queryDate, query);
                                        break;
                                }
                                break;
                            case "PreservationState":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndPreservationStateOrderByCoinYearAsc(queryDate, query2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndPreservationStateOrderByCoinYearDesc(queryDate, query2);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndPreservationStateOrderByCoinYearAsc(queryDate, query2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndPreservationStateOrderByCoinYearDesc(queryDate, query2);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByCoinYearAsc(queryDate, query2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByCoinYearDesc(queryDate, query2);
                                        break;
                                }
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
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByCoinYearAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByCoinYearDesc(queryY, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByCoinYearAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByCoinYearDesc(queryY, query);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinYearAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinYearDesc(queryY, query);
                                        break;
                                }
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc")) {
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByCoinYearAsc(queryDate, query);
                                        } else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByCoinYearDesc(queryDate, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByCoinYearAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByCoinYearDesc(queryDate, query);
                                        break;
                                }
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
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinYearAsc(querySupplier, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinYearDesc(querySupplier, query2);
                                break;
                            case "CoinYear":
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByCoinYearAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByCoinYearDesc(queryY, query2);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByCoinYearAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByCoinYearDesc(queryY, query2);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinYearAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinYearDesc(queryY, query2);
                                        break;
                                }
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
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByAcquisitionDateAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByAcquisitionDateDesc(queryCoin, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByAcquisitionDateAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByAcquisitionDateDesc(queryCoin, queryY);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByAcquisitionDateAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByAcquisitionDateDesc(queryCoin, queryY);
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(queryCoin, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByAcquisitionDateAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByAcquisitionDateDesc(queryCoin, queryDate);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByAcquisitionDateAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByAcquisitionDateDesc(queryCoin, queryDate);
                                        break;
                                }
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
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByAcquisitionDateAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByAcquisitionDateDesc(querySupplier, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByAcquisitionDateAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByAcquisitionDateDesc(querySupplier, queryY);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByAcquisitionDateAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByAcquisitionDateDesc(querySupplier, queryY);
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(querySupplier, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByAcquisitionDateAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByAcquisitionDateDesc(querySupplier, queryDate);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByAcquisitionDateAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByAcquisitionDateDesc(querySupplier, queryDate);
                                        break;
                                }
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByAcquisitionDateAsc(querySupplier, query);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByAcquisitionDateDesc(querySupplier, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByAcquisitionDateAsc(querySupplier, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByAcquisitionDateDesc(querySupplier, query2);
                                break;
                        }
                        break;
                    case "CoinYear":
                        switch (value2) {
                            case "CoinModel":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByAcquisitionDateAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByAcquisitionDateDesc(queryCoin, queryY);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByAcquisitionDateAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByAcquisitionDateDesc(queryCoin, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByAcquisitionDateAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByAcquisitionDateDesc(queryCoin, queryY);
                                        break;
                                }
                                break;
                            case "Supplier":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByAcquisitionDateAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByAcquisitionDateDesc(querySupplier, queryY);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByAcquisitionDateAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByAcquisitionDateDesc(querySupplier, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByAcquisitionDateAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByAcquisitionDateDesc(querySupplier, queryY);
                                        break;
                                }
                                break;
                            case "CoinYear":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearOrderByAcquisitionDateAsc(queryY);
                                        else
                                            coins = coinRepo.findAllByCoinYearOrderByAcquisitionDateDesc(queryY);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByAcquisitionDateAsc(queryY);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByAcquisitionDateDesc(queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterOrderByAcquisitionDateAsc(queryY);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterOrderByAcquisitionDateDesc(queryY);
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time) {
                                    case "Same":
                                        switch (time2) {
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                    case "Before":
                                        switch (time2) {
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                    case "After":
                                        switch (time2) {
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case "CoinLocation":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByAcquisitionDateAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByAcquisitionDateDesc(queryY, query);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByAcquisitionDateAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByAcquisitionDateDesc(queryY, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByAcquisitionDateAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByAcquisitionDateDesc(queryY, query);
                                        break;
                                }
                                break;
                            case "PreservationState":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByAcquisitionDateAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByAcquisitionDateDesc(queryY, query2);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByAcquisitionDateAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByAcquisitionDateDesc(queryY, query2);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByAcquisitionDateAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByAcquisitionDateDesc(queryY, query2);
                                        break;
                                }
                                break;
                        }
                        break;
                    case "AcquisitionDate":
                        switch (value2) {
                            case "CoinModel":
                                switch (time2) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByAcquisitionDateAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByAcquisitionDateDesc(queryCoin, queryDate);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(queryCoin, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByAcquisitionDateAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByAcquisitionDateDesc(queryCoin, queryDate);
                                        break;
                                }
                                break;
                            case "Supplier":
                                switch (time2) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByAcquisitionDateAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByAcquisitionDateDesc(querySupplier, queryDate);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(querySupplier, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByAcquisitionDateAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByAcquisitionDateDesc(querySupplier, queryDate);
                                        break;
                                }
                                break;
                            case "CoinYear":
                                switch (time) {
                                    case "Before":
                                        switch (time2) {
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                    case "After":
                                        switch (time2) {
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                        }
                                    case "Same":
                                        switch (time2) {
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByAcquisitionDateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByAcquisitionDateDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByAcquisitionDateAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByAcquisitionDateDesc(queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByAcquisitionDateAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByAcquisitionDateDesc(queryDate);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateOrderByAcquisitionDateAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateOrderByAcquisitionDateDesc(queryDate);
                                        break;
                                }
                                break;
                            case "CoinLocation":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByAcquisitionDateAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByAcquisitionDateDesc(queryDate, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByAcquisitionDateAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByAcquisitionDateDesc(queryDate, query);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByAcquisitionDateAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByAcquisitionDateDesc(queryDate, query);
                                        break;
                                }
                                break;
                            case "PreservationState":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndPreservationStateOrderByAcquisitionDateAsc(queryDate, query2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndPreservationStateOrderByAcquisitionDateDesc(queryDate, query2);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndPreservationStateOrderByAcquisitionDateAsc(queryDate, query2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndPreservationStateOrderByAcquisitionDateDesc(queryDate, query2);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByAcquisitionDateAsc(queryDate, query2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByAcquisitionDateDesc(queryDate, query2);
                                        break;
                                }
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
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByAcquisitionDateAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByAcquisitionDateDesc(queryY, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByAcquisitionDateAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByAcquisitionDateDesc(queryY, query);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByAcquisitionDateAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByAcquisitionDateDesc(queryY, query);
                                        break;
                                }
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByAcquisitionDateAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByAcquisitionDateDesc(queryDate, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByAcquisitionDateAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByAcquisitionDateDesc(queryDate, query);
                                        break;
                                }
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
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByAcquisitionDateAsc(querySupplier, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByAcquisitionDateDesc(querySupplier, query2);
                                break;
                            case "CoinYear":
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByAcquisitionDateAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByAcquisitionDateDesc(queryY, query2);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByAcquisitionDateAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByAcquisitionDateDesc(queryY, query2);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByAcquisitionDateAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByAcquisitionDateDesc(queryY, query2);
                                        break;
                                }
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
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByCoinLocationAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByCoinLocationDesc(queryCoin, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByCoinLocationAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByCoinLocationDesc(queryCoin, queryY);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinLocationAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinLocationDesc(queryCoin, queryY);
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByCoinLocationAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByCoinLocationDesc(queryCoin, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByCoinLocationAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByCoinLocationDesc(queryCoin, queryDate);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinLocationAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinLocationDesc(queryCoin, queryDate);
                                        break;
                                }
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
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByCoinLocationAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByCoinLocationDesc(querySupplier, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByCoinLocationAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByCoinLocationDesc(querySupplier, queryY);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinLocationAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinLocationDesc(querySupplier, queryY);
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByCoinLocationAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByCoinLocationDesc(querySupplier, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByCoinLocationAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByCoinLocationDesc(querySupplier, queryDate);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinLocationAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinLocationDesc(querySupplier, queryDate);
                                        break;
                                }
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByCoinLocationAsc(querySupplier, query);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByCoinLocationDesc(querySupplier, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinLocationAsc(querySupplier, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinLocationDesc(querySupplier, query2);
                                break;
                        }
                        break;
                    case "CoinYear":
                        switch (value2) {
                            case "CoinModel":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinLocationAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByCoinLocationDesc(queryCoin, queryY);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByCoinLocationAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByCoinLocationDesc(queryCoin, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByCoinLocationAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByCoinLocationDesc(queryCoin, queryY);
                                        break;
                                }
                                break;
                            case "Supplier":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinLocationAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByCoinLocationDesc(querySupplier, queryY);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByCoinLocationAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByCoinLocationDesc(querySupplier, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByCoinLocationAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByCoinLocationDesc(querySupplier, queryY);
                                        break;
                                }
                                break;
                            case "CoinYear":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearOrderByCoinLocationAsc(queryY);
                                        else
                                            coins = coinRepo.findAllByCoinYearOrderByCoinLocationDesc(queryY);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByCoinLocationAsc(queryY);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByCoinLocationDesc(queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterOrderByCoinLocationAsc(queryY);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterOrderByCoinLocationDesc(queryY);
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time) {
                                    case "Same":
                                        switch (time2) {
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                    case "Before":
                                        switch (time2) {
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                    case "After":
                                        switch (time2) {
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case "CoinLocation":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinLocationAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinLocationDesc(queryY, query);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByCoinLocationAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByCoinLocationDesc(queryY, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByCoinLocationAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByCoinLocationDesc(queryY, query);
                                        break;
                                }
                                break;
                            case "PreservationState":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinLocationAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinLocationDesc(queryY, query2);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByCoinLocationAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByCoinLocationDesc(queryY, query2);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByCoinLocationAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByCoinLocationDesc(queryY, query2);
                                        break;
                                }
                                break;
                        }
                        break;
                    case "AcquisitionDate":
                        switch (value2) {
                            case "CoinModel":
                                switch (time2) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinLocationAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByCoinLocationDesc(queryCoin, queryDate);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByCoinLocationAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByCoinLocationDesc(queryCoin, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByCoinLocationAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByCoinLocationDesc(queryCoin, queryDate);
                                        break;
                                }
                                break;
                            case "Supplier":
                                switch (time2) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinLocationAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByCoinLocationDesc(querySupplier, queryDate);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByCoinLocationAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByCoinLocationDesc(querySupplier, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByCoinLocationAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByCoinLocationDesc(querySupplier, queryDate);
                                        break;
                                }
                                break;
                            case "CoinYear":
                                switch (time) {
                                    case "Before":
                                        switch (time2) {
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                    case "After":
                                        switch (time2) {
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                        }
                                    case "Same":
                                        switch (time2) {
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinLocationAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByCoinLocationDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByCoinLocationAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByCoinLocationDesc(queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByCoinLocationAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByCoinLocationDesc(queryDate);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateOrderByCoinLocationAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateOrderByCoinLocationDesc(queryDate);
                                        break;
                                }
                                break;
                            case "CoinLocation":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByCoinLocationAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByCoinLocationDesc(queryDate, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByCoinLocationAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByCoinLocationDesc(queryDate, query);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByCoinLocationAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByCoinLocationDesc(queryDate, query);
                                        break;
                                }
                                break;
                            case "PreservationState":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndPreservationStateOrderByCoinLocationAsc(queryDate, query2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndPreservationStateOrderByCoinLocationDesc(queryDate, query2);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndPreservationStateOrderByCoinLocationAsc(queryDate, query2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndPreservationStateOrderByCoinLocationDesc(queryDate, query2);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByCoinLocationAsc(queryDate, query2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByCoinLocationDesc(queryDate, query2);
                                        break;
                                }
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
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByCoinLocationAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByCoinLocationDesc(queryY, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByCoinLocationAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByCoinLocationDesc(queryY, query);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinLocationAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByCoinLocationDesc(queryY, query);
                                        break;
                                }
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByCoinLocationAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByCoinLocationDesc(queryDate, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByCoinLocationAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByCoinLocationDesc(queryDate, query);
                                        break;
                                }
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
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinLocationAsc(querySupplier, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByCoinLocationDesc(querySupplier, query2);
                                break;
                            case "CoinYear":
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByCoinLocationAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByCoinLocationDesc(queryY, query2);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByCoinLocationAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByCoinLocationDesc(queryY, query2);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinLocationAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByCoinLocationDesc(queryY, query2);
                                        break;
                                }
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
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByPreservationStateAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByPreservationStateDesc(queryCoin, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByPreservationStateAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByPreservationStateDesc(queryCoin, queryY);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByPreservationStateAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByPreservationStateDesc(queryCoin, queryY);
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByPreservationStateAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByPreservationStateDesc(queryCoin, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByPreservationStateAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByPreservationStateDesc(queryCoin, queryDate);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByPreservationStateAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByPreservationStateDesc(queryCoin, queryDate);
                                        break;
                                }
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
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByPreservationStateAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByPreservationStateDesc(querySupplier, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByPreservationStateAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByPreservationStateDesc(querySupplier, queryY);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByPreservationStateAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByPreservationStateDesc(querySupplier, queryY);
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByPreservationStateAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByPreservationStateDesc(querySupplier, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByPreservationStateAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByPreservationStateDesc(querySupplier, queryDate);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByPreservationStateAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByPreservationStateDesc(querySupplier, queryDate);
                                        break;
                                }
                                break;
                            case "CoinLocation":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByPreservationStateAsc(querySupplier, query);
                                else
                                    coins = coinRepo.findAllBySupplierAndCoinLocationOrderByPreservationStateDesc(querySupplier, query);
                                break;
                            case "PreservationState":
                                if (order.equals("Asc"))
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByPreservationStateAsc(querySupplier, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByPreservationStateDesc(querySupplier, query2);
                                break;
                        }
                        break;
                    case "CoinYear":
                        switch (value2) {
                            case "CoinModel":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByPreservationStateAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearOrderByPreservationStateDesc(queryCoin, queryY);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByPreservationStateAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearBeforeOrderByPreservationStateDesc(queryCoin, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByPreservationStateAsc(queryCoin, queryY);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndCoinYearAfterOrderByPreservationStateDesc(queryCoin, queryY);
                                        break;
                                }
                                break;
                            case "Supplier":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByPreservationStateAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearOrderByPreservationStateDesc(querySupplier, queryY);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByPreservationStateAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearBeforeOrderByPreservationStateDesc(querySupplier, queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByPreservationStateAsc(querySupplier, queryY);
                                        else
                                            coins = coinRepo.findAllBySupplierAndCoinYearAfterOrderByPreservationStateDesc(querySupplier, queryY);
                                        break;
                                }
                                break;
                            case "CoinYear":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearOrderByPreservationStateAsc(queryY);
                                        else
                                            coins = coinRepo.findAllByCoinYearOrderByPreservationStateDesc(queryY);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByPreservationStateAsc(queryY);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeOrderByPreservationStateDesc(queryY);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterOrderByPreservationStateAsc(queryY);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterOrderByPreservationStateDesc(queryY);
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time) {
                                    case "Same":
                                        switch (time2) {
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                    case "Before":
                                        switch (time2) {
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                    case "After":
                                        switch (time2) {
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case "CoinLocation":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByPreservationStateAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByPreservationStateDesc(queryY, query);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByPreservationStateAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByPreservationStateDesc(queryY, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByPreservationStateAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByPreservationStateDesc(queryY, query);
                                        break;
                                }
                                break;
                            case "PreservationState":
                                switch (time) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByPreservationStateAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByPreservationStateDesc(queryY, query2);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByPreservationStateAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByPreservationStateDesc(queryY, query2);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByPreservationStateAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByPreservationStateDesc(queryY, query2);
                                        break;
                                }
                                break;
                        }
                        break;
                    case "AcquisitionDate":
                        switch (value2) {
                            case "CoinModel":
                                switch (time2) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByPreservationStateAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateOrderByPreservationStateDesc(queryCoin, queryDate);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByPreservationStateAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateBeforeOrderByPreservationStateDesc(queryCoin, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByPreservationStateAsc(queryCoin, queryDate);
                                        else
                                            coins = coinRepo.findAllByCoinModelAndAcquisitionDateAfterOrderByPreservationStateDesc(queryCoin, queryDate);
                                        break;
                                }
                                break;
                            case "Supplier":
                                switch (time2) {
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByPreservationStateAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateOrderByPreservationStateDesc(querySupplier, queryDate);
                                        break;
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByPreservationStateAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateBeforeOrderByPreservationStateDesc(querySupplier, queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByPreservationStateAsc(querySupplier, queryDate);
                                        else
                                            coins = coinRepo.findAllBySupplierAndAcquisitionDateAfterOrderByPreservationStateDesc(querySupplier, queryDate);
                                        break;
                                }
                                break;
                            case "CoinYear":
                                switch (time) {
                                    case "Before":
                                        switch (time2) {
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                    case "After":
                                        switch (time2) {
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAfterAndAcquisitionDateAfterOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearBeforeAndAcquisitionDateOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                        }
                                    case "Same":
                                        switch (time2) {
                                            case "Before":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateBeforeOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                            case "After":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateAfterOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                            case "Same":
                                                if (order.equals("Asc"))
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByPreservationStateAsc(queryY, queryDate);
                                                else
                                                    coins = coinRepo.findAllByCoinYearAndAcquisitionDateOrderByPreservationStateDesc(queryY, queryDate);
                                                break;
                                        }
                                        break;
                                }
                                break;
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByPreservationStateAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeOrderByPreservationStateDesc(queryDate);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByPreservationStateAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterOrderByPreservationStateDesc(queryDate);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateOrderByPreservationStateAsc(queryDate);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateOrderByPreservationStateDesc(queryDate);
                                        break;
                                }
                                break;
                            case "CoinLocation":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByPreservationStateAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByPreservationStateDesc(queryDate, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByPreservationStateAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByPreservationStateDesc(queryDate, query);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByPreservationStateAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAndCoinLocationOrderByPreservationStateDesc(queryDate, query);
                                        break;
                                }
                                break;
                            case "PreservationState":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndPreservationStateOrderByPreservationStateAsc(queryDate, query2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndPreservationStateOrderByPreservationStateDesc(queryDate, query2);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndPreservationStateOrderByPreservationStateAsc(queryDate, query2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndPreservationStateOrderByPreservationStateDesc(queryDate, query2);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByPreservationStateAsc(queryDate, query2);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAndPreservationStateOrderByPreservationStateDesc(queryDate, query2);
                                        break;
                                }
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
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByPreservationStateAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndCoinLocationOrderByPreservationStateDesc(queryY, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByPreservationStateAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndCoinLocationOrderByPreservationStateDesc(queryY, query);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByPreservationStateAsc(queryY, query);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndCoinLocationOrderByPreservationStateDesc(queryY, query);
                                        break;
                                }
                            case "AcquisitionDate":
                                switch (time2) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByPreservationStateAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateBeforeAndCoinLocationOrderByPreservationStateDesc(queryDate, query);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByPreservationStateAsc(queryDate, query);
                                        else
                                            coins = coinRepo.findAllByAcquisitionDateAfterAndCoinLocationOrderByPreservationStateDesc(queryDate, query);
                                        break;
                                }
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
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByPreservationStateAsc(querySupplier, query2);
                                else
                                    coins = coinRepo.findAllBySupplierAndPreservationStateOrderByPreservationStateDesc(querySupplier, query2);
                                break;
                            case "CoinYear":
                                switch (time) {
                                    case "Before":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByPreservationStateAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearBeforeAndPreservationStateOrderByPreservationStateDesc(queryY, query2);
                                        break;
                                    case "After":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByPreservationStateAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAfterAndPreservationStateOrderByPreservationStateDesc(queryY, query2);
                                        break;
                                    case "Same":
                                        if (order.equals("Asc"))
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByPreservationStateAsc(queryY, query2);
                                        else
                                            coins = coinRepo.findAllByCoinYearAndPreservationStateOrderByPreservationStateDesc(queryY, query2);
                                        break;
                                }
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

    //Muestra todos los coins que se encuentran en la base de datos
    @RequestMapping("/allCoins")
    public String showAll(Model model) {
        java.util.Date utilDate = new GregorianCalendar(1990, 1, 1).getTime();
        java.sql.Date date= new java.sql.Date(utilDate.getTime());
        model.addAttribute("qqueryD", date);
        model.addAttribute("qqueryY", 1990);
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coins", coinRepo.findAll());
        return "/coinQueries";
    }

}