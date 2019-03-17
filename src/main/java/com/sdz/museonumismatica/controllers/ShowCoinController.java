package com.sdz.museonumismatica.controllers;

import java.sql.Date;
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

    @Autowired

    @RequestMapping("/showCoins")
    public String tablon(Model model) {
        model.addAttribute("coins", coinRepo.findAll());
        return "";
    }

    //BY COIN MODEL
    @RequestMapping("/showByCoinModel")
    public String showByCoinModel(@RequestParam CoinModel coinModel, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModel(coinModel);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByCoinYearDesc")
    public String showByCoinModelOrderByCoinYearDesc(@RequestParam CoinModel coinModel, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByCoinYearDesc(coinModel);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByCoinYearAsc")
    public String showByCoinModelOrderByCoinYearAsc(@RequestParam CoinModel coinModel, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByCoinYearAsc(coinModel);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByAcquisitionDateStatnDesc")
    public String showByCoinModelOrderByAcquisitionDateDesc(@RequestParam CoinModel coinModel, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByAcquisitionDateDesc(coinModel);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByAcquisitionDateAsc")
    public String showByCoinModelOrderByAcquisitionDateAsc(@RequestParam CoinModel coinModel, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByAcquisitionDateAsc(coinModel);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByAcquisitionDate")
    public String showByCoinModelOrderByAcquisitionDate(@RequestParam CoinModel coinModel, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByAcquisitionDateDesc(coinModel);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByCoinLocationDesc")
    public String showByCoinModelOrderByCoinLocationDesc(@RequestParam CoinModel coinModel, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByCoinLocationDesc(coinModel);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByCoinLocationAsc")
    public String showByCoinModelOrderByCoinLocationAsc(@RequestParam CoinModel coinModel, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByCoinLocationAsc(coinModel);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByPreservationStateDesc")
    public String showByCoinModelOrderByPreservationStateDesc(@RequestParam CoinModel coinModel, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByPreservationStateDesc(coinModel);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByPreservationStateAsc")
    public String showByCoinModelOrderByPreservationStateAsc(@RequestParam CoinModel coinModel, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByPreservationStateAsc(coinModel);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //BY YEAR
    @RequestMapping("/showByCoinYear")
    public String showByCoinYear(@RequestParam int year, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinYear(year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinYearBetween")
    public String showByCoinYearBetween(@RequestParam int startCoinYear, int endCoinYear, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinYearBetween(startCoinYear, endCoinYear);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinYearBefore")
    public String showByCoinYearBefore(@RequestParam int year, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinYearBefore(year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinYearAfter")
    public String showByCoinYearAfter(@RequestParam int year, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinYearAfter(year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //BY ACQUISITION DATE
    @RequestMapping("/showByAcquisitionDate")
    public String showByAcquisitionDate(@RequestParam Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionDate(acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionDateBetween")
    public String showByAcquisitionDateBetween(@RequestParam Date startAcquisition, Date endAcquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionDateBetween(startAcquisition, endAcquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionDateBefore")
    public String showByAcquisitionDateBefore(@RequestParam Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionDateBefore(acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionDateAfter")
    public String showByAcquisitionDateAfter(@RequestParam Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionDateAfter(acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //BY LOCATION
    @RequestMapping("/showByCoinLocation")
    public String showByCoinLocation(@RequestParam String location, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinLocation(location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinLocationOrderByCoinYearDesc")
    public String showByCoinLocationOrderByCoinYearDesc(@RequestParam String location, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinLocationOrderByCoinYearDesc(location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinLocationOrderByCoinYearAsc")
    public String showByCoinLocationOrderByCoinYearAsc(@RequestParam String location, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinLocationOrderByCoinYearAsc(location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinLocationOrderByAcquisitionDateDesc")
    public String showByCoinLocationOrderByAcquisitionDateDesc(@RequestParam String location, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinLocationOrderByAcquisitionDateDesc(location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinLocationOrderByAcquisitionDateAsc")
    public String showByCoinLocationOrderByAcquisitionDateAsc(@RequestParam String location, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinLocationOrderByAcquisitionDateAsc(location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinLocationOrderByPreservationStateDesc")
    public String showByCoinLocationOrderByPreservationStateDesc(@RequestParam String location, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinLocationOrderByPreservationStateDesc(location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinLocationOrderByPreservationStateAsc")
    public String showByCoinLocationOrderByPreservationStateAsc(@RequestParam String location, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinLocationOrderByPreservationStateAsc(location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //BY STATE
    @RequestMapping("/showByPreservationState")
    public String showByPreservationState(@RequestParam String state, Model model) {
        List<Coin> coins = coinRepo.findAllByPreservationState(state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByPreservationStateOrderByCoinYearDesc")
    public String showByPreservationStateOrderByCoinYearDesc(@RequestParam String state, Model model) {
        List<Coin> coins = coinRepo.findAllByPreservationStateOrderByCoinYearDesc(state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByPreservationStateOrderByCoinYearAsc")
    public String showByPreservationStateOrderByCoinYearAsc(@RequestParam String state, Model model) {
        List<Coin> coins = coinRepo.findAllByPreservationStateOrderByCoinYearAsc(state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByPreservationStateOrderByAcquisitionDateDesc")
    public String showByPreservationStateOrderByAcquisitionDateDesc(@RequestParam String state, Model model) {
        List<Coin> coins = coinRepo.findAllByPreservationStateOrderByAcquisitionDateDesc(state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByPreservationStateOrderByAcquisitionDateAsc")
    public String showByPreservationStateOrderByAcquisitionDateAsc(@RequestParam String state, Model model) {
        List<Coin> coins = coinRepo.findAllByPreservationStateOrderByAcquisitionDateAsc(state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByPreservationStateOrderByCoinLocationDesc")
    public String showByPreservationStateOrderByCoinLocationDesc(@RequestParam String state, Model model) {
        List<Coin> coins = coinRepo.findAllByPreservationStateOrderByCoinLocationDesc(state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByPreservationStateOrderByCoinLocationAsc")
    public String showByPreservationStateOrderByCoinLocationAsc(@RequestParam String state, Model model) {
        List<Coin> coins = coinRepo.findAllByPreservationStateOrderByCoinLocationAsc(state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //BY SUPPLIER
    @RequestMapping("/showBySupplier")
    public String showBySupplier(@RequestParam Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplier(supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByCoinYearDesc")
    public String showBySupplierOrderByCoinYearDesc(@RequestParam Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByCoinYearDesc(supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByCoinYearAsc")
    public String showBySupplierOrderByCoinYearAsc(@RequestParam Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByCoinYearAsc(supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByAcquisitionDateDesc")
    public String showBySupplierOrderByAcquisitionDateDesc(@RequestParam Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByAcquisitionDateDesc(supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByAcquisitionDateAsc")
    public String showBySupplierOrderByAcquisitionDateAsc(@RequestParam Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByAcquisitionDateAsc(supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByCoinLocationDesc")
    public String showBySupplierOrderByCoinLocationDesc(@RequestParam Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByCoinLocationDesc(supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByCoinLocationAsc")
    public String showBySupplierOrderByCoinLocationAsc(@RequestParam Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByCoinLocationAsc(supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByPreservationStateDesc")
    public String showBySupplierOrderByPreservationStateDesc(@RequestParam Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByPreservationStateDesc(supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByPreservationStateAsc")
    public String showBySupplierOrderByPreservationStateAsc(@RequestParam Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByPreservationStateAsc(supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //COINMODEL AND
    @RequestMapping("/showByCoinModelAndCoinYear")
    public String showByCoinModelAndCoinYear(@RequestParam CoinModel coinModel, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelAndCoinYear(coinModel, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelAndAcquisitionDate")
    public String showByCoinModelAndAcquisitionDate(@RequestParam CoinModel coinModel,Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelAndAcquisitionDate(coinModel, acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelAndCoinLocation")
    public String showByCoinModelAndCoinLocation(@RequestParam CoinModel coinModel,String location, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelAndCoinLocation(coinModel, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelAndPreservationState")
    public String showByCoinModelAndPreservationState(@RequestParam CoinModel coinModel, String state, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelAndPreservationState(coinModel, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelAndSupplier")
    public String showByCoinModelAndSupplier(@RequestParam CoinModel coinModel, Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelAndSupplier(coinModel, supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //YEAR AND
    @RequestMapping("/showByCoinYearAndAcquisitionDate")
    public String showByCoinYearAndAcquisitionDate(@RequestParam int year,Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinYearAndAcquisitionDate(year, acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinYearAndCoinLocation")
    public String showByCoinYearAndCoinLocation(@RequestParam  int year, String location, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinYearAndCoinLocation(year, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinYearAndPreservationState")
    public String showByCoinYearAndPreservationState(@RequestParam  int year, String state, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinYearAndPreservationState(year, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinYearAndSupplier")
    public String showByCoinYearAndSupplier(@RequestParam  int year, Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinYearAndSupplier(year, supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //ACQUISITION AND
    @RequestMapping("/showByAcquisitionDateAndCoinYear")
    public String showByAcquisitionDateAndCoinYear(@RequestParam Date acquisition, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionDateAndCoinYear(acquisition, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionDateAndCoinLocation")
    public String showByAcquisitionDateAndCoinLocation(@RequestParam Date acquisition,String location, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionDateAndCoinLocation(acquisition, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionDateAndPreservationState")
    public String showByAcquisitionDateAndPreservationState(@RequestParam  Date acquisition,String state, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionDateAndPreservationState(acquisition, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionDateAndSupplier")
    public String showByAcquisitionDateAndSupplier(@RequestParam  Date acquisition, Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionDateAndSupplier(acquisition, supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //LOCATION AND
    @RequestMapping("/showByCoinLocationAndCoinYear")
    public String showByCoinLocationAndCoinYear(@RequestParam String location, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinLocationAndCoinYear(location, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinLocationAndAcquisitionDate")
    public String showByCoinLocationAndAcquisitionDate(@RequestParam String location, Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinLocationAndAcquisitionDate(location, acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinLocationAndPreservationState")
    public String showByCoinLocationAndPreservationState(@RequestParam String location, String state, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinLocationAndPreservationState(location, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinLocationAndSupplier")
    public String showByCoinLocationAndSupplier(@RequestParam String location, Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinLocationAndSupplier(location, supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //STATE AND
    @RequestMapping("/showByPreservationStateAndCoinYear")
    public String showByPreservationStateAndCoinYear(@RequestParam String state, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByPreservationStateAndCoinYear(state, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByPreservationStateAndAcquisitionDate")
    public String showByPreservationStateAndAcquisitionDate(@RequestParam String state,Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByPreservationStateAndAcquisitionDate(state, acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByPreservationStateAndCoinLocation")
    public String showByPreservationStateAndCoinLocation(@RequestParam String state,String location, Model model) {
        List<Coin> coins = coinRepo.findAllByPreservationStateAndCoinLocation(state, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByPreservationStateAndSupplier")
    public String showByPreservationStateAndSupplier(@RequestParam String state, Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllByPreservationStateAndSupplier(state, supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //SUPPLIER AND
    @RequestMapping("/showBySupplierAndCoinYear")
    public String showBySupplierAndCoinYear(@RequestParam Supplier supplier, int year, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierAndCoinYear(supplier, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierAndAcquisitionDate")
    public String showBySupplierAndAcquisitionDate(@RequestParam Supplier supplier, Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierAndAcquisitionDate(supplier, acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierAndCoinLocation")
    public String showBySupplierAndCoinLocation(@RequestParam Supplier supplier, String location, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierAndCoinLocation(supplier, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierAndPreservationState")
    public String showBySupplierAndPreservationState(@RequestParam Supplier supplier,String state, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierAndPreservationState(supplier, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }
}