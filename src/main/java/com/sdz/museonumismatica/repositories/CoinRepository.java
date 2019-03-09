package com.sdz.museonumismatica.repositories;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sdz.museonumismatica.Coin;
import com.sdz.museonumismatica.CoinModel;
import com.sdz.museonumismatica.Supplier;

public interface CoinRepository extends JpaRepository<Coin, Long> {
	List<Coin> findByCoinModel(CoinModel model);
	List<Coin> findByYear(int coinYear);
	List<Coin> findByAcquisition(Date acquisitionDate);
	List<Coin> findByLocation(String coinLocation);
	List<Coin> findByState(String preservationState);
	List<Coin> findByState(Supplier supplier);
	//falran metodos para modificar y de ordenación
}