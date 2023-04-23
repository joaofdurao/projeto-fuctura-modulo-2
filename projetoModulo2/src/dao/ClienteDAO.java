package dao;

import javax.persistence.EntityManager;

import jpautil.JPAUtil;
import models.Cliente;
import models.Usuario;

public class ClienteDAO {


	public void createCliente(Cliente cliente, Integer idUsuario) {
		EntityManager em = JPAUtil.getEntityManager();
		Usuario usuario = new Usuario();
		
		try {
			em.getTransaction().begin();
			usuario = em.find(Usuario.class, idUsuario);
			cliente.setUsuario(usuario);
			em.persist(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public Cliente readCliente(Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		Cliente cliente = new Cliente();
		
		try {
			em.getTransaction().begin();
			cliente = em.find(Cliente.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return cliente;
	}

	public void updateCliente(Cliente cliente, Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			cliente = em.find(Cliente.class, id);
			em.merge(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public void deleteCliente(Cliente cliente, Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			cliente = em.find(Cliente.class, id);
			em.remove(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
