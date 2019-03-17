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

    @RequestMapping("/showByCoinModelOrderByYearDesc")
    public String showByCoinModelOrderByYearDesc(@RequestParam CoinModel coinModel, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByYearDesc(coinModel, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByYearAsc")
    public String showByCoinModelOrderByYearAsc(@RequestParam CoinModel coinModel, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByYearAsc(coinModel, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByDateDesc")
    public String showByCoinModelOrderByDateDesc(@RequestParam CoinModel coinModel, Date date, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByDateDesc(coinModel, date);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByDateAsc")
    public String showByCoinModelOrderByDateAsc(@RequestParam CoinModel coinModel, Date date, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByDateAsc(coinModel, date);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByDate")
    public String showByCoinModelOrderByDate(@RequestParam CoinModel coinModel, Date date, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByDateDesc(coinModel, date);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByLocationDesc")
    public String showByCoinModelOrderByLocationDesc(@RequestParam CoinModel coinModel, String location, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByLocationDesc(coinModel, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByLocationAsc")
    public String showByCoinModelOrderByLocationAsc(@RequestParam CoinModel coinModel, String location, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByLocationAsc(coinModel, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByStateDesc")
    public String showByCoinModelOrderByStateDesc(@RequestParam CoinModel coinModel, String state, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByStateDesc(coinModel, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByStateAsc")
    public String showByCoinModelOrderByStateAsc(@RequestParam CoinModel coinModel, String state, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByStateAsc(coinModel, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //BY YEAR
    @RequestMapping("/showByYear")
    public String showByYear(@RequestParam int year, Model model) {
        List<Coin> coins = coinRepo.findAllByYear(year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByYearBetween")
    public String showByYearBetween(@RequestParam int startYear, int endYear, Model model) {
        List<Coin> coins = coinRepo.findAllByYearBetween(startYear, endYear);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByYearBefore")
    public String showByYearBefore(@RequestParam int year, Model model) {
        List<Coin> coins = coinRepo.findAllByYearBefore(year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByYearAfter")
    public String showByYearAfter(@RequestParam int year, Model model) {
        List<Coin> coins = coinRepo.findAllByYearAfter(year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //BY ACQUISITION DATE
    @RequestMapping("/showByAcquisition")
    public String showByAcquisition(@RequestParam Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisition(acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionBetween")
    public String showByAcquisitionBetween(@RequestParam Date startAcquisition, Date endAcquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionBetween(startAcquisition, endAcquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionBefore")
    public String showByAcquisitionBefore(@RequestParam Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionBefore(acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionAfter")
    public String showByAcquisitionAfter(@RequestParam Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionAfter(acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //BY LOCATION
    @RequestMapping("/showByLocation")
    public String showByLocation(@RequestParam String location, Model model) {
        List<Coin> coins = coinRepo.findAllByLocation(location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByLocationOrderByYearDesc")
    public String showByLocationOrderByYearDesc(@RequestParam String location, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByLocationOrderByYearDesc(location, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByLocationOrderByYearAsc")
    public String showByLocationOrderByYearAsc(@RequestParam String location, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByLocationOrderByYearAsc(location, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByLocationOrderByDateDesc")
    public String showByLocationOrderByDateDesc(@RequestParam String location, Date date, Model model) {
        List<Coin> coins = coinRepo.findAllByLocationOrderByDateDesc(location, date);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByLocationOrderByDateAsc")
    public String showByLocationOrderByDateAsc(@RequestParam String location, Date date, Model model) {
        List<Coin> coins = coinRepo.findAllByLocationOrderByDateAsc(location, date);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByLocationOrderByStateDesc")
    public String showByLocationOrderByStateDesc(@RequestParam String location, String state, Model model) {
        List<Coin> coins = coinRepo.findAllByLocationOrderByStateDesc(location, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByLocationOrderByStateAsc")
    public String showByLocationOrderByStateAsc(@RequestParam String location, String state, Model model) {
        List<Coin> coins = coinRepo.findAllByLocationOrderByStateAsc(location, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //BY STATE
    @RequestMapping("/showByState")
    public String showByState(@RequestParam String state, Model model) {
        List<Coin> coins = coinRepo.findAllByState(state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByStateOrderByYearDesc")
    public String showByStateOrderByYearDesc(@RequestParam String state, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByStateOrderByYearDesc(state, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByStateOrderByYearAsc")
    public String showByStateOrderByYearAsc(@RequestParam String state, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByStateOrderByYearAsc(state, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByStateOrderByDateDesc")
    public String showByStateOrderByDateDesc(@RequestParam String state, Date date, Model model) {
        List<Coin> coins = coinRepo.findAllByStateOrderByDateDesc(state, date);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByStateOrderByDateAsc")
    public String showByStateOrderByDateAsc(@RequestParam String state, Date date, Model model) {
        List<Coin> coins = coinRepo.findAllByStateOrderByDateAsc(state, date);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByStateOrderByLocationDesc")
    public String showByStateOrderByLocationDesc(@RequestParam String state, String location, Model model) {
        List<Coin> coins = coinRepo.findAllByStateOrderByLocationDesc(state, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByStateOrderByLocationAsc")
    public String showByStateOrderByLocationAsc(@RequestParam String state, String location, Model model) {
        List<Coin> coins = coinRepo.findAllByStateOrderByLocationAsc(state, location);
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

    @RequestMapping("/showBySupplierOrderByYearDesc")
    public String showBySupplierOrderByYearDesc(@RequestParam Supplier supplier, int year, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByYearDesc(supplier, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByYearAsc")
    public String showBySupplierOrderByYearAsc(@RequestParam Supplier supplier, int year, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByYearAsc(supplier, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByDateDesc")
    public String showBySupplierOrderByDateDesc(@RequestParam Supplier supplier, Date date, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByDateDesc(supplier, date);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByDateAsc")
    public String showBySupplierOrderByDateAsc(@RequestParam Supplier supplier, Date date, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByDateAsc(supplier, date);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByLocationDesc")
    public String showBySupplierOrderByLocationDesc(@RequestParam Supplier supplier, String location, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByLocationDesc(supplier, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByLocationAsc")
    public String showBySupplierOrderByLocationAsc(@RequestParam Supplier supplier, String location, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByLocationAsc(supplier, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByStateDesc")
    public String showBySupplierOrderByStateDesc(@RequestParam Supplier supplier, String state, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByStateDesc(supplier, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByStateAsc")
    public String showBySupplierOrderByStateAsc(@RequestParam Supplier supplier, String state, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByStateAsc(supplier, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //COINMODEL AND
    @RequestMapping("/showByCoinModelAndYear")
    public String showByCoinModelAndYear(@RequestParam CoinModel coinModel, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelAndYear(coinModel, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelAndAcquisition")
    public String showByCoinModelAndAcquisition(@RequestParam CoinModel coinModel,Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelAndAcquisition(coinModel, acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelAndLocation")
    public String showByCoinModelAndLocation(@RequestParam CoinModel coinModel,String location, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelAndLocation(coinModel, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelAndState")
    public String showByCoinModelAndState(@RequestParam CoinModel coinModel, String state, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelAndState(coinModel, state);
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
    @RequestMapping("/showByYearAndAcquisition")
    public String showByYearAndAcquisition(@RequestParam int year,Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByYearAndAcquisition(year, acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByYearAndLocation")
    public String showByYearAndLocation(@RequestParam  int year, String location, Model model) {
        List<Coin> coins = coinRepo.findAllByYearAndLocation(year, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByYearAndState")
    public String showByYearAndState(@RequestParam  int year, String state, Model model) {
        List<Coin> coins = coinRepo.findAllByYearAndState(year, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByYearAndSupplier")
    public String showByYearAndSupplier(@RequestParam  int year, Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllByYearAndSupplier(year, supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //ACQUISITION AND
    @RequestMapping("/showByAcquisitionAndYear")
    public String showByAcquisitionAndYear(@RequestParam Date acquisition, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionAndYear(acquisition, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionAndLocation")
    public String showByAcquisitionAndLocation(@RequestParam Date acquisition,String location, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionAndLocation(acquisition, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionAndState")
    public String showByAcquisitionAndState(@RequestParam  Date acquisition,String state, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionAndState(acquisition, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionAndSupplier")
    public String showByAcquisitionAndSupplier(@RequestParam  Date acquisition, Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionAndSupplier(acquisition, supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //LOCATION AND
    @RequestMapping("/showByLocationAndYear")
    public String showByLocationAndYear(@RequestParam String location, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByLocationAndYear(location, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByLocationAndAcquisition")
    public String showByLocationAndAcquisition(@RequestParam String location, Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByLocationAndAcquisition(location, acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByLocationAndState")
    public String showByLocationAndState(@RequestParam String location, String state, Model model) {
        List<Coin> coins = coinRepo.findAllByLocationAndState(location, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByLocationAndSupplier")
    public String showByLocationAndSupplier(@RequestParam String location, Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllByLocationAndSupplier(location, supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //STATE AND
    @RequestMapping("/showByStateAndYear")
    public String showByStateAndYear(@RequestParam String state, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByStateAndYear(state, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByStateAndAcquisition")
    public String showByStateAndAcquisition(@RequestParam String state,Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByStateAndAcquisition(state, acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByStateAndLocation")
    public String showByStateAndLocation(@RequestParam String state,String location, Model model) {
        List<Coin> coins = coinRepo.findAllByStateAndLocation(state, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByStateAndSupplier")
    public String showByStateAndSupplier(@RequestParam String state, Supplier supplier, Model model) {
        List<Coin> coins = coinRepo.findAllByStateAndSupplier(state, supplier);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //SUPPLIER AND
    @RequestMapping("/showBySupplierAndYear")
    public String showBySupplierAndYear(@RequestParam Supplier supplier, int year, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierAndYear(supplier, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierAndAcquisition")
    public String showBySupplierAndAcquisition(@RequestParam Supplier supplier, Date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierAndAcquisition(supplier, acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierAndLocation")
    public String showBySupplierAndLocation(@RequestParam Supplier supplier, String location, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierAndLocation(supplier, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierAndState")
    public String showBySupplierAndState(@RequestParam Supplier supplier,String state, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierAndState(supplier, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }
}