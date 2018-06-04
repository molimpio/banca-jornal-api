package br.com.olimpio.bancajornal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mensagem implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer origem_id;
	private Integer destino_id;
	private String assunto;	
	private String corpo;
	
	public Mensagem() {
		super();
	}

	public Mensagem(Integer id, Integer origem_id, Integer destino_id, String assunto, String corpo) {
		super();
		this.id = id;
		this.origem_id = origem_id;
		this.destino_id = destino_id;
		this.assunto = assunto;
		this.corpo = corpo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrigem_id() {
		return origem_id;
	}

	public void setOrigem_id(Integer origem_id) {
		this.origem_id = origem_id;
	}

	public Integer getDestino_id() {
		return destino_id;
	}

	public void setDestino_id(Integer destino_id) {
		this.destino_id = destino_id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}	
	
}