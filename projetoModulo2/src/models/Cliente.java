package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Id
	@GeneratedValue(generator = "sequence_cliente", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sequence_cliente", sequenceName = "sequence_cliente", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_CLI", nullable = false)
	private Integer id;

	@Column(name = "NOME_CLI", nullable = false, length = 50)
	private String nome;

	@Column(name = "CPF_CLI", nullable = false, unique = true, length = 11)
	private String cpf;

	@Column(name = "DATANASC_CLI")
	private LocalDate dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "GEN_CLI", length = 12)
	private Genero genero;

	@Column(name = "FONE_CLI", nullable = false, length = 11)
	private String telefone;

	@Column(name = "emailC_CLI", nullable = false, length = 50)
	private String emailC;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_USU", foreignKey = @ForeignKey(name = "USUARIO_PERSON_ID_FK"))
	private Usuario usuario;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente", orphanRemoval = true)
	private List<Conta> contas;

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf, String telefone, String emailC, Usuario usuario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.emailC = emailC;
		this.usuario = usuario;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getemailC() {
		return emailC;
	}

	public void setemailC(String emailC) {
		this.emailC = emailC;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Cliente ID: " + id + "\nNome: " + nome + "\nCPF: " + cpf + "\nData de Nascimento: " + dataNascimento.format(dtf) + "\nTelefone: "
				+ telefone + "\nE-mail: " + emailC + "\nUsuario vinculado: " + usuario.getNome();
	}

}
