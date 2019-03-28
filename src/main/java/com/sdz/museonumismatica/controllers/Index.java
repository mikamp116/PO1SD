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
import java.util.GregorianCalendar;
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
        java.util.Date utilDate = new GregorianCalendar(1997, 3, 15).getTime();
        java.sql.Date d1= new java.sql.Date(utilDate.getTime());
        java.util.Date utilDate2 = new GregorianCalendar(2019, 9, 25).getTime();
        java.sql.Date d2= new java.sql.Date(utilDate2.getTime());
        java.util.Date utilDate3 = new GregorianCalendar(2010, 10, 19).getTime();
        java.sql.Date d3= new java.sql.Date(utilDate3.getTime());


        CoinModel dos_euros = new CoinModel(2, "Euro", 26, (float) 10.3, metales, "Una moneda muy bonita");
        CoinModel un_euro = new CoinModel(1, "Euro", 16, (float) 7.4, "Cobre", "Random description");
        Supplier mika = new Supplier("123456789A", "Mikayel Mardanyan", 28933, "mikamardanyan@gmail.com", 69696969);
        coinModelRepository.save(dos_euros);
        coinModelRepository.save(un_euro);
        supplierRepository.save(mika);
        coinRepository.save(new Coin(dos_euros, 1987, "Madrid", d1, "Bien preservado", mika));
        coinRepository.save(new Coin(dos_euros, 1987, "Alcobendas", d2, "Mal preservado", mika));
        coinRepository.save(new Coin(un_euro, 2008, "Madrid", d3, "Bien preservado", mika));

    }

}
