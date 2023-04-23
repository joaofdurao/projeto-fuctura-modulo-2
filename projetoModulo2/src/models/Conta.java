package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CONTA")
public class Conta {

	@Id
	@GeneratedValue(generator = "sequence_conta", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sequence_conta", sequenceName = "sequence_conta", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_CONTA", nullable = false)
	private Integer id;

	@Column(name = "NR_CONTA", nullable = false, length = 10)
	private String numero;

	@Column(name = "AG_CONTA", nullable = false, length = 10)
	private String agencia;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_CONTA", nullable = false, length = 18)
	private TipoConta tipo;

	@Column(name = "SALDO_CONTA", nullable = false)
	private Double saldo;

	@ManyToOne
	@JoinColumn(name = "ID_CLI", nullable = false, foreignKey = @ForeignKey(name = "CLIENTE_ID_FK"))
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "ID_BANCO", nullable = false, foreignKey = @ForeignKey(name = "BANCO_ID_FK"))
	private Banco banco;

	public Conta() {
		super();
	}

	public Conta(String numero, String agencia, TipoConta tipo, Double saldo, Cliente cliente, Banco banco) {
		super();
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.saldo = saldo;
		this.cliente = cliente;
		this.banco = banco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	@Override
	public String toString() {
		return "Conta numero: " + numero + "\nAgencia: " + agencia + "\nTipo: " + tipo + "\nSaldo: " + saldo + "\nCliente: "
				+ cliente.getNome() + "\nBanco:" + banco.getAbreviacao();
	}


}
