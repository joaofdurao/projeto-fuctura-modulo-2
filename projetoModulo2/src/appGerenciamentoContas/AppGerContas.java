package appGerenciamentoContas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.BancoDAO;
import dao.ClienteDAO;
import dao.ContaDAO;
import dao.UsuarioDAO;
import models.Banco;
import models.Cliente;
import models.Conta;
import models.Usuario;

public class AppGerContas {

	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// INSTANCIANDO OBJETOS PARA MANIPULAÇÃO
		Usuario usuario = new Usuario();
		Cliente cliente = new Cliente();
		Banco banco = new Banco();
		Conta conta = new Conta();

		UsuarioDAO usuDAO = new UsuarioDAO();
		ClienteDAO cliDAO = new ClienteDAO();
		BancoDAO banDAO = new BancoDAO();
		ContaDAO conDAO = new ContaDAO();

		// CADASTRAR USUARIO
		// Obrigatórios:
		usuario.setTipo(null);
		usuario.setNome(null);
		usuario.setEmail(null);
		usuario.setSenha(null);
		// Outras:
		usuario.setCpf(null);
		usuario.setGenero(null);
		usuario.setDataNascimento(LocalDate.parse(null, dtf));
		//CRIAR USUARIO
		usuDAO.createUsuario(null);
		//BUSCAR USUARIO
		usuDAO.readUsuario(null);
		//ATUALIZAR USUARIO
		usuDAO.updateUsuario(null, null);
		//DELETAR USUARIO
		usuDAO.deleteUsuario(null, null);

		// CADASTRAR CLIENTE
		// Obrigatórios:
		cliente.setNome(null);
		cliente.setCpf(null);
		cliente.setemailC(null);
		cliente.setTelefone(null);
		// Outras:
		cliente.setGenero(null);
		cliente.setDataNascimento(LocalDate.parse(null, dtf));
		//CRIAR CLIENTE
		cliDAO.createCliente(null, null);
		//BUSCAR CLIENTE
		cliDAO.readCliente(null);
		//ATUALIZAR CLIENTE
		cliDAO.updateCliente(null, null);
		//DELETAR CLIENTE
		cliDAO.deleteCliente(null, null);

		// CADASTRAR BANCO
		// Obrigatórios:
		banco.setNome(null);
		banco.setAbreviacao(null);
		banco.setCnpj(null);
		// Outras:
		banco.setTipo(null);
		//CRIAR BANCO
		banDAO.createBanco(null);
		//BUSCAR BANCO
		banDAO.readBanco(null);
		//ATUALIZAR BANCO
		banDAO.updateBanco(null, null);
		//DELETAR BANCO
		banDAO.deleteBanco(null, null);
		
		// CADASTRAR CONTA
		// Obrigatórios:
		conta.setAgencia(null);
		conta.setNumero(null);
		conta.setSaldo(null);
		conta.setTipo(null);
		conta.setBanco(null);
		conta.setCliente(null);
		//CRIAR CONTA
		conDAO.createConta(null);
		//BUSCAR CONTA
		conDAO.readConta(null);
		//ATUALIZAR CONTA
		conDAO.updateConta(null, null);
		//DELETAR CONTA
		conDAO.deleteConta(null, null);


	}

}
