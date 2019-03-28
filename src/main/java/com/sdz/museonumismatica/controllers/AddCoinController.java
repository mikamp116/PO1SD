package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.Coin;
import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.Supplier;
import com.sdz.museonumismatica.repositories.CoinModelRepository;
import com.sdz.museonumismatica.repositories.CoinRepository;
import com.sdz.museonumismatica.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class AddCoinController {
    @Autowired
    private CoinRepository coinRepository;
    @Autowired
    private CoinModelRepository coinModelRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    @RequestMapping("/ejemplarAnnadido")
    public String addCoin(@RequestParam(value = "coinModel") CoinModel coinModel,
                          @RequestParam(value = "coinYear") int cYear,
                          @RequestParam(value = "acquisitionDate") Date acqDate,
                          @RequestParam(value = "coinLocation") String cLocation,
                          @RequestParam(value = "preservationState") String preState,
                          @RequestParam(value = "supplier") Supplier sup, Model model) {
        Coin coin = new Coin(coinModel, cYear, cLocation, acqDate, preState, sup);
        coinRepository.save(coin);
        model.addAttribute("coin", coin);
        return "coinAdded";
    }

    @RequestMapping("/modificarEjemplar")
    public String modifyC(@RequestParam Long id, Model model) {
        Coin coin = coinRepository.getOne(id);
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coin", coin);
        return "showCoin";
    }

    @RequestMapping("/ejemplarModificado")
    public String modifySupplier(Coin coin, Model model) {
        model.addAttribute("coin", coin);
        coinRepository.save(coin);
        return "coinModified";
    }
}
