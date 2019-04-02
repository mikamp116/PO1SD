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

/**
 * @author Jorge Chavero Morcillo
 *
 * Implementacion de añadir ejemplares
 */
@Controller
public class AddCoinController {
    @Autowired
    private CoinRepository coinRepository;
    @Autowired
    private CoinModelRepository coinModelRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    //Añadir ejemplares
    @RequestMapping("/coinAdded")
    public String addCoin(@RequestParam(value = "coinModel") long coinModelID,
                          @RequestParam(value = "coinYear") int cYear,
                          @RequestParam(value = "acquisitionDate") Date acqDate,
                          @RequestParam(value = "coinLocation") String cLocation,
                          @RequestParam(value = "preservationState") String preState,
                          @RequestParam(value = "supplier") long supID, Model model) {
        //Buscamos en los repositorios un supplier y coinModel con esas ID y los sacamos para añadirlos
        CoinModel coinModel = coinModelRepository.getOne(coinModelID);
        Supplier sup = supplierRepository.getOne(supID);
        //Creamos un nuevo coin con las variables pasadas
        Coin coin = new Coin(coinModel, cYear, cLocation, acqDate, preState, sup);
        //Guardamos coin en el repositorio y lo añadimos al model que pasaremos a la pagina
        coinRepository.save(coin);
        model.addAttribute("coin", coin);
        return "coinAdded";
    }

    //Modificar ejemplares
    @RequestMapping("/coinModify")
    public String modifyC(@RequestParam Long id, Model model) {
        //Obtenemos la moneda a mostrar junto a los proveedores y modelos para añadirlos al model y pasarlo a la página
        Coin coin = coinRepository.getOne(id);
        model.addAttribute("coinModels", coinModelRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("coin", coin);
        return "showCoin";
    }

    //ejemplar modificado
    @RequestMapping("/coinModified")
    public String modifySupplier(Coin coin, Model model) {
        Coin newCoin = coinRepository.getOne(coin.getId());
        Coin oldCoin = new Coin(newCoin.getCoinModel(), newCoin.getCoinYear(), newCoin.getCoinLocation(),
                newCoin.getAcquisitionDate(),newCoin.getPreservationState(),newCoin.getSupplier());
        model.addAttribute("coin_b", oldCoin);
        model.addAttribute("coin", coin);
        coinRepository.save(newCoin);
        return "coinModified";
    }
}
