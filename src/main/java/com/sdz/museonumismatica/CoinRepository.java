package com.sdz.museonumismatica;

import java.sql.Date;

import javax.persistence.OneToOne;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin, Long> {
	Anuncio findByAsunto(String asunto);
	List<Coin> findByCoinModel(CoinModel model);
	List<Coin> findByYear(int coinYear);
	List<Coin> findByAcquisition(Date acquisitionDate);
	List<Coin> findByLocation(String coinLocation);
	List<Coin> findByState(String preservationState);
	List<Coin> findByState(Supplier supplier);
	//falran metodos para modificar y de ordenación
}