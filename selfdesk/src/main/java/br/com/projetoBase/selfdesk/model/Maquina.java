package br.com.projetoBase.selfdesk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	
@Table (name="tbl_maquina")

public class Maquina {
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="marca", length = 100)
	private String marca;
	
	@Column(name="modelo", length = 100)
	private String modelo;
	
	@Column(name="ram", length = 10)
	private String ram;
	
	@Column(name="hd", length = 10)
	private String hd;
	
	@Column(name="tamTela", length = 100)
	private String tamTela;
	
	@Column(name="placaVideo", length = 100)
	private String placaVideo;
	
	@Column(name="numSerie", length = 100)
	private String numSerie;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getHd() {
		return hd;
	}
	public void setHd(String hd) {
		this.hd = hd;
	}
	public String getTamTela() {
		return tamTela;
	}
	public void setTamTela(String tamTela) {
		this.tamTela = tamTela;
	}
	public String getPlacaVideo() {
		return placaVideo;
	}
	public void setPlacaVideo(String placaVideo) {
		this.placaVideo = placaVideo;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	
	
	

}
