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
    public String queries(@RequestParam(value="orderBy") String orderBy,
                          @RequestParam(value="order") String order,
                          @RequestParam(value="cif") String cif,
                          @RequestParam(value="name") String name,
                          @RequestParam(value="postalCodeA") Integer postalCodeA,
                          @RequestParam(value="postalCodeB") Integer postalCodeB,
                          @RequestParam(value="email") String email,
                          @RequestParam(value="phoneNumber") Integer phoneNumber,
                          Model model) {

        List<Supplier> suppliers = new ArrayList<>();

        if (!cif.isEmpty()) {
            if (name.isEmpty() && postalCodeA == null && postalCodeB == null && email.isEmpty() && phoneNumber == null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifOrderByCifAsc(cif);
                        else
                            suppliers = supplierRepository.findByCifOrderByCifDesc(cif);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifOrderByNameAsc(cif);
                        else
                            suppliers = supplierRepository.findByCifOrderByNameDesc(cif);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifOrderByPostalCodeAsc(cif);
                        else
                            suppliers = supplierRepository.findByCifOrderByPostalCodeDesc(cif);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifOrderByEmailAsc(cif);
                        else
                            suppliers = supplierRepository.findByCifOrderByEmailDesc(cif);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifOrderByPhoneNumberAsc(cif);
                        else
                            suppliers = supplierRepository.findByCifOrderByPhoneNumberDesc(cif);
                        break;
                }
            else if (!name.isEmpty())
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndNameContainingOrderByCifAsc(cif, name);
                        else
                            suppliers = supplierRepository.findByCifAndNameContainingOrderByCifDesc(cif, name);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndNameContainingOrderByNameAsc(cif, name);
                        else
                            suppliers = supplierRepository.findByCifAndNameContainingOrderByNameDesc(cif, name);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndNameContainingOrderByPostalCodeAsc(cif, name);
                        else
                            suppliers = supplierRepository.findByCifAndNameContainingOrderByPostalCodeDesc(cif, name);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndNameContainingOrderByEmailAsc(cif, name);
                        else
                            suppliers = supplierRepository.findByCifAndNameContainingOrderByEmailDesc(cif, name);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndNameContainingOrderByPhoneNumberAsc(cif, name);
                        else
                            suppliers = supplierRepository.findByCifAndNameContainingOrderByPhoneNumberDesc(cif, name);
                        break;
                }
            else if (!email.isEmpty())
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndEmailOrderByCifAsc(cif, email);
                        else
                            suppliers = supplierRepository.findByCifAndEmailOrderByCifDesc(cif, email);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndEmailOrderByNameAsc(cif, email);
                        else
                            suppliers = supplierRepository.findByCifAndEmailOrderByNameDesc(cif, email);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndEmailOrderByPostalCodeAsc(cif, email);
                        else
                            suppliers = supplierRepository.findByCifAndEmailOrderByPostalCodeDesc(cif, email);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndEmailOrderByEmailAsc(cif, email);
                        else
                            suppliers = supplierRepository.findByCifAndEmailOrderByEmailDesc(cif, email);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndEmailOrderByPhoneNumberAsc(cif, email);
                        else
                            suppliers = supplierRepository.findByCifAndEmailOrderByPhoneNumberDesc(cif, email);
                        break;
                }
            else if (phoneNumber != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPhoneNumberOrderByCifAsc(cif, phoneNumber);
                        else
                            suppliers = supplierRepository.findByCifAndPhoneNumberOrderByCifDesc(cif, phoneNumber);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPhoneNumberOrderByNameAsc(cif, phoneNumber);
                        else
                            suppliers = supplierRepository.findByCifAndPhoneNumberOrderByNameDesc(cif, phoneNumber);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPhoneNumberOrderByPostalCodeAsc(cif, phoneNumber);
                        else
                            suppliers = supplierRepository.findByCifAndPhoneNumberOrderByPostalCodeDesc(cif, phoneNumber);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPhoneNumberOrderByEmailAsc(cif, phoneNumber);
                        else
                            suppliers = supplierRepository.findByCifAndPhoneNumberOrderByEmailDesc(cif, phoneNumber);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPhoneNumberOrderByPhoneNumberAsc(cif, phoneNumber);
                        else
                            suppliers = supplierRepository.findByCifAndPhoneNumberOrderByPhoneNumberDesc(cif, phoneNumber);
                        break;
                }
            else if (postalCodeA != null && postalCodeB != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeBetweenOrderByCifAsc(cif, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeBetweenOrderByCifDesc(cif, postalCodeA, postalCodeB);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeBetweenOrderByNameAsc(cif, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeBetweenOrderByNameDesc(cif, postalCodeA, postalCodeB);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeBetweenOrderByPostalCodeAsc(cif, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeBetweenOrderByPostalCodeDesc(cif, postalCodeA, postalCodeB);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeBetweenOrderByEmailAsc(cif, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeBetweenOrderByEmailDesc(cif, postalCodeA, postalCodeB);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeBetweenOrderByPhoneNumberAsc(cif, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeBetweenOrderByPhoneNumberDesc(cif, postalCodeA, postalCodeB);
                        break;
                }
            else if (postalCodeA != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeGreaterThanOrderByCifAsc(cif, postalCodeA);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeGreaterThanOrderByCifDesc(cif, postalCodeA);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeGreaterThanOrderByNameAsc(cif, postalCodeA);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeGreaterThanOrderByNameDesc(cif, postalCodeA);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeGreaterThanOrderByPostalCodeAsc(cif, postalCodeA);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeGreaterThanOrderByPostalCodeDesc(cif, postalCodeA);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeGreaterThanOrderByEmailAsc(cif, postalCodeA);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeGreaterThanOrderByEmailDesc(cif, postalCodeA);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeGreaterThanOrderByPhoneNumberAsc(cif, postalCodeA);
                        else {
                            suppliers = supplierRepository.findByCifAndPostalCodeGreaterThanOrderByPhoneNumberDesc(cif, postalCodeA);
                        }
                        break;
                }
            else if (postalCodeA == null && postalCodeB != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeLessThanOrderByCifAsc(cif, postalCodeB);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeLessThanOrderByCifDesc(cif, postalCodeB);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeLessThanOrderByNameAsc(cif, postalCodeB);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeLessThanOrderByNameDesc(cif, postalCodeB);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeLessThanOrderByPostalCodeAsc(cif, postalCodeB);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeLessThanOrderByPostalCodeDesc(cif, postalCodeB);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeLessThanOrderByEmailAsc(cif, postalCodeB);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeLessThanOrderByEmailDesc(cif, postalCodeB);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByCifAndPostalCodeLessThanOrderByPhoneNumberAsc(cif, postalCodeB);
                        else
                            suppliers = supplierRepository.findByCifAndPostalCodeLessThanOrderByPhoneNumberDesc(cif, postalCodeB);
                        break;
                }
        } else if (!name.isEmpty()) {
            if (cif.isEmpty() && postalCodeA == null && postalCodeB == null && email.isEmpty() && phoneNumber == null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingOrderByCifAsc(name);
                        else
                            suppliers = supplierRepository.findByNameContainingOrderByCifDesc(name);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingOrderByNameAsc(name);
                        else
                            suppliers = supplierRepository.findByNameContainingOrderByNameDesc(name);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingOrderByPostalCodeAsc(name);
                        else
                            suppliers = supplierRepository.findByNameContainingOrderByPostalCodeDesc(name);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingOrderByEmailAsc(name);
                        else
                            suppliers = supplierRepository.findByNameContainingOrderByEmailDesc(name);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingOrderByPhoneNumberAsc(name);
                        else
                            suppliers = supplierRepository.findByNameContainingOrderByPhoneNumberDesc(name);
                        break;
                }
            else if (!email.isEmpty())
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndEmailOrderByCifAsc(name, email);
                        else
                            suppliers = supplierRepository.findByNameContainingAndEmailOrderByCifDesc(name, email);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndEmailOrderByNameAsc(name, email);
                        else
                            suppliers = supplierRepository.findByNameContainingAndEmailOrderByNameDesc(name, email);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndEmailOrderByPostalCodeAsc(name, email);
                        else
                            suppliers = supplierRepository.findByNameContainingAndEmailOrderByPostalCodeDesc(name, email);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndEmailOrderByEmailAsc(name, email);
                        else
                            suppliers = supplierRepository.findByNameContainingAndEmailOrderByEmailDesc(name, email);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndEmailOrderByPhoneNumberAsc(name, email);
                        else
                            suppliers = supplierRepository.findByNameContainingAndEmailOrderByPhoneNumberDesc(name, email);
                        break;
                }
            else if (phoneNumber != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPhoneNumberOrderByCifAsc(name, phoneNumber);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPhoneNumberOrderByCifDesc(name, phoneNumber);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPhoneNumberOrderByNameAsc(name, phoneNumber);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPhoneNumberOrderByNameDesc(name, phoneNumber);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPhoneNumberOrderByPostalCodeAsc(name, phoneNumber);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPhoneNumberOrderByPostalCodeDesc(name, phoneNumber);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPhoneNumberOrderByEmailAsc(name, phoneNumber);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPhoneNumberOrderByEmailDesc(name, phoneNumber);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPhoneNumberOrderByPhoneNumberAsc(name, phoneNumber);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPhoneNumberOrderByPhoneNumberDesc(name, phoneNumber);
                        break;
                }
            else if (postalCodeA != null && postalCodeB != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeBetweenOrderByCifAsc(name, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeBetweenOrderByCifDesc(name, postalCodeA, postalCodeB);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeBetweenOrderByNameAsc(name, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeBetweenOrderByNameDesc(name, postalCodeA, postalCodeB);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeBetweenOrderByPostalCodeAsc(name, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeBetweenOrderByPostalCodeDesc(name, postalCodeA, postalCodeB);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeBetweenOrderByEmailAsc(name, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeBetweenOrderByEmailDesc(name, postalCodeA, postalCodeB);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeBetweenOrderByPhoneNumberAsc(name, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeBetweenOrderByPhoneNumberDesc(name, postalCodeA, postalCodeB);
                        break;
                }
            else if (postalCodeA != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeGreaterThanOrderByCifAsc(name, postalCodeA);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeGreaterThanOrderByCifDesc(name, postalCodeA);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeGreaterThanOrderByNameAsc(name, postalCodeA);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeGreaterThanOrderByNameDesc(name, postalCodeA);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeGreaterThanOrderByPostalCodeAsc(name, postalCodeA);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeGreaterThanOrderByPostalCodeDesc(name, postalCodeA);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeGreaterThanOrderByEmailAsc(name, postalCodeA);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeGreaterThanOrderByEmailDesc(name, postalCodeA);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeGreaterThanOrderByPhoneNumberAsc(name, postalCodeA);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeGreaterThanOrderByPhoneNumberDesc(name, postalCodeA);
                        break;
                }
            else if (postalCodeA == null && postalCodeB != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeLessThanOrderByCifAsc(name, postalCodeB);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeLessThanOrderByCifDesc(name, postalCodeB);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeLessThanOrderByNameAsc(name, postalCodeB);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeLessThanOrderByNameDesc(name, postalCodeB);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeLessThanOrderByPostalCodeAsc(name, postalCodeB);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeLessThanOrderByPostalCodeDesc(name, postalCodeB);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeLessThanOrderByEmailAsc(name, postalCodeB);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeLessThanOrderByEmailDesc(name, postalCodeB);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeLessThanOrderByPhoneNumberAsc(name, postalCodeB);
                        else
                            suppliers = supplierRepository.findByNameContainingAndPostalCodeLessThanOrderByPhoneNumberDesc(name, postalCodeB);
                        break;
                }
        } else if (!email.isEmpty()) {
            if (postalCodeA == null && postalCodeB == null && phoneNumber == null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailOrderByCifAsc(email);
                        else
                            suppliers = supplierRepository.findByEmailOrderByCifDesc(email);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailOrderByNameAsc(email);
                        else
                            suppliers = supplierRepository.findByEmailOrderByNameDesc(email);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailOrderByPostalCodeAsc(email);
                        else
                            suppliers = supplierRepository.findByEmailOrderByPostalCodeDesc(email);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailOrderByEmailAsc(email);
                        else
                            suppliers = supplierRepository.findByEmailOrderByEmailDesc(email);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailOrderByPhoneNumberAsc(email);
                        else
                            suppliers = supplierRepository.findByEmailOrderByPhoneNumberDesc(email);
                        break;
                }
            else if (phoneNumber != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPhoneNumberOrderByCifAsc(email, phoneNumber);
                        else
                            suppliers = supplierRepository.findByEmailAndPhoneNumberOrderByCifDesc(email, phoneNumber);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPhoneNumberOrderByNameAsc(email, phoneNumber);
                        else
                            suppliers = supplierRepository.findByEmailAndPhoneNumberOrderByNameDesc(email, phoneNumber);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPhoneNumberOrderByPostalCodeAsc(email, phoneNumber);
                        else
                            suppliers = supplierRepository.findByEmailAndPhoneNumberOrderByPostalCodeDesc(email, phoneNumber);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPhoneNumberOrderByEmailAsc(email, phoneNumber);
                        else
                            suppliers = supplierRepository.findByEmailAndPhoneNumberOrderByEmailDesc(email, phoneNumber);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPhoneNumberOrderByPhoneNumberAsc(email, phoneNumber);
                        else
                            suppliers = supplierRepository.findByEmailAndPhoneNumberOrderByPhoneNumberDesc(email, phoneNumber);
                        break;
                }
            else if (postalCodeA != null && postalCodeB != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeBetweenOrderByCifAsc(email, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeBetweenOrderByCifDesc(email, postalCodeA, postalCodeB);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeBetweenOrderByNameAsc(email, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeBetweenOrderByNameDesc(email, postalCodeA, postalCodeB);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeBetweenOrderByPostalCodeAsc(email, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeBetweenOrderByPostalCodeDesc(email, postalCodeA, postalCodeB);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeBetweenOrderByEmailAsc(email, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeBetweenOrderByEmailDesc(email, postalCodeA, postalCodeB);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeBetweenOrderByPhoneNumberAsc(email, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeBetweenOrderByPhoneNumberDesc(email, postalCodeA, postalCodeB);
                        break;
                }
            else if (postalCodeA != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeGreaterThanOrderByCifAsc(email, postalCodeA);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeGreaterThanOrderByCifDesc(email, postalCodeA);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeGreaterThanOrderByNameAsc(email, postalCodeA);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeGreaterThanOrderByNameDesc(email, postalCodeA);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeGreaterThanOrderByPostalCodeAsc(email, postalCodeA);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeGreaterThanOrderByPostalCodeDesc(email, postalCodeA);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeGreaterThanOrderByEmailAsc(email, postalCodeA);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeGreaterThanOrderByEmailDesc(email, postalCodeA);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeGreaterThanOrderByPhoneNumberAsc(email, postalCodeA);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeGreaterThanOrderByPhoneNumberDesc(email, postalCodeA);
                        break;
                }
            else if (postalCodeA == null && postalCodeB != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeLessThanOrderByCifAsc(email, postalCodeB);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeLessThanOrderByCifDesc(email, postalCodeB);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeLessThanOrderByNameAsc(email, postalCodeB);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeLessThanOrderByNameDesc(email, postalCodeB);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeLessThanOrderByPostalCodeAsc(email, postalCodeB);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeLessThanOrderByPostalCodeDesc(email, postalCodeB);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeLessThanOrderByEmailAsc(email, postalCodeB);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeLessThanOrderByEmailDesc(email, postalCodeB);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByEmailAndPostalCodeLessThanOrderByPhoneNumberAsc(email, postalCodeB);
                        else
                            suppliers = supplierRepository.findByEmailAndPostalCodeLessThanOrderByPhoneNumberDesc(email, postalCodeB);
                        break;
                }
        } else if (phoneNumber!=null) {
            if (postalCodeA == null && postalCodeB == null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberOrderByCifAsc(phoneNumber);
                        else
                            suppliers = supplierRepository.findByPhoneNumberOrderByCifDesc(phoneNumber);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberOrderByNameAsc(phoneNumber);
                        else
                            suppliers = supplierRepository.findByPhoneNumberOrderByNameDesc(phoneNumber);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberOrderByPostalCodeAsc(phoneNumber);
                        else
                            suppliers = supplierRepository.findByPhoneNumberOrderByPostalCodeDesc(phoneNumber);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberOrderByEmailAsc(phoneNumber);
                        else
                            suppliers = supplierRepository.findByPhoneNumberOrderByEmailDesc(phoneNumber);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberOrderByPhoneNumberAsc(phoneNumber);
                        else
                            suppliers = supplierRepository.findByPhoneNumberOrderByPhoneNumberDesc(phoneNumber);
                        break;
                }
            else if (postalCodeA != null && postalCodeB != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeBetweenOrderByCifAsc(phoneNumber, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeBetweenOrderByCifDesc(phoneNumber, postalCodeA, postalCodeB);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeBetweenOrderByNameAsc(phoneNumber, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeBetweenOrderByNameDesc(phoneNumber, postalCodeA, postalCodeB);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeBetweenOrderByPostalCodeAsc(phoneNumber, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeBetweenOrderByPostalCodeDesc(phoneNumber, postalCodeA, postalCodeB);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeBetweenOrderByEmailAsc(phoneNumber, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeBetweenOrderByEmailDesc(phoneNumber, postalCodeA, postalCodeB);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeBetweenOrderByPhoneNumberAsc(phoneNumber, postalCodeA, postalCodeB);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeBetweenOrderByPhoneNumberDesc(phoneNumber, postalCodeA, postalCodeB);
                        break;
                }
            else if (postalCodeA != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeGreaterThanOrderByCifAsc(phoneNumber, postalCodeA);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeGreaterThanOrderByCifDesc(phoneNumber, postalCodeA);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeGreaterThanOrderByNameAsc(phoneNumber, postalCodeA);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeGreaterThanOrderByNameDesc(phoneNumber, postalCodeA);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeGreaterThanOrderByPostalCodeAsc(phoneNumber, postalCodeA);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeGreaterThanOrderByPostalCodeDesc(phoneNumber, postalCodeA);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeGreaterThanOrderByEmailAsc(phoneNumber, postalCodeA);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeGreaterThanOrderByEmailDesc(phoneNumber, postalCodeA);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeGreaterThanOrderByPhoneNumberAsc(phoneNumber, postalCodeA);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeGreaterThanOrderByPhoneNumberDesc(phoneNumber, postalCodeA);
                        break;
                }
            else if (postalCodeA == null && postalCodeB != null)
                switch (orderBy) {
                    case "CIF":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeLessThanOrderByCifAsc(phoneNumber, postalCodeB);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeLessThanOrderByCifDesc(phoneNumber, postalCodeB);
                        break;
                    case "Name":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeLessThanOrderByNameAsc(phoneNumber, postalCodeB);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeLessThanOrderByNameDesc(phoneNumber, postalCodeB);
                        break;
                    case "PostalCode":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeLessThanOrderByPostalCodeAsc(phoneNumber, postalCodeB);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeLessThanOrderByPostalCodeDesc(phoneNumber, postalCodeB);
                        break;
                    case "Email":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeLessThanOrderByEmailAsc(phoneNumber, postalCodeB);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeLessThanOrderByEmailDesc(phoneNumber, postalCodeB);
                        break;
                    case "PhoneNumber":
                        if (order.equals("Asc"))
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeLessThanOrderByPhoneNumberAsc(phoneNumber, postalCodeB);
                        else
                            suppliers = supplierRepository.findByPhoneNumberAndPostalCodeLessThanOrderByPhoneNumberDesc(phoneNumber, postalCodeB);
                        break;
                }
        } else if (postalCodeA!=null && postalCodeB!=null) {
            switch (orderBy) {
                case "CIF":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeBetweenOrderByCifAsc(postalCodeA, postalCodeB);
                    else
                        suppliers = supplierRepository.findByPostalCodeBetweenOrderByCifDesc(postalCodeA, postalCodeB);
                    break;
                case "Name":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeBetweenOrderByNameAsc(postalCodeA, postalCodeB);
                    else
                        suppliers = supplierRepository.findByPostalCodeBetweenOrderByNameDesc(postalCodeA, postalCodeB);
                    break;
                case "PostalCode":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeBetweenOrderByPostalCodeAsc(postalCodeA, postalCodeB);
                    else
                        suppliers = supplierRepository.findByPostalCodeBetweenOrderByPostalCodeDesc(postalCodeA, postalCodeB);
                    break;
                case "Email":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeBetweenOrderByEmailAsc(postalCodeA, postalCodeB);
                    else
                        suppliers = supplierRepository.findByPostalCodeBetweenOrderByEmailDesc(postalCodeA, postalCodeB);
                    break;
                case "PhoneNumber":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeBetweenOrderByPhoneNumberAsc(postalCodeA, postalCodeB);
                    else
                        suppliers = supplierRepository.findByPostalCodeBetweenOrderByPhoneNumberDesc(postalCodeA, postalCodeB);
                    break;
            }
        } else if (postalCodeA!=null && postalCodeB==null) {
            switch (orderBy) {
                case "CIF":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeGreaterThanOrderByCifAsc(postalCodeA);
                    else
                        suppliers = supplierRepository.findByPostalCodeGreaterThanOrderByCifDesc(postalCodeA);
                    break;
                case "Name":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeGreaterThanOrderByNameAsc(postalCodeA);
                    else
                        suppliers = supplierRepository.findByPostalCodeGreaterThanOrderByNameDesc(postalCodeA);
                    break;
                case "PostalCode":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeGreaterThanOrderByPostalCodeAsc(postalCodeA);
                    else
                        suppliers = supplierRepository.findByPostalCodeGreaterThanOrderByPostalCodeDesc(postalCodeA);
                    break;
                case "Email":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeGreaterThanOrderByEmailAsc(postalCodeA);
                    else
                        suppliers = supplierRepository.findByPostalCodeGreaterThanOrderByEmailDesc(postalCodeA);
                    break;
                case "PhoneNumber":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeGreaterThanOrderByPhoneNumberAsc(postalCodeA);
                    else
                        suppliers = supplierRepository.findByPostalCodeGreaterThanOrderByPhoneNumberDesc(postalCodeA);
                    break;
            }
        } else if (postalCodeA==null && postalCodeB!=null) {
            switch (orderBy) {
                case "CIF":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeLessThanOrderByCifAsc(postalCodeB);
                    else
                        suppliers = supplierRepository.findByPostalCodeLessThanOrderByCifDesc(postalCodeB);
                    break;
                case "Name":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeLessThanOrderByNameAsc(postalCodeB);
                    else
                        suppliers = supplierRepository.findByPostalCodeLessThanOrderByNameDesc(postalCodeB);
                    break;
                case "PostalCode":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeLessThanOrderByPostalCodeAsc(postalCodeB);
                    else
                        suppliers = supplierRepository.findByPostalCodeLessThanOrderByPostalCodeDesc(postalCodeB);
                    break;
                case "Email":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeLessThanOrderByEmailAsc(postalCodeB);
                    else
                        suppliers = supplierRepository.findByPostalCodeLessThanOrderByEmailDesc(postalCodeB);
                    break;
                case "PhoneNumber":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findByPostalCodeLessThanOrderByPhoneNumberAsc(postalCodeB);
                    else
                        suppliers = supplierRepository.findByPostalCodeLessThanOrderByPhoneNumberDesc(postalCodeB);
                    break;
            }
        } else {
            switch (orderBy) {
                case "CIF":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findAllByOrderByCifAsc();
                    else
                        suppliers = supplierRepository.findAllByOrderByCifDesc();
                    break;
                case "Name":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findAllByOrderByNameAsc();
                    else
                        suppliers = supplierRepository.findAllByOrderByNameDesc();
                    break;
                case "PostalCode":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findAllByOrderByPostalCodeAsc();
                    else
                        suppliers = supplierRepository.findAllByOrderByPostalCodeDesc();
                    break;
                case "Email":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findAllByOrderByEmailAsc();
                    else
                        suppliers = supplierRepository.findAllByOrderByEmailDesc();
                    break;
                case "PhoneNumber":
                    if (order.equals("Asc"))
                        suppliers = supplierRepository.findAllByOrderByPhoneNumberAsc();
                    else
                        suppliers = supplierRepository.findAllByOrderByPhoneNumberDesc();
                    break;
            }
        }

        model.addAttribute("suppliers", suppliers);

        return "/supplierQueries";
    }

    @RequestMapping("/modify")
    public String modify(@RequestParam Long id, Model model) {
        Supplier sp = supplierRepository.getOne(id);
        model.addAttribute("supplier", sp);
        return "showSupplier";
    }
}