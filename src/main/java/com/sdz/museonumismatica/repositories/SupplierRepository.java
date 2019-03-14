package com.sdz.museonumismatica.repositories;

import com.sdz.museonumismatica.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    List<Supplier> findAllByOrderByCifAsc();
    List<Supplier> findAllByOrderByCifDesc();
    List<Supplier> findByCif(String cif);

    List<Supplier> findAllByOrderByNameAsc();
    List<Supplier> findAllByOrderByNameDesc();
    List<Supplier> findByName(String name);

    List<Supplier> findByPostalcode(int postalCode);
    List<Supplier> findByPostalcodeBetween(int postalCode1, int postalCode2);
    List<Supplier> findAllByOrderByPostalcodeAsc();
    List<Supplier> findAllByOrderByPostalcodeDesc();

    List<Supplier> findByEmail(String email);

    List<Supplier> findByPhonenumber(int phoneNumber);
}
