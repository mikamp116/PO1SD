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
	List<Coin> findAllByCoinModelOrderByCoinYearDesc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByCoinYearAsc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByAcquisitionDateDesc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByAcquisitionDateAsc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByCoinLocationDesc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByCoinLocationAsc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByPreservationStateDesc(CoinModel coinModel);
	List<Coin> findAllByCoinModelOrderByPreservationStateAsc(CoinModel coinModel);

	// Busqueda por año de la moneda;
	List<Coin> findAllByCoinYearOrderByCoinYearAsc(int year);
	List<Coin> findAllByCoinYearOrderByCoinYearDesc(int year);
	List<Coin> findAllByCoinYearOrderByAcquisitionDateAsc(int year);
	List<Coin> findAllByCoinYearOrderByAcquisitionDateDesc(int year);
	List<Coin> findAllByCoinYearOrderByCoinLocationAsc(int year);
	List<Coin> findAllByCoinYearOrderByCoinLocationDesc(int year);
	List<Coin> findAllByCoinYearOrderByPreservationStateAsc(int year);
	List<Coin> findAllByCoinYearOrderByPreservationStateDesc(int year);

	List<Coin> findAllByCoinYearBeforeOrderByCoinYearAsc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByCoinYearDesc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByAcquisitionDateAsc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByAcquisitionDateDesc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByCoinLocationAsc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByCoinLocationDesc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByPreservationStateAsc(int year);
	List<Coin> findAllByCoinYearBeforeOrderByPreservationStateDesc(int year);

	List<Coin> findAllByCoinYearAfterOrderByCoinYearAsc(int year);
	List<Coin> findAllByCoinYearAfterOrderByCoinYearDesc(int year);
	List<Coin> findAllByCoinYearAfterOrderByAcquisitionDateAsc(int year);
	List<Coin> findAllByCoinYearAfterOrderByAcquisitionDateDesc(int year);
	List<Coin> findAllByCoinYearAfterOrderByCoinLocationAsc(int year);
	List<Coin> findAllByCoinYearAfterOrderByCoinLocationDesc(int year);
	List<Coin> findAllByCoinYearAfterOrderByPreservationStateAsc(int year);
	List<Coin> findAllByCoinYearAfterOrderByPreservationStateDesc(int year);

	// Busqueda por adquisición de la moneda
	List<Coin> findAllByAcquisitionDateOrderByAcquisitionDateAsc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByAcquisitionDateDesc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByCoinYearAsc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByCoinYearDesc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByCoinLocationAsc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByCoinLocationDesc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByPreservationStateAsc(Date date);
	List<Coin> findAllByAcquisitionDateOrderByPreservationStateDesc(Date date);

	List<Coin> findAllByAcquisitionDateBeforeOrderByAcquisitionDateAsc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByAcquisitionDateDesc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByCoinYearAsc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByCoinYearDesc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByCoinLocationAsc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByCoinLocationDesc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByPreservationStateAsc(Date date);
	List<Coin> findAllByAcquisitionDateBeforeOrderByPreservationStateDesc(Date date);

	List<Coin> findAllByAcquisitionDateAfterOrderByAcquisitionDateAsc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByAcquisitionDateDesc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByCoinYearAsc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByCoinYearDesc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByCoinLocationAsc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByCoinLocationDesc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByPreservationStateAsc(Date date);
	List<Coin> findAllByAcquisitionDateAfterOrderByPreservationStateDesc(Date date);


	//Busqueda por localización de la moneda
	List<Coin> findAllByCoinLocationOrderByCoinLocationDesc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByCoinLocationAsc(String coinLocation);

	List<Coin> findAllByCoinLocationOrderByCoinYearDesc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByCoinYearAsc(String coinLocation);

	List<Coin> findAllByCoinLocationOrderByAcquisitionDateDesc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByAcquisitionDateAsc(String coinLocation);

	List<Coin> findAllByCoinLocationOrderByPreservationStateDesc(String coinLocation);
	List<Coin> findAllByCoinLocationOrderByPreservationStateAsc(String coinLocation);

	//Busqueda por estado de la moneda
	List<Coin> findAllByPreservationStateOrderByPreservationStateDesc(String state);
	List<Coin> findAllByPreservationStateOrderByPreservationStateAsc(String state);

	List<Coin> findAllByPreservationStateOrderByCoinYearDesc(String state);
	List<Coin> findAllByPreservationStateOrderByCoinYearAsc(String state);

	List<Coin> findAllByPreservationStateOrderByAcquisitionDateDesc(String state);
	List<Coin> findAllByPreservationStateOrderByAcquisitionDateAsc(String state);

	List<Coin> findAllByPreservationStateOrderByCoinLocationDesc(String state);
	List<Coin> findAllByPreservationStateOrderByCoinLocationAsc(String state);

	//Busqueda por proveedor
	List<Coin> findAllBySupplierOrderByCoinYearDesc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByCoinYearAsc(Supplier supplier);

	List<Coin> findAllBySupplierOrderByAcquisitionDateDesc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByAcquisitionDateAsc(Supplier supplier);

	List<Coin> findAllBySupplierOrderByCoinLocationDesc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByCoinLocationAsc(Supplier supplier);

	List<Coin> findAllBySupplierOrderByPreservationStateDesc(Supplier supplier);
	List<Coin> findAllBySupplierOrderByPreservationStateAsc(Supplier supplier);

	//AND(Ordenar por año de moneda)
	//CoinModel
	List<Coin> findAllByCoinModelAndSupplierOrderByCoinYearAsc(CoinModel queryCoin, Supplier querySupplier);
	List<Coin> findAllByCoinModelAndSupplierOrderByCoinYearDesc(CoinModel queryCoin, Supplier querySupplier);

	List<Coin> findAllByCoinModelAndCoinYearOrderByCoinYearAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearOrderByCoinYearDesc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearBeforeOrderByCoinYearAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearBeforeOrderByCoinYearDesc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearAfterOrderByCoinYearAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearAfterOrderByCoinYearDesc(CoinModel queryCoin, int queryY);

	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByCoinYearAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByCoinYearDesc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateBeforeOrderByCoinYearAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateBeforeOrderByCoinYearDesc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateAfterOrderByCoinYearAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateAfterOrderByCoinYearDesc(CoinModel queryCoin, Date queryDate);

	List<Coin> findAllByCoinModelAndCoinLocationOrderByCoinYearAsc(CoinModel queryCoin, String query);
	List<Coin> findAllByCoinModelAndCoinLocationOrderByCoinYearDesc(CoinModel queryCoin, String query);

	List<Coin> findAllByCoinModelAndPreservationStateOrderByCoinYearAsc(CoinModel queryCoin, String query2);
	List<Coin> findAllByCoinModelAndPreservationStateOrderByCoinYearDesc(CoinModel queryCoin, String query2);

	//Supplier
	List<Coin> findAllBySupplierAndCoinYearOrderByCoinYearAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearOrderByCoinYearDesc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearBeforeOrderByCoinYearAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearBeforeOrderByCoinYearDesc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearAfterOrderByCoinYearAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearAfterOrderByCoinYearDesc(Supplier querySupplier, int queryY);

	List<Coin> findAllBySupplierAndAcquisitionDateOrderByCoinYearAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateOrderByCoinYearDesc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateBeforeOrderByCoinYearAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateBeforeOrderByCoinYearDesc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateAfterOrderByCoinYearAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateAfterOrderByCoinYearDesc(Supplier querySupplier, Date queryDate);

	List<Coin> findAllBySupplierAndCoinLocationOrderByCoinYearAsc(Supplier querySupplier, String query);
	List<Coin> findAllBySupplierAndCoinLocationOrderByCoinYearDesc(Supplier querySupplier, String query);

	List<Coin> findAllBySupplierAndPreservationStateOrderByCoinYearAsc(Supplier querySupplier, String query2);
	List<Coin> findAllBySupplierAndPreservationStateOrderByCoinYearDesc(Supplier querySupplier, String query2);

	//CoinYear
	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByCoinYearAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByCoinYearDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateBeforeOrderByCoinYearAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateBeforeOrderByCoinYearDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateAfterOrderByCoinYearAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateAfterOrderByCoinYearDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateOrderByCoinYearAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateOrderByCoinYearDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByCoinYearAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByCoinYearDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByCoinYearAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByCoinYearDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateOrderByCoinYearAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateOrderByCoinYearDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByCoinYearAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByCoinYearDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateAfterOrderByCoinYearAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateAfterOrderByCoinYearDesc(int queryY, Date queryDate);

	List<Coin> findAllByCoinYearAndCoinLocationOrderByCoinYearAsc(int queryY, String query);
	List<Coin> findAllByCoinYearAndCoinLocationOrderByCoinYearDesc(int queryY, String query);
	List<Coin> findAllByCoinYearBeforeAndCoinLocationOrderByCoinYearAsc(int queryY, String query);
	List<Coin> findAllByCoinYearBeforeAndCoinLocationOrderByCoinYearDesc(int queryY, String query);
	List<Coin> findAllByCoinYearAfterAndCoinLocationOrderByCoinYearAsc(int queryY, String query);
	List<Coin> findAllByCoinYearAfterAndCoinLocationOrderByCoinYearDesc(int queryY, String query);

	List<Coin> findAllByCoinYearAndPreservationStateOrderByCoinYearAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearAndPreservationStateOrderByCoinYearDesc(int queryY, String query2);
	List<Coin> findAllByCoinYearBeforeAndPreservationStateOrderByCoinYearAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearBeforeAndPreservationStateOrderByCoinYearDesc(int queryY, String query2);
	List<Coin> findAllByCoinYearAfterAndPreservationStateOrderByCoinYearAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearAfterAndPreservationStateOrderByCoinYearDesc(int queryY, String query2);

	//AcquisitionDate
	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByCoinYearAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByCoinYearDesc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateBeforeAndCoinLocationOrderByCoinYearAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateBeforeAndCoinLocationOrderByCoinYearDesc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAfterAndCoinLocationOrderByCoinYearAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAfterAndCoinLocationOrderByCoinYearDesc(Date queryDate, String query);

	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByCoinYearAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByCoinYearDesc(Date queryDate, String query2);

	//CoinLocation
	List<Coin> findAllByCoinLocationAndPreservationStateOrderByCoinYearAsc(String query, String query2);
	List<Coin> findAllByCoinLocationAndPreservationStateOrderByCoinYearDesc(String query, String query2);
	List<Coin> findAllByAcquisitionDateBeforeAndPreservationStateOrderByCoinYearAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateBeforeAndPreservationStateOrderByCoinYearDesc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAfterAndPreservationStateOrderByCoinYearAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAfterAndPreservationStateOrderByCoinYearDesc(Date queryDate, String query2);

	//AND(Ordenar por fecha de adquisicion)
	//CoinModel
	List<Coin> findAllByCoinModelAndSupplierOrderByAcquisitionDateAsc(CoinModel queryCoin, Supplier querySupplier);
	List<Coin> findAllByCoinModelAndSupplierOrderByAcquisitionDateDesc(CoinModel queryCoin, Supplier querySupplier);

	List<Coin> findAllByCoinModelAndCoinYearOrderByAcquisitionDateAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearOrderByAcquisitionDateDesc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearBeforeOrderByAcquisitionDateAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearBeforeOrderByAcquisitionDateDesc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearAfterOrderByAcquisitionDateAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearAfterOrderByAcquisitionDateDesc(CoinModel queryCoin, int queryY);

	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByAcquisitionDateAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByAcquisitionDateDesc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateAfterOrderByAcquisitionDateAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateAfterOrderByAcquisitionDateDesc(CoinModel queryCoin, Date queryDate);

	List<Coin> findAllByCoinModelAndCoinLocationOrderByAcquisitionDateAsc(CoinModel queryCoin, String query);
	List<Coin> findAllByCoinModelAndCoinLocationOrderByAcquisitionDateDesc(CoinModel queryCoin, String query);

	List<Coin> findAllByCoinModelAndPreservationStateOrderByAcquisitionDateAsc(CoinModel queryCoin, String query2);
	List<Coin> findAllByCoinModelAndPreservationStateOrderByAcquisitionDateDesc(CoinModel queryCoin, String query2);

	//Supplier
	List<Coin> findAllBySupplierAndCoinYearOrderByAcquisitionDateAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearOrderByAcquisitionDateDesc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearBeforeOrderByAcquisitionDateAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearBeforeOrderByAcquisitionDateDesc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearAfterOrderByAcquisitionDateAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearAfterOrderByAcquisitionDateDesc(Supplier querySupplier, int queryY);

	List<Coin> findAllBySupplierAndAcquisitionDateOrderByAcquisitionDateAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateOrderByAcquisitionDateDesc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateAfterOrderByAcquisitionDateAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateAfterOrderByAcquisitionDateDesc(Supplier querySupplier, Date queryDate);

	List<Coin> findAllBySupplierAndCoinLocationOrderByAcquisitionDateAsc(Supplier querySupplier, String query);
	List<Coin> findAllBySupplierAndCoinLocationOrderByAcquisitionDateDesc(Supplier querySupplier, String query);

	List<Coin> findAllBySupplierAndPreservationStateOrderByAcquisitionDateAsc(Supplier querySupplier, String query2);
	List<Coin> findAllBySupplierAndPreservationStateOrderByAcquisitionDateDesc(Supplier querySupplier, String query2);

	//CoinYear
	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByAcquisitionDateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByAcquisitionDateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateAfterOrderByAcquisitionDateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateAfterOrderByAcquisitionDateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateOrderByAcquisitionDateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateOrderByAcquisitionDateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByAcquisitionDateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByAcquisitionDateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateOrderByAcquisitionDateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateOrderByAcquisitionDateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByAcquisitionDateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByAcquisitionDateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateAfterOrderByAcquisitionDateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateAfterOrderByAcquisitionDateDesc(int queryY, Date queryDate);

	List<Coin> findAllByCoinYearAndCoinLocationOrderByAcquisitionDateAsc(int queryY, String query);
	List<Coin> findAllByCoinYearAndCoinLocationOrderByAcquisitionDateDesc(int queryY, String query);
	List<Coin> findAllByCoinYearBeforeAndCoinLocationOrderByAcquisitionDateAsc(int queryY, String query);
	List<Coin> findAllByCoinYearBeforeAndCoinLocationOrderByAcquisitionDateDesc(int queryY, String query);
	List<Coin> findAllByCoinYearAfterAndCoinLocationOrderByAcquisitionDateAsc(int queryY, String query);
	List<Coin> findAllByCoinYearAfterAndCoinLocationOrderByAcquisitionDateDesc(int queryY, String query);

	List<Coin> findAllByCoinYearAndPreservationStateOrderByAcquisitionDateAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearAndPreservationStateOrderByAcquisitionDateDesc(int queryY, String query2);
	List<Coin> findAllByCoinYearBeforeAndPreservationStateOrderByAcquisitionDateAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearBeforeAndPreservationStateOrderByAcquisitionDateDesc(int queryY, String query2);
	List<Coin> findAllByCoinYearAfterAndPreservationStateOrderByAcquisitionDateAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearAfterAndPreservationStateOrderByAcquisitionDateDesc(int queryY, String query2);

	//AcquisitionDate
	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByAcquisitionDateAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByAcquisitionDateDesc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateBeforeAndCoinLocationOrderByAcquisitionDateAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateBeforeAndCoinLocationOrderByAcquisitionDateDesc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAfterAndCoinLocationOrderByAcquisitionDateAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAfterAndCoinLocationOrderByAcquisitionDateDesc(Date queryDate, String query);

	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByAcquisitionDateAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByAcquisitionDateDesc(Date queryDate, String query2);

	//CoinLocation
	List<Coin> findAllByCoinLocationAndPreservationStateOrderByAcquisitionDateAsc(String query, String query2);
	List<Coin> findAllByCoinLocationAndPreservationStateOrderByAcquisitionDateDesc(String query, String query2);
	List<Coin> findAllByAcquisitionDateBeforeAndPreservationStateOrderByAcquisitionDateAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateBeforeAndPreservationStateOrderByAcquisitionDateDesc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAfterAndPreservationStateOrderByAcquisitionDateAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAfterAndPreservationStateOrderByAcquisitionDateDesc(Date queryDate, String query2);

	//AND(Ordenar por localizacion de la moneda)
	//CoinModel
	List<Coin> findAllByCoinModelAndSupplierOrderByCoinLocationAsc(CoinModel queryCoin, Supplier querySupplier);
	List<Coin> findAllByCoinModelAndSupplierOrderByCoinLocationDesc(CoinModel queryCoin, Supplier querySupplier);

	List<Coin> findAllByCoinModelAndCoinYearOrderByCoinLocationAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearOrderByCoinLocationDesc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearBeforeOrderByCoinLocationAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearBeforeOrderByCoinLocationDesc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearAfterOrderByCoinLocationAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearAfterOrderByCoinLocationDesc(CoinModel queryCoin, int queryY);

	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByCoinLocationAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByCoinLocationDesc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateBeforeOrderByCoinLocationAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateBeforeOrderByCoinLocationDesc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateAfterOrderByCoinLocationAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateAfterOrderByCoinLocationDesc(CoinModel queryCoin, Date queryDate);

	List<Coin> findAllByCoinModelAndCoinLocationOrderByCoinLocationAsc(CoinModel queryCoin, String query);
	List<Coin> findAllByCoinModelAndCoinLocationOrderByCoinLocationDesc(CoinModel queryCoin, String query);

	List<Coin> findAllByCoinModelAndPreservationStateOrderByCoinLocationAsc(CoinModel queryCoin, String query2);
	List<Coin> findAllByCoinModelAndPreservationStateOrderByCoinLocationDesc(CoinModel queryCoin, String query2);

	//Supplier
	List<Coin> findAllBySupplierAndCoinYearOrderByCoinLocationAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearOrderByCoinLocationDesc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearBeforeOrderByCoinLocationAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearBeforeOrderByCoinLocationDesc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearAfterOrderByCoinLocationAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearAfterOrderByCoinLocationDesc(Supplier querySupplier, int queryY);

	List<Coin> findAllBySupplierAndAcquisitionDateOrderByCoinLocationAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateOrderByCoinLocationDesc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateBeforeOrderByCoinLocationAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateBeforeOrderByCoinLocationDesc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateAfterOrderByCoinLocationAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateAfterOrderByCoinLocationDesc(Supplier querySupplier, Date queryDate);

	List<Coin> findAllBySupplierAndCoinLocationOrderByCoinLocationAsc(Supplier querySupplier, String query);
	List<Coin> findAllBySupplierAndCoinLocationOrderByCoinLocationDesc(Supplier querySupplier, String query);

	List<Coin> findAllBySupplierAndPreservationStateOrderByCoinLocationAsc(Supplier querySupplier, String query2);
	List<Coin> findAllBySupplierAndPreservationStateOrderByCoinLocationDesc(Supplier querySupplier, String query2);

	//CoinYear
	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByCoinLocationAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByCoinLocationDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateBeforeOrderByCoinLocationAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateBeforeOrderByCoinLocationDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateAfterOrderByCoinLocationAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateAfterOrderByCoinLocationDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateOrderByCoinLocationAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateOrderByCoinLocationDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByCoinLocationAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByCoinLocationDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByCoinLocationAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByCoinLocationDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateOrderByCoinLocationAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateOrderByCoinLocationDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByCoinLocationAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByCoinLocationDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateAfterOrderByCoinLocationAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateAfterOrderByCoinLocationDesc(int queryY, Date queryDate);

	List<Coin> findAllByCoinYearAndCoinLocationOrderByCoinLocationAsc(int queryY, String query);
	List<Coin> findAllByCoinYearAndCoinLocationOrderByCoinLocationDesc(int queryY, String query);
	List<Coin> findAllByCoinYearBeforeAndCoinLocationOrderByCoinLocationAsc(int queryY, String query);
	List<Coin> findAllByCoinYearBeforeAndCoinLocationOrderByCoinLocationDesc(int queryY, String query);
	List<Coin> findAllByCoinYearAfterAndCoinLocationOrderByCoinLocationAsc(int queryY, String query);
	List<Coin> findAllByCoinYearAfterAndCoinLocationOrderByCoinLocationDesc(int queryY, String query);

	List<Coin> findAllByCoinYearAndPreservationStateOrderByCoinLocationAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearAndPreservationStateOrderByCoinLocationDesc(int queryY, String query2);
	List<Coin> findAllByCoinYearBeforeAndPreservationStateOrderByCoinLocationAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearBeforeAndPreservationStateOrderByCoinLocationDesc(int queryY, String query2);
	List<Coin> findAllByCoinYearAfterAndPreservationStateOrderByCoinLocationAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearAfterAndPreservationStateOrderByCoinLocationDesc(int queryY, String query2);

	//AcquisitionDate
	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByCoinLocationAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByCoinLocationDesc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateBeforeAndCoinLocationOrderByCoinLocationAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateBeforeAndCoinLocationOrderByCoinLocationDesc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAfterAndCoinLocationOrderByCoinLocationAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAfterAndCoinLocationOrderByCoinLocationDesc(Date queryDate, String query);

	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByCoinLocationAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByCoinLocationDesc(Date queryDate, String query2);

	//CoinLocation
	List<Coin> findAllByCoinLocationAndPreservationStateOrderByCoinLocationAsc(String query, String query2);
	List<Coin> findAllByCoinLocationAndPreservationStateOrderByCoinLocationDesc(String query, String query2);
	List<Coin> findAllByAcquisitionDateBeforeAndPreservationStateOrderByCoinLocationAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateBeforeAndPreservationStateOrderByCoinLocationDesc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAfterAndPreservationStateOrderByCoinLocationAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAfterAndPreservationStateOrderByCoinLocationDesc(Date queryDate, String query2);

	//AND(Ordenar por estado de preservación)
	//CoinModel
	List<Coin> findAllByCoinModelAndSupplierOrderByPreservationStateAsc(CoinModel queryCoin, Supplier querySupplier);
	List<Coin> findAllByCoinModelAndSupplierOrderByPreservationStateDesc(CoinModel queryCoin, Supplier querySupplier);

	List<Coin> findAllByCoinModelAndCoinYearOrderByPreservationStateAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearOrderByPreservationStateDesc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearBeforeOrderByPreservationStateAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearBeforeOrderByPreservationStateDesc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearAfterOrderByPreservationStateAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearAfterOrderByPreservationStateDesc(CoinModel queryCoin, int queryY);

	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByPreservationStateAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByPreservationStateDesc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateBeforeOrderByPreservationStateAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateBeforeOrderByPreservationStateDesc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateAfterOrderByPreservationStateAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateAfterOrderByPreservationStateDesc(CoinModel queryCoin, Date queryDate);

	List<Coin> findAllByCoinModelAndCoinLocationOrderByPreservationStateAsc(CoinModel queryCoin, String query);
	List<Coin> findAllByCoinModelAndCoinLocationOrderByPreservationStateDesc(CoinModel queryCoin, String query);

	List<Coin> findAllByCoinModelAndPreservationStateOrderByPreservationStateAsc(CoinModel queryCoin, String query2);
	List<Coin> findAllByCoinModelAndPreservationStateOrderByPreservationStateDesc(CoinModel queryCoin, String query2);

	//Supplier
	List<Coin> findAllBySupplierAndCoinYearOrderByPreservationStateAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearOrderByPreservationStateDesc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearBeforeOrderByPreservationStateAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearBeforeOrderByPreservationStateDesc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearAfterOrderByPreservationStateAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearAfterOrderByPreservationStateDesc(Supplier querySupplier, int queryY);

	List<Coin> findAllBySupplierAndAcquisitionDateOrderByPreservationStateAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateOrderByPreservationStateDesc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateBeforeOrderByPreservationStateAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateBeforeOrderByPreservationStateDesc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateAfterOrderByPreservationStateAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateAfterOrderByPreservationStateDesc(Supplier querySupplier, Date queryDate);

	List<Coin> findAllBySupplierAndCoinLocationOrderByPreservationStateAsc(Supplier querySupplier, String query);
	List<Coin> findAllBySupplierAndCoinLocationOrderByPreservationStateDesc(Supplier querySupplier, String query);

	List<Coin> findAllBySupplierAndPreservationStateOrderByPreservationStateAsc(Supplier querySupplier, String query2);
	List<Coin> findAllBySupplierAndPreservationStateOrderByPreservationStateDesc(Supplier querySupplier, String query2);

	//CoinYear
	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByPreservationStateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByPreservationStateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateBeforeOrderByPreservationStateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateBeforeOrderByPreservationStateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateAfterOrderByPreservationStateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateAfterOrderByPreservationStateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateOrderByPreservationStateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateOrderByPreservationStateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByPreservationStateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateBeforeOrderByPreservationStateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByPreservationStateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearBeforeAndAcquisitionDateAfterOrderByPreservationStateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateOrderByPreservationStateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateOrderByPreservationStateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByPreservationStateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateBeforeOrderByPreservationStateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateAfterOrderByPreservationStateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAfterAndAcquisitionDateAfterOrderByPreservationStateDesc(int queryY, Date queryDate);

	List<Coin> findAllByCoinYearAndCoinLocationOrderByPreservationStateAsc(int queryY, String query);
	List<Coin> findAllByCoinYearAndCoinLocationOrderByPreservationStateDesc(int queryY, String query);
	List<Coin> findAllByCoinYearBeforeAndCoinLocationOrderByPreservationStateAsc(int queryY, String query);
	List<Coin> findAllByCoinYearBeforeAndCoinLocationOrderByPreservationStateDesc(int queryY, String query);
	List<Coin> findAllByCoinYearAfterAndCoinLocationOrderByPreservationStateAsc(int queryY, String query);
	List<Coin> findAllByCoinYearAfterAndCoinLocationOrderByPreservationStateDesc(int queryY, String query);

	List<Coin> findAllByCoinYearAndPreservationStateOrderByPreservationStateAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearAndPreservationStateOrderByPreservationStateDesc(int queryY, String query2);
	List<Coin> findAllByCoinYearBeforeAndPreservationStateOrderByPreservationStateAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearBeforeAndPreservationStateOrderByPreservationStateDesc(int queryY, String query2);
	List<Coin> findAllByCoinYearAfterAndPreservationStateOrderByPreservationStateAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearAfterAndPreservationStateOrderByPreservationStateDesc(int queryY, String query2);

	//AcquisitionDate
	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByPreservationStateAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByPreservationStateDesc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateBeforeAndCoinLocationOrderByPreservationStateAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateBeforeAndCoinLocationOrderByPreservationStateDesc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAfterAndCoinLocationOrderByPreservationStateAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAfterAndCoinLocationOrderByPreservationStateDesc(Date queryDate, String query);

	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByPreservationStateAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByPreservationStateDesc(Date queryDate, String query2);

	//CoinLocation
	List<Coin> findAllByCoinLocationAndPreservationStateOrderByPreservationStateAsc(String query, String query2);
	List<Coin> findAllByCoinLocationAndPreservationStateOrderByPreservationStateDesc(String query, String query2);
	List<Coin> findAllByAcquisitionDateBeforeAndPreservationStateOrderByPreservationStateAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateBeforeAndPreservationStateOrderByPreservationStateDesc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAfterAndPreservationStateOrderByPreservationStateAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAfterAndPreservationStateOrderByPreservationStateDesc(Date queryDate, String query2);

}