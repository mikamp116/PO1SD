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
    List<Supplier> findByNameContaining(String name);
    List<Supplier> findByNameContainingOrderByCifAsc(String name);            // por CIF ascendiente
    List<Supplier> findByNameContainingOrderByCifDesc(String name);           // por CIF descendiente
    List<Supplier> findByNameContainingOrderByPostalCodeAsc(String name);     // por codigo postal ascendiente
    List<Supplier> findByNameContainingOrderByPostalCodeDesc(String name);    // por codigo postal descendiente
    List<Supplier> findByNameContainingOrderByEmailAsc(String name);          // por email ascendiente
    List<Supplier> findByNameContainingOrderByEmailDesc(String name);         // por email descendiente
    List<Supplier> findByNameContainingOrderByPhoneNumberAsc(String name);    // por numero de telefono ascendiente
    List<Supplier> findByNameContainingOrderByPhoneNumberDesc(String name);   // por numero de telefono descendiente
    
    
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

    List<Supplier> findByCifAndNameContaining(String cif, String name);

    List<Supplier> findByPostalCodeLessThanOrderByPhoneNumberDesc(Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeBetweenOrderByCifAsc(String cif, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeBetweenOrderByNameAsc(String cif, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeBetweenOrderByNameDesc(String cif, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeBetweenOrderByPostalCodeAsc(String cif, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeBetweenOrderByPostalCodeDesc(String cif, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeBetweenOrderByEmailAsc(String cif, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeBetweenOrderByEmailDesc(String cif, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeBetweenOrderByPhoneNumberAsc(String cif, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeBetweenOrderByPhoneNumberDesc(String cif, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeGreaterThanOrderByCifAsc(String cif, Integer postalCodeA);

    List<Supplier> findByCifAndPostalCodeGreaterThanOrderByCifDesc(String cif, Integer postalCodeA);

    List<Supplier> findByCifAndPostalCodeGreaterThanOrderByNameAsc(String cif, Integer postalCodeA);

    List<Supplier> findByCifAndPostalCodeGreaterThanOrderByNameDesc(String cif, Integer postalCodeA);

    List<Supplier> findByCifAndPostalCodeGreaterThanOrderByPostalCodeAsc(String cif, Integer postalCodeA);

    List<Supplier> findByCifAndPostalCodeGreaterThanOrderByPostalCodeDesc(String cif, Integer postalCodeA);

    List<Supplier> findByCifAndPostalCodeGreaterThanOrderByEmailAsc(String cif, Integer postalCodeA);

    List<Supplier> findByCifAndPostalCodeGreaterThanOrderByEmailDesc(String cif, Integer postalCodeA);

    List<Supplier> findByCifAndPostalCodeGreaterThanOrderByPhoneNumberAsc(String cif, Integer postalCodeA);

    List<Supplier> findByCifOrderByCifAsc(String cif);

    List<Supplier> findByCifOrderByCifDesc(String cif);

    List<Supplier> findByCifAndNameContainingOrderByCifAsc(String cif, String name);

    List<Supplier> findByCifAndNameContainingOrderByCifDesc(String cif, String name);

    List<Supplier> findByCifAndNameContainingOrderByNameAsc(String cif, String name);

    List<Supplier> findByCifAndNameContainingOrderByNameDesc(String cif, String name);

    List<Supplier> findByCifAndNameContainingOrderByPostalCodeAsc(String cif, String name);

    List<Supplier> findByCifAndNameContainingOrderByPostalCodeDesc(String cif, String name);

    List<Supplier> findByCifAndNameContainingOrderByEmailAsc(String cif, String name);

    List<Supplier> findByCifAndNameContainingOrderByEmailDesc(String cif, String name);

    List<Supplier> findByCifAndNameContainingOrderByPhoneNumberAsc(String cif, String name);

    List<Supplier> findByCifAndNameContainingOrderByPhoneNumberDesc(String cif, String name);

    List<Supplier> findByCifAndEmailOrderByCifAsc(String cif, String email);

    List<Supplier> findByCifAndEmailOrderByCifDesc(String cif, String email);

    List<Supplier> findByCifAndEmailOrderByNameAsc(String cif, String email);

    List<Supplier> findByCifAndEmailOrderByNameDesc(String cif, String email);

    List<Supplier> findByCifAndEmailOrderByPostalCodeAsc(String cif, String email);

    List<Supplier> findByCifAndEmailOrderByPostalCodeDesc(String cif, String email);

    List<Supplier> findByCifAndEmailOrderByEmailAsc(String cif, String email);

    List<Supplier> findByCifAndEmailOrderByEmailDesc(String cif, String email);

    List<Supplier> findByCifAndEmailOrderByPhoneNumberAsc(String cif, String email);

    List<Supplier> findByCifAndEmailOrderByPhoneNumberDesc(String cif, String email);

    List<Supplier> findByCifAndPhoneNumberOrderByCifAsc(String cif, Integer phoneNumber);

    List<Supplier> findByCifAndPhoneNumberOrderByCifDesc(String cif, Integer phoneNumber);

    List<Supplier> findByCifAndPhoneNumberOrderByNameAsc(String cif, Integer phoneNumber);

    List<Supplier> findByCifAndPhoneNumberOrderByNameDesc(String cif, Integer phoneNumber);

    List<Supplier> findByCifAndPhoneNumberOrderByPostalCodeAsc(String cif, Integer phoneNumber);

    List<Supplier> findByCifAndPhoneNumberOrderByPostalCodeDesc(String cif, Integer phoneNumber);

    List<Supplier> findByCifAndPhoneNumberOrderByEmailAsc(String cif, Integer phoneNumber);

    List<Supplier> findByCifAndPhoneNumberOrderByEmailDesc(String cif, Integer phoneNumber);

    List<Supplier> findByCifAndPhoneNumberOrderByPhoneNumberAsc(String cif, Integer phoneNumber);

    List<Supplier> findByCifAndPhoneNumberOrderByPhoneNumberDesc(String cif, Integer phoneNumber);

    List<Supplier> findByCifAndPostalCodeBetweenOrderByCifDesc(String cif, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeGreaterThanOrderByPhoneNumberDesc(String cif, Integer postalCodeA);

    List<Supplier> findByCifAndPostalCodeLessThanOrderByCifAsc(String cif, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeLessThanOrderByCifDesc(String cif, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeLessThanOrderByNameAsc(String cif, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeLessThanOrderByNameDesc(String cif, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeLessThanOrderByPostalCodeAsc(String cif, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeLessThanOrderByPostalCodeDesc(String cif, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeLessThanOrderByEmailAsc(String cif, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeLessThanOrderByEmailDesc(String cif, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeLessThanOrderByPhoneNumberAsc(String cif, Integer postalCodeB);

    List<Supplier> findByCifAndPostalCodeLessThanOrderByPhoneNumberDesc(String cif, Integer postalCodeB);

    List<Supplier> findByNameContainingOrderByNameAsc(String name);

    List<Supplier> findByNameContainingOrderByNameDesc(String name);

    List<Supplier> findByNameContainingAndEmailOrderByCifAsc(String name, String email);

    List<Supplier> findByNameContainingAndEmailOrderByCifDesc(String name, String email);

    List<Supplier> findByNameContainingAndEmailOrderByNameAsc(String name, String email);

    List<Supplier> findByNameContainingAndEmailOrderByNameDesc(String name, String email);

    List<Supplier> findByNameContainingAndEmailOrderByPostalCodeAsc(String name, String email);

    List<Supplier> findByNameContainingAndEmailOrderByPostalCodeDesc(String name, String email);

    List<Supplier> findByNameContainingAndEmailOrderByEmailAsc(String name, String email);

    List<Supplier> findByNameContainingAndEmailOrderByEmailDesc(String name, String email);

    List<Supplier> findByNameContainingAndEmailOrderByPhoneNumberAsc(String name, String email);

    List<Supplier> findByNameContainingAndEmailOrderByPhoneNumberDesc(String name, String email);

    List<Supplier> findByNameContainingAndPhoneNumberOrderByCifAsc(String name, Integer phoneNumber);

    List<Supplier> findByNameContainingAndPhoneNumberOrderByCifDesc(String name, Integer phoneNumber);

    List<Supplier> findByNameContainingAndPhoneNumberOrderByNameAsc(String name, Integer phoneNumber);

    List<Supplier> findByNameContainingAndPhoneNumberOrderByNameDesc(String name, Integer phoneNumber);

    List<Supplier> findByNameContainingAndPhoneNumberOrderByPostalCodeAsc(String name, Integer phoneNumber);

    List<Supplier> findByNameContainingAndPhoneNumberOrderByPostalCodeDesc(String name, Integer phoneNumber);

    List<Supplier> findByNameContainingAndPhoneNumberOrderByEmailAsc(String name, Integer phoneNumber);

    List<Supplier> findByNameContainingAndPhoneNumberOrderByEmailDesc(String name, Integer phoneNumber);

    List<Supplier> findByNameContainingAndPhoneNumberOrderByPhoneNumberAsc(String name, Integer phoneNumber);

    List<Supplier> findByNameContainingAndPhoneNumberOrderByPhoneNumberDesc(String name, Integer phoneNumber);

    List<Supplier> findByNameContainingAndPostalCodeBetweenOrderByCifAsc(String name, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeBetweenOrderByCifDesc(String name, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeBetweenOrderByNameAsc(String name, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeBetweenOrderByNameDesc(String name, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeBetweenOrderByPostalCodeAsc(String name, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeBetweenOrderByPostalCodeDesc(String name, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeBetweenOrderByEmailAsc(String name, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeBetweenOrderByEmailDesc(String name, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeBetweenOrderByPhoneNumberAsc(String name, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeBetweenOrderByPhoneNumberDesc(String name, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeGreaterThanOrderByCifAsc(String name, Integer postalCodeA);

    List<Supplier> findByNameContainingAndPostalCodeGreaterThanOrderByCifDesc(String name, Integer postalCodeA);

    List<Supplier> findByNameContainingAndPostalCodeGreaterThanOrderByNameAsc(String name, Integer postalCodeA);

    List<Supplier> findByNameContainingAndPostalCodeGreaterThanOrderByNameDesc(String name, Integer postalCodeA);

    List<Supplier> findByNameContainingAndPostalCodeGreaterThanOrderByPostalCodeAsc(String name, Integer postalCodeA);

    List<Supplier> findByNameContainingAndPostalCodeGreaterThanOrderByPostalCodeDesc(String name, Integer postalCodeA);

    List<Supplier> findByNameContainingAndPostalCodeGreaterThanOrderByEmailAsc(String name, Integer postalCodeA);

    List<Supplier> findByNameContainingAndPostalCodeGreaterThanOrderByEmailDesc(String name, Integer postalCodeA);

    List<Supplier> findByNameContainingAndPostalCodeGreaterThanOrderByPhoneNumberAsc(String name, Integer postalCodeA);

    List<Supplier> findByNameContainingAndPostalCodeGreaterThanOrderByPhoneNumberDesc(String name, Integer postalCodeA);

    List<Supplier> findByNameContainingAndPostalCodeLessThanOrderByCifAsc(String name, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeLessThanOrderByCifDesc(String name, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeLessThanOrderByNameAsc(String name, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeLessThanOrderByNameDesc(String name, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeLessThanOrderByPostalCodeAsc(String name, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeLessThanOrderByPostalCodeDesc(String name, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeLessThanOrderByEmailAsc(String name, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeLessThanOrderByEmailDesc(String name, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeLessThanOrderByPhoneNumberAsc(String name, Integer postalCodeB);

    List<Supplier> findByNameContainingAndPostalCodeLessThanOrderByPhoneNumberDesc(String name, Integer postalCodeB);

    List<Supplier> findByEmailOrderByEmailAsc(String email);

    List<Supplier> findByEmailOrderByEmailDesc(String email);

    List<Supplier> findByEmailAndPhoneNumberOrderByCifAsc(String email, Integer phoneNumber);

    List<Supplier> findByEmailAndPhoneNumberOrderByCifDesc(String email, Integer phoneNumber);

    List<Supplier> findByEmailAndPhoneNumberOrderByNameAsc(String email, Integer phoneNumber);

    List<Supplier> findByEmailAndPhoneNumberOrderByNameDesc(String email, Integer phoneNumber);

    List<Supplier> findByEmailAndPhoneNumberOrderByPostalCodeAsc(String email, Integer phoneNumber);

    List<Supplier> findByEmailAndPhoneNumberOrderByPostalCodeDesc(String email, Integer phoneNumber);

    List<Supplier> findByEmailAndPhoneNumberOrderByEmailAsc(String email, Integer phoneNumber);

    List<Supplier> findByEmailAndPhoneNumberOrderByEmailDesc(String email, Integer phoneNumber);

    List<Supplier> findByEmailAndPhoneNumberOrderByPhoneNumberAsc(String email, Integer phoneNumber);

    List<Supplier> findByEmailAndPhoneNumberOrderByPhoneNumberDesc(String email, Integer phoneNumber);

    List<Supplier> findByEmailAndPostalCodeBetweenOrderByCifAsc(String email, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeBetweenOrderByCifDesc(String email, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeBetweenOrderByNameAsc(String email, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeBetweenOrderByNameDesc(String email, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeBetweenOrderByPostalCodeAsc(String email, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeBetweenOrderByPostalCodeDesc(String email, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeBetweenOrderByEmailAsc(String email, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeBetweenOrderByEmailDesc(String email, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeBetweenOrderByPhoneNumberAsc(String email, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeBetweenOrderByPhoneNumberDesc(String email, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeGreaterThanOrderByCifAsc(String email, Integer postalCodeA);

    List<Supplier> findByEmailAndPostalCodeGreaterThanOrderByCifDesc(String email, Integer postalCodeA);

    List<Supplier> findByEmailAndPostalCodeGreaterThanOrderByNameAsc(String email, Integer postalCodeA);

    List<Supplier> findByEmailAndPostalCodeGreaterThanOrderByNameDesc(String email, Integer postalCodeA);

    List<Supplier> findByEmailAndPostalCodeGreaterThanOrderByPostalCodeAsc(String email, Integer postalCodeA);

    List<Supplier> findByEmailAndPostalCodeGreaterThanOrderByPostalCodeDesc(String email, Integer postalCodeA);

    List<Supplier> findByEmailAndPostalCodeGreaterThanOrderByEmailAsc(String email, Integer postalCodeA);

    List<Supplier> findByEmailAndPostalCodeGreaterThanOrderByEmailDesc(String email, Integer postalCodeA);

    List<Supplier> findByEmailAndPostalCodeGreaterThanOrderByPhoneNumberAsc(String email, Integer postalCodeA);

    List<Supplier> findByEmailAndPostalCodeGreaterThanOrderByPhoneNumberDesc(String email, Integer postalCodeA);

    List<Supplier> findByEmailAndPostalCodeLessThanOrderByCifAsc(String email, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeLessThanOrderByCifDesc(String email, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeLessThanOrderByNameAsc(String email, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeLessThanOrderByNameDesc(String email, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeLessThanOrderByPostalCodeAsc(String email, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeLessThanOrderByPostalCodeDesc(String email, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeLessThanOrderByEmailAsc(String email, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeLessThanOrderByEmailDesc(String email, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeLessThanOrderByPhoneNumberAsc(String email, Integer postalCodeB);

    List<Supplier> findByEmailAndPostalCodeLessThanOrderByPhoneNumberDesc(String email, Integer postalCodeB);

    List<Supplier> findByPhoneNumberOrderByCifAsc(Integer phoneNumber);

    List<Supplier> findByPhoneNumberOrderByCifDesc(Integer phoneNumber);

    List<Supplier> findByPhoneNumberOrderByNameAsc(Integer phoneNumber);

    List<Supplier> findByPhoneNumberOrderByNameDesc(Integer phoneNumber);

    List<Supplier> findByPhoneNumberOrderByPostalCodeAsc(Integer phoneNumber);

    List<Supplier> findByPhoneNumberOrderByPostalCodeDesc(Integer phoneNumber);

    List<Supplier> findByPhoneNumberOrderByEmailAsc(Integer phoneNumber);

    List<Supplier> findByPhoneNumberOrderByEmailDesc(Integer phoneNumber);

    List<Supplier> findByPhoneNumberOrderByPhoneNumberAsc(Integer phoneNumber);

    List<Supplier> findByPhoneNumberOrderByPhoneNumberDesc(Integer phoneNumber);

    List<Supplier> findByPhoneNumberAndPostalCodeBetweenOrderByCifAsc(Integer phoneNumber, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeBetweenOrderByCifDesc(Integer phoneNumber, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeBetweenOrderByNameAsc(Integer phoneNumber, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeBetweenOrderByNameDesc(Integer phoneNumber, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeBetweenOrderByPostalCodeAsc(Integer phoneNumber, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeBetweenOrderByPostalCodeDesc(Integer phoneNumber, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeBetweenOrderByEmailAsc(Integer phoneNumber, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeBetweenOrderByEmailDesc(Integer phoneNumber, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeBetweenOrderByPhoneNumberAsc(Integer phoneNumber, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeBetweenOrderByPhoneNumberDesc(Integer phoneNumber, Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeGreaterThanOrderByCifAsc(Integer phoneNumber, Integer postalCodeA);

    List<Supplier> findByPhoneNumberAndPostalCodeGreaterThanOrderByCifDesc(Integer phoneNumber, Integer postalCodeA);

    List<Supplier> findByPhoneNumberAndPostalCodeGreaterThanOrderByNameAsc(Integer phoneNumber, Integer postalCodeA);

    List<Supplier> findByPhoneNumberAndPostalCodeGreaterThanOrderByNameDesc(Integer phoneNumber, Integer postalCodeA);

    List<Supplier> findByPhoneNumberAndPostalCodeGreaterThanOrderByPostalCodeAsc(Integer phoneNumber, Integer postalCodeA);

    List<Supplier> findByPhoneNumberAndPostalCodeGreaterThanOrderByPostalCodeDesc(Integer phoneNumber, Integer postalCodeA);

    List<Supplier> findByPhoneNumberAndPostalCodeGreaterThanOrderByEmailAsc(Integer phoneNumber, Integer postalCodeA);

    List<Supplier> findByPhoneNumberAndPostalCodeGreaterThanOrderByEmailDesc(Integer phoneNumber, Integer postalCodeA);

    List<Supplier> findByPhoneNumberAndPostalCodeGreaterThanOrderByPhoneNumberAsc(Integer phoneNumber, Integer postalCodeA);

    List<Supplier> findByPhoneNumberAndPostalCodeGreaterThanOrderByPhoneNumberDesc(Integer phoneNumber, Integer postalCodeA);

    List<Supplier> findByPhoneNumberAndPostalCodeLessThanOrderByCifAsc(Integer phoneNumber, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeLessThanOrderByCifDesc(Integer phoneNumber, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeLessThanOrderByNameAsc(Integer phoneNumber, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeLessThanOrderByNameDesc(Integer phoneNumber, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeLessThanOrderByPostalCodeAsc(Integer phoneNumber, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeLessThanOrderByPostalCodeDesc(Integer phoneNumber, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeLessThanOrderByEmailAsc(Integer phoneNumber, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeLessThanOrderByEmailDesc(Integer phoneNumber, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeLessThanOrderByPhoneNumberAsc(Integer phoneNumber, Integer postalCodeB);

    List<Supplier> findByPhoneNumberAndPostalCodeLessThanOrderByPhoneNumberDesc(Integer phoneNumber, Integer postalCodeB);

    List<Supplier> findByPostalCodeBetweenOrderByCifAsc(Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPostalCodeBetweenOrderByCifDesc(Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPostalCodeBetweenOrderByNameAsc(Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPostalCodeBetweenOrderByNameDesc(Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPostalCodeBetweenOrderByPostalCodeAsc(Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPostalCodeBetweenOrderByPostalCodeDesc(Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPostalCodeBetweenOrderByEmailAsc(Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPostalCodeBetweenOrderByEmailDesc(Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPostalCodeBetweenOrderByPhoneNumberAsc(Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPostalCodeBetweenOrderByPhoneNumberDesc(Integer postalCodeA, Integer postalCodeB);

    List<Supplier> findByPostalCodeGreaterThanOrderByCifAsc(Integer postalCodeA);

    List<Supplier> findByPostalCodeGreaterThanOrderByCifDesc(Integer postalCodeA);

    List<Supplier> findByPostalCodeGreaterThanOrderByNameAsc(Integer postalCodeA);

    List<Supplier> findByPostalCodeGreaterThanOrderByNameDesc(Integer postalCodeA);

    List<Supplier> findByPostalCodeGreaterThanOrderByPostalCodeAsc(Integer postalCodeA);

    List<Supplier> findByPostalCodeGreaterThanOrderByPostalCodeDesc(Integer postalCodeA);

    List<Supplier> findByPostalCodeGreaterThanOrderByEmailAsc(Integer postalCodeA);

    List<Supplier> findByPostalCodeGreaterThanOrderByEmailDesc(Integer postalCodeA);

    List<Supplier> findByPostalCodeGreaterThanOrderByPhoneNumberAsc(Integer postalCodeA);

    List<Supplier> findByPostalCodeGreaterThanOrderByPhoneNumberDesc(Integer postalCodeA);

    List<Supplier> findByPostalCodeLessThanOrderByCifAsc(Integer postalCodeB);

    List<Supplier> findByPostalCodeLessThanOrderByCifDesc(Integer postalCodeB);

    List<Supplier> findByPostalCodeLessThanOrderByNameAsc(Integer postalCodeB);

    List<Supplier> findByPostalCodeLessThanOrderByNameDesc(Integer postalCodeB);

    List<Supplier> findByPostalCodeLessThanOrderByPostalCodeAsc(Integer postalCodeB);

    List<Supplier> findByPostalCodeLessThanOrderByPostalCodeDesc(Integer postalCodeB);

    List<Supplier> findByPostalCodeLessThanOrderByEmailAsc(Integer postalCodeB);

    List<Supplier> findByPostalCodeLessThanOrderByEmailDesc(Integer postalCodeB);

    List<Supplier> findByPostalCodeLessThanOrderByPhoneNumberAsc(Integer postalCodeB);
}
