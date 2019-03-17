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
    List<Supplier> findAllByOrderByPostalCodeAsc();     // por codigo postal ascendiente
    List<Supplier> findAllByOrderByPostalCodeDesc();    // por codigo postal descendiente
    List<Supplier> findAllByOrderByEmailAsc();          // por email ascendiente
    List<Supplier> findAllByOrderByEmailDesc();         // por email descendiente
    List<Supplier> findAllByOrderByPhoneNumberAsc();    // por numero de telefono ascendiente
    List<Supplier> findAllByOrderByPhoneNumberDesc();   // por numero de telefono descendiente
    
    
    // Buscar por CIF y ordenar en funcion de los posibles atributos
    List<Supplier> findByCif(String cif);
    List<Supplier> findByCifOrderByNameAsc(String cif);             // por nombre ascendiente
    List<Supplier> findByCifOrderByNameDesc(String cif);            // por nombre descendiente
    List<Supplier> findByCifOrderByPostalCodeAsc(String cif);       // por codigo postal ascendiente
    List<Supplier> findByCifOrderByPostalCodeDesc(String cif);      // por codigo postal descendiente
    List<Supplier> findByCifOrderByEmailAsc(String cif);            // por email ascendiente
    List<Supplier> findByCifOrderByEmailDesc(String cif);           // por email descendiente
    List<Supplier> findByCifOrderByPhoneNumberAsc(String cif);      // por numero de telefono ascendiente
    List<Supplier> findByCifOrderByPhoneNumberDesc(String cif);     // por numero de telefono descendiente

    
    // Buscar por nombre y ordenar en funcion de los posibles atributos
    List<Supplier> findByName(String name);
    List<Supplier> findByNameOrderByCifAsc(String name);            // por CIF ascendiente
    List<Supplier> findByNameOrderByCifDesc(String name);           // por CIF descendiente
    List<Supplier> findByNameOrderByPostalCodeAsc(String name);     // por codigo postal ascendiente
    List<Supplier> findByNameOrderByPostalCodeDesc(String name);    // por codigo postal descendiente
    List<Supplier> findByNameOrderByEmailAsc(String name);          // por email ascendiente
    List<Supplier> findByNameOrderByEmailDesc(String name);         // por email descendiente
    List<Supplier> findByNameOrderByPhoneNumberAsc(String name);    // por numero de telefono ascendiente
    List<Supplier> findByNameOrderByPhoneNumberDesc(String name);   // por numero de telefono descendiente
    
    
    // Buscar por codigo postal y ordenar en funcion de los posibles atributos
    List<Supplier> findByPostalCode(int postalCode);
    List<Supplier> findByPostalCodeOrderByCifAsc(int postalCode);           // por CIF ascendiente
    List<Supplier> findByPostalCodeOrderByCifDesc(int postalCode);          // por CIF descendiente
    List<Supplier> findByPostalCodeOrderByNameAsc(int postalCode);          // por nombre ascendiente
    List<Supplier> findByPostalCodeOrderByNameDesc(int postalCode);         // por nombre descendiente
    List<Supplier> findByPostalCodeOrderByEmailAsc(int postalCode);         // por email ascendiente
    List<Supplier> findByPostalCodeOrderByEmailDesc(int postalCode);        // por email descendiente
    List<Supplier> findByPostalCodeOrderByPhoneNumberAsc(int postalCode);   // por numero de telefono ascendiente
    List<Supplier> findByPostalCodeOrderByPhoneNumberDesc(int postalCode);  // por numero de telefono descendiente
    
    // Buscar por rango de codigo postal y ordenar en funcion de los posibles atributos
    List<Supplier> findByPostalCodeBetween(int postalCode1, int postalCode2);
    List<Supplier> findByPostalCodeBetweenOrderByCifAsc(int postalCode1, int postalCode2);           // por CIF ascendiente
    List<Supplier> findByPostalCodeBetweenOrderByCifDesc(int postalCode1, int postalCode2);          // por CIF descendiente
    List<Supplier> findByPostalCodeBetweenOrderByNameAsc(int postalCode1, int postalCode2);          // por nombre ascendiente
    List<Supplier> findByPostalCodeBetweenOrderByNameDesc(int postalCode1, int postalCode2);         // por nombre descendiente
    List<Supplier> findByPostalCodeBetweenOrderByEmailAsc(int postalCode1, int postalCode2);         // por email ascendiente
    List<Supplier> findByPostalCodeBetweenOrderByEmailDesc(int postalCode1, int postalCode2);        // por email descendiente
    List<Supplier> findByPostalCodeBetweenOrderByPhoneNumberAsc(int postalCode1, int postalCode2);   // por numero de telefono ascendiente
    List<Supplier> findByPostalCodeBetweenOrderByPhoneNumberDesc(int postalCode1, int postalCode2);  // por numero de telefono descendiente
    
   
    // Buscar por email y ordenar en funcion de los posibles atributos
    List<Supplier> findByEmail(String email);
    List<Supplier> findByEmailOrderByCifAsc(String email);           // por CIF ascendiente
    List<Supplier> findByEmailOrderByCifDesc(String email);          // por CIF descendiente
    List<Supplier> findByEmailOrderByNameAsc(String email);          // por nombre ascendiente
    List<Supplier> findByEmailOrderByNameDesc(String email);         // por nombre descendiente
    List<Supplier> findByEmailOrderByPostalCodeAsc(String email);    // por codigo postal ascendiente
    List<Supplier> findByEmailOrderByPostalCodeDesc(String email);   // por codigo postal descendiente
    List<Supplier> findByEmailOrderByPhoneNumberAsc(String email);   // por numero de telefono ascendiente
    List<Supplier> findByEmailOrderByPhoneNumberDesc(String email);  // por numero de telefono descendiente

    
    // Buscar por numero de telefono y ordenar en funcion de los posibles atributos
    List<Supplier> findByPhoneNumber(int phoneNumber);
    List<Supplier> findByPhoneNumberOrderByCifAsc(int phoneNumber);           // por CIF ascendiente
    List<Supplier> findByPhoneNumberOrderByCifDesc(int phoneNumber);          // por CIF descendiente
    List<Supplier> findByPhoneNumberOrderByNameAsc(int phoneNumber);          // por nombre ascendiente
    List<Supplier> findByPhoneNumberOrderByNameDesc(int phoneNumber);         // por nombre descendiente
    List<Supplier> findByPhoneNumberOrderByPostalCodeAsc(int phoneNumber);    // por codigo postal ascendiente
    List<Supplier> findByPhoneNumberOrderByPostalCodeDesc(int phoneNumber);   // por codigo postal descendiente
    List<Supplier> findByPhoneNumberOrderByEmailAsc(int phoneNumber);         // por email ascendiente
    List<Supplier> findByPhoneNumberOrderByEmailDesc(int phoneNumber);        // por email descendiente
}
