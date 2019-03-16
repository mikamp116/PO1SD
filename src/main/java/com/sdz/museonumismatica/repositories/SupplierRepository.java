package com.sdz.museonumismatica.repositories;

import com.sdz.museonumismatica.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    // Ordenar todos los proveedores en funcion de los posibles atributos 
    List<Supplier> findAllByOrderByCifAsc();            // por CIF ascendiente
    List<Supplier> findAllByOrderByCifDesc();           // por CIF descendiente
    List<Supplier> findAllByOrderByNameAsc();           // por nombre ascendiente
    List<Supplier> findAllByOrderByNameDesc();          // por nombre descendiente
    List<Supplier> findAllByOrderByPostalcodeAsc();     // por codigo postal ascendiente
    List<Supplier> findAllByOrderByPostalcodeDesc();    // por codigo postal descendiente
    List<Supplier> findAllByOrderByEmailAsc();          // por email ascendiente
    List<Supplier> findAllByOrderByEmailDesc();         // por email descendiente
    List<Supplier> findAllByOrderByPhonenumberAsc();    // por numero de telefono ascendiente
    List<Supplier> findAllByOrderByPhonenumberDesc();   // por numero de telefono descendiente
    
    
    // Buscar por CIF y ordenar en funcion de los posibles atributos
    List<Supplier> findByCif(String cif);
    List<Supplier> findByCifOrderByNameAsc(String cif);             // por nombre ascendiente
    List<Supplier> findByCifOrderByNameDesc(String cif);            // por nombre descendiente
    List<Supplier> findByCifOrderByPostalcodeAsc(String cif);       // por codigo postal ascendiente
    List<Supplier> findByCifOrderByPostalcodeDesc(String cif);      // por codigo postal descendiente
    List<Supplier> findByCifOrderByEmailAsc(String cif);            // por email ascendiente
    List<Supplier> findByCifOrderByEmailDesc(String cif);           // por email descendiente
    List<Supplier> findByCifOrderByPhonenumberAsc(String cif);      // por numero de telefono ascendiente
    List<Supplier> findByCifOrderByPhonenumberDesc(String cif);     // por numero de telefono descendiente

    
    // Buscar por nombre y ordenar en funcion de los posibles atributos
    List<Supplier> findByName(String name);
    List<Supplier> findByNameOrderByCifAsc(String name);            // por CIF ascendiente
    List<Supplier> findByNameOrderByCifDesc(String name);           // por CIF descendiente
    List<Supplier> findByNameOrderByPostalcodeAsc(String name);     // por codigo postal ascendiente
    List<Supplier> findByNameOrderByPostalcodeDesc(String name);    // por codigo postal descendiente
    List<Supplier> findByNameOrderByEmailAsc(String name);          // por email ascendiente
    List<Supplier> findByNameOrderByEmailDesc(String name);         // por email descendiente
    List<Supplier> findByNameOrderByPhonenumberAsc(String name);    // por numero de telefono ascendiente
    List<Supplier> findByNameOrderByPhonenumberDesc(String name);   // por numero de telefono descendiente
    
    
    // Buscar por codigo postal y ordenar en funcion de los posibles atributos
    List<Supplier> findByPostalcode(int postalCode);
    List<Supplier> findByPostalcodeOrderByCifAsc(int postalCode);           // por CIF ascendiente
    List<Supplier> findByPostalcodeOrderByCifDesc(int postalCode);          // por CIF descendiente
    List<Supplier> findByPostalcodeOrderByNameAsc(int postalCode);          // por nombre ascendiente
    List<Supplier> findByPostalcodeOrderByNameDesc(int postalCode);         // por nombre descendiente
    List<Supplier> findByPostalcodeOrderByEmailAsc(int postalCode);         // por email ascendiente
    List<Supplier> findByPostalcodeOrderByEmailDesc(int postalCode);        // por email descendiente
    List<Supplier> findByPostalcodeOrderByPhonenumberAsc(int postalCode);   // por numero de telefono ascendiente
    List<Supplier> findByPostalcodeOrderByPhonenumberDesc(int postalCode);  // por numero de telefono descendiente
    
    // Buscar por rango de codigo postal y ordenar en funcion de los posibles atributos
    List<Supplier> findByPostalcodeBetween(int postalCode1, int postalCode2);
    List<Supplier> findByPostalcodeBetweenOrderByCifAsc(int postalCode1, int postalCode2);           // por CIF ascendiente
    List<Supplier> findByPostalcodeBetweenOrderByCifDesc(int postalCode1, int postalCode2);          // por CIF descendiente
    List<Supplier> findByPostalcodeBetweenOrderByNameAsc(int postalCode1, int postalCode2);          // por nombre ascendiente
    List<Supplier> findByPostalcodeBetweenOrderByNameDesc(int postalCode1, int postalCode2);         // por nombre descendiente
    List<Supplier> findByPostalcodeBetweenOrderByEmailAsc(int postalCode1, int postalCode2);         // por email ascendiente
    List<Supplier> findByPostalcodeBetweenOrderByEmailDesc(int postalCode1, int postalCode2);        // por email descendiente
    List<Supplier> findByPostalcodeBetweenOrderByPhonenumberAsc(int postalCode1, int postalCode2);   // por numero de telefono ascendiente
    List<Supplier> findByPostalcodeBetweenOrderByPhonenumberDesc(int postalCode1, int postalCode2);  // por numero de telefono descendiente
    
   
    // Buscar por email y ordenar en funcion de los posibles atributos
    List<Supplier> findByEmail(String email);
    List<Supplier> findByEmailOrderByCifAsc(String email);           // por CIF ascendiente
    List<Supplier> findByEmailOrderByCifDesc(String email);          // por CIF descendiente
    List<Supplier> findByEmailOrderByNameAsc(String email);          // por nombre ascendiente
    List<Supplier> findByEmailOrderByNameDesc(String email);         // por nombre descendiente
    List<Supplier> findByEmailOrderByPostalcodeAsc(String email);    // por codigo postal ascendiente
    List<Supplier> findByEmailOrderByPostalcodeDesc(String email);   // por codigo postal descendiente
    List<Supplier> findByEmailOrderByPhonenumberAsc(String email);   // por numero de telefono ascendiente
    List<Supplier> findByEmailOrderByPhonenumberDesc(String email);  // por numero de telefono descendiente

    
    // Buscar por numero de telefono y ordenar en funcion de los posibles atributos
    List<Supplier> findByPhonenumber(int phoneNumber);
    List<Supplier> findByPhonenumberOrderByCifAsc(int phoneNumber);           // por CIF ascendiente
    List<Supplier> findByPhonenumberOrderByCifDesc(int phoneNumber);          // por CIF descendiente
    List<Supplier> findByPhonenumberOrderByNameAsc(int phoneNumber);          // por nombre ascendiente
    List<Supplier> findByPhonenumberOrderByNameDesc(int phoneNumber);         // por nombre descendiente
    List<Supplier> findByPhonenumberOrderByPostalcodeAsc(int phoneNumber);    // por codigo postal ascendiente
    List<Supplier> findByPhonenumberOrderByPostalcodeDesc(int phoneNumber);   // por codigo postal descendiente
    List<Supplier> findByPhonenumberOrderByEmailAsc(int phoneNumber);         // por email ascendiente
    List<Supplier> findByPhonenumberOrderByEmailDesc(int phoneNumber);        // por email descendiente
}
