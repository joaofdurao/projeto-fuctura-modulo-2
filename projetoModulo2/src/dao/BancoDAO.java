package dao;

import javax.persistence.EntityManager;

import jpautil.JPAUtil;
import models.Banco;


public class BancoDAO {


	public void createBanco(Banco banco) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(banco);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public Banco readBanco(Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		Banco banco = new Banco();
		
		try {
			em.getTransaction().begin();
			banco = em.find(Banco.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return banco;
	}

	public void updateBanco(Banco banco, Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			banco = em.find(Banco.class, id);
			em.merge(banco);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void deleteBanco(Banco banco, Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			banco = em.find(Banco.class, id);
			em.remove(banco);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
