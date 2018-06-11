/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import Entidades.Dados;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Sensores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author a968692
 */
public class DadosJpaController implements Serializable {

    public DadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dados dados) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sensores sensoresIdsensores = dados.getSensoresIdsensores();
            if (sensoresIdsensores != null) {
                sensoresIdsensores = em.getReference(sensoresIdsensores.getClass(), sensoresIdsensores.getIdsensores());
                dados.setSensoresIdsensores(sensoresIdsensores);
            }
            em.persist(dados);
            if (sensoresIdsensores != null) {
                sensoresIdsensores.getDadosList().add(dados);
                sensoresIdsensores = em.merge(sensoresIdsensores);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDados(dados.getIddados()) != null) {
                throw new PreexistingEntityException("Dados " + dados + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dados dados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dados persistentDados = em.find(Dados.class, dados.getIddados());
            Sensores sensoresIdsensoresOld = persistentDados.getSensoresIdsensores();
            Sensores sensoresIdsensoresNew = dados.getSensoresIdsensores();
            if (sensoresIdsensoresNew != null) {
                sensoresIdsensoresNew = em.getReference(sensoresIdsensoresNew.getClass(), sensoresIdsensoresNew.getIdsensores());
                dados.setSensoresIdsensores(sensoresIdsensoresNew);
            }
            dados = em.merge(dados);
            if (sensoresIdsensoresOld != null && !sensoresIdsensoresOld.equals(sensoresIdsensoresNew)) {
                sensoresIdsensoresOld.getDadosList().remove(dados);
                sensoresIdsensoresOld = em.merge(sensoresIdsensoresOld);
            }
            if (sensoresIdsensoresNew != null && !sensoresIdsensoresNew.equals(sensoresIdsensoresOld)) {
                sensoresIdsensoresNew.getDadosList().add(dados);
                sensoresIdsensoresNew = em.merge(sensoresIdsensoresNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dados.getIddados();
                if (findDados(id) == null) {
                    throw new NonexistentEntityException("The dados with id " + id + " no longer exists.");
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
            Dados dados;
            try {
                dados = em.getReference(Dados.class, id);
                dados.getIddados();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dados with id " + id + " no longer exists.", enfe);
            }
            Sensores sensoresIdsensores = dados.getSensoresIdsensores();
            if (sensoresIdsensores != null) {
                sensoresIdsensores.getDadosList().remove(dados);
                sensoresIdsensores = em.merge(sensoresIdsensores);
            }
            em.remove(dados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dados> findDadosEntities() {
        return findDadosEntities(true, -1, -1);
    }

    public List<Dados> findDadosEntities(int maxResults, int firstResult) {
        return findDadosEntities(false, maxResults, firstResult);
    }

    private List<Dados> findDadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dados.class));
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

    public Dados findDados(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dados.class, id);
        } finally {
            em.close();
        }
    }

    public int getDadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dados> rt = cq.from(Dados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
