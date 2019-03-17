package com.sdz.museonumismatica.repositories;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sdz.museonumismatica.Coin;
import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.Supplier;

/**
 * @author Jorge Chavero Morcillo
 * Implementacion del repositorio de monedas
 */
public interface CoinRepository extends JpaRepository<Coin, Long> {
	// Busqueda por modelo
	List<Coin> findAllByCoinModel(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByCoinYearDesc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByCoinYearAsc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByAcquisitionDateDesc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByAcquisitionDateAsc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByCoinLocationDesc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByCoinLocationAsc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByPreservationStateDesc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByPreservationStateAsc(CoinModel coinModel);

	// Busqueda por año de la moneda
	List<Coin> findAllByCoinYear(int year);
	List<Coin> findAllByCoinYearBetween(int yearStart, int yearEnd);
	List<Coin> findAllByCoinYearBefore(int year);
	List<Coin> findAllByCoinYearAfter(int year);

	// Busqueda por adquisición de la moneda
	List<Coin> findAllByAcquisitionDate(Date date);
	List<Coin> findAllByAcquisitionDateBetween(Date dateStart, Date dateEnd);
	List<Coin> findAllByAcquisitionDateBefore(Date date);
	List<Coin> findAllByAcquisitionDateAfter(Date date);

	//Busqueda por localización de la moneda
	List<Coin> findAllByCoinLocation(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByCoinYearDesc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByCoinYearAsc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByAcquisitionDateDesc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByAcquisitionDateAsc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByPreservationStateDesc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByPreservationStateAsc(String coinLocation);

	//Busqueda por estado de la moneda
	List<Coin> findAllByPreservationState(String state);
	List<Coin> findAllByPreservationStateOrderByCoinYearDesc(String state);
	List<Coin> findAllByPreservationStateOrderByCoinYearAsc(String state);
	List<Coin> findAllByPreservationStateOrderByAcquisitionDateDesc(String state);
	List<Coin> findAllByPreservationStateOrderByAcquisitionDateAsc(String state);
	List<Coin> findAllByPreservationStateOrderByCoinLocationDesc(String state);
	List<Coin> findAllByPreservationStateOrderByCoinLocationAsc(String state);

	//Busqueda por proveedor
	List<Coin> findAllBySupplier(Supplier supplier);
	List<Coin> findAllBySupplierOrderByCoinYearDesc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByCoinYearAsc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByAcquisitionDateDesc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByAcquisitionDateAsc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByCoinLocationDesc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByCoinLocationAsc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByPreservationStateDesc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByPreservationStateAsc(Supplier supplier);

	//Busqueda CoinModel And
	List<Coin> findAllByCoinModelAndCoinYear(CoinModel model, int year);
	List<Coin> findAllByCoinModelAndAcquisitionDate(CoinModel model, Date date);
	List<Coin> findAllByCoinModelAndCoinLocation(CoinModel model, String location);
	List<Coin> findAllByCoinModelAndPreservationState(CoinModel model, String state);
	List<Coin> findAllByCoinModelAndSupplier(CoinModel model, Supplier supplier);

	//Busqueda CoinYear And
	List<Coin> findAllByCoinYearAndAcquisitionDate(int model, Date date);
	List<Coin> findAllByCoinYearAndCoinLocation(int model, String location);
	List<Coin> findAllByCoinYearAndPreservationState(int model, String state);
	List<Coin> findAllByCoinYearAndSupplier(int model, Supplier supplier);

	//Busqueda Acquisition And
	List<Coin> findAllByAcquisitionDateAndCoinYear(Date date, int year);
	List<Coin> findAllByAcquisitionDateAndCoinLocation(Date date, String location);
	List<Coin> findAllByAcquisitionDateAndPreservationState(Date date, String state);
	List<Coin> findAllByAcquisitionDateAndSupplier(Date date, Supplier supplier);

	//Busqueda Location And
	List<Coin> findAllByCoinLocationAndCoinYear(String location, int year);
	List<Coin> findAllByCoinLocationAndAcquisitionDate(String location, Date date);
	List<Coin> findAllByCoinLocationAndPreservationState(String location, String state);
	List<Coin> findAllByCoinLocationAndSupplier(String location, Supplier supplier);

	//Busqueda State And
	List<Coin> findAllByPreservationStateAndCoinYear(String state, int year);
	List<Coin> findAllByPreservationStateAndAcquisitionDate(String state, Date date);
	List<Coin> findAllByPreservationStateAndCoinLocation(String state, String location);
	List<Coin> findAllByPreservationStateAndSupplier(String state, Supplier supplier);

	//Busqueda Supplier And
	List<Coin> findAllBySupplierAndCoinYear(Supplier supplier, int year);
	List<Coin> findAllBySupplierAndAcquisitionDate(Supplier supplier, Date date);
	List<Coin> findAllBySupplierAndCoinLocation(Supplier supplier, String location);
	List<Coin> findAllBySupplierAndPreservationState(Supplier supplier, String state);
}