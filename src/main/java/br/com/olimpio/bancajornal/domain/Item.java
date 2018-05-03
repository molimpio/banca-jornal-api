package br.com.olimpio.bancajornal.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Item implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer codigo;
	
	@OneToOne(mappedBy="id.categoria")
	private Integer categoria_id;
	
	@OneToOne(mappedBy="id.unidade")
	private Integer unidade_id;
	
	private Integer qtde;
	private Date data;
	private String descricao;
	private Boolean ativo;
	
	@OneToOne(mappedBy="id.banca")
	private Integer banca_id;
	
	public Item() {
		super();
	}

	public Item(Integer id, Integer codigo, Integer categoria_id, Integer unidade_id, Integer qtde, Date data,
			String descricao, Boolean ativo, Integer banca_id) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.categoria_id = categoria_id;
		this.unidade_id = unidade_id;
		this.qtde = qtde;
		this.data = data;
		this.descricao = descricao;
		this.ativo = ativo;
		this.banca_id = banca_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}

	public Integer getUnidade_id() {
		return unidade_id;
	}

	public void setUnidade_id(Integer unidade_id) {
		this.unidade_id = unidade_id;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getBanca_id() {
		return banca_id;
	}

	public void setBanca_id(Integer banca_id) {
		this.banca_id = banca_id;
	}
	
	
}
