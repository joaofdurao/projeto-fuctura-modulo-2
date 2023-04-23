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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Id
	@GeneratedValue(generator = "sequence_usuario", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sequence_usuario", sequenceName = "sequence_usuario", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_USU",nullable = false)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_USU", nullable = false, length = 6)
	private TipoUsuario tipo;

	@Column(name = "NOME_USU", nullable = false, length = 50)
	private String nome;

	@Column(name = "CPF_USU", unique = true, length = 11)
	private String cpf;

	@Column(name = "DATANASC_USU")
	private LocalDate dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "GEN_USU", length = 12)
	private Genero genero;

	@Column(name = "EMAIL_USU", nullable = false, unique = true, length = 50)
	private String email;

	@Column(name = "SENHA_USU", nullable = false)
	private Integer senha;
	
	@OneToMany(fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL,
			mappedBy = "usuario")
	private List<Cliente> clientes;
	
	

	public Usuario() {
		super();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Usuario " + tipo + " Id: " + id + "\nNome: " + nome + "\nCPF: " + cpf + "\nData de Nascimento:" + dataNascimento.format(dtf)
				+ "\nE-mail: " + email;
	}

	
}