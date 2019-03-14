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
	List<Coin> findAllByCoinModelOrderByYearDesc(CoinModel coinModel, int year);
	List<Coin> findAllByCoinModelOrderByYearAsc(CoinModel coinModel, int year);
	List<Coin> findAllByCoinModelOrderByDateDesc(CoinModel coinModel, Date date);
	List<Coin> findAllByCoinModelOrderByDateAsc(CoinModel coinModel, Date date);
	List<Coin> findAllByCoinModelOrderByLocationDesc(CoinModel coinModel, String location);
	List<Coin> findAllByCoinModelOrderByLocationAsc(CoinModel coinModel, String location);
	List<Coin> findAllByCoinModelOrderByStateDesc(CoinModel coinModel, String state);
	List<Coin> findAllByCoinModelOrderByStateAsc(CoinModel coinModel, String state);

	// Busqueda por año de la moneda
	List<Coin> findAllByYearBetween(int yearStart, int yearEnd);
	List<Coin> findAllByYearBefore(int year);
	List<Coin> findAllByYearAfter(int year);

	// Busqueda por adquisición de la moneda
	List<Coin> findAllByAcquisitionBetween(Date dateStart, Date dateEnd);
	List<Coin> findAllByAcquisitionBefore(Date date);
	List<Coin> findAllByAcquisitionAfter(Date date);

	//Busqueda por localización de la moneda
	List<Coin> findAllByLocationOrderByYearDesc(String coinLocation, int year);
	List<Coin> findAllByLocationOrderByYearAsc(String coinLocation, int year);
	List<Coin> findAllByLocationOrderByDateDesc(String coinLocation, Date date);
	List<Coin> findAllByLocationOrderByDateAsc(String coinLocation, Date date);
	List<Coin> findAllByLocationOrderByStateDesc(String coinLocation, String state);
	List<Coin> findAllByLocationOrderByStateAsc(String coinLocation, String state);

	//Busqueda por estado de la moneda
	List<Coin> findAllByStateOrderByYearDesc(String state, int year);
	List<Coin> findAllByStateOrderByYearAsc(String state, int year);
	List<Coin> findAllByStateOrderByDateDesc(String state, Date date);
	List<Coin> findAllByStateOrderByDateAsc(String state, Date date);
	List<Coin> findAllByStateOrderByLocationDesc(String coinLocation, String location);
	List<Coin> findAllByStateOrderByLocationAsc(String coinLocation, String location);

	//Busqueda por proveedor
	List<Coin> findAllBySupplierOrderByYearDesc(Supplier supplier, int year);
	List<Coin> findAllBySupplierOrderByYearAsc(Supplier supplier, int year);
	List<Coin> findAllBySupplierOrderByDateDesc(Supplier supplier, Date date);
	List<Coin> findAllBySupplierOrderByDateAsc(Supplier supplier, Date date);
	List<Coin> findAllBySupplierOrderByLocationDesc(Supplier supplier, String location);
	List<Coin> findAllBySupplierOrderByLocationAsc(Supplier supplier, String location);
	List<Coin> findAllBySupplierOrderByStateDesc(Supplier supplier, String state);
	List<Coin> findAllBySupplierOrderByStateAsc(Supplier supplier, String state);

	List<Coin> findAllByCoinModelAndYear(CoinModel model, int year);
	List<Coin> findAllByCoinModelAndAcquisition(CoinModel model, Date date);
	List<Coin> findAllByCoinModelAndLocation(CoinModel model, String location);
	List<Coin> findAllByCoinModelAndState(CoinModel model, String state);
	List<Coin> findAllByCoinModelAndSupplier(CoinModel model, Supplier supplier);

	List<Coin> findAllByYearAndAcquisition(int model, Date date);
	List<Coin> findAllByYearAndLocation(int model, String location);
	List<Coin> findAllByYearAndState(int model, String state);
	List<Coin> findAllByYearAndSupplier(int model, Supplier supplier);

	List<Coin> findAllByAcquisitionAndYear(Date date, int year);
	List<Coin> findAllByAcquisitionAndLocation(Date date, String location);
	List<Coin> findAllByAcquisitionAndState(Date date, String state);
	List<Coin> findAllByAcquisitionAndSupplier(Date date, Supplier supplier);

	List<Coin> findAllByLocationAndYear(String location, int year);
	List<Coin> findAllByLocationAndAcquisition(String location, Date date);
	List<Coin> findAllByLocationAndState(String location, String state);
	List<Coin> findAllByLocationAndSupplier(String location, Supplier supplier);

	List<Coin> findAllByStateAndYear(String state, int year);
	List<Coin> findAllByStateAndAcquisition(String state, Date date);
	List<Coin> findAllByStateAndLocation(String state, String location);
	List<Coin> findAllByStateAndSupplier(String state, Supplier supplier);

	List<Coin> findAllBySupplierAndYear(CoinModel model, int year);
	List<Coin> findAllBySupplierAndAcquisition(CoinModel model, Date date);
	List<Coin> findAllBySupplierAndLocation(CoinModel model, String location);
	List<Coin> findAllBySupplierAndState(CoinModel model, String state);
}