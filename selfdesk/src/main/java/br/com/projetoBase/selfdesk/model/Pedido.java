package br.com.projetoBase.selfdesk.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_pedido")
	private int numPedido;
	
	@Column(name="status")
	private char status;
	@Column(name="observacoes", length=200)
	private String observacoes;
	
	@Column(name = "data_pedido")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd/MM/yyyy")
	private Date dataPedido;
	
	
	@ManyToOne
	@JsonIgnoreProperties("pedidos") // ignoro a lista de pedidos do solicitante
	private Usuario solicitante;

	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "pedido")
	@JsonIgnoreProperties("pedido")
	private List<Item> itens;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Maquina computador; 
	
	public int getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Usuario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Maquina getComputador() {
		return computador;
	}

	public void setComputador(Maquina computador) {
		this.computador = computador;
	}
}