package br.com.olimpio.bancajornal.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Item implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String codigo;
	
	@OneToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@OneToOne
	@JoinColumn(name="unidade_id")
	private Unidade unidade;
	
	private Integer qtde;
	private Date data;
	private String descricao;
	private Boolean ativo;
	
	@OneToOne
	@JoinColumn(name="banca_id")
	private Banca banca;
	
	public Item() {
		super();
	}

	public Item(Integer id, String codigo, Categoria categoria, Unidade unidade, Integer qtde, Date data,
			String descricao, Boolean ativo, Banca banca) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.categoria = categoria;
		this.unidade = unidade;
		this.qtde = qtde;
		this.data = data;
		this.descricao = descricao;
		this.ativo = ativo;
		this.banca = banca;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
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

	public Banca getBanca() {
		return banca;
	}

	public void setBanca(Banca banca) {
		this.banca = banca;
	}	
	
}
