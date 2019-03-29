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
	List<Coin> findAllByCoinModelOrderByCoinModelDesc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByCoinModelAsc(CoinModel coinModel);
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
	List<Coin> findAllByCoinYearOrderByCoinYearAsc(int year);
	List<Coin> findAllByCoinYearOrderByCoinYearDesc(int year);
	List<Coin> findAllByCoinYearOrderByAcquisitionDateAsc(int year);
	List<Coin> findAllByCoinYearOrderByAcquisitionDateDesc(int year);
	List<Coin> findAllByCoinYearOrderByCoinLocationAsc(int year);
	List<Coin> findAllByCoinYearOrderByCoinLocationDesc(int year);
	List<Coin> findAllByCoinYearOrderByPreservationStateAsc(int year);
	List<Coin> findAllByCoinYearOrderByPreservationStateDesc(int year);
	List<Coin> findAllByCoinYearBefore(int year);
	List<Coin> findAllByCoinYearBeforeOrderByCoinYearAsc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByCoinYearDesc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByAcquisitionDateAsc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByAcquisitionDateDesc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByCoinLocationAsc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByCoinLocationDesc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByPreservationStateAsc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByPreservationStateDesc(int year);
	List<Coin> findAllByCoinYearAfter(int year);
	List<Coin> findAllByCoinYearAfterOrderByCoinYearAsc(int year);
	List<Coin> findAllByCoinYearAfterOrderByCoinYearDesc(int year);
	List<Coin> findAllByCoinYearAfterOrderByAcquisitionDateAsc(int year);
	List<Coin> findAllByCoinYearAfterOrderByAcquisitionDateDesc(int year);
	List<Coin> findAllByCoinYearAfterOrderByCoinLocationAsc(int year);
	List<Coin> findAllByCoinYearAfterOrderByCoinLocationDesc(int year);
	List<Coin> findAllByCoinYearAfterOrderByPreservationStateAsc(int year);
	List<Coin> findAllByCoinYearAfterOrderByPreservationStateDesc(int year);

	// Busqueda por adquisición de la moneda
	List<Coin> findAllByAcquisitionDate(Date date);
	List<Coin> findAllByAcquisitionDateOrderByAcquisitionDateAsc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByAcquisitionDateDesc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByCoinYearAsc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByCoinYearDesc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByCoinLocationAsc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByCoinLocationDesc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByPreservationStateAsc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByPreservationStateDesc(Date date);
	List<Coin> findAllByAcquisitionDateBefore(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByAcquisitionDateAsc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByAcquisitionDateDesc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByCoinYearAsc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByCoinYearDesc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByCoinLocationAsc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByCoinLocationDesc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByPreservationStateAsc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByPreservationStateDesc(Date date);
	List<Coin> findAllByAcquisitionDateAfter(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByAcquisitionDateAsc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByAcquisitionDateDesc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByCoinYearAsc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByCoinYearDesc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByCoinLocationAsc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByCoinLocationDesc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByPreservationStateAsc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByPreservationStateDesc(Date date);


	//Busqueda por localización de la moneda
	List<Coin> findAllByCoinLocation(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByCoinLocationDesc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByCoinLocationAsc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByCoinYearDesc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByCoinYearAsc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByAcquisitionDateDesc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByAcquisitionDateAsc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByPreservationStateDesc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByPreservationStateAsc(String coinLocation);

	//Busqueda por estado de la moneda
	List<Coin> findAllByPreservationState(String state);
	List<Coin> findAllByPreservationStateOrderByPreservationStateDesc(String state);
	List<Coin> findAllByPreservationStateOrderByPreservationStateAsc(String state);
	List<Coin> findAllByPreservationStateOrderByCoinYearDesc(String state);
	List<Coin> findAllByPreservationStateOrderByCoinYearAsc(String state);
	List<Coin> findAllByPreservationStateOrderByAcquisitionDateDesc(String state);
	List<Coin> findAllByPreservationStateOrderByAcquisitionDateAsc(String state);
	List<Coin> findAllByPreservationStateOrderByCoinLocationDesc(String state);
	List<Coin> findAllByPreservationStateOrderByCoinLocationAsc(String state);

	//Busqueda por proveedor
	List<Coin> findAllBySupplier(Supplier supplier);
	List<Coin> findAllBySupplierOrderBySupplierDesc(Supplier supplier);
	List<Coin> findAllBySupplierOrderBySupplierAsc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByCoinYearDesc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByCoinYearAsc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByAcquisitionDateDesc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByAcquisitionDateAsc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByCoinLocationDesc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByCoinLocationAsc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByPreservationStateDesc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByPreservationStateAsc(Supplier supplier);

	//Busqueda CoinModel And
	List<Coin> findAllByCoinModelAndCoinYearOrderByCoinYearDesc(CoinModel model, int year);
	List<Coin> findAllByCoinModelAndCoinYearOrderByCoinYearAsc(CoinModel model, int year);
	List<Coin> findAllByCoinModelAndCoinYearOrderByAcquisitionDateDesc(CoinModel model, int year);
	List<Coin> findAllByCoinModelAndCoinYearOrderByAcquisitionDateAsc(CoinModel model, int year);
	List<Coin> findAllByCoinModelAndCoinYearOrderByCoinLocationDesc(CoinModel model, int year);
	List<Coin> findAllByCoinModelAndCoinYearOrderByCoinLocationAsc(CoinModel model, int year);
	List<Coin> findAllByCoinModelAndCoinYearOrderByPreservationStateDesc(CoinModel model, int year);
	List<Coin> findAllByCoinModelAndCoinYearOrderByPreservationStateAsc(CoinModel model, int year);

	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByCoinYearDesc(CoinModel model, Date date);
	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByCoinYearAsc(CoinModel model, Date date);

	List<Coin> findAllByCoinModelAndCoinLocation(CoinModel model, String location);

	List<Coin> findAllByCoinModelAndPreservationState(CoinModel model, String state);

	List<Coin> findAllByCoinModelAndSupplier(CoinModel model, Supplier supplier);


	//Busqueda CoinYear And
	List<Coin> findAllByCoinYearAndAcquisitionDate(int year, Date date);
	List<Coin> findAllByCoinYearAndCoinLocation(int year, String location);
	List<Coin> findAllByCoinYearAndPreservationState(int year, String state);
	List<Coin> findAllByCoinYearAndSupplier(int year, Supplier supplier);

	//Busqueda Acquisition And
	List<Coin> findAllByAcquisitionDateAndCoinLocation(Date date, String location);
	List<Coin> findAllByAcquisitionDateAndPreservationState(Date date, String state);
	List<Coin> findAllByAcquisitionDateAndSupplier(Date date, Supplier supplier);

	//Busqueda Location And
	List<Coin> findAllByCoinLocationAndPreservationState(String location, String state);
	List<Coin> findAllByCoinLocationAndSupplier(String location, Supplier supplier);

	//Busqueda State And
	List<Coin> findAllByPreservationStateAndSupplier(String state, Supplier supplier);


}