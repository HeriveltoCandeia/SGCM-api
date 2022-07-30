package br.pucminas.tcc.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ChavePesquisa implements Serializable {

	private Long codigoMedicoId;
	private int anoData;
	private Month mesData;
	private int diaData;
	private int horaData;
	private int minutoData;
	private int segundoData;

 	
   
 	public ChavePesquisa() { }
	      
 	public ChavePesquisa(Long id, int anoData, Month mesData, int diaData, int horaData, int minutoData, int segundoDAta ) {
 		this.codigoMedicoId = codigoMedicoId;
 		this.anoData = anoData;
 		this.mesData = mesData;
 		this.diaData = diaData;
 		this.horaData = horaData;
 		this.minutoData = minutoData;
 		this.segundoData = segundoData;
 	}

	public Long getCodigoMedicoId() {
		return codigoMedicoId;
	}

	public void setCodigoMedicoId(Long codigoMedicoId) {
		this.codigoMedicoId = codigoMedicoId;
	}

	public int getAnoData() {
		return anoData;
	}

	public void setAnoData(int anoData) {
		this.anoData = anoData;
	}

	public Month getMesData() {
		return mesData;
	}

	public void setMesData(Month mesData) {
		this.mesData = mesData;
	}

	public int getDiaData() {
		return diaData;
	}

	public void setDiaData(int diaData) {
		this.diaData = diaData;
	}

	public int getHoraData() {
		return horaData;
	}

	public void setHoraData(int horaData) {
		this.horaData = horaData;
	}

	public int getMinutoData() {
		return minutoData;
	}

	public void setMinutoData(int minutoData) {
		this.minutoData = minutoData;
	}

	public int getSegundoData() {
		return segundoData;
	}

	public void setSegundoData(int segundoData) {
		this.segundoData = segundoData;
	}

 	
}
