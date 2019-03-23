package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.Coin;
import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.Supplier;
import com.sdz.museonumismatica.repositories.CoinModelRepository;
import com.sdz.museonumismatica.repositories.CoinRepository;
import com.sdz.museonumismatica.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.TreeSet;

@Controller
public class Index {
    @Autowired
    private CoinModelRepository coinModelRepository;
    @Autowired
    private CoinRepository coinRepository;
    @Autowired
    private SupplierRepository supplierRepository;


    @PostConstruct
    public void init() {
        TreeSet<String> metales = new TreeSet<>();
        metales.add("Acero");
        metales.add("Cobre");
        CoinModel dos_euros = new CoinModel(2, "Euro", 26, (float) 10.3, metales, "Una moneda muy bonita");
        CoinModel un_euro = new CoinModel(1, "Euro", 16, (float) 7.4, "Cobre", "Random description");
        Supplier mika = new Supplier("123456789A", "Mikayel Mardanyan", 28933, "mikamardanyan@gmail.com", 69696969);
        coinModelRepository.save(dos_euros);
        coinModelRepository.save(un_euro);
        supplierRepository.save(mika);
        coinRepository.save(new Coin(dos_euros, 2019, "Madrid", new Date(2018, 10, 21), "Bien preservado", mika));

    }

}
