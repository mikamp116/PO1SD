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
        java.util.Date utilDate4 = new GregorianCalendar(2000, 1, 1).getTime();
        java.sql.Date d4= new java.sql.Date(utilDate3.getTime());


        CoinModel dos_euros = new CoinModel(2, "Euro", 26, (float) 10.3, metales, "Una moneda muy bonita");
        CoinModel un_euro = new CoinModel(1, "Euro", 16, (float) 7.4, "Cobre", "Imprescindible en cualquier coleccion");
        CoinModel doblon_esp = new CoinModel(15, "Doblon español", (float) 46.0, (float) 6.77, "Oro", "El modelo mas importante de la coleccion");
        Supplier supplier1 = new Supplier("111111111A", "Proveedor Uno", 22222, "mikamardanyan@gmail.com", 690111111);
        Supplier supplier2 = new Supplier("222222222B", "Proveedor Dos", 22222, "proveedor_dos@gmail.com", 690222222);
        Supplier supplier3 = new Supplier("333333333C", "Proveedor Tres", 33333, "proveedor_tres@gmail.com", 690333333);
        Supplier supplier4 = new Supplier("444444444D", "Proveedor Cuatro", 4444, "proveedor_cuatro@gmail.com", 669444444);
        Supplier calderilla = new Supplier("B0000000A", "Calderilla", 28000, "calderilla@sd.es", 690000000);

        coinModelRepository.save(dos_euros);
        coinModelRepository.save(un_euro);
        supplierRepository.save(supplier1);
        supplierRepository.save(supplier2);
        supplierRepository.save(supplier3);
        supplierRepository.save(supplier4);
        supplierRepository.save(calderilla);
        coinRepository.save(new Coin(dos_euros, 1987, "Madrid", d1, "Bien preservado", calderilla));
        coinRepository.save(new Coin(dos_euros, 1987, "Alcobendas", d2, "Mal preservado", calderilla));
        coinRepository.save(new Coin(un_euro, 2008, "Madrid", d3, "Bien preservado", supplier1));
        coinRepository.save(new Coin(doblon_esp, 1634, "Valladolid", d4, "Bien preservado", calderilla));

    }

}
