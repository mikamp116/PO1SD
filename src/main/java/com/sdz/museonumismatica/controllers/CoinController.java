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
    public String showByStateOrderByLocation(@RequestParam State state, String location, Model model) {

        List<Coin> coins = coinRepo.findAllByStateOrderByLocationDesc(state, location);

        model.addAttribute("coins", coins);

        return "coinQueries";
    }

}