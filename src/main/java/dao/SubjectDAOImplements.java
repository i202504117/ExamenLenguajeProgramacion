package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Subject;

public class SubjectDAOImplements implements SubjectDAO {
	EntityManagerFactory fabric;
	EntityManager em;
	
	public SubjectDAOImplements() {
		fabric=Persistence.createEntityManagerFactory("LenguajeProII");
		em= fabric.createEntityManager();
	}
	
	@Override
	public void registrar(Subject subject) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(subject);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void editar(Subject subject) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(subject);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminar(Integer idsubject) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Subject subject = em.find(Subject.class, idsubject);
			if (subject != null) {
				em.remove(subject);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Subject> listar() {
		Query query= em.createNamedQuery("Subject.findAll");
		List<Subject> lista;
		try {
			lista = query.getResultList();
		}catch (Exception e) {
			lista=null;
		}
		return lista;
	}


}
