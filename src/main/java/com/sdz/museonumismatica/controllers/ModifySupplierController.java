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

        supplierRepository.delete(supplier);
        supplierRepository.save(supplier);
        /*Supplier s = supplierRepository.getOne(supplier.getId());
        s.setCif(supplier.getCif());
        s.setEmail(supplier.getEmail());
        s.setName(supplier.getName());
        s.setPhoneNumber(supplier.getPhoneNumber());
        s.setPostalCode(supplier.getPostalCode());*/

        return "supplierModified";
    }
}
