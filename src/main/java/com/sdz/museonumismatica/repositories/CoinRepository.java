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

	//AND(Ordenar por año de moneda)
	List<Coin> findAllByCoinModelAndSupplierOrderByCoinYearAsc(CoinModel queryCoin, Supplier querySupplier);
	List<Coin> findAllByCoinModelAndSupplierOrderByCoinYearDesc(CoinModel queryCoin, Supplier querySupplier);
	List<Coin> findAllByCoinModelAndCoinYearOrderByCoinYearAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearOrderByCoinYearDesc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByCoinYearAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByCoinYearDesc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndCoinLocationOrderByCoinYearAsc(CoinModel queryCoin, String query);
	List<Coin> findAllByCoinModelAndCoinLocationOrderByCoinYearDesc(CoinModel queryCoin, String query);
	List<Coin> findAllByCoinModelAndPreservationStateOrderByCoinYearAsc(CoinModel queryCoin, String query2);
	List<Coin> findAllByCoinModelAndPreservationStateOrderByCoinYearDesc(CoinModel queryCoin, String query2);

	List<Coin> findAllBySupplierAndCoinYearOrderByCoinYearAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearOrderByCoinYearDesc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndAcquisitionDateOrderByCoinYearAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateOrderByCoinYearDesc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndCoinLocationOrderByCoinYearAsc(Supplier querySupplier, String query);
	List<Coin> findAllBySupplierAndCoinLocationOrderByCoinYearDesc(Supplier querySupplier, String query);
	List<Coin> findAllBySupplierAndPreservationStateOrderByCoinYearAsc(CoinModel queryCoin, String query2);
	List<Coin> findAllBySupplierAndPreservationStateOrderByCoinYearDesc(CoinModel queryCoin, String query2);

	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByCoinYearAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByCoinYearDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndCoinLocationOrderByCoinYearAsc(int queryY, String query);
	List<Coin> findAllByCoinYearAndCoinLocationOrderByCoinYearDesc(int queryY, String query);
	List<Coin> findAllByCoinYearAndPreservationStateOrderByCoinYearAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearAndPreservationStateOrderByCoinYearDesc(int queryY, String query2);

	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByCoinYearAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByCoinYearDesc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByCoinYearAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByCoinYearDesc(Date queryDate, String query2);

	List<Coin> findAllByCoinLocationAndPreservationStateOrderByCoinYearAsc(String query, String query2);
	List<Coin> findAllByCoinLocationAndPreservationStateOrderByCoinYearDesc(String query, String query2);

	//AND(Ordenar por fecha de adquisicion)
	List<Coin> findAllByCoinModelAndSupplierOrderByAcquisitionDateAsc(CoinModel queryCoin, Supplier querySupplier);
	List<Coin> findAllByCoinModelAndSupplierOrderByAcquisitionDateDesc(CoinModel queryCoin, Supplier querySupplier);
	List<Coin> findAllByCoinModelAndCoinYearOrderByAcquisitionDateAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearOrderByAcquisitionDateDesc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByAcquisitionDateAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByAcquisitionDateDesc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndCoinLocationOrderByAcquisitionDateAsc(CoinModel queryCoin, String query);
	List<Coin> findAllByCoinModelAndCoinLocationOrderByAcquisitionDateDesc(CoinModel queryCoin, String query);
	List<Coin> findAllByCoinModelAndPreservationStateOrderByAcquisitionDateAsc(CoinModel queryCoin, String query2);
	List<Coin> findAllByCoinModelAndPreservationStateOrderByAcquisitionDateDesc(CoinModel queryCoin, String query2);

	List<Coin> findAllBySupplierAndCoinYearOrderByAcquisitionDateAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearOrderByAcquisitionDateDesc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndAcquisitionDateOrderByAcquisitionDateAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateOrderByAcquisitionDateDesc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndCoinLocationOrderByAcquisitionDateAsc(Supplier querySupplier, String query);
	List<Coin> findAllBySupplierAndCoinLocationOrderByAcquisitionDateDesc(Supplier querySupplier, String query);
	List<Coin> findAllBySupplierAndPreservationStateOrderByAcquisitionDateAsc(CoinModel queryCoin, String query2);
	List<Coin> findAllBySupplierAndPreservationStateOrderByAcquisitionDateDesc(CoinModel queryCoin, String query2);

	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByAcquisitionDateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByAcquisitionDateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndCoinLocationOrderByAcquisitionDateAsc(int queryY, String query);
	List<Coin> findAllByCoinYearAndCoinLocationOrderByAcquisitionDateDesc(int queryY, String query);
	List<Coin> findAllByCoinYearAndPreservationStateOrderByAcquisitionDateAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearAndPreservationStateOrderByAcquisitionDateDesc(int queryY, String query2);

	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByAcquisitionDateAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByAcquisitionDateDesc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByAcquisitionDateAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByAcquisitionDateDesc(Date queryDate, String query2);

	List<Coin> findAllByCoinLocationAndPreservationStateOrderByAcquisitionDateAsc(String query, String query2);
	List<Coin> findAllByCoinLocationAndPreservationStateOrderByAcquisitionDateDesc(String query, String query2);

	//AND(Ordenar por localizacion de la moneda)
	List<Coin> findAllByCoinModelAndSupplierOrderByCoinLocationAsc(CoinModel queryCoin, Supplier querySupplier);
	List<Coin> findAllByCoinModelAndSupplierOrderByCoinLocationDesc(CoinModel queryCoin, Supplier querySupplier);
	List<Coin> findAllByCoinModelAndCoinYearOrderByCoinLocationAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearOrderByCoinLocationDesc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByCoinLocationAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByCoinLocationDesc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndCoinLocationOrderByCoinLocationAsc(CoinModel queryCoin, String query);
	List<Coin> findAllByCoinModelAndCoinLocationOrderByCoinLocationDesc(CoinModel queryCoin, String query);
	List<Coin> findAllByCoinModelAndPreservationStateOrderByCoinLocationAsc(CoinModel queryCoin, String query2);
	List<Coin> findAllByCoinModelAndPreservationStateOrderByCoinLocationDesc(CoinModel queryCoin, String query2);

	List<Coin> findAllBySupplierAndCoinYearOrderByCoinLocationAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearOrderByCoinLocationDesc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndAcquisitionDateOrderByCoinLocationAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateOrderByCoinLocationDesc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndCoinLocationOrderByCoinLocationAsc(Supplier querySupplier, String query);
	List<Coin> findAllBySupplierAndCoinLocationOrderByCoinLocationDesc(Supplier querySupplier, String query);
	List<Coin> findAllBySupplierAndPreservationStateOrderByCoinLocationAsc(CoinModel queryCoin, String query2);
	List<Coin> findAllBySupplierAndPreservationStateOrderByCoinLocationDesc(CoinModel queryCoin, String query2);

	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByCoinLocationAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByCoinLocationDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndCoinLocationOrderByCoinLocationAsc(int queryY, String query);
	List<Coin> findAllByCoinYearAndCoinLocationOrderByCoinLocationDesc(int queryY, String query);
	List<Coin> findAllByCoinYearAndPreservationStateOrderByCoinLocationAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearAndPreservationStateOrderByCoinLocationDesc(int queryY, String query2);

	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByCoinLocationAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByCoinLocationDesc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByCoinLocationAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByCoinLocationDesc(Date queryDate, String query2);

	List<Coin> findAllByCoinLocationAndPreservationStateOrderByCoinLocationAsc(String query, String query2);
	List<Coin> findAllByCoinLocationAndPreservationStateOrderByCoinLocationDesc(String query, String query2);

	//AND(Ordenar por estado de preservación)
	List<Coin> findAllByCoinModelAndSupplierOrderByPreservationStateAsc(CoinModel queryCoin, Supplier querySupplier);
	List<Coin> findAllByCoinModelAndSupplierOrderByPreservationStateDesc(CoinModel queryCoin, Supplier querySupplier);
	List<Coin> findAllByCoinModelAndCoinYearOrderByPreservationStateAsc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndCoinYearOrderByPreservationStateDesc(CoinModel queryCoin, int queryY);
	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByPreservationStateAsc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndAcquisitionDateOrderByPreservationStateDesc(CoinModel queryCoin, Date queryDate);
	List<Coin> findAllByCoinModelAndCoinLocationOrderByPreservationStateAsc(CoinModel queryCoin, String query);
	List<Coin> findAllByCoinModelAndCoinLocationOrderByPreservationStateDesc(CoinModel queryCoin, String query);
	List<Coin> findAllByCoinModelAndPreservationStateOrderByPreservationStateAsc(CoinModel queryCoin, String query2);
	List<Coin> findAllByCoinModelAndPreservationStateOrderByPreservationStateDesc(CoinModel queryCoin, String query2);

	List<Coin> findAllBySupplierAndCoinYearOrderByPreservationStateAsc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndCoinYearOrderByPreservationStateDesc(Supplier querySupplier, int queryY);
	List<Coin> findAllBySupplierAndAcquisitionDateOrderByPreservationStateAsc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndAcquisitionDateOrderByPreservationStateDesc(Supplier querySupplier, Date queryDate);
	List<Coin> findAllBySupplierAndCoinLocationOrderByPreservationStateAsc(Supplier querySupplier, String query);
	List<Coin> findAllBySupplierAndCoinLocationOrderByPreservationStateDesc(Supplier querySupplier, String query);
	List<Coin> findAllBySupplierAndPreservationStateOrderByPreservationStateAsc(CoinModel queryCoin, String query2);
	List<Coin> findAllBySupplierAndPreservationStateOrderByPreservationStateDesc(CoinModel queryCoin, String query2);

	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByPreservationStateAsc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndAcquisitionDateOrderByPreservationStateDesc(int queryY, Date queryDate);
	List<Coin> findAllByCoinYearAndCoinLocationOrderByPreservationStateAsc(int queryY, String query);
	List<Coin> findAllByCoinYearAndCoinLocationOrderByPreservationStateDesc(int queryY, String query);
	List<Coin> findAllByCoinYearAndPreservationStateOrderByPreservationStateAsc(int queryY, String query2);
	List<Coin> findAllByCoinYearAndPreservationStateOrderByPreservationStateDesc(int queryY, String query2);

	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByPreservationStateAsc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAndCoinLocationOrderByPreservationStateDesc(Date queryDate, String query);
	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByPreservationStateAsc(Date queryDate, String query2);
	List<Coin> findAllByAcquisitionDateAndPreservationStateOrderByPreservationStateDesc(Date queryDate, String query2);

	List<Coin> findAllByCoinLocationAndPreservationStateOrderByPreservationStateAsc(String query, String query2);
	List<Coin> findAllByCoinLocationAndPreservationStateOrderByPreservationStateDesc(String query, String query2);

}