package dao;

import javax.persistence.EntityManager;

import jpautil.JPAUtil;
import models.Conta;


public class ContaDAO {


	public void createConta(Conta conta) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(conta);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public Conta readConta(Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		Conta conta = new Conta();
		
		try {
			em.getTransaction().begin();
			conta = em.find(Conta.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		return conta;
	}

	public void updateConta(Conta conta, Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			conta = em.find(Conta.class, id);
			em.merge(conta);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void deleteConta(Conta conta, Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			conta = em.find(Conta.class, id);
			em.remove(conta);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
