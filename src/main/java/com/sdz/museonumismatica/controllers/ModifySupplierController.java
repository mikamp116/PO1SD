package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.Supplier;
import com.sdz.museonumismatica.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModifySupplierController {
    @Autowired
    private SupplierRepository supplierRepository;

    @RequestMapping("/modifySupplier")
    public String modifySupplier(Supplier supplier, Model model) {
        Supplier s_ref = supplierRepository.getOne(supplier.getId());
        Supplier supplier_before = new Supplier(s_ref.getCif(), s_ref.getName(), s_ref.getPostalCode(), s_ref.getEmail(), s_ref.getPhoneNumber());
        model.addAttribute("supplier_b", supplier_before);
        supplierRepository.save(supplier);
        model.addAttribute("supplier", supplier);
        return "supplierModified";
    }

    @RequestMapping("/backFromModifySupplierToSupplierQuery")
    public String back(Model model) {
        model.addAttribute("suppliers", supplierRepository.findAll());
        return "supplierQueries";
    }
}
