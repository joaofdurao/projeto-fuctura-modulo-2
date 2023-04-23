package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_BANCO")
public class Banco {

	@Id
	@GeneratedValue(generator = "sequence_banco", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sequence_banco", sequenceName = "sequence_banco", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_BANCO", nullable = false)
	private Integer id;

	@Column(name = "NOME_BANCO", nullable = false, unique = true, length = 50)
	private String nome;

	@Column(name = "ABREV_BANCO", nullable = false, unique = true, length = 5)
	private String abreviacao;

	@Column(name = "CNPJ_BANCO", nullable = false, length = 14)
	private String cnpj;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_BANCO", length = 18)
	private TipoBanco tipo;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "banco")
	private List<Conta> contas;

	public Banco() {
		super();
	}

	public Banco(String nome, String abreviacao, String cnpj) {
		super();
		this.nome = nome;
		this.abreviacao = abreviacao;
		this.cnpj = cnpj;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAbreviacao() {
		return abreviacao;
	}

	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public TipoBanco getTipo() {
		return tipo;
	}

	public void setTipo(TipoBanco tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Banco ID: " + id + "\nNome: " + nome + "\nAbreviacao: " + abreviacao + "\nCnpj=" + cnpj;
	}

}