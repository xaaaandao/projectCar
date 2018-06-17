/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entidades.Movimentos;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author a968692
 */
public class MovimentosJpaController implements Serializable {

    public MovimentosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movimentos movimentos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movimentos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovimentos(movimentos.getIdmovimentos()) != null) {
                throw new PreexistingEntityException("Movimentos " + movimentos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movimentos movimentos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movimentos = em.merge(movimentos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = movimentos.getIdmovimentos();
                if (findMovimentos(id) == null) {
                    throw new NonexistentEntityException("The movimentos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movimentos movimentos;
            try {
                movimentos = em.getReference(Movimentos.class, id);
                movimentos.getIdmovimentos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movimentos with id " + id + " no longer exists.", enfe);
            }
            em.remove(movimentos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movimentos> findMovimentosEntities() {
        return findMovimentosEntities(true, -1, -1);
    }

    public List<Movimentos> findMovimentosEntities(int maxResults, int firstResult) {
        return findMovimentosEntities(false, maxResults, firstResult);
    }

    private List<Movimentos> findMovimentosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movimentos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Movimentos findMovimentos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movimentos.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovimentosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movimentos> rt = cq.from(Movimentos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
