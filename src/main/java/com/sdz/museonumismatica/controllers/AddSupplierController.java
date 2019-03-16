package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.Supplier;
import com.sdz.museonumismatica.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddSupplierController {
    @Autowired
    private SupplierRepository supplierRepository;

    @RequestMapping("/supplierAdded")
    public String addSupplier(Supplier supplier, Model model) {

        supplierRepository.save(supplier);

        return "supplierAdded";
    }
}
