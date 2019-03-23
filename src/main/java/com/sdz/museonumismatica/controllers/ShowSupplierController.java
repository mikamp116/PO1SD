package com.sdz.museonumismatica.controllers;

import com.sdz.museonumismatica.Supplier;
import com.sdz.museonumismatica.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikayel Mardanyan Petrosyan
 */
@Controller
public class ShowSupplierController {
    @Autowired
    private SupplierRepository supplierRepository;

    @RequestMapping("/supplierQuery")
    public String queries(@RequestParam(value="searchBy") String searchBy,
                          @RequestParam(value="orderBy") String orderBy,
                          @RequestParam(value="order") String order,
                          @RequestParam(value="query") String query,
                          Model model) {

        List<Supplier> suppliers = new ArrayList<>();

        switch (searchBy){
            case "CIF":
                if (orderBy.equals("CIF"))
                    suppliers = supplierRepository.findByCif(query);
                else
                    switch (orderBy) {
                        case "Name":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByCifOrderByNameAsc(query);
                            else
                                suppliers = supplierRepository.findByCifOrderByNameDesc(query);
                            break;
                        case "Postalcode":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByCifOrderByPostalCodeAsc(query);
                            else
                                suppliers = supplierRepository.findByCifOrderByPostalCodeDesc(query);
                            break;
                        case "Email":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByCifOrderByEmailAsc(query);
                            else
                                suppliers = supplierRepository.findByCifOrderByEmailDesc(query);
                            break;
                        case "Phonenumber":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByCifOrderByPhoneNumberAsc(query);
                            else
                                suppliers = supplierRepository.findByCifOrderByPhoneNumberDesc(query);
                            break;
                    }
                break;
            case "Name":
                if (orderBy.equals("Name"))
                    suppliers = supplierRepository.findByName(query);
                else
                    switch (orderBy) {
                        case "CIF":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByNameOrderByCifAsc(query);
                            else
                                suppliers = supplierRepository.findByNameOrderByCifDesc(query);
                            break;
                        case "Postalcode":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByNameOrderByPostalCodeAsc(query);
                            else
                                suppliers = supplierRepository.findByNameOrderByPostalCodeDesc(query);
                            break;
                        case "Email":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByNameOrderByEmailAsc(query);
                            else
                                suppliers = supplierRepository.findByNameOrderByEmailDesc(query);
                            break;
                        case "Phonenumber":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByNameOrderByPhoneNumberAsc(query);
                            else
                                suppliers = supplierRepository.findByNameOrderByPhoneNumberDesc(query);
                            break;
                    }
                break;
            case "Postalcode":
                if (orderBy.equals("Postalcode"))
                    suppliers = supplierRepository.findByPostalCode(Integer.parseInt(query));
                else
                    switch (orderBy) {
                        case "CIF":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByPostalCodeOrderByCifAsc(Integer.parseInt(query));
                            else
                                suppliers = supplierRepository.findByPostalCodeOrderByCifDesc(Integer.parseInt(query));
                            break;
                        case "Name":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByPostalCodeOrderByNameAsc(Integer.parseInt(query));
                            else
                                suppliers = supplierRepository.findByPostalCodeOrderByNameDesc(Integer.parseInt(query));
                            break;
                        case "Email":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByPostalCodeOrderByEmailAsc(Integer.parseInt(query));
                            else
                                suppliers = supplierRepository.findByPostalCodeOrderByEmailDesc(Integer.parseInt(query));
                            break;
                        case "Phonenumber":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByPostalCodeOrderByPhoneNumberAsc(Integer.parseInt(query));
                            else
                                suppliers = supplierRepository.findByPostalCodeOrderByPhoneNumberDesc(Integer.parseInt(query));
                            break;
                    }
                break;
            case "Email":
                if (orderBy.equals("Email"))
                    suppliers = supplierRepository.findByEmail(query);
                else
                    switch (orderBy) {
                        case "CIF":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByEmailOrderByCifAsc(query);
                            else
                                suppliers = supplierRepository.findByEmailOrderByCifDesc(query);
                            break;
                        case "Name":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByEmailOrderByNameAsc(query);
                            else 
                                suppliers = supplierRepository.findByEmailOrderByNameDesc(query);
                            break;
                        case "Postalcode":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByEmailOrderByPostalCodeAsc(query);
                            else
                                suppliers = supplierRepository.findByEmailOrderByPostalCodeDesc(query);
                            break;
                        case "Phonenumber":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByEmailOrderByPhoneNumberAsc(query);
                            else
                                suppliers = supplierRepository.findByEmailOrderByPhoneNumberDesc(query);
                            break;
                    }
                break;
            case "Phonenumber":
                if (orderBy.equals("Phonenumber"))
                    suppliers = supplierRepository.findByPhoneNumber(Integer.parseInt(query));
                else
                    switch (orderBy) {
                        case "CIF":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByPhoneNumberOrderByCifAsc(Integer.parseInt(query));
                            else
                                suppliers = supplierRepository.findByPhoneNumberOrderByCifDesc(Integer.parseInt(query));
                            break;
                        case "Name":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByPhoneNumberOrderByNameAsc(Integer.parseInt(query));
                            else
                                suppliers = supplierRepository.findByPhoneNumberOrderByNameDesc(Integer.parseInt(query));
                            break;
                        case "Email":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByPhoneNumberOrderByEmailAsc(Integer.parseInt(query));
                            else
                                suppliers = supplierRepository.findByPhoneNumberOrderByEmailDesc(Integer.parseInt(query));
                            break;
                        case "Postalcode":
                            if (order.equals("Asc"))
                                suppliers = supplierRepository.findByPhoneNumberOrderByPostalCodeAsc(Integer.parseInt(query));
                            else
                                suppliers = supplierRepository.findByPhoneNumberOrderByPostalCodeDesc(Integer.parseInt(query));
                            break;
                    }
                break;
        }
        
        model.addAttribute("suppliers", suppliers);

        return "/supplierQueries";
    }

    @RequestMapping("/modify")
    public String modify(@RequestParam String cif, Model model) {
        List<Supplier> suppliers = supplierRepository.findByCif(cif);
        Supplier supplier;
        if (!suppliers.isEmpty()) {
            supplier = suppliers.get(0);
        } else {
            supplier = new Supplier();
        }
        model.addAttribute("supplier", supplier);
        supplierRepository.delete(supplier);

        return "showSupplier";
    }
}
