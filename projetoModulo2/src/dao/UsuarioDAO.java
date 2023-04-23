package dao;

import javax.persistence.EntityManager;

import jpautil.JPAUtil;
import models.Usuario;

public class UsuarioDAO {

	public void createUsuario(Usuario usuario) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public Usuario readUsuario(Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		Usuario usuario = new Usuario();
		
		try {
			em.getTransaction().begin();
			usuario = em.find(Usuario.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return usuario;
	}

	public void updateUsuario(Usuario usuario, Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			usuario = em.find(Usuario.class, id);
			em.merge(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void deleteUsuario(Usuario usuario,Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			usuario = em.find(Usuario.class, id);
			em.remove(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
