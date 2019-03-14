package com.sdz.museonumismatica.controllers;

import java.util.List;

import com.sdz.museonumismatica.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sdz.museonumismatica.Coin;
import com.sdz.museonumismatica.repositories.CoinRepository;

public class CoinController {
	@Autowired
	private CoinRepository coinRepo;
	
	@Autowired
	
	@RequestMapping("/showCoins")
	public String tablon(Model model) {
		model.addAttribute("coins", coinRepo.findAll());
		return "";
	}
	
	@RequestMapping("/newCoin")
	public String insertar(Model model) {
		List<Coin> coinList = coinRepo.findAll();
		model.addAttribute("coins", coinList);
		return"";
	}

    //BY COIN MODEL
    @RequestMapping("/showByCoinModelOrderByYear")
    public String showByCoinModelOrderByYear(@RequestParam CoinModel coinModel, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByYearDesc(coinModel, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByDate")
    public String showByCoinModelOrderByDate(@RequestParam CoinModel coinModel, Date date, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByDateDesc(coinModel, date);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByLocation")
    public String showByCoinModelOrderByLocation(@RequestParam CoinModel coinModel, String location, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByLocationDesc(coinModel, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByCoinModelOrderByState")
    public String showByCoinModelOrderByState(@RequestParam CoinModel coinModel, String state, Model model) {
        List<Coin> coins = coinRepo.findAllByCoinModelOrderByStateDesc(coinModel, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //BY YEAR
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
    @RequestMapping("/showByAcquisitionBetween")
    public String showByAcquisitionBetween(@RequestParam date startAcquisition, date endAcquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionBetween(startAcquisition, endAcquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionBefore")
    public String showByAcquisitionBefore(@RequestParam date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionBefore(acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByAcquisitionAfter")
    public String showByAcquisitionAfter(@RequestParam date acquisition, Model model) {
        List<Coin> coins = coinRepo.findAllByAcquisitionAfter(acquisition);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //BY LOCATION
    @RequestMapping("/showByLocationOrderByYear")
    public String showByLocationOrderByYear(@RequestParam String location, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByLocationOrderByYearDesc(location, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByLocationOrderByDate")
    public String showByLocationOrderByDate(@RequestParam String location, Date date, Model model) {
        List<Coin> coins = coinRepo.findAllByLocationOrderByDateDesc(location, date);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByLocationOrderByState")
    public String showByLocationOrderByState(@RequestParam String location, String state, Model model) {
        List<Coin> coins = coinRepo.findAllByLocationOrderByStateDesc(location, state);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //BY STATE
    @RequestMapping("/showByStateOrderByYear")
    public String showByStateOrderByYear(@RequestParam String state, int year, Model model) {
        List<Coin> coins = coinRepo.findAllByStateOrderByYearDesc(state, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByStateOrderByDate")
    public String showByStateOrderByDate(@RequestParam String state, Date date, Model model) {
        List<Coin> coins = coinRepo.findAllByStateOrderByDateDesc(state, date);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showByStateOrderByLocation")
    public String showByStateOrderByLocation(@RequestParam String state, String location, Model model) {
        List<Coin> coins = coinRepo.findAllByStateOrderByLocationDesc(state, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    //BY SUPPLIER
    @RequestMapping("/showBySupplierOrderByYear")
    public String showBySupplierOrderByYear(@RequestParam Supplier supplier, int year, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByYearDesc(supplier, year);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByDate")
    public String showBySupplierOrderByDate(@RequestParam Supplier supplier, Date date, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByDateDesc(supplier, date);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByLocation")
    public String showBySupplierOrderByLocation(@RequestParam Supplier supplier, String location, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByLocationDesc(supplier, location);
        model.addAttribute("coins", coins);
        return "coinQueries";
    }

    @RequestMapping("/showBySupplierOrderByState")
    public String showBySupplierOrderByState(@RequestParam Supplier supplier, String state, Model model) {
        List<Coin> coins = coinRepo.findAllBySupplierOrderByStateDesc(supplier, state);
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
    public String showByLocationAndState(@RequestParamString location, String state, Model model) {
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
    public String showByStateAndYear(@RequestParam State State, int year, Model model) {
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