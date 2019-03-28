package com.sdz.museonumismatica;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Jorge Chavero Morcillo
 *
 * Implementacion de los ejemplares de monedas
 */
@Entity
public class Coin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private CoinModel coinModel;
	private int coinYear;
	private String coinLocation;
	private Date acquisitionDate;
	private String preservationState;
	@OneToOne
	private Supplier supplier;
	
	public Coin() {}

	public Coin(long id, CoinModel coinModel, int coinYear, String coinLocation, Date acquisitionDate, String preservationState,
				Supplier supplier) {
		this.id = id;
		this.coinModel = coinModel;
		this.coinYear = coinYear;
		this.coinLocation = coinLocation;
		this.acquisitionDate = acquisitionDate;
		this.preservationState = preservationState;
		this.supplier = supplier;
	}

	public Coin(CoinModel coinModel, int coinYear, String coinLocation, Date acquisitionDate, String preservationState,
			Supplier supplier) {
		this.coinModel = coinModel;
		this.coinYear = coinYear;
		this.coinLocation = coinLocation;
		this.acquisitionDate = acquisitionDate;
		this.preservationState = preservationState;
		this.supplier = supplier;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Ejemplar{" +
				"Modelo de moneda=" + coinModel.toString() +
				"\nAño = " + coinYear + "/ Localizacion = " + coinLocation + "/ Fecha de adquisición =" + acquisitionDate + "/ Estado de preservación ='" + preservationState +
				"\n Proveedor=" + supplier.toString() + '}';
	}
}
