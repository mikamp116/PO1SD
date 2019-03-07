package com.sdz.museonumismatica;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;

public class Coin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	CoinModel coinModel;
	int coinYear;
	String coinLocation;
	Date acquisitionDate;
	String preservationState;
	Supplier supplier;

	public Coin() {
		super();
	}

	public Coin(CoinModel coinModel, int coinYear, String coinLocation, Date acquisitionDate, String preservationState,
                Supplier supplier) {
		super();
		this.coinModel = coinModel;
		this.coinYear = coinYear;
		this.coinLocation = coinLocation;
		this.acquisitionDate = acquisitionDate;
		this.preservationState = preservationState;
		this.supplier = supplier;
	}

	public CoinModel getCoinModel() {
		return coinModel;
	}
	
	public void setCoinModel(CoinModel coinModel) {
		this.coinModel = coinModel;
	}
	
	public int getCoinYear() {
		return coinYear;
	}
	
	public void setCoinYear(int coinYear) {
		this.coinYear = coinYear;
	}
	
	public String getCoinLocation() {
		return coinLocation;
	}
	
	public void setCoinLocation(String coinLocation) {
		this.coinLocation = coinLocation;
	}
	
	public Date getAcquisitionDate() {
		return acquisitionDate;
	}
	
	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}
	
	public String getPreservationState() {
		return preservationState;
	}
	
	public void setPreservationState(String preservationState) {
		this.preservationState = preservationState;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
